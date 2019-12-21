package Draw;
import utils.WhackAMole;
import style.content_styling;

import com.sun.prism.paint.Color;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class main extends Application  {
	static   WhackAMole whackamole; 
    static   content_styling  styling;
	static   TextField moles_left;
	static   TextField attempts_left;
	static   Button review;
	static   Alert gameover;
    boolean game ;

	public static void main(String[] args) {
 		Application.launch(args);
        

	}
   @Override
	public void start(Stage stage) throws Exception {
	    whackamole = new WhackAMole(5,5);
	    styling=new content_styling();
 		stage.setTitle("Whack a mole");
 	
 	   	moles_left=new TextField();
 		attempts_left=new TextField();
        gameover= new Alert(AlertType.WARNING); 
  	 	styling.textfield(moles_left);
 	 	styling.textfield(attempts_left);
        gameover.setTitle("Game Over");
  	    Timeline timeline = new Timeline(new KeyFrame(
  	        Duration.millis(20),
  	        ae -> reptetive_actions()));
       timeline.setCycleCount(Animation.INDEFINITE);
  	   timeline.play();

	 	
 	 	
 		HBox hbox= new HBox(moles_left, attempts_left);
        hbox.setSpacing(20);
        hbox.setAlignment(Pos.CENTER);
        Button reset= new Button("reset");
        whackamole.reset(reset);

        styling.reset_button(reset);
		VBox vbox = new VBox( whackamole.grid(5,5)  ,hbox, reset );
		whackamole.printgrid();
		whackamole.whack();
 		styling.vbox_main(vbox);
        Scene scene = new Scene(vbox, 600,600);
   		stage.setScene(scene);
  		stage.setMaxHeight(600);
		stage.setMaxWidth(600);
		 
		stage.show();

   }
        
      public   void   reptetive_actions() {
	   moles_left.setText(Integer.toString(whackamole.molesleft));
	   attempts_left.setText(Integer.toString(whackamole.attemptsleft)); 
       whackamole.review(gameover);
       game= whackamole.review(gameover);
       if( game){ 
 	      System.out.print("nooooo");
         whackamole.reset();
         gameover.show();
         } 
      }
   }
	 
    
	 

   

