/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// Let's say the checkerboard is n-by-m sized
	public void run() {
		if (frontIsClear()) {  // n > 1
			DrawCB();			// Draw the Checkerboard
		} else { 			   // n = 1
			turnLeft();
			if (frontIsClear()) { // n = 1 && m >1
				DrawCB();
			} else { 			  // n = 1 && m = 1
				putBeeper();
			}

		}
	}

	
	/*
	 * Draw the checkerboard 
	 * Pre-condition: The front is clear
	 * Post-condition: The whole checkerboard is appropriately filled
	 */
	private void DrawCB() {
		while (true) {
			if (frontIsClear()) {
				PutAndMove();
			} else {
				DrawIfBlocked(); {
				}
			}
		}
	}
	
	/* 
	 * Put and move twice
	 * Pre-condition: the beeper is not present and the front is clear
	 * Post-condition: moved twice and the beeper is not present
	 */
	private void PutAndMove() {
		putBeeper();
		for (int i = 0; i<2; i++) {
			OneStep();
		}
	}
	
	/* 
	 * Move twice and put
	 * Pre-condition: the beeper is present and the front is clear
	 * Post-condition: moved twice and the beeper is present
	 */	
	private void MoveAndPut() {
		for (int i = 0; i<2; i++) {
			OneStep();
		}
		putBeeper();
	}

	/* 
	 * Keep drawing the checkerboard even when the Karel is blocked by the wall
	 * Pre-condition: Facing the wall to the east or the west
	 * Post-condition: Move upward while executing the one chunk of drawing (2 move + 1 put)
	 */
	private void DrawIfBlocked() {
		if (facingEast()) {
			turnLeft(); // for odd-sized checkerboard
			if (frontIsClear() && noBeepersPresent()) {
				turnRight();
				PutAndMove();
			} else if (frontIsClear() && beepersPresent()) { 
				turnRight();
				MoveAndPut();
			} else if (frontIsBlocked() && noBeepersPresent()) {
				putBeeper();
			}
		} else if (facingWest()) {
			turnRight();
			if (frontIsClear() && noBeepersPresent()) {
				putBeeper();
			} else if (frontIsClear() && beepersPresent()) { 
				turnLeft();
				MoveAndPut();
			} else if (frontIsBlocked() && noBeepersPresent()) {
				putBeeper();
			}
		}
	}

	/*
	 * Pre-condition: Facing the east or the west
	 * Post-condition: If the front is clear, move forward.
	 * 				   If the front is blocked, move upward. 
	 */
	private void OneStep() {
		if (frontIsClear()) {
			move();
		} else {
			if (facingEast()) {
				MoveUpIfEastBlocked();	
			} else if (facingWest()) {
				MoveUpIfWestBlocked();
			}
		}
	}

	/*
	 * Pre-condition: The front is the wall while facing the east.
	 * Post-condition: Moved upward while facing the west
	 */
	private void MoveUpIfEastBlocked() {
		turnLeft();
		if (frontIsClear()) {
			move();
			turnLeft();
		} 
	}
	/*
	 * Pre-condition: The front is the wall while facing the west.
	 * Post-condition: Moved upward while facing the east
	 */	
	private void MoveUpIfWestBlocked() {
		turnRight();
		if (frontIsClear()) {
			move();
			turnRight();
		} 
	}

}
