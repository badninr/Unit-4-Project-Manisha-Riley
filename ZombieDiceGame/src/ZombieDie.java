public class ZombieDie {

    //Dice attributes
    private int side;
    private int color;
    private String sideName;



    //Constructor
    public ZombieDie(){
        side = (int) ((Math.random() * 6) + 1);
        color = 0;
        sideName = "";
    }



    //Getters
    public String getSideName(){
        return sideName;
    }
    public int getColor() { return color; }



    //Setters
    public void setColor(int colorInput){
        color = colorInput;
    }



    //Rolls die
    public void roll(){
        side = (int) ((Math.random() * 6) + 1);
    }



    //Assigns die side name based on what number they rolled and the color of the die
    public String sideName(){
        //Red = 1; Yellow = 2; Green = 3
        if (color == 1){
            if (side == 1 || side == 2 || side == 3){
                sideName = "shotgun";
            } else if (side == 4 || side == 5){
                sideName = "footprint";
            } else {
                sideName = "brain";
            }

        } else if (color == 2){
            if (side == 1 || side == 2){
                sideName = "shotgun";
            } else if (side == 3 || side == 4){
                sideName = "footprint";
            } else {
                sideName = "brain";
            }

        } else {
            if (side == 1 || side == 2 || side == 3){
                sideName = "brain";
            } else if (side == 4 || side == 5){
                sideName = "footprint";
            } else {
                sideName = "shotgun";
            }
        }
        return sideName;
    }



    //toString override
    public String toString(){
        return "Color: " + color;
    }
}



