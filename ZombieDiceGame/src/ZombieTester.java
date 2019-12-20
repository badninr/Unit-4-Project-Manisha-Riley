import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


//Makes the GUI
public class ZombieTester extends Application {
    public void start(Stage stage) {
        Scene scene = new Scene(new ZombieGUI(), 750, 500);

        stage.setTitle("Zombie Dice");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[]args) {
        launch(args);
    }
}


