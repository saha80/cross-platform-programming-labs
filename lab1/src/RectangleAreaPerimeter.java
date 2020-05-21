import javafx.application.*;
import javafx.stage.Stage;

public class RectangleAreaPerimeter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new UI().getScene());
        stage.setTitle("Area and Perimeter");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
