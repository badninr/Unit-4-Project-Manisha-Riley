//Imports
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.image.Image;



public class ZombieGUI extends GridPane {

    //Players
    ZombieGame player1 = new ZombieGame();
    ZombieGame player2 = new ZombieGame();



    //Keeps track of who's turn it is
    private boolean isP1Turn = true;



    //Labels
    private Label p1TotalScoreLabel;
    private Label p1BrainCountLabel;
    private Label p1ShotgunCountLabel;
    private Label p2TotalScoreLabel;
    private Label p2BrainCountLabel;
    private Label p2ShotgunCountLabel;
    private Label winText;
    private Label remainingDiceLabel;
    private Label playerLabel;
    private Label shotgunLabel;



    //Buttons
    private Button rollBtn;
    private Button passBtn;



    //ImageViews (holds images)
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



    //Constructor
    public ZombieGUI() {
        Font font = new Font(12);
        Font titleFont = new Font(25);


        //Sets up labels
        Label titleLabel = new Label("Zombie Dice");
        titleLabel.setFont(titleFont);
        GridPane.setHalignment (titleLabel, HPos.CENTER);
        titleLabel.setTextFill(Color.WHITE);

        Label p1Label = new Label("Player 1");
        p1Label.setFont(font);
        GridPane.setHalignment (p1Label, HPos.LEFT);
        p1Label.setTextFill(Color.WHITE);

        p1TotalScoreLabel = new Label("Total Score: 0");
        p1TotalScoreLabel.setFont(font);
        GridPane.setHalignment (p1TotalScoreLabel, HPos.LEFT);
        p1TotalScoreLabel.setTextFill(Color.WHITE);

        p1BrainCountLabel = new Label("Brain Count: 0");
        p1BrainCountLabel.setFont(font);
        GridPane.setHalignment (p1BrainCountLabel, HPos.LEFT);
        p1BrainCountLabel.setTextFill(Color.WHITE);

        p1ShotgunCountLabel = new Label("Shotgun Count: 0");
        p1ShotgunCountLabel.setFont(font);
        GridPane.setHalignment (p1ShotgunCountLabel, HPos.LEFT);
        p1ShotgunCountLabel.setTextFill(Color.WHITE);

        Label p2Label = new Label("Player 2");
        p2Label.setFont(font);
        GridPane.setHalignment (p2Label, HPos.RIGHT);
        p2Label.setTextFill(Color.WHITE);

        p2TotalScoreLabel = new Label("Total Score: 0");
        p2TotalScoreLabel.setFont(font);
        GridPane.setHalignment (p2TotalScoreLabel, HPos.RIGHT);
        p2TotalScoreLabel.setTextFill(Color.WHITE);

        p2BrainCountLabel = new Label("Brain Count: 0");
        p2BrainCountLabel.setFont(font);
        GridPane.setHalignment (p2BrainCountLabel, HPos.RIGHT);
        p2BrainCountLabel.setTextFill(Color.WHITE);

        p2ShotgunCountLabel = new Label("Shotgun Count: 0");
        p2ShotgunCountLabel.setFont(font);
        GridPane.setHalignment (p2ShotgunCountLabel, HPos.RIGHT);
        p2ShotgunCountLabel.setTextFill(Color.WHITE);

        winText = new Label("");
        winText.setFont(font);
        GridPane.setHalignment(winText, HPos.CENTER);
        winText.setTextFill(Color.WHITE);

        remainingDiceLabel = new Label("Remaining Dice: 10");
        remainingDiceLabel.setFont(font);
        GridPane.setHalignment(remainingDiceLabel, HPos.CENTER);
        remainingDiceLabel.setTextFill(Color.WHITE);

        playerLabel = new Label("Player 1's turn");
        playerLabel.setFont(font);
        GridPane.setHalignment(playerLabel, HPos.CENTER);
        playerLabel.setTextFill(Color.WHITE);

        shotgunLabel = new Label("");
        shotgunLabel.setFont(font);
        GridPane.setHalignment(shotgunLabel, HPos.CENTER);
        shotgunLabel.setTextFill(Color.WHITE);



        //Sets buttons
        rollBtn = new Button("Roll");
        rollBtn.setFont(font);
        rollBtn.setPrefWidth(50);
        rollBtn.setAlignment(Pos.CENTER);
        rollBtn.setOnAction(this::roll);

        passBtn = new Button("Pass");
        passBtn.setFont(font);
        passBtn.setPrefWidth(50);
        passBtn.setAlignment(Pos.CENTER);
        passBtn.setOnAction(this::pass);



        //Making screen pretty
        setAlignment(Pos.CENTER);
        setHgap(40);
        setVgap(20);
        setStyle("-fx-background-color: #013220");



        //Adding everything
        add(titleLabel,0,0,14,1);
        add(p1Label,1,1,3,1);
        add(p1TotalScoreLabel,1,2,3,1);
        add(p1BrainCountLabel,1,3,3,1);
        add(p1ShotgunCountLabel,1,4,3,1);
        add(p2Label,10,1,3,1);
        add(p2TotalScoreLabel,10,2,3,1);
        add(p2BrainCountLabel,10,3,3,1);
        add(p2ShotgunCountLabel,10,4,3,1);
        add(winText,5,12,5,1);
        add(rollBtn,3,10,2,1);
        add(passBtn, 9,10,2,1);
        add(imageBlank1, 2, 8);
        add(imageBlank2, 3, 8);
        add(imageBlank3, 4, 8);
        add(imageBlank4, 5, 8);
        add(imageBlank5, 6, 8);
        add(imageBlank6, 7, 8);
        add(imageBlank7, 8, 8);
        add(imageBlank8, 9, 8);
        add(imageBlank9, 10, 8);
        add(imageBlank10, 11, 8);
        add(currentImage1,3,5,2,2);
        add(currentImage2,6,5,2,2);
        add(currentImage3,9,5,2,2);
        add(remainingDiceLabel, 5, 11, 4,1 );
        add(playerLabel,5,1,4,1);
        add(shotgunLabel,0,13,14,1);
        addUpcomingDice();
        addCurrentDice();
    //
    }


