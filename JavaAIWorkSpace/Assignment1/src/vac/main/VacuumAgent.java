package vac.main;
public class VacuumAgent {
	//Sensor data
	private boolean postion; //true = A, false = B
	private boolean isClean;//status of current square 
	//actuator actions
	private boolean clean;//weather or not should clean
	private boolean move;//weather or not should move
	/**<h1>Vacuum Agent argument constructor</h1>
	 * <p>
	 * @param startingSpace            : boolean true = A, false = B
	 * @param currentSpaceStatus       : boolean determines wither startingSpace is clean
	 * @Postcondition A Vacuum Object has been instantiated. */
	public VacuumAgent(boolean startingSpace, boolean currentSpaceStatus) {
		this.postion = startingSpace;
		this.isClean = currentSpaceStatus;
		this.determineAction();
	}
	/**<h1>Update Position</h1>
	 * <p>
	 * @param position            : boolean true = A, false = B
	 * @Postcondition position of vacuum has been updated*/
	public void updatePostion(boolean postion) {
		this.postion = postion;
	}
	/**<h1>Detect Dirt</h1>
	 * <p>
	 * @param clean            : boolean true = clean, false = false
	 * @Postcondition cleanliness of square currently occupied by vacuum has been determined
	 * and vacuum sensors have been updated. */
	public void isSquareClean(boolean clean) {
		this.isClean = clean;
	}
	/**<h1>Get position</h1>
	 * <p>
	 * @return position         : boolean true = A, false = B 
	 * @Postcondition The position of the vacuum has been return as boolean.*/
	public boolean getPostion() {
		return this.postion;
	}
	//Actuator methods
	/**<h1>Determine action</h1>
	 * <p>
	 * @Postcondition Determine actions to be performed by vacuum based on current sensor.  */
	public void determineAction() {
		if(isClean) {//if square is clean
			clean = false; //don't clean
			move = true; //move to the next square
		}else {//else if square is not clean
			clean = true;//clean dirty square
			move = false;//dont move
		}
	}
	//Actuators
	/**<h1>Cleaning Actuator</h1>
	 * <p>
	 * @return position         : boolean value of clean 
	 * @postcondition gives the value of cleaning actuator*/
	public boolean cleanActuator() {
		return clean;
	}
	/**<h1>Moving Actuator</h1>
	 * <p>
	 * @return position         : boolean value of move 
	 * @postcondition gives the value of moving actuator*/
	public boolean movingActuator() {
		return move;
	}
}
