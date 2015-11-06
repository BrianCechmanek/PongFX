package pong;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;



public class MainScreen extends Application {
	public static Pane canvas;
	public static Paddle playerPaddle, aiPaddle; 
	public static Ball ball;
	public static int level;
	
	public static void main(String[] args) {
        System.out.println("Launching PongFX");
        launch(args);
        }

	public void start(Stage mainStage) {
		mainStage.setTitle("PongFX");
		mainStage.setResizable(false);
		
		//create the pane, called canvas by convention
		canvas = new Pane();
		
		// set the canvas onto the mainscene
		final Scene mainScene = new Scene(canvas, 750, 400, Color.CADETBLUE);
		
		
		//instantiate the player and AI paddles and ball
		playerPaddle = new Paddle(canvas.getWidth()/15, canvas.getHeight()/2.5 );
		aiPaddle = new Paddle( (canvas.getWidth()*.93), canvas.getHeight()/2.5 );
		ball = new Ball(canvas.getHeight());

		
		//set up a timeline and key listener so the paddles can move 
		// (and later the ball and score et c)
//		mainScene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

//			@Override
//			public void handle(KeyEvent event) {
				
				
//			}
			
			
//		});
		
		

		
		//Do the drawing
		canvas.getChildren().addAll(playerPaddle, aiPaddle, ball);
		//start up the level
		level = 1;
		ball.move(ball);
		mainStage.setScene(mainScene);
		mainStage.show();
	}
	
}