    //Methods-----------------------------------------------------------------------------------------------------------



    //Tells addUpcomingDice what image slot to use
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




    //Tells addCurrentDice what image slot to use
    public ImageView selectCurrentBigImage(int num) {
        if (num == 0) {
            return currentImage1;
        } else if (num == 1){
            return currentImage2;
        } else {
            return currentImage3;
        }
    }




    //Updates the 3 main dice images based on color/side
    public void addCurrentDice(){
        for (int i = 0; i < 3; i++){
            selectCurrentBigImage(i).setImage(null);
        }
        if (isP1Turn) {
            for (int i = 0; i < 3; i++) {
                int currentSideName = player1.getCurrentSideName(i);
                if (player1.findCurrentDiceColor(i) == 1) {
                    if (currentSideName == 1 ){
                        selectCurrentBigImage(i).setImage(redShotgunDie);
                    }
                    if (currentSideName == 2 ){
                        selectCurrentBigImage(i).setImage(redBrainDie);
                    }
                    if (currentSideName == 3) {
                        selectCurrentBigImage(i).setImage(redFootprintDie);
                    }
                } else if (player1.findCurrentDiceColor(i) == 2) {
                    if (currentSideName == 1 ){
                        selectCurrentBigImage(i).setImage(yellowShotgunDie);
                    }
                    if (currentSideName == 2 ){
                        selectCurrentBigImage(i).setImage(yellowBrainDie);
                    }
                    if (currentSideName == 3) {
                        selectCurrentBigImage(i).setImage(yellowFootprintDie);
                    }
                } else {
                    if (currentSideName == 1 ){
                        selectCurrentBigImage(i).setImage(greenShotgunDie);
                    }
                    if (currentSideName == 2 ){
                        selectCurrentBigImage(i).setImage(greenBrainDie);
                    }
                    if (currentSideName == 3) {
                        selectCurrentBigImage(i).setImage(greenFootprintDie);
                    }
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                int currentSideName = player2.getCurrentSideName(i);
                if (player2.findCurrentDiceColor(i) == 1) {
                    if (currentSideName == 1 ){
                        selectCurrentBigImage(i).setImage(redShotgunDie);
                    }
                    if (currentSideName == 2 ){
                        selectCurrentBigImage(i).setImage(redBrainDie);
                    }
                    if (currentSideName == 3) {
                        selectCurrentBigImage(i).setImage(redFootprintDie);
                    }
                } else if (player2.findCurrentDiceColor(i) == 2) {
                    if (currentSideName == 1 ){
                        selectCurrentBigImage(i).setImage(yellowShotgunDie);
                    }
                    if (currentSideName == 2 ){
                        selectCurrentBigImage(i).setImage(yellowBrainDie);
                    }
                    if (currentSideName == 3) {
                        selectCurrentBigImage(i).setImage(yellowFootprintDie);
                    }
                } else {
                    if (currentSideName == 1 ){
                        selectCurrentBigImage(i).setImage(greenShotgunDie);
                    }
                    if (currentSideName == 2 ){
                        selectCurrentBigImage(i).setImage(greenBrainDie);
                    }
                    if (currentSideName == 3) {
                        selectCurrentBigImage(i).setImage(greenFootprintDie);
                    }
                }
            }
        }
    }



    //Updates small dice upcoming based on their color
    public void addUpcomingDice(){
        for (int i = 0; i < 10; i++){
            selectCurrentImage(i).setImage(null);
        }
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



    //Switches player, resets labels and images
    private void pass(ActionEvent event) {

        if (isP1Turn){
            isP1Turn = false;
            player1.setTotalScore();
            setLabels();
            winText.setText("");
            rollBtn.setVisible(true);
            player2.resetList();

        } else {
            isP1Turn = true;
            player2.setTotalScore();
            winText.setText("");
            rollBtn.setVisible(true);
            player1.resetList();
            setLabels();
        }
        checkPlayerWin();
        addCurrentDice();
        addUpcomingDice();
        currentImage1.setVisible(false);
        currentImage2.setVisible(false);
        currentImage3.setVisible(false);
    }



    //Resets the labels to current values
    private void setLabels(){
        p1TotalScoreLabel.setText("Total Score: " + player1.getTotalScore());
        p1BrainCountLabel.setText("Brain Count: " + player1.getBrainCount());
        p1ShotgunCountLabel.setText("Shotgun Count: " + player1.getShotgunCount());
        p2TotalScoreLabel.setText("Total Score: " + player2.getTotalScore());
        p2BrainCountLabel.setText("Brain Count: " + player2.getBrainCount());
        p2ShotgunCountLabel.setText("Shotgun Count: " + player2.getShotgunCount());
        if (isP1Turn) {
            remainingDiceLabel.setText("Remaining Dice: " + player1.getDiceListLength());
            playerLabel.setText("Player 1's turn");
        } else {
            remainingDiceLabel.setText("Remaining Dice: " + player2.getDiceListLength());
            playerLabel.setText("Player 2's turn");
        }
    }



    //Runs a turn, updates all images, labels, and values
    private void roll(ActionEvent event) {
        if (isP1Turn) {
            shotgunLabel.setText("");
            currentImage1.setVisible(true);
            currentImage2.setVisible(true);
            currentImage3.setVisible(true);
            player1.turn();
            if (player1.checkShotgunCount()){
                isP1Turn = false;
                addCurrentDice();
                addUpcomingDice();
                player1.setTotalScore();
                setLabels();
                winText.setText("");
                rollBtn.setVisible(true);
                player2.resetList();
                shotgunLabel.setText("You got 3 shotguns. Your brain score was emptied, and the turn was switched.");
            }
            setLabels();
            checkPlayerWin();
            addUpcomingDice();
            addCurrentDice();
            player1.replaceDice();
            if (player1.getDiceListLength() == 0){
                winText.setText("You are out of dice. Pass.");
                rollBtn.setVisible(false);
            }
        } else {
            shotgunLabel.setText("");
            currentImage1.setVisible(true);
            currentImage2.setVisible(true);
            currentImage3.setVisible(true);
            player2.turn();
            if (player2.checkShotgunCount()){
                isP1Turn = true;
                addCurrentDice();
                addUpcomingDice();
                player2.setTotalScore();
                winText.setText("");
                rollBtn.setVisible(true);
                player1.resetList();
                setLabels();
                shotgunLabel.setText("You got 3 shotguns. Your brain score was emptied, and the turn was switched.");
            }
            addUpcomingDice();
            addCurrentDice();
            setLabels();
            checkPlayerWin();
            player2.replaceDice();
            if (player2.getDiceListLength() == 0){
                winText.setText("You are out of dice. Pass.");
                rollBtn.setVisible(false);
            }
        }

    }



    //Checks for a player win and updates labels respectively
    public void checkPlayerWin(){
        if (player1.checkWin()){
            System.out.println("Player 1 wins");
                winText.setText("Player 1 wins!");
                rollBtn.setVisible(false);
                passBtn.setVisible(false);
                playerLabel.setText("");
                remainingDiceLabel.setText("");
        } else if (player2.checkWin()){
            System.out.println("Player 2 wins");
                winText.setText("Player 2 wins!");
                rollBtn.setVisible(false);
            passBtn.setVisible(false);
            playerLabel.setText("");
            remainingDiceLabel.setText("");


        }
    }


}


