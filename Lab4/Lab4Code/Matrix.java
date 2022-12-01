public class Matrix {

    //atributes

    private Vector[] values;
    private int row;
    private int col;


    //constructor
    public Matrix(int r, int c){
        this.row = r;
        this.col = c;

        this.values = new Vector[r];
        for (int i = 0; i<r; i++){
            this.values[i] = new Vector(c);
        }
    }

    public double get(int i, int j){
        return this.values[i].get(j);
    }

    public void set(int i, int j, double val){
        this.values[i].set(j, val);
    }

    public void multiply(double e){

        for(int i = 0; i<this.row; i++){
            this.values[i].multiply(e);
        }
    }

    public void print(){
        for(int i = 0; i<this.row; i++){
            this.values[i].print();
        }
    }

    public void zero() {
        for(int i = 0; i<this.row; i++){
            this.values[i].zero();
        }
    }

    public void create3DRotationZ(double arg){
        this.set(0,0,Math.cos(arg));
        this.set(0,1,-Math.sin(arg));
        this.set(0,2,0);
        this.set(1,0,Math.sin(arg));
        this.set(1,1,Math.cos(arg));
        this.set(1,2,0);
        this.set(2,0,0);
        this.set(2,1,0);
        this.set(2,2,1);
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
