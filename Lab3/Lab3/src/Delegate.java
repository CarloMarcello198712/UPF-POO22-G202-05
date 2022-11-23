import java.time.LocalDateTime;
import java.util.LinkedList;

import com.google.zxing.common.BitMatrix;

public class Delegate extends Member {
    
    //Atributes
    private LinkedList<Regular> dependents;
    private Headquarter headOf;

    //Constructor
    public Delegate(String n, int p, String e, Headquarter h){
        super(n, p, e, h);
        this.headOf = h;
        this.dependents = new LinkedList<Regular>();
        
        QRLib q = new QRLib();
        genDelegateQR(q);
    }

    public void setHeadOf(Headquarter h){
        this.headOf = h;
    }

    public void addDependents(Regular r){
        this.dependents.add(r);
    }

    public LinkedList<Regular> getDependents(){
        return dependents;
    }


    public Image genDelegateQR(QRLib q){
        Image image = new Image("QrDelegateDataBase/QrDelegate for "+this.getName()+".png",15,15);
        BitMatrix qr = QRLib.generateQRCodeImage("This is a QR for a Delegate Member. You don’t have to care about rising sea levels, if you live on a mega yatch."+this.getName(), 15, 15);
        image.setBitMatrix(qr);
        image.save();
        return image;
        
    }

    public Image genRegularQR(QRLib q){
        Image image = new Image("QrRegularDataBase/QrRegular for "+this.getName()+" department.png",15,15);
        BitMatrix qr = QRLib.generateQRCodeImage("This is a QR for a Regular Member. Climate change doesn’t matter, if you stay indoors."+this.getName(), 15, 15);
        image.setBitMatrix(qr);
        image.save();
        return image;
    }

    public boolean signUpDelegate(Delegate d, QRLib q, Image i){
        String qrText = QRLib.decodeQRCodeImage(i.getBitmap());
        if(qrText.equals("This is a QR for a Delegate Member. Climate change doesn’t matter, if you stay indoors."+d.getName())){
            return true;
        }
        return false;
    }

    public boolean signUpRegular(Regular r, QRLib q, Image i){
        String qrText = q.decodeQRCodeImage(i.getBitmap());
        String headquarter_text = "This is a QR for a Regular Member. Climate change doesn?t matter, if you stay indoors."+this.getName();
        if(qrText.equals(headquarter_text)){
            return true;
        }
        return false;
    }
    

    public void proposeAction(Action a){
        InfoAction actionDetails = new InfoAction(a, headOf, this.dependents.size(), 0, false);
        this.headOf.addAction(actionDetails);
    }

    public void signUpAction(LocalDateTime d){
        Action action = this.headOf.getOrganization().getAction(d);
        InfoAction i_a = new InfoAction(action, headOf, this.dependents.size(), 0, false);
        this.headOf.addAction(i_a);
    }
}
