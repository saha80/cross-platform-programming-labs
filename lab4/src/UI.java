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
    private final TextField formula = new TextField();
    private final TextField from = new TextField();
    private final TextField to = new TextField();

    private final Button calculateIntegralButton = new Button("Integral");
    private final Label integralResultLabel = new Label("0");

    EventHandler<ActionEvent> perimeterButtonPressed = calculatePerimeter -> {
        double form, to;
        try {
            form = Double.parseDouble(this.from.getText());
            to = Double.parseDouble(this.to.getText());
        } catch (NumberFormatException e) {
            this.integralResultLabel.setText("Invalid ranges");
            return;
        }
        Integral integral = new Integral(form, to, (int) (Math.abs(to - form) / 0.01));
        try {
            integral.setFormula(formula.getText().replace('X', 'x').replaceAll("\\s+", ""));
        } catch (IllegalArgumentException e) {
            this.integralResultLabel.setText("Invalid formula");
            return;
        }
        integral.calculateIntegral();
        this.integralResultLabel.setText(String.valueOf(integral.getResult()));
    };

    public UI() {
        VBox rootVBox = new VBox(10);

        HBox inputFormula = new HBox(20);
        HBox IntegralResultHBox = new HBox(10);
        HBox BoundsHBox = new HBox(10);
        HBox fromBound = new HBox(10);
        HBox toBound = new HBox(10);

        inputFormula.getChildren().addAll(new Label("Formula:"), formula);
        inputFormula.setAlignment(Pos.CENTER);

        to.setMaxWidth(50);
        toBound.getChildren().addAll(new Label("To:"), to);
        toBound.setAlignment(Pos.CENTER);

        from.setMaxWidth(50);
        fromBound.getChildren().addAll(new Label("From:"), from);
        fromBound.setAlignment(Pos.CENTER);

        BoundsHBox.getChildren().addAll(toBound, fromBound);
        BoundsHBox.setAlignment(Pos.CENTER);

        IntegralResultHBox.getChildren().addAll(calculateIntegralButton, integralResultLabel);
        IntegralResultHBox.setAlignment(Pos.CENTER);

        calculateIntegralButton.setOnAction(perimeterButtonPressed);

        rootVBox.getChildren().addAll(inputFormula, BoundsHBox, IntegralResultHBox);
        rootVBox.setAlignment(Pos.CENTER);
        scene = new Scene(rootVBox, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
