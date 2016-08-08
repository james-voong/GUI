package HigherOrLower;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HigherOrLower extends Application {
	int target = (int) (Math.random() * 99 + 1);
	TextField input = new TextField();
	final Text prev = new Text();
	final Text text = new Text();

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Higher or Lower");

		text.setText("Initial guess?");
		// force the field to be numeric only
		input.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					input.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		Button btn = new Button();
		btn.setText("New Game");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				target = (int) (Math.random() * 99 + 1);
				input.clear();
				text.setText("New game started. Initial guess?");
			}
		});

		input.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String guess = input.getText();
				int i = Integer.parseInt(guess);
				System.out.println(target);

				if (i > target && i > 0 && i <= 100) {
					text.setText("Target is lower");
					input.clear();
					prev.setText("Previous guess: " + i);
				} else if (i < target && i > 0 && i <= 100) {
					text.setText("Target is higher");
					input.clear();
					prev.setText("Previous guess: " + i);
				} else if (i == target) {
					text.setText("Congratulations, you win!");
					input.clear();
				} else {
					text.setText("Guess must be between 1-100");
					input.clear();
					prev.setText("Previous guess: " + i);
				}
			}
		});

		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(25, 25, 25, 25));
		pane.getChildren().add(text);
		pane.getChildren().add(input);
		pane.getChildren().add(prev);
		pane.getChildren().add(btn);

		primaryStage.setScene(new Scene(pane, 300, 250));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
