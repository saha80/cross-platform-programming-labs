import javafx.application.Application;
import javafx.stage.Stage;

public class Lab4 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setScene(new UI().getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
