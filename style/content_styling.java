package style;

 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class content_styling {


	public void vbox(VBox vbox) { 
	     vbox.setSpacing(10);
          vbox.setPadding(new Insets(10,30,70,30));
		
	}
	public void vbox_main(VBox vbox) {
 	    vbox.setStyle("-fx-background-image: url('https://image.freepik.com/free-photo/old-wooden-texture-background-vintage_55716-1138.jpg')");
  	     vbox.setAlignment(Pos.CENTER);
  	     vbox.setSpacing(5);

	}
	
	public void button(Button button) { 
		button.setStyle("-fx-background-color:black;"
				+"-fx-background-radius:100%;"
				+ "-fx-min-height:60px;"
				+ "-fx-min-width:80px; "
				+ "-fx-text-fill:white;"
			);
  	}
	
	public void textfield(TextField textfield) { 
		
 		textfield.setDisable(true);
 		textfield.setStyle("-fx-background-color:white;"
 				+ "-fx-max-height:50px;"
 				+ "-fx-text-fill:black;"
				+ "-fx-font-size:20px;"
 				);
 			}
	
	public void mole_button(Button button) { 
		button.setStyle("-fx-background-image: url('https://icon-library.net/images/mole-icon/mole-icon-5.jpg');"+
				   "-fx-background-color:black;"
		    +"-fx-background-radius:100%;" 
 		   +"-fx-background-position:center;"
	 	   +"-fx-background-repeat:no-repeat;"
		   +"-fx-background-size:100%;"
	 	   + "-fx-min-height:70px;"
		   +"-fx-background-insets: 0,1,1;"
			+ "-fx-min-width:80px; ");
 	}
	
	
	public void reset_button(Button reset ) { 
        reset.setStyle("-fx-background-color:orange;"
 				+ "-fx-min-height:60px;"
				+"-fx-min-width:520px;"
 				+ "-fx-text-fill:white"); 
     	}
 }
