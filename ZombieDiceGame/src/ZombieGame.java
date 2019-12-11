

import java.util.*;

public class ZombieGame {
    private int brainCount;
    private int shotgunCount;
    private int roundNum;
    private int currentPlayer;

    private ArrayList<Integer> dice = new ArrayList<Integer>();
    private ArrayList<Integer> currentDice = new ArrayList<Integer>();

    public ZombieGame(){

    }

    ZombieDie die1 = new ZombieDie();
    ZombieDie die2 = new ZombieDie();
    ZombieDie die3 = new ZombieDie();
    ZombieDie die4 = new ZombieDie();
    ZombieDie die5 = new ZombieDie();
    ZombieDie die6 = new ZombieDie();
    ZombieDie die7 = new ZombieDie();
    ZombieDie die8 = new ZombieDie();
    ZombieDie die9 = new ZombieDie();
    ZombieDie die10 = new ZombieDie();
    ZombieDie die11 = new ZombieDie();
    ZombieDie die12 = new ZombieDie();
    ZombieDie die13 = new ZombieDie();

    public int assignColor(int input){
        if (input >= 0 && input <= 2){
            die6.setColor(1);
        } else if (input >= 3 && input <= 6){
            dieColor = 2;
        } else {
            dieColor = 3;
        }
    }

    public void selectDice() {
        for (int i=1; i<=13; i++) {
            dice.add(i);
        }

        Collections.shuffle(dice);

        for (int i=1; i<=3; i++) {

            currentDice.add(dice.get(0));

            assignColor(dice.get(0));

            dice.remove(0);
        }


    }
}
