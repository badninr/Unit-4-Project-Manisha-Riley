public class ZombieDie {
    private int side;
    private int color;
    private String sideName = "";

    public ZombieDie(){
        side = (int) ((Math.random() * 6) + 1);
        color = 0;
        sideName = "";
    }

    public String getSideName(){
        return sideName;
    }

    public String getSide(){
        return sideName;
    }

    public int getColor() { return color; }

    public void setColor(int colorInput){
        color = colorInput;
    }

    public void roll(){
        side = (int) ((Math.random() * 6) + 1);
    }

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

    public String toString(){
        String result = "Color: " + color;
        return result;
    }
}



