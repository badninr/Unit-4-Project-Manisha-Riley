import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ZombieTester extends Application {
    public void start(Stage stage) {
        Scene scene = new Scene(new ZombieGUI(), 500, 400);

        stage.setTitle("Zombie Dice");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[]args) {
        launch(args);
    }
}


