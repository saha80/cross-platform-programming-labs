import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UI {
    private Scene scene;
    TextField leftComplex = new TextField();
    TextField rightComplex = new TextField();

    Button calculateButton = new Button("Calculate");
    Label result = new Label("0");

    EventHandler<ActionEvent> calculateButtonPressed = calculateArea -> {
        Integer l, h;
        try {
            l = Integer.valueOf(leftComplex.getText());
            if (l < 0) {
                result.setText("negative length");
                return;
            }
        } catch (NumberFormatException e) {
            result.setText("invalid length");
            return;
        }
        try {
            h = Integer.valueOf(rightComplex.getText());
            if (h < 0) {
                result.setText("negative height");
                return;
            }
        } catch (NumberFormatException e) {
            result.setText("invalid height");
            return;
        }
        result.setText(String.valueOf(l * h));
    };

    public UI() {
        VBox rootHBox = new VBox(10);

        HBox leftNumberBox = new HBox(20);
        HBox rightNumberBox = new HBox(20);
        HBox CalculateAndResult = new HBox(10);

        leftNumberBox.getChildren().addAll(new Label("Left"), leftComplex);
        leftNumberBox.setAlignment(Pos.CENTER);

        rightNumberBox.getChildren().addAll(new Label("Right"), rightComplex);
        rightNumberBox.setAlignment(Pos.CENTER);

        calculateButton.setOnAction(calculateButtonPressed);
        CalculateAndResult.getChildren().addAll(calculateButton, result);

        rootHBox.getChildren().addAll(leftNumberBox, rightNumberBox, CalculateAndResult);
        rootHBox.setAlignment(Pos.CENTER);

        scene = new Scene(rootHBox, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
