import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;

public class UI {
    private final Scene scene;
    TextField firstReal = new TextField();
    TextField firstImag = new TextField();
    TextField secondReal = new TextField();
    TextField secondImag = new TextField();

    Button calculateButton = new Button("Calculate");
    Label result = new Label("0");

    EventHandler<ActionEvent> calculateButtonPressed = calculateArea -> {
        double leftReal, leftImag;
        double rightReal, rightImag;
        try {
            leftReal = Double.parseDouble(firstReal.getText());
            if (!firstImag.getText().isEmpty()) {
                leftImag = Double.parseDouble(firstImag.getText());
            } else {
                leftImag = 0;
            }
        } catch (NumberFormatException e) {
            result.setText("invalid length");
            return;
        }
        try {
            rightReal = Double.parseDouble(secondReal.getText());
            if (!secondImag.getText().isEmpty()) {
                rightImag = Double.parseDouble(secondImag.getText());
            } else {
                rightImag = 0;
            }
        } catch (NumberFormatException e) {
            result.setText("invalid height");
            return;
        }
        Expression expression = new Expression(
                Arrays.asList(new ComplexLinearForm(leftReal, leftImag), new ComplexLinearForm(rightReal, rightImag)));
        ComplexLinearForm res = expression.calculateResult();
        String resAsStr = String.valueOf(res.real());
        if (res.real() > 0) {
            resAsStr += '+' + String.valueOf(res.imag()) + 'i';
        } else if (res.imag() < 0) {
            resAsStr += String.valueOf(res.imag()) + 'i';
        }
        result.setText(resAsStr);
    };

    public UI() {
        VBox rootHBox = new VBox(10);

        HBox leftNumberBox = new HBox(20);
        HBox rightNumberBox = new HBox(20);
        HBox CalculateAndResult = new HBox(10);

        firstReal.setMaxWidth(100);
        firstImag.setMaxWidth(100);
        leftNumberBox.getChildren().addAll(new Label("Left"), firstReal, firstImag);
        leftNumberBox.setAlignment(Pos.CENTER);

        secondReal.setMaxWidth(100);
        secondImag.setMaxWidth(100);
        rightNumberBox.getChildren().addAll(new Label("Right"), secondReal, secondImag);
        rightNumberBox.setAlignment(Pos.CENTER);

        calculateButton.setOnAction(calculateButtonPressed);
        CalculateAndResult.getChildren().addAll(calculateButton, result);
        CalculateAndResult.setAlignment(Pos.CENTER);

        rootHBox.getChildren().addAll(leftNumberBox, rightNumberBox, CalculateAndResult);
        rootHBox.setAlignment(Pos.CENTER);

        scene = new Scene(rootHBox, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
