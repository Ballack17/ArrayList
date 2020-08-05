package lesson5.hw5;

public class Box {
    private float rating;
    private int weight;
    private int value;
    private boolean used;


    Box(){
        this.weight = 4 + (int)(Math.random()*6);
        this.value = 1 + (int)(Math.random()*5);
        this.rating = (float)value / weight;
        this.used = false;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    Box(int weight, int value){
        this.weight = weight;
        this.value = value;
        this.rating = (float)value / weight;
        this.used = false;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return  "{rating= " + rating +
                ", weigth= " + weight +
                ", value= " + value +
                "}";
    }

}
