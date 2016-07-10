/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			RepairCol();
			MoveToNextCol();
		}
		RepairCol();
		ReadyToMove(); //OBOB (Off-by-one bug) problem
	}

/*
 * Pre-condition: Facing the east, in any position in the given world.
 * Post-condition: Finished one column repairment, facing the east at the end of the column
 */
	private void RepairCol() {
		MoveToColEnd();
		while (frontIsClear()) {			
			FillEmptySlots();
			SkipFilledSlots();
		}
		FillEmptySlots(); //OBOB (Off-by-one bug) problem
	}
	
/*
 * Pre-condition: Facing the east
 * Post-condition: Placed in the top of the column, facing the east
 */
	private void MoveToColEnd() {
		turnRight();
		if (frontIsClear()) {
			WalkToTheWall();
			turnAround();
		} else {
			turnAround();
		}	
	}

/*
 * Pre-condition: Facing the north in the quad column
 * Post-condition: when beepers are present, skip the slot
 */
	private void SkipFilledSlots() {
		if (beepersPresent()) {
			while (beepersPresent() && frontIsClear()) {
				move();
			}
		}
	}

/*
 * Pre-condition: Facing the north in the quad column
 * Post-condition: when beepers are not present, put beeper
 */
	private void FillEmptySlots() {
		if (noBeepersPresent()) {
			while (noBeepersPresent()) {
				putBeeper();
			}
		}
	}
	
/*
 * Pre-condition: none
 * Post-condition: Placed at the end of the wall in a given direction
 */
	private void WalkToTheWall() {
		while (frontIsClear()) {
			move();
		} 
	}

/*
 * Pre-condition: facing the north at the top of the column
 * Post-condition: facing east at the bottom of the next 4th column 
 */
	private void MoveToNextCol() {
		ReadyToMove();
		for (int i = 0; i<4; i++) {
			if (frontIsClear()) {
				move();
			}
		}
	}
/*
 * Pre-condition: facing the north at the top of the column
 * Post-condition: facing the east at the bottom of the same column
 */
	private void ReadyToMove() {
		turnAround();
		WalkToTheWall();
		turnLeft();
	}






}
