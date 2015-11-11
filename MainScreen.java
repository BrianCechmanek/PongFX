package pong;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
		
		//Do the drawing
		canvas.getChildren().addAll(playerPaddle, aiPaddle, ball);
		//start up the level
		level = 1;
		ball.move(ball);


		mainScene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if ((event.getCode() == KeyCode.KP_UP) && (playerPaddle.getLayoutY() > 0))  {
					System.out.println("KeyCode is" + event.getCode());
					Paddle.moveUp(playerPaddle);
				}
				else if ((event.getCode() == KeyCode.KP_DOWN) && (playerPaddle.getLayoutY() < MainScreen.canvas.getHeight()))  {
					System.out.println("KeyCode is" + event.getCode());
					Paddle.moveDown(playerPaddle);
				} else {
					System.out.println("KeyCode is " + event.getCode()  + " but if/else isn't catching codes correctly.");
				}
		    }		
		});			
		mainStage.setScene(mainScene);
		mainStage.show();
	}
	
}
