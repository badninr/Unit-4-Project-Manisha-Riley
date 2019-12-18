

import java.util.*;

public class ZombieGame {
    private int brainCount;
    private int shotgunCount;
    private int footprintCount;
    private int totalScore;

    private ArrayList<ZombieDie> dice = new ArrayList<ZombieDie>();
    private ArrayList<ZombieDie> currentDice = new ArrayList<ZombieDie>();


    //Game constructor. Creates a new list of dice, assigns each of them a color, shuffles, then selects the first three
    //dice to be used.
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

    public int findDiceColor(int index){
        return dice.get(index).getColor();
    }

    public int findCurrentDiceColor(int index){
        return currentDice.get(index).getColor();
    }

    public String findDiceSideName(int index) { return currentDice.get(index).getSideName(); }

    public int getBrainCount() { return brainCount; }

    public int getShotgunCount() { return shotgunCount; }

    public int getDiceListLength() {
        return dice.size();
    }


    //Sets the color of the dice based on their input
    public void assignColor(ZombieDie input){
        if (dice.indexOf(input)>=0 && dice.indexOf(input)<=2){
            input.setColor(1);
        } else if (dice.indexOf(input)>=3 && dice.indexOf(input)<=6){
            input.setColor(2);
        } else {
            input.setColor(3);
        }
    }

    //Selects the first 3 dice and adds them to the "current" list
    public void selectFirstDice() {

        for (int i=1; i<=3; i++) {
            currentDice.add(dice.get(0));

            dice.remove(0);
        }

        System.out.println(currentDice);
        System.out.println(dice);
    }

    //Counts what is chosen, and add them to score
    public void turn(){
        for (int i = 0; i < 3; i++){
            currentDice.get(i).roll();
            currentDice.get(i).sideName();
            System.out.println("Dice at index "+ i + " rolled "+ currentDice.get(i).sideName() );
            if (currentDice.get(i).getSideName().equals("shotgun")){
                shotgunCount++;
            } else if (currentDice.get(i).getSideName().equals("brain")){
                brainCount++;
            } else {
                footprintCount++;
            }
            replaceDice();
        }
    }

    //Removes everything but footprints from current list
    public void replaceDice(){
        for (int i=0; i<=2; i++) {
            if (currentDice.get(i).getSideName().equals("shotgun") || currentDice.get(i).getSideName().equals("brain")) {
                currentDice.remove(i);
                currentDice.add(i, dice.get(0));
                dice.remove(0);
            }
        }
    }

    //Checks shotgun amount; resets brain count if shotgun count = 3
    public void checkShotgunCount(){
        if (shotgunCount == 3){
            brainCount = 0;
        }
    }

    public int getTotalScore(){
        return totalScore;
    }
}
