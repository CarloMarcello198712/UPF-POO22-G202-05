public class BWFrame extends Frame{
    public BWFrame(int n, int m){
        super(n,m);
    }

    public void setBW(int i, int j, double val){
        this.set(i, j, val);
    }

    public double getBW(int i, int j){
        return this.get(i, j);
    }


    public void changeBrightness(double delta){
        this.multiply(delta);
    }

    
}
