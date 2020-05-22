import javafx.application.Application;
import javafx.stage.Stage;

public class Lab2 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setScene(new UI().getScene());
        stage.setTitle("Lab 2");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
