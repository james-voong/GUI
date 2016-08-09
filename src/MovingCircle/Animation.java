package MovingCircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;

public class Animation extends Application {
	int width = 400, height = 300;
	Random rand = new Random();
	float x = 100, y = 100, dx = -1.5f, dy = -1.5f;
	ArrayList<Circle> circles = new ArrayList<Circle>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		for (int i = 0; i < 2; i++) {
			x = rand.nextFloat() * 200;
			y = rand.nextFloat() * 200;
			int rad = rand.nextInt(30) + 12;
			
			if (x < rad)
				x = rad;

			if (y < rad)
				y = rad;

			Circle circle = new Circle(x, y, rad);
			circle.setFill(Color.rgb((rand.nextInt(255)), rand.nextInt(255), rand.nextInt(255)));
			circles.add(circle);
			root.getChildren().add(circle);
		}
		final Scene scene = new Scene(root, width, height);

		KeyFrame frame = new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for (int i = 0; i < circles.size(); i++) {
					if (circles.get(i).getCenterX() + circles.get(i).getTranslateX() < circles.get(i).getRadius()
							|| circles.get(i).getCenterX() + circles.get(i).getTranslateX()
									+ circles.get(i).getRadius() > scene.getWidth()) {
						dx = -dx;
					}
					if (circles.get(i).getCenterY() + circles.get(i).getTranslateY() < circles.get(i).getRadius()
							|| circles.get(i).getCenterY() + circles.get(i).getTranslateY()
									+ circles.get(i).getRadius() > scene.getHeight()) {
						dy = -dy;
					}
					circles.get(i).setTranslateX(circles.get(i).getTranslateX() + dx);
					circles.get(i).setTranslateY(circles.get(i).getTranslateY() + dy);
				}
			}

		});
		TimelineBuilder.create().cycleCount(javafx.animation.Animation.INDEFINITE).keyFrames(frame).build().play();

		primaryStage.setTitle("Animation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
