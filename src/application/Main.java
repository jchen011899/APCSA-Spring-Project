/**
 * The snake program is a JavaFX version of the classic game
 * 
 * @author Jason Chen
 * @version 1.0
 * @since 2017-3-30
 */
package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Main extends Application {

	private Stage primaryStage;
	private AnchorPane introScreen;

	//Start method for the stage and launches the application
	/**
	 * @param parimaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			//Setting the primary stage field to the parameter in the start method
			this.primaryStage = primaryStage;
			//Setting title for the Application
			this.primaryStage.setTitle("SnakeFX");
			//Method used to load the application
			initRootLayout();

		} catch(Exception e) {
			e.printStackTrace();

		}
	}
	
	//Initialization routine for the application
	public void initRootLayout(){
		try{
			//Creates new FXML loader object
			FXMLLoader loader = new FXMLLoader();
			//Tells the FXML loader what to load
			loader.setLocation(Main.class.getResource("introScreen.fxml"));
			//Sets introScreen to AnchorPane
			introScreen = (AnchorPane) loader.load();
			//Sets a scene to the stage
			Scene scene = new Scene (introScreen);
			//Gives controller access to the main app
			introScreenController controller = loader.getController();
			
			//Shows the stage that was created
			controller.setMainApp(this);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);


	}
	
	
}
