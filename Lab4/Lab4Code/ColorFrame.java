public class ColorFrame extends Frame{
    //Constructor

    public ColorFrame(int n, int m){
        super(n,m);
    }

    public void set( int i , int j , int r , int g , int b ) {
        double ret = RGBToVal( r , g , b );
        set( i , j , ret );
    }

    public int[] getRGB(int i, int j){
        return valToRGB(get(i, j));
    }

    public void changeBrightness(double delta){
        for(int i = 0; i< this.getRow(); i++){
            for(int j = 0; j<this.getCol();j++){
                int[] pixel = getRGB(i, j);
                pixel[0] = (int) (pixel[0] * delta);
                if (pixel[0] > 255) pixel[0] = 255; //If the color component becomes higher than 255, we have to truncate it to 255
                
                pixel[1] = (int) (pixel[1] * delta);
                if (pixel[1] > 255) pixel[1] = 255;

                pixel[2] = (int) (pixel[2] * delta);
                if (pixel[2] > 255) pixel[2] = 255;

                set(i, j, pixel[0],pixel[1],pixel[2]); 
            }
        }
    }

    public void changeRGB(int dr, int dg, int db){
        for(int i = 0; i< this.getRow(); i++){
            for(int j = 0; j<this.getCol();j++){
                int[] pixel = getRGB(i, j);
                pixel[0] = pixel[0] * dr;
                pixel[1] = pixel[1] * dg;
                pixel[2] = pixel[2] * db;
                set(i, j, pixel[0],pixel[1],pixel[2]); 
            }
        }

    }


    private int[] valToRGB (double rgb ) {
        int[] ret = new int [ 3 ] ;
        ret[ 0 ] = ( ( int ) rgb >> 16 ) & 255;
        ret[ 1 ] = ( ( int ) rgb >> 8 ) & 255;
        ret[ 2 ] = ( ( int ) rgb ) & 255;
        return ret ;
    }
    
    private double RGBToVal( int r , int g , int b ) {
        double ret = ( r << 16 ) | ( g << 8 ) | b ;
        return ret;
    }
}