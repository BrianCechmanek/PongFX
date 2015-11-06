package pong;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;

public class Paddle extends Rectangle{
	
	public Paddle(double i, double d) {
		
		final int moveSpeed = 5;
		
		this.setLayoutX(i);
		this.setLayoutY(d);
		this.setHeight(MainScreen.canvas.getHeight()/6);
		this.setWidth(MainScreen.canvas.getWidth()/50);
		this.setFill(Color.ALICEBLUE);
		
		
	}

	public void moveUp() {
		this.setLayoutY(this.getLayoutY() - 5);
	}
	
	public void moveDown() {
		this.setLayoutY(this.getLayoutY() +  5);
	}
	
}
