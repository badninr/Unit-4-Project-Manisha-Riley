//Import
import java.util.*;

public class ZombieGame {


    //Variables
    private int brainCount;
    private int shotgunCount;
    private int totalScore;
    private int side1;
    private int side2;
    private int side3;



    //Array lists of die
    private ArrayList<ZombieDie> dice = new ArrayList<>();
    private ArrayList<ZombieDie> currentDice = new ArrayList<>();
    private ArrayList<ZombieDie> originalDice = new ArrayList<>();



    //Game constructor
    public ZombieGame(){
        brainCount = 0;
        shotgunCount = 0;

        for(int i = 0; i < 13; i++){
            dice.add(new ZombieDie());
        }

        for (int i = 0; i < 13; i++){
            assignColor(dice.get(i));
        }
        Collections.shuffle(dice);
        for (int i = 0; i < 13; i++){
            originalDice.add(dice.get(i));
        }

        selectFirstDice();
        System.out.println("Dice list: " + dice);
        System.out.println("Current dice list: " + currentDice);
    }



    //Getters
    public int getBrainCount() { return brainCount; }

    public int getShotgunCount() { return shotgunCount; }

    public int findDiceColor(int index){
        return dice.get(index).getColor();
    }

    public int findCurrentDiceColor(int index){
        return currentDice.get(index).getColor();
    }

    public int getTotalScore(){
        return totalScore;
    }

    public int getDiceListLength() {
        return dice.size();
    }



    //Setter
    public void setTotalScore(){
        totalScore = totalScore + brainCount;
        brainCount = 0;
        shotgunCount = 0;
    }



    //Methods-----------------------------------------------------------------------------------------------------------



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
    }



    //Used in turn method, determines what variable the loop is referring to
    public void setCurrentSideName(int num, int side){
        if (num == 0){
            side1 = side;
        } else if (num == 1){
            side2 = side;
        } else {
            side3 = side;
        }
    }



    //Gives the side name of the dice at the specified index in currentDice
    public int getCurrentSideName(int index){
        if (index == 0){
            return side1;
        } else if (index == 1){
            return side2;
        } else {
            return side3;
        }
    }



    //KEY: Shotgun = 1; Brain = 2; Footprint = 3



    //Turn; Counts what is chosen, and add them to score, sets side name
    public void turn(){
        for (int i = 0; i < 3; i++){
            currentDice.get(i).roll();
            currentDice.get(i).sideName();

            System.out.println("Dice at index "+ i + " is the color " + currentDice.get(i).getColor() + " and rolled "+ currentDice.get(i).sideName() );
            if (currentDice.get(i).getSideName().equals("shotgun")){
                shotgunCount++;
                setCurrentSideName(i, 1);
            } else if (currentDice.get(i).getSideName().equals("brain")){
                brainCount++;
                setCurrentSideName(i, 2);
            } else {
                setCurrentSideName(i, 3);
            }
            if (dice.size()==0){
                break;
            }
        }
        System.out.println(currentDice);
        System.out.println(dice);

    }



    //Removes and replaces shotguns and brains from currentDice
    public void replaceDice(){
        for (int i = 0; i < 3; i++){
            if (currentDice.get(i).getSideName().equals("shotgun") || currentDice.get(i).getSideName().equals("brain")) {
                currentDice.remove(i);
                currentDice.add(i, dice.get(0));
                dice.remove(0);
            }
        }
    }



    //Resets the list of dice and current dice back to their original values
    public void resetList(){
        dice.clear();
        currentDice.clear();
        dice.addAll(originalDice);
        System.out.println("Updated dice: " + dice);
        currentDice.add(dice.get(0));
        currentDice.add(dice.get(1));
        currentDice.add(dice.get(2));
        System.out.println("New Current dice: "+currentDice);
        dice.remove(0);
        dice.remove(0);
        dice.remove(0);
        System.out.println("New dice list(after update): "+dice);
    }



    //Checks for win
    public boolean checkWin(){
        return totalScore >= 13;
    }



    //Checks shotgun amount; resets brain count if shotgun count = 3
    public boolean checkShotgunCount(){
        if (shotgunCount >= 3){
            brainCount = 0;
            shotgunCount = 0;
            return true;
        } else {
            return false;
        }
    }



}
