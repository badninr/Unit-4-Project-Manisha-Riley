

import java.util.*;

public class ZombieGame {
    private int brainCount;
    private int shotgunCount;
    private int footprintCount;

    private ArrayList<ZombieDie> dice = new ArrayList<ZombieDie>();
    private ArrayList<ZombieDie> currentDice = new ArrayList<ZombieDie>();

    public ZombieGame(){
        brainCount = 0;
        shotgunCount = 0;
        footprintCount = 0;

        for(int i = 0; i < 13; i++){
            dice.add(new ZombieDie());
        }

        for (int i = 0; i < 13; i++){
            assignColor(dice.get(i));
        }
        Collections.shuffle(dice);
        System.out.println(dice);
        selectFirstDice();
    }


    public void assignColor(ZombieDie input){
        if (dice.indexOf(input)>=0 && dice.indexOf(input)<=2){
            input.setColor(1);
        } else if (dice.indexOf(input)>=3 && dice.indexOf(input)<=6){
            input.setColor(2);
        } else {
            input.setColor(3);
        }
    }

    public void selectFirstDice() {

        for (int i=1; i<=3; i++) {
            currentDice.add(dice.get(0));

            dice.remove(0);
        }

        System.out.println(currentDice);
        System.out.println(dice);
    }

    public void checkDice(){
        for (int i = 0; i < 3; i++){
            currentDice.get(i).roll();
            currentDice.get(i).sideName();

            if (currentDice.get(i).getSideName().equals("shotgun")){
                shotgunCount++;
            } else if (currentDice.get(i).getSideName().equals("brain")){
                brainCount++;
            } else {
                footprintCount++;
            }
        }
        System.out.println("Shotgun count: " + shotgunCount);
        System.out.println("Brain count: " + brainCount);
        System.out.println("Footprint count: " + footprintCount);
    }

    public void replaceDice(){
        for (int i=1; i<=3; i++) {
            if (currentDice.get(i).getSideName().equals("shotgun") || currentDice.get(i).getSideName().equals("brain")) {
                currentDice.remove(i);
                currentDice.add(i, dice.get(0));
            }
        }

        System.out.println(currentDice);
        System.out.println(dice);
    }
}
