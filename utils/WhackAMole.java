package utils;
import java.util.ArrayList;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import style.content_styling;

class row { 
	public Button button;
	public int value;
	public boolean mole;
	public boolean clicked;
 
	
}
public class WhackAMole   {
	



private content_styling styling;
public 	int score; 
public 	int  molesleft; 
public	int attemptsleft; 
public ArrayList<row> moleGrid;
	public WhackAMole( int molesleft , int attemptsleft) {
		styling = new content_styling();
		moleGrid= new ArrayList<row>(); 
        this.molesleft=molesleft;
        this.attemptsleft=attemptsleft;
	}
	//EFFECT: printing the whole grid without the moles
	public VBox grid(int x , int y) { 
		 int n=0;

		  VBox vbox = new VBox(); 
		  for (int j=0; j<y; j++) {
		     HBox hbox = new  HBox(); 
		     hbox.setSpacing(30);
		     for(int i=0; i<x; i++) { 
			     Button button = new Button();
 			     button.setText(String.valueOf(n++));
			   	 row one_row=new row();
			     styling.button(button);
			     one_row.button=button; 
			     one_row.value=n;
			     one_row.mole=false;
			     one_row.clicked=false;
			     moleGrid.add(one_row);
         		 hbox.getChildren().add(one_row.button);
			    
		   }
		    vbox.getChildren().add(hbox);
	       styling.vbox(vbox);
	
		  }
		  return  vbox;
	   }
	
   public void whack() { 
     int j =0; 
	 for ( j=0; j<moleGrid.size(); j++) { 
         handle( moleGrid.get(j));
    		   
	   }		   
   } 	
   
   
   public void handle(row one) { 
     one.button.setOnMouseClicked( (new EventHandler<MouseEvent>(){ 
		public void handle(MouseEvent event) { 
 			one.button.setTextFill(Color.CORAL);
		if( one.mole==true  && one.clicked==false) {
			styling.mole_button(one.button);	
			molesleft--;
			one.clicked=true; 
  			 
		} else if(one.mole==false && one.clicked==false) { 
			
			attemptsleft--;
			one.clicked=true;
			one.button.setDisable(true);

  				}				  
			  }
		   }) );	   
	     }
    	
    //EFFECT: placing moles where they are supposed to be
    public void printgrid() { 
         int num=0;
		 Random rand = new Random();
         for(int i=0 ;i<molesleft ; i++) {
              num=rand.nextInt(24);
              for(int j=0; j<moleGrid.size(); j++) { 
             	   if(moleGrid.get(j).value== num) { 
    		       		   moleGrid.get(j).mole=true; 
    		   }   
    	   }
       }
    }
    
    public void reset( Button reset){ 
    	reset.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
 				 reset();
				   Alert alert= new Alert(AlertType.WARNING); 
	        	   alert.setTitle("Game Over");
	        	   alert.setContentText("Game is Over");
	        		 alert.show(); 
		
			}  
			});
    	
    	
    	}
    
    public void modify() { 
   	 for ( int j=0; j<moleGrid.size(); j++) { 
    
   		   moleGrid.get(j).button.setDisable(false);

   		   if(moleGrid.get(j).mole=true) { 
   			moleGrid.get(j).mole=false;
   		  styling.button(moleGrid.get(j).button);
   		   }
    		   
	   }		   
      printgrid();
    	
    }
    
   public boolean review(Alert alert) { 
   boolean game = false;

 	   if(molesleft<0) { 
 		   alert.setContentText("You Won, Congratulation!!! 😃 😃 😃");
 		 	 game=true;
      } else if ( attemptsleft<0){
		   alert.setContentText("Game Is over, good luck next time !! 😧 😧 😧");

    	  game=true;
    	  
      } else { 
	   	    game=false; 
	   	    }
 		  return game;	   
 		    }
    
  public void reset() { 
	    molesleft=5; 
		attemptsleft=5;
		modify();
   }
   
  
  public void reset_timer() {
	  
	  
	  
  }
   }
 

