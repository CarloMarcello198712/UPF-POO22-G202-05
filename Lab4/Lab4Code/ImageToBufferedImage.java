import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class ImageToBufferedImage {

    static BufferedImage image;
    static boolean imageLoaded = false;

    public static void main(String[] args) {
        
        ImageObserver myImageObserver = new ImageObserver() {
                public boolean imageUpdate(Image image, int flags, int x, int y, int width, int height) {

                    if ((flags & ALLBITS) != 0) {
                        imageLoaded = true;
                        System.out.println("Image loading finished!");
                        return false;
                    }
                    return true;
                }
            };


        String imageURL = "Lenna_(test_image).png";

        Image sourceImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        sourceImage.getWidth(myImageObserver);

        while (!imageLoaded) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }

        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
        GraphicsConfiguration graphicsConfiguration = graphicsDevice.getDefaultConfiguration();

        image = graphicsConfiguration.createCompatibleImage(sourceImage.getWidth(null), sourceImage.getHeight(null), Transparency.BITMASK);

        Graphics graphics = image.createGraphics();

        graphics.drawImage(sourceImage, 0, 0, null);
        graphics.dispose();

        Frame frame = new Frame("Example Frame");


        frame.add(new CustomPaintComponent());
        

        int frameWidth = 300;
        int frameHeight = 300;
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);      

    }

    
    static class CustomPaintComponent extends Component {
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            int x = 0;
            int y = 0;
            g2d.drawImage(image, x, y, this);

        }
    }
}
