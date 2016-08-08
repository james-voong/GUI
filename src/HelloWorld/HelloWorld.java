package HelloWorld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World");

		final Text text = new Text();
		text.setText("Noone has greeted you");

		Button btn = new Button();
		btn.setText("Greet you");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			int n = 0;

			@Override
			public void handle(ActionEvent arg0) {
				n++;
				if (n == 1) {
					text.setText("Hello there! Said " + n + " time");
				} else
					text.setText("Hello there! Said " + n + " time(s)");

			}

		});

		Button btn2 = new Button();
		btn2.setText("Meh");
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				double rand = Math.random();
				if (rand <= 0.2) {
					text.setText("Go away");
				} else if (rand > 0.2 && rand <= 0.4) {
					text.setText("Piss off");
				} else if (rand > 0.4 && rand <= 0.6) {
					text.setText("Please leave");
				} else if (rand > 0.6 && rand <= 0.8) {
					text.setText("Leave me alone.");
				} else if (rand > 0.8) {
					text.setText("I demand you leave me alone. Now.");
				}
			}

		});

		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(25, 25, 25, 25));
		pane.getChildren().add(text);
		pane.getChildren().add(btn);
		pane.getChildren().add(btn2);

		primaryStage.setScene(new Scene(pane, 300, 250));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
