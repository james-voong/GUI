package MovingCircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;

@SuppressWarnings("deprecation")
public class Animation extends Application {
	int width = 400, height = 300;
	Random rand = new Random();
	float x = 100, y = 100, dx = -3f, dy = -3f;
	ArrayList<MovableCircle> circles = new ArrayList<MovableCircle>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		for (int i = 0; i < 10; i++) {

			int rad = rand.nextInt(50);
			x = rand.nextFloat() * 200 + rad;
			y = rand.nextFloat() * 200 + rad;
			MovableCircle circle = new MovableCircle(x, y, rad, dx, dy);
			circle.setFill(Color.rgb((rand.nextInt(255)), rand.nextInt(255), rand.nextInt(255)));
			circles.add(circle);
			root.getChildren().add(circle);
		}
		final Scene scene = new Scene(root, width, height);

		KeyFrame frame = new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for (int i = 0; i < circles.size(); i++) {
					// Makes sure ball doesn't go off left edge
					if (circles.get(i).getCenterX() + circles.get(i).getTranslateX() < circles.get(i).getRadius()) {
						float newDx = 3f;
						circles.get(i).setDx(newDx);
					}
					// Makes sure ball doesn't go off right edge
					if (circles.get(i).getCenterX() + circles.get(i).getTranslateX()
							+ circles.get(i).getRadius() > scene.getWidth()) {
						float newDx = -3f;
						circles.get(i).setDx(newDx);
					}
					// Makes sure ball doesn't go off top
					if (circles.get(i).getCenterY() + circles.get(i).getTranslateY() < circles.get(i).getRadius()) {
						float newDy = 3f;
						circles.get(i).setDy(newDy);
					}
					// Makes sure ball doesn't go off bottom edge
					if (circles.get(i).getCenterY() + circles.get(i).getTranslateY()
							+ circles.get(i).getRadius() > scene.getHeight()) {
						float newDy = -3f;
						circles.get(i).setDy(newDy);

					}

					circles.get(i).setTranslateX(circles.get(i).getTranslateX() + circles.get(i).getDx());
					circles.get(i).setTranslateY(circles.get(i).getTranslateY() + circles.get(i).getDy());
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
