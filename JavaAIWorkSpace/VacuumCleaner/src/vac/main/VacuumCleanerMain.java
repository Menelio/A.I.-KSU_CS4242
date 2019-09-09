package vac.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class VacuumCleanerMain extends Application  {
//Global variables
	private VacuumAgent vacuum;
	private boolean vacuumExists = false;//check if vacuum has been created
	
	//status of each space (clean/dirty)
	private boolean spaceAIsClean = true;
	private boolean spaceBIsClean = true;
	
	//Image Of the world states
	private Image dirtAB_vac = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/DirtAB_Vac.png"); 
	private Image dirtA_vac = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/DirtA_Vac.png");
	private Image dirtB_vac = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/DirtB_Vac.png");
	private Image dirt_vac = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/Dirt_Vac.png");
	
	private Image dirtAB_vacA = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/DirtAB_VacA.png"); 
	private Image dirtA_vacA = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/DirtA_VacA.png");
	private Image dirtB_vacA = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/DirtB_VacA.png");
	private Image dirt_vacA = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/Dirt_VacA.png");
	
	private Image dirtAB_vacB = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/DirtAB_VacB.png"); 
	private Image dirtA_vacB = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/DirtA_VacB.png");
	private Image dirtB_vacB = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/DirtB_VacB.png"); 
	private Image dirt_vacB = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%201/JavaWorkSpace/VacuumCleaner/assests/Dirt_VacB.png");
	
	//buttons
	Button statusA = new Button("Add dirt to space A");//add or remove dirt from A
	Button statusB = new Button("Add dirt to space B");//add or remove dirt from B
	Button placeVacA = new Button("Place vacuum in space A");//place vacuum in A
	Button placeVacB = new Button("Place vacuum in space B");//place vacuum in B
	Button acuate = new Button("Turn on vacuum");//trigger vacuum actuators
	
	//List of performed actions by vacuum
	ListView<String> log = new ListView<String>();
	
	//Anchor pane to set buttons and grid pane
	private AnchorPane aPane = new AnchorPane();
	
	//Image View 
	private ImageView imgVw = new ImageView(dirt_vac);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//position and place Image of Environment in anchor pane
		aPane.getChildren().add(imgVw);
		AnchorPane.setTopAnchor(imgVw, 0.0);
		AnchorPane.setLeftAnchor(imgVw, 0.0);
		
		//position and place buttons in anchor pane
		//statusA button
		aPane.getChildren().add(statusA);
		AnchorPane.setTopAnchor(statusA, 320.0);
		AnchorPane.setLeftAnchor(statusA, 100.0);
		//placeVacA button
		aPane.getChildren().add(placeVacA);
		AnchorPane.setTopAnchor(placeVacA, 350.0);
		AnchorPane.setLeftAnchor(placeVacA, 85.0);
		//statusB button
		aPane.getChildren().add(statusB);
		AnchorPane.setTopAnchor(statusB, 320.0);
		AnchorPane.setLeftAnchor(statusB, 400.0);
		//placeVacB button
		aPane.getChildren().add(placeVacB);
		AnchorPane.setTopAnchor(placeVacB, 350.0);
		AnchorPane.setLeftAnchor(placeVacB, 385.0);
		//acuate button
		aPane.getChildren().add(acuate);
		AnchorPane.setTopAnchor(acuate, 0.0);
		AnchorPane.setLeftAnchor(acuate, 620.0);
		
		//position and place list of steps performed by vacuum
		aPane.getChildren().add(log);
		AnchorPane.setTopAnchor(log, 25.0);
		AnchorPane.setLeftAnchor(log, 620.0);
		
		//add functionality to buttons
		statusA.setOnAction(e->{
			if(spaceAIsClean) {
				spaceAIsClean = false;
			}else {
				spaceAIsClean = true;
			}
			updateEnvironment ();
		});
		statusB.setOnAction(e->{
			if(spaceBIsClean) {
				spaceBIsClean = false;
			}else {
				spaceBIsClean = true;
			}
			updateEnvironment ();
		});
		
		placeVacA.setOnAction(e->{
			if(!vacuumExists) {
				vacuum = new VacuumAgent(true,spaceAIsClean );
				vacuumExists = true;
				updateEnvironment ();
			}else if(vacuumExists && vacuum.getPostion()){
				vacuumExists = false;
				vacuum.updatePostion(true);
				updateEnvironment ();
			}
		});
		placeVacB.setOnAction(e->{
			if(!vacuumExists) {
				vacuum = new VacuumAgent(false,spaceBIsClean );
				vacuumExists = true;
				updateEnvironment ();
			}else if(vacuumExists && !vacuum.getPostion()){
				vacuumExists = false;
				vacuum.updatePostion(false);
				updateEnvironment ();
			}
		});
		
		acuate.setOnAction(e->{
			turnOnVacuum();
		});
		
		//Set up window
		Scene scene = new Scene(aPane);
		stage.setScene(scene);
		stage.show();
	}
	//Update Environment
	public void updateEnvironment () {
		//update imgVw based on Environment booleans
		if(spaceAIsClean && spaceBIsClean && !vacuumExists) {//If vacuum has not been placed
			imgVw.setImage(dirt_vac); 
		}else if(!spaceAIsClean && spaceBIsClean && !vacuumExists) {
			imgVw.setImage(dirtA_vac); 
		}else if(spaceAIsClean && !spaceBIsClean && !vacuumExists) {
			imgVw.setImage(dirtB_vac); 
		}else if(!spaceAIsClean && !spaceBIsClean && !vacuumExists) {
			imgVw.setImage(dirtAB_vac); 
		}else if(spaceAIsClean && spaceBIsClean && vacuumExists && vacuum.getPostion()) {//If vacuum has been placed in A
				imgVw.setImage(dirt_vacA);
		}else if(!spaceAIsClean && spaceBIsClean && vacuumExists && vacuum.getPostion()) {
				imgVw.setImage(dirtA_vacA);
		}else if(spaceAIsClean && !spaceBIsClean && vacuumExists && vacuum.getPostion()) {
				imgVw.setImage(dirtB_vacA);
		}else if(!spaceAIsClean && !spaceBIsClean && vacuumExists && vacuum.getPostion()) {
				imgVw.setImage(dirtAB_vacA);
		}else if(spaceAIsClean && spaceBIsClean && vacuumExists && !vacuum.getPostion()) {//If vacuum has been placed in B
				imgVw.setImage(dirt_vacB);
		}else if(!spaceAIsClean && spaceBIsClean && vacuumExists && !vacuum.getPostion()) {
				imgVw.setImage(dirtA_vacB);
		}else if(spaceAIsClean && !spaceBIsClean && vacuumExists && !vacuum.getPostion()) {
				imgVw.setImage(dirtB_vacB);
		}else if(!spaceAIsClean && !spaceBIsClean && vacuumExists && !vacuum.getPostion()) {
				imgVw.setImage(dirtAB_vacB);
		}
	}
	/*Turn on vacuum and updates log with each step the vacuum takes*/
	public void turnOnVacuum() {
		if(vacuumExists) {
			while(!spaceAIsClean || !spaceBIsClean) { //while both sides are dirty the vacuum runs
				vacuum.determineAction();//update actuators
				if(vacuum.cleanActuator()&&vacuum.getPostion()) {
					spaceAIsClean = true;
					log.getItems().add("Vacuum cleaned space A");
					vacuum.isSquareClean(true);
				}else if(vacuum.cleanActuator()&&!vacuum.getPostion()) {
					spaceBIsClean = true;
					log.getItems().add("Vacuum cleaned space B");
					vacuum.isSquareClean(true);
				}else if(vacuum.movingActuator()) {
					vacuum.updatePostion(!vacuum.getPostion());
					vacuum.isSquareClean(false);
					if(vacuum.getPostion()) {
						log.getItems().add("Vacuum moved to space A");
					}else {
						log.getItems().add("Vacuum moved to space B");
					}
				}
				updateEnvironment ();
			}
			log.getItems().add("Vacuum has finished cleaning");
		}
	}
}
