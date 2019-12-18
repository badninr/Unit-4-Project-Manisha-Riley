import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import java.util.*;

import java.awt.*;


public class ZombieGUI extends GridPane {
    //Players
    ZombieGame player1 = new ZombieGame();
    ZombieGame player2 = new ZombieGame();

    private boolean isP1Turn = true;

    private Label p1TotalScoreLabel;
    private Label p1BrainCountLabel;
    private Label p1ShotgunCountLabel;
    private Label p2TotalScoreLabel;
    private Label p2BrainCountLabel;
    private Label p2ShotgunCountLabel;
    private Label winText;



    private ImageView imageBlank1 = new ImageView();
    private ImageView imageBlank2 = new ImageView();
    private ImageView imageBlank3 = new ImageView();
    private ImageView imageBlank4 = new ImageView();
    private ImageView imageBlank5 = new ImageView();
    private ImageView imageBlank6 = new ImageView();
    private ImageView imageBlank7 = new ImageView();
    private ImageView imageBlank8 = new ImageView();
    private ImageView imageBlank9 = new ImageView();
    private ImageView imageBlank10 = new ImageView();
    private ImageView currentImage1 = new ImageView();
    private ImageView currentImage2 = new ImageView();
    private ImageView currentImage3 = new ImageView();


    //Images
    private Image redDie = new Image("updatedRedDie.png", 20, 20,false,false);
    private Image yellowDie = new Image("yellowDie.png", 20, 20,false,false);
    private Image greenDie = new Image("updatedGreenDie.png",20, 20,false,false);
    private Image redFootprintDie = new Image("redDieFeet.png",60,60,false,false);
    private Image yellowFootprintDie = new Image("yellowDieFeet.png",60,60,false,false);
    private Image greenFootprintDie = new Image("greenDieFeet.png",60,60,false,false);
    private Image redShotgunDie = new Image("redBullet.png",60,60,false,false);
    private Image yellowShotgunDie = new Image("yellowDieBullet.png",60,60,false,false);
    private Image greenShotgunDie = new Image("greenDieBullet.png",60,60,false,false);
    private Image redBrainDie = new Image("redDieBrain.png",60,60,false,false);
    private Image yellowBrainDie = new Image("yellowDieBrain.png",60,60,false,false);
    private Image greenBrainDie = new Image("greenDieBrain.png",60,60,false,false);


