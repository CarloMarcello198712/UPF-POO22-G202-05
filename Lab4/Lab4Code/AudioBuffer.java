public class AudioBuffer extends Vector{
    //Constructor

    public AudioBuffer(int d){
        super(d);
    }

    //Change volume method
    public void changeVolume(double delta){
        this.multiply(delta);
    } 
}
