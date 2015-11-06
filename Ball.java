package pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;

public class Ball extends Circle {
    public Ball( double i) { 
    
	this.setLayoutX(MainScreen.canvas.getWidth()/2);
	this.setLayoutY(MainScreen.canvas.getHeight()/2);
	this.setRadius(i/30);
	this.setFill(Color.ALICEBLUE);		
    }
    
    public void move(Circle shape) {
    	    final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
    	    	    int deltaX = 4 * MainScreen.level;
    	    	    int generateUpDown() {
    	    	    	    double temp = Math.random();
    	    	    	    if (temp<0.5) {
    	    	    	    	    return -1;
    	    	    	    } else {
    	    	    	    	    return 1;
    	    	    	    }
    	    	    }
    	        int deltaY = generateUpDown() * MainScreen.level;
    	        
			@Override
			public void handle(ActionEvent event) {
		        final Bounds bounds = MainScreen.canvas.getBoundsInLocal();
		        final boolean atRIghtBorder = shape.getLayoutX() + shape.getRadius() >= (bounds.getMaxX());
		        final boolean atLeftBorder = shape.getLayoutX() - shape.getRadius() <= (bounds.getMinX());
		        final boolean atTopBorder = shape.getLayoutY() <= (bounds.getMinY() + shape.getRadius());
		        final boolean atBottomBorder = shape.getLayoutY() >= (bounds.getMaxY() - shape.getRadius());
		        
                if (atRIghtBorder) {
                	deltaX *= -1;
                	shape.setLayoutX(shape.getLayoutX() - shape.getRadius());
                }
                if (atLeftBorder) {
                	deltaX *= -1;
                	shape.setLayoutX(shape.getLayoutX() + shape.getRadius());
                }
                if (atTopBorder) {
                	deltaY *= -1;
                	shape.setLayoutY(shape.getLayoutY() + shape.getRadius());
                }
                if (atBottomBorder) {
                	deltaY *= -1;
                	shape.setLayoutY(shape.getLayoutY() - shape.getRadius());
                }

                shape.setLayoutX(shape.getLayoutX() + deltaX);
                shape.setLayoutY(shape.getLayoutY() + deltaY);	
                
                detectCollision(shape);
			   }

		    public void detectCollision(Circle shape) {
	    	        final boolean inPlayerPaddle = shape.getBoundsInParent().intersects(MainScreen.playerPaddle.getBoundsInParent());
	    	        final boolean inAiPaddle = shape.getBoundsInParent().intersects(MainScreen.aiPaddle.getBoundsInParent());
	    	    
	    	        if(inPlayerPaddle || inAiPaddle) {
	    	    	        deltaX *= -1;
	    	    	        deltaY *= -1;
		            shape.setLayoutX(shape.getLayoutX());
		            shape.setLayoutY(shape.getLayoutY());
	    	        }
		    }
		    
    	        
    	    }));
    	    loop.setCycleCount(Timeline.INDEFINITE);
    	    loop.play();	  
    }  
    
}
