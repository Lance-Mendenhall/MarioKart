import java.util.Scanner;

public class MarioKartCourseSelector {

	public static void main(String[] args) {
		
		boolean stillPlaying=true;
		Scanner sc = new Scanner(System.in);
		Racers myRacer = new Racers();
		Courses myCourses = new Courses();
		//String[] courseOptions = new String[3];
		
		while(stillPlaying) {
			// get 3 distinct courses
			myCourses.getDistinct();
		
		// display courses
		// display course, then pick course - if course is picked decrement value
		// option to view what random is
		
			System.out.print("Select a course:\n1) ");
			myCourses.displayCourseChoices(0); 
			System.out.print("\n2) ");
			myCourses.displayCourseChoices(1);
			System.out.print("\n3) ");
			myCourses.displayCourseChoices(2);
			System.out.print("\n4) Random\n5) Quit game"
				+ "\n6) Display array with indices" + "\n7) Race!" 
				+ "\n8) Display Racers" + "\n9) Display racers with skills\n");
			
			// switch statement for choice
			boolean validChoice=false;
			
			while(!validChoice) {
				int choice=sc.nextInt();
				String str=sc.nextLine();
				switch(choice) {
				case 1:
				case 2:
				case 3:	
					//call function
					System.out.print("You chose ");
					myCourses.displayCourseSelection(choice-1);
					System.out.println("");
					validChoice=true;
					break;
				case 4: // random course
					System.out.println("You chose ");
					myCourses.pickedRandom();
					System.out.println("");
					validChoice=true;
					break;
				case 5:
					validChoice=true;
					stillPlaying=false;
					System.out.println("Thanks for playing! Goodbye!");
					break;
				case 6:
					myCourses.displayWithIndex();
					break;
				case 7:
					myRacer.haveARace();
					break;
				case 8:
					myRacer.displayRacers();
					break;
				case 9:
					myRacer.displayRacersWithSkill();
					break;
				default:
					System.out.println("Enter a valid choice.");
					break;
				
				
				} // end switch
				
			} // end validChoice while loop

		} // end while stillPlaying loop
		sc.close();
		
	} // end main
	
}