    public ZombieGUI() {
        Font font = new Font(12);
        Font titleFont = new Font(30);

        //labels
        Label titleLabel = new Label("Zombie Dice");
        titleLabel.setFont(font);
        GridPane.setHalignment (titleLabel, HPos.CENTER);
        titleLabel.setTextFill(Color.WHITE);

        Label p1Label = new Label("Player 1");
        p1Label.setFont(font);
        GridPane.setHalignment (p1Label, HPos.LEFT);
        p1Label.setTextFill(Color.WHITE);

        p1TotalScoreLabel = new Label("Total Score: ");
        p1TotalScoreLabel.setFont(font);
        GridPane.setHalignment (p1TotalScoreLabel, HPos.LEFT);
        p1TotalScoreLabel.setTextFill(Color.WHITE);

        p1BrainCountLabel = new Label("Brain Count: ");
        p1BrainCountLabel.setFont(font);
        GridPane.setHalignment (p1BrainCountLabel, HPos.LEFT);
        p1BrainCountLabel.setTextFill(Color.WHITE);

        p1ShotgunCountLabel = new Label("Shotgun Count: ");
        p1ShotgunCountLabel.setFont(font);
        GridPane.setHalignment (p1ShotgunCountLabel, HPos.LEFT);
        p1ShotgunCountLabel.setTextFill(Color.WHITE);

        Label p2Label = new Label("Player 2");
        p2Label.setFont(font);
        GridPane.setHalignment (p2Label, HPos.RIGHT);
        p2Label.setTextFill(Color.WHITE);

        p2TotalScoreLabel = new Label("Total Score: ");
        p2TotalScoreLabel.setFont(font);
        GridPane.setHalignment (p2TotalScoreLabel, HPos.RIGHT);
        p2TotalScoreLabel.setTextFill(Color.WHITE);

        p2BrainCountLabel = new Label("Brain Count: ");
        p2BrainCountLabel.setFont(font);
        GridPane.setHalignment (p2BrainCountLabel, HPos.RIGHT);
        p2BrainCountLabel.setTextFill(Color.WHITE);

        p2ShotgunCountLabel = new Label("Shotgun Count: ");
        p2ShotgunCountLabel.setFont(font);
        GridPane.setHalignment (p2ShotgunCountLabel, HPos.RIGHT);
        p2ShotgunCountLabel.setTextFill(Color.WHITE);

        winText = new Label("*will be win label*");
        winText.setFont(font);
        GridPane.setHalignment(winText, HPos.CENTER);
        winText.setTextFill(Color.WHITE);


        //buttons
        Button rollBtn = new Button("Roll");
        rollBtn.setFont(font);
        rollBtn.setPrefWidth(50);
        rollBtn.setAlignment(Pos.CENTER);
        rollBtn.setOnAction(this::roll);

        Button passBtn = new Button("Pass");
        passBtn.setFont(font);
        passBtn.setPrefWidth(50);
        passBtn.setAlignment(Pos.CENTER);
        passBtn.setOnAction(this::pass);


        //making screen pretty
        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        setStyle("-fx-background-color: #013220");



        //Adding everything
        add(titleLabel,4,0,5,1);
        add(p1Label,0,1,3,1);
        add(p1TotalScoreLabel,0,2,3,1);
        add(p1BrainCountLabel,0,3,3,1);
        add(p1ShotgunCountLabel,0,4,3,1);
        add(p2Label,9,1,3,1);
        add(p2TotalScoreLabel,9,2,3,1);
        add(p2BrainCountLabel,9,3,3,1);
        add(p2ShotgunCountLabel,9,4,3,1);
        add(winText,4,12,4,1);
        add(rollBtn,2,10,2,1);
        add(passBtn, 8,10,2,1);
        add(imageBlank1, 1, 8);
        add(imageBlank2, 2, 8);
        add(imageBlank3, 3, 8);
        add(imageBlank4, 4, 8);
        add(imageBlank5, 5, 8);
        add(imageBlank6, 6, 8);
        add(imageBlank7, 7, 8);
        add(imageBlank8, 8, 8);
        add(imageBlank9, 9, 8);
        add(imageBlank10, 10, 8);
        add(currentImage1,2,5,2,2);
        add(currentImage2,5,5,2,2);
        add(currentImage3,8,5,2,2);
        addUpcomingDice();
        addCurrentDice();
    //
    }

    public ImageView selectCurrentImage(int num) {
        if (num == 0) {
            return imageBlank1;
        } else if (num == 1){
            return imageBlank2;
        } else if (num == 2){
            return imageBlank3;
        } else if (num == 3){
            return imageBlank4;
        } else if (num == 4){
            return imageBlank5;
        } else if (num == 5){
            return imageBlank6;
        } else if (num == 6){
            return imageBlank7;
        } else if (num == 7){
            return imageBlank8;
        } else if (num == 8){
            return imageBlank9;
        } else {
            return imageBlank10;
        }
    }

    public ImageView selectCurrentBigImage(int num) {
        if (num == 0) {
            return currentImage1;
        } else if (num == 1){
            return currentImage2;
        } else {
            return currentImage3;
        }
    }



