import java.util.*;

public class ZombieGame {
    private int brainCount;
    private int shotgunCount;
    private int dieColor;
    private int roundNum;
    private int currentPlayer;

    private ArrayList<Integer> colors;

    public int selectColor() {
        for (int i=1; i<=13; i++)
            colors.add(i);

        Collections.shuffle(colors);

        int colorSelection = (int) Math.random()*13 + 1;

        colors.remove(colorSelection);



    }
}

