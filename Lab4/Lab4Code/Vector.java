import java.util.LinkedList;

public class Vector {
    //Atributes
    private double[] values;
    private int dim;

    //Constructor

    public Vector(int d){
        this.dim = d;
        this.values = new double[this.dim];
        zero();

    }

    public void zero(){
        for(int i = 0; i<this.dim; i++){
            this.values[i] = 0;
        }
    }

    public void set(int i, double val){
        this.values[i] = val;
    }

    public double get(int i){
        return this.values[i];
    }

    public void multiply(double s){
        for(int i = 0; i<this.dim; i++){
            this.values[i] = this.values[i] * s;
        }
    }

    public void print(){
        for(Double val: this.values){
            System.out.print(val+" ");
        }
        System.out.print("\n");
    }

    public void set3D(double a, double b, double c){
        this.set(0,a);
        this.set(1,b);
        this.set(2,c);
    }

    public void matrixMultiply(Matrix m){
        Vector v1 = new Vector(m.getRow());

        if(this.dim == m.getCol()){
            double aux;
            for(int i = 0; i<m.getRow(); i++){
                aux = 0;
                for(int j=0; j<m.getCol(); j++){
                    aux = aux +m.get(i, j)*this.get(j);
                }
                v1.set(i,aux);
            }

            for(int i = 0; i<this.dim; i++){
                this.set(i, v1.get(i));
            }
        }else{
            System.out.println("No se puede multiplicar un vector con tamaño diferente a la matriz");
        }


    }

}