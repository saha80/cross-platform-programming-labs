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

    HBox perimeterIntegral = new HBox(10);
    private final Button calculateIntegralButton = new Button("Integral");
    private final Label integralResultLabel = new Label("0");

    EventHandler<ActionEvent> perimeterButtonPressed = calculatePerimeter -> {
        Integral integral = new Integral(-2, 2, 1000);
        try {
            integral.setFormula(formula.getText());
        } catch (IllegalArgumentException e) {
            this.integralResultLabel.setText("Illegal formula");
            return;
        }
        integral.calculateIntegral();
        this.integralResultLabel.setText(String.valueOf(integral.getResult()));
    };

    public UI() {
        VBox rootVBox = new VBox(10);
        
        HBox inputFormula = new HBox(20);
        
        inputFormula.getChildren().addAll(new Label("Formula:"), formula);
        inputFormula.setAlignment(Pos.CENTER);
        
        perimeterIntegral.getChildren().addAll(calculateIntegralButton);
        perimeterIntegral.setAlignment(Pos.CENTER);

        calculateIntegralButton.setOnAction(perimeterButtonPressed);

        rootVBox.getChildren().addAll(inputFormula, calculateIntegralButton, integralResultLabel);
        rootVBox.setAlignment(Pos.CENTER);
        scene = new Scene(rootVBox, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