    public void addCurrentDice(){
        if (isP1Turn) {
            for (int i = 0; i < 3; i++) {
                if (player1.findCurrentDiceColor(i) == 1) {
                    if (player1.findDiceSideName(i).equals("shotgun")){
                        selectCurrentBigImage(i).setImage(redShotgunDie);
                    } else if (player1.findDiceSideName(i).equals("footprint")){
                        selectCurrentBigImage(i).setImage(redFootprintDie);
                    } else {
                        selectCurrentBigImage(i).setImage(redBrainDie);
                    }
                } else if (player1.findCurrentDiceColor(i)  == 2) {
                    if (player1.findDiceSideName(i).equals("shotgun")){
                        selectCurrentBigImage(i).setImage(yellowShotgunDie);
                    } else if (player1.findDiceSideName(i).equals("footprint")){
                        selectCurrentBigImage(i).setImage(yellowFootprintDie);
                    } else {
                        selectCurrentBigImage(i).setImage(yellowBrainDie);
                    }
                } else {
                    if (player1.findDiceSideName(i).equals("shotgun")){
                        selectCurrentBigImage(i).setImage(greenShotgunDie);
                    } else if (player1.findDiceSideName(i).equals("footprint")){
                        selectCurrentBigImage(i).setImage(greenFootprintDie);
                    } else {
                        selectCurrentBigImage(i).setImage(greenBrainDie);
                    }
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (player2.findCurrentDiceColor(i) == 1) {
                    if (player2.findDiceSideName(i).equals("shotgun")){
                        selectCurrentBigImage(i).setImage(redShotgunDie);
                    } else if (player2.findDiceSideName(i).equals("footprint")){
                        selectCurrentBigImage(i).setImage(redFootprintDie);
                    } else {
                        selectCurrentBigImage(i).setImage(redBrainDie);
                    }
                } else if (player2.findCurrentDiceColor(i)  == 2) {
                    if (player2.findDiceSideName(i).equals("shotgun")){
                        selectCurrentBigImage(i).setImage(yellowShotgunDie);
                    } else if (player2.findDiceSideName(i).equals("footprint")){
                        selectCurrentBigImage(i).setImage(yellowFootprintDie);
                    } else {
                        selectCurrentBigImage(i).setImage(yellowBrainDie);
                    }
                } else {
                    if (player2.findDiceSideName(i).equals("shotgun")){
                        selectCurrentBigImage(i).setImage(greenShotgunDie);
                    } else if (player2.findDiceSideName(i).equals("footprint")){
                        selectCurrentBigImage(i).setImage(greenFootprintDie);
                    } else {
                        selectCurrentBigImage(i).setImage(greenBrainDie);
                    }
                }
            }
        }
    }


    public void addUpcomingDice(){
        if (isP1Turn) {
            for (int i = 0; i < player1.getDiceListLength(); i++) {
                if (player1.findDiceColor(i) == 1) {
                    selectCurrentImage(i).setImage(redDie);
                } else if (player1.findDiceColor(i) == 2) {
                    selectCurrentImage(i).setImage(yellowDie);
                } else {
                    selectCurrentImage(i).setImage(greenDie);
                }
            }

        } else {
            for (int i = 0; i < player2.getDiceListLength(); i++) {
                if (player2.findDiceColor(i) == 1) {
                    selectCurrentImage(i).setImage(redDie);
                } else if (player2.findDiceColor(i) == 2) {
                    selectCurrentImage(i).setImage(yellowDie);
                } else {
                    selectCurrentImage(i).setImage(greenDie);
                }
            }
        }
    }

    private void pass(ActionEvent event) {
        if (isP1Turn){
            isP1Turn = false;
            addCurrentDice();
            addUpcomingDice();
        } else {
            isP1Turn = true;
            addCurrentDice();
            addUpcomingDice();
        }
    }

    private void setLabels(){
        p1TotalScoreLabel.setText("Total Score: " + player1.getTotalScore());
        p1BrainCountLabel.setText("Brain Count: " + player1.getBrainCount());
        p1ShotgunCountLabel.setText("Shotgun Count: " + player1.getShotgunCount());
        p2TotalScoreLabel.setText("Total Score: " + player2.getTotalScore());
        p2BrainCountLabel.setText("Brain Count: " + player2.getBrainCount());
        p2ShotgunCountLabel.setText("Shotgun Count: " + player2.getShotgunCount());
    }

    private void roll(ActionEvent event) {
        if (isP1Turn) {
            player1.turn();
            addUpcomingDice();
            addCurrentDice();
            setLabels();

        } else {
            player2.turn();
            addUpcomingDice();
            addCurrentDice();
            setLabels();
        }
    }


}


