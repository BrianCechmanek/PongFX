package pong;

import java.awt.event.KeyListener;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	
	public static void moveUp(Rectangle paddle) {
		paddle.setLayoutY(paddle.getLayoutY() - 20);
	}
	
	public static void moveDown(Rectangle paddle) {
		paddle.setLayoutY(paddle.getLayoutY() +  20);
	}

	
} //close class paddle

/*
MainScreen.canvas.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
	@Override
	public void handle(KeyEvent event) {
		if ((event.getCode() == KeyCode.KP_UP) && (paddle.getLayoutY() > 0))  {
			System.out.println("KeyCode is" + event.getCode());
			moveUp(paddle);
		}
		else if ((event.getCode() == KeyCode.KP_DOWN) && (paddle.getLayoutY() < MainScreen.canvas.getHeight()))  {
			System.out.println("KeyCode is" + event.getCode());
			moveDown(paddle);
		} else {
			System.out.println("KeyCode is" + event.getCode()  + " but it isn't registering correctly.");
		}
	}));


public void move(Rectangle paddle) {
	final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<KeyEvent>() {
			        MainScreen.canvas.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler <KeyEvent>() {
			        	    @Override
				        	    public void handle(KeyEvent event) {
				        		if ((event.getCode() == KeyCode.KP_UP) && (paddle.getLayoutY() > 0))  {
				        			System.out.println("KeyCode is" + event.getCode());
				        			moveUp(paddle);
				        		}
				        		else if ((event.getCode() == KeyCode.KP_DOWN) && (paddle.getLayoutY() < MainScreen.canvas.getHeight()))  {
				        			System.out.println("KeyCode is" + event.getCode());
				        			moveDown(paddle);
				        		} else {
				        			System.out.println("KeyCode is" + event.getCode()  + " but it isn't registering correctly.");
				        		}			        	     	
				        }
			    }
             )));

    loop.setCycleCount(Timeline.INDEFINITE);
    loop.play();
}
*/

/*	public void move(Paddle paddle) {
 final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<KeyEvent>() {
	@Override
	public void handle(KeyEvent event) {
		if ((event.getCode() == KeyCode.KP_UP) && (paddle.getLayoutY() > 0))  {
			System.out.println("KeyCode is" + event.getCode());
			moveUp(paddle);
		}
		else if ((event.getCode() == KeyCode.KP_DOWN) && (paddle.getLayoutY() < MainScreen.canvas.getHeight()))  {
			System.out.println("KeyCode is" + event.getCode());
			moveDown(paddle);
		} else {
			System.out.println("KeyCode is" + event.getCode()  + " but it isn't registering correctly.");
		}
	}
	}));
loop.setCycleCount(Timeline.INDEFINITE);
loop.play();	

} // close move()
*/