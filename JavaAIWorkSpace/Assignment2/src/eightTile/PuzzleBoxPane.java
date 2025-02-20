package eightTile;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/*Class for creating Puzzle Box in gPanes
 * */
public class PuzzleBoxPane {

	//Global variable
	//image of tiles 
	private Image i1 = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%202/JavaWorkSpace/Assignment2/src/Assest/1.png");
	private ImageView v1 = new ImageView(i1);
	private Image i2 = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%202/JavaWorkSpace/Assignment2/src/Assest/2.png");
	private ImageView v2 = new ImageView(i2);
	private Image i3 = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%202/JavaWorkSpace/Assignment2/src/Assest/3.png");
	private ImageView v3 = new ImageView(i3);
	private Image i4 = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%202/JavaWorkSpace/Assignment2/src/Assest/4.png");
	private ImageView v4 = new ImageView(i4);
	private Image i5 = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%202/JavaWorkSpace/Assignment2/src/Assest/5.png");
	private ImageView v5 = new ImageView(i5);
	private Image i6 = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%202/JavaWorkSpace/Assignment2/src/Assest/6.png");
	private ImageView v6 = new ImageView(i6);
	private Image i7 = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%202/JavaWorkSpace/Assignment2/src/Assest/7.png");
	private ImageView v7 = new ImageView(i7);
	private Image i8 = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%202/JavaWorkSpace/Assignment2/src/Assest/8.png");
	private ImageView v8 = new ImageView(i8);
	private Image iB = new Image("file:/C:/Users/Manny/Desktop/KSU/2019_Artificial%20Intelligence/Assignment%202/JavaWorkSpace/Assignment2/src/Assest/B.png");
	private ImageView vB = new ImageView(iB);
	
	//gridPane inner and outer
	private GridPane innerPane = new GridPane();
	private GridPane outerPane = new GridPane();
	
	//label
	private Label label;
	
	/**<h1> Constructor </h1>
	 * Create Puzzle Box Pane bases on given puzzle box
	 * <p>
	 * @param puzzleBox			: PuzzleBox to be represent in Pane
	 * @param name 				: String name of puzzle box(number)
	 * @postcondition 			: A pane representing the given 
	 * */
	public PuzzleBoxPane(PuzzleBox pb, String name) {
		//setup pane
		innerPane.setGridLinesVisible(true);
		//tiles index
		int k = 0;
		//nested for loops to fill inner Pane
		for(int i=0; i < 3; i++) {
			
			for(int j=0; j < 3; j++) {
				//set 1 tile
				if(pb.getTiles()[k]=='1') {
					innerPane.add(v1, j, i);
				}
				//set 2 tile
				if(pb.getTiles()[k]=='2') {
					innerPane.add(v2, j, i);
				}
				//set 3 tile
				if(pb.getTiles()[k]=='3') {
					innerPane.add(v3, j, i);
				}
				//set 4 tile
				if(pb.getTiles()[k]=='4') {
					innerPane.add(v4, j, i);
				}
				//set 5 tile
				if(pb.getTiles()[k]=='5') {
					innerPane.add(v5, j, i);
				}
				//set 6 tile
				if(pb.getTiles()[k]=='6') {
					innerPane.add(v6, j, i);
				}
				//set 7 tile
				if(pb.getTiles()[k]=='7') {
					innerPane.add(v7, j, i);
				}
				//set 8 tile
				if(pb.getTiles()[k]=='8') {
					innerPane.add(v8, j, i);
				}
				//set Blank tile
				if(pb.getTiles()[k]=='*') {
					innerPane.add(vB, j, i);
				}
				k++;
			}
		}
		//create Label
		label = new Label("PuzzleBox "+ name +" f(n)="+pb.getFn());
		//place inner in outer
		outerPane.add(innerPane, 0, 0);
		outerPane.add(label, 0, 1);
	}
	
	/**Get Puzzle Box Pane
	 * @return PuzzleBoxPane		: outerPane
	 * @postcondition 				: returns outerPane 
	 * */
	public GridPane getPuzzleBoxPane() {
		return outerPane;
	}
}
