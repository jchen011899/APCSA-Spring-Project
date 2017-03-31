package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import application.Snake;
import application.Main;

public class introScreenController {

	//Fields decorated with @FXML tag in order for the code to interact with the GUI
	@FXML
	private Button playButton;
	@FXML
	private Button optionsButton;
	//Reference to main application to pass a reference to the controllers
	private Main mainApp;

	//Empty constructor. Loader looks for the constructor first 
	public introScreenController(){

	}

	//Initialize method that is decorated with @FXML tag and determines functionality of the GUI
	@FXML
	public void initialize(){
		//Eventhandler to determine assigne functionality to the playButton
		playButton.setOnAction(new EventHandler <ActionEvent> (){
			@Override
			public void handle(ActionEvent e) {
				//try catch used to detect errors in the run
				try { 
					//Instantiation of the snake class
					Snake snake = new Snake();
					//Method used to open a new stage when playButton is pressed
					snake.start(Snake.newStage);

				}catch(Exception ez){
					ez.printStackTrace();
				}

			}
		});
		//Eventhandler used to add functionality to the options button
		optionsButton.setOnAction(new EventHandler <ActionEvent> () {
			@Override
			public void handle(ActionEvent e){
				Parent root;
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OptionsScreen.fxml"));
		            Parent root1 = (Parent) fxmlLoader.load();
		            Stage stage = new Stage();
		            stage.initModality(Modality.APPLICATION_MODAL);
		            stage.initStyle(StageStyle.UNDECORATED);
		            stage.setTitle("Options");
		            stage.setScene(new Scene(root1));  
		            stage.show();
				} catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});


	}
	
	public void setMainApp(Main mainApp) {

		this.mainApp = mainApp;
	}


}



