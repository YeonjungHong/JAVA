/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {

	public void run() {
		WalkToTheDoor();
		PickUpNewspaper();
		ReturnToInit();
	}
	
/*
 * Pre-condition: Karel in the upper left corner of the house and facing the east.
 * Post-condition: Facing the open door
 */	
	private void WalkToTheDoor() {
		WalkToTheWall();
		turnRight();
		move();
		turnLeft();
	}

/*
 * Pre-condition: none
 * Post-condition: Facing the wall
 */
	private void WalkToTheWall() {
		while (frontIsClear()) {
			move();
			} 
	}

/*
 * Pre-condition: none
 * Post-condition: turned to the right	
 */
	private void turnRight() {
		for (int i = 1; i<4; i++) {
			turnLeft();
		}
	}

/*
 * Pre-condition: Facing beepers in the front
 * Post-condition: Back to the position in the pre-condition fronting the west with beepers
 */	
	private void PickUpNewspaper() {
			move();
			pickBeeper();
			turnAround();
			move();
	}

/*
 * Pre-condition: none
 * Post-condition: turned to the opposite direction
 */	
	private void turnAround() {
		turnLeft();
		turnLeft();
	}

/*
 * Pre-condition: Facing the west and against the door
 * Post-condition: Standing in the upper left corner facing the east	
 */
	private void ReturnToInit() {
		WalkToTheWall();
		turnRight();
		move();
		turnRight();	
	}
}