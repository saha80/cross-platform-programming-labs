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
    private final Scene scene;
    HBox inputLength = new HBox(20);
    TextField length = new TextField();
    HBox inputHeight = new HBox(20);
    TextField height = new TextField();

    HBox areaParameter = new HBox(10);
    Button calculateAreaButton = new Button("Area");
    Label area = new Label("0");

    HBox perimeterParameter = new HBox(10);
    Button calculatePerimeterButton = new Button("Perimeter");
    Label perimeter = new Label("0");

    HBox RectangleParameters = new HBox(10);

    EventHandler<ActionEvent> areaButtonPressed = calculateArea -> {
        Integer l = 0, h = 0;
        try {
            l = Integer.valueOf(length.getText().replaceAll("\\s+", ""));
            if (l < 0) {
                area.setText("negative length");
                return;
            }
        } catch (NumberFormatException e) {
            area.setText("invalid length");
            return;
        }
        try {
            h = Integer.valueOf(height.getText().replaceAll("\\s+", ""));
            if (h < 0) {
                area.setText("negative height");
                return;
            }
        } catch (NumberFormatException e) {
            area.setText("invalid height");
            return;
        }
        area.setText(String.valueOf(l * h));
    };

    EventHandler<ActionEvent> perimeterButtonPressed = calculatePerimeter -> {
        Integer l = 0, h = 0;
        try {
            l = Integer.valueOf(length.getText().replaceAll("\\s+", ""));
            if (l < 0) {
                perimeter.setText("negative length");
                return;
            }
        } catch (NumberFormatException e) {
            perimeter.setText("invalid height");
            return;
        }
        try {
            h = Integer.valueOf(height.getText().replaceAll("\\s+", ""));
            if (h < 0) {
                perimeter.setText("negative height");
                return;
            }
        } catch (NumberFormatException e) {
            perimeter.setText("invalid height");
            return;
        }
        perimeter.setText(String.valueOf(2 * (l + h)));
    };

    public UI() {
        VBox root_v_layout = new VBox(10);
        inputLength.getChildren().addAll(new Label("Length"), length);
        inputLength.setAlignment(Pos.CENTER);
        inputHeight.getChildren().addAll(new Label("Height"), height);
        inputHeight.setAlignment(Pos.CENTER);

        areaParameter.getChildren().addAll(calculateAreaButton, area);
        areaParameter.setAlignment(Pos.CENTER);
        perimeterParameter.getChildren().addAll(calculatePerimeterButton, perimeter);
        perimeterParameter.setAlignment(Pos.CENTER);

        calculateAreaButton.setOnAction(areaButtonPressed);
        calculatePerimeterButton.setOnAction(perimeterButtonPressed);

        RectangleParameters.getChildren().addAll(areaParameter, perimeterParameter);
        RectangleParameters.setAlignment(Pos.CENTER);
        root_v_layout.getChildren().addAll(inputLength, inputHeight, RectangleParameters);
        root_v_layout.setAlignment(Pos.CENTER);
        scene = new Scene(root_v_layout, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
