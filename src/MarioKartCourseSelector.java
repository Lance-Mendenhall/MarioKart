import java.util.Scanner;

public class MarioKartCourseSelector {

	public static void main(String[] args) {
		
		final int NUMCOURSES = 48;
		
		// course names as string
		String[] courseStr = new String[NUMCOURSES];
		
		courseStr[0] = "Mario Kart Stadium";
		courseStr[1] = "Water Park";
		courseStr[2] = "Sweet Sweet Canyon";
		courseStr[3] = "Thwomp Ruins";
		courseStr[4] = "Mario Circuit (Flower)";
		courseStr[5] = "Toad Harbor";
		courseStr[6] = "Twisted Mansion";
		courseStr[7] = "Shy Guy Falls";
		courseStr[8] = "Sunshine Airport";
		courseStr[9] = "Dolphin Shoals";
		courseStr[10] = "Electrodrome";
		courseStr[11] = "Mount Wario";
		courseStr[12] = "Cloudtop Cruise";
		courseStr[13] = "Bone-dry Ruins";
		courseStr[14] = "Bowser's Castle";
		courseStr[15] = "Rainbow Road (Special)";
		courseStr[16] = "Yoshi Circuit";
		courseStr[17] = "Excitebike Arena";
		courseStr[18] = "Dragon Driftway";
		courseStr[19] = "Mute City";
		courseStr[20] = "Baby Park";
		courseStr[21] = "Cheese Land";
		courseStr[22] = "Wild Woods";
		courseStr[23] = "Animal Crossing";
		courseStr[24] = "Moo Moo Meadows";
		courseStr[25] = "Mario Circuit (Shell)";
		courseStr[26] = "Cheep Cheep Beach";
		courseStr[27] = "Toad's Turnpike";
		courseStr[28] = "Dry Dry Desert";
		courseStr[29] = "Donut Plains";
		courseStr[30] = "Royal Raceway";
		courseStr[31] = "DK Jungle";
		courseStr[32] = "Wario Stadium";
		courseStr[33] = "Sherbet Land";
		courseStr[34] = "Music Land";
		courseStr[35] = "Yoshi Valley";
		courseStr[36] = "Tick Tock Clock";
		courseStr[37] = "Piranha Plant Slide";
		courseStr[38] = "Grumble Volcano";
		courseStr[39] = "Rainbow Road (Lightning)";
		courseStr[40] = "Wario's Gold Mine";
		courseStr[41] = "Rainbow Road (Triforce)";
		courseStr[42] = "Ice Ice Outpost";
		courseStr[43] = "Hyrule Circuit";
		courseStr[44] = "Neo-Bowser City";
		courseStr[45] = "Ribbon Road";
		courseStr[46] = "Super Bell Subway";
		courseStr[47] = "Big Blue";
		
		cutTheDeck(courseStr, NUMCOURSES);
		//System.out.println("The first course is: " + courseStr[0]);
		//displayAll(courseStr,NUMCOURSES);
		
		// assign array of indices
		int[] prob = new int[NUMCOURSES];
		
		for(int i=0;i<NUMCOURSES;i++) {
			prob[i] = 50;
		}
		
		boolean stillPlaying=true;
		Scanner sc = new Scanner(System.in);
		
		while(stillPlaying) {
			// Course[] options = new Course[3];
			int[] options = {-1,-1,-1};
	
			boolean distinct=false;
		
			while(!distinct) {
				if((options[0]==options[1]) || (options[0]==options[2]) || (options[2]==options[1])){
					selectCourses(options,NUMCOURSES,prob);
				}
				else {
					distinct=true;
				}
			}
		
		// display courses
		// Scanner sc = new Scanner(System.in);
		
		// menu
		// display course, then pick course - if course is picked decrement value
		// option to view what random is
		
			System.out.println("Select a course:\n1) " + courseStr[options[0]] + "\n2) " 
				+ courseStr[options[1]] + "\n3) "
				+ courseStr[options[2]] + "\n4) Random\n5) Quit game"
				+ "\n6) Display array with indices");
			
			// switch statement for choice
			boolean validChoice=false;
			
			
			//int choice=sc.nextInt();
			// sc.close();
			
			while(!validChoice) {
				//int choice=getChoice();
				int choice=sc.nextInt();
				String str=sc.nextLine();
				switch(choice) {
				case 1:
					//call function
					System.out.println("You chose " + courseStr[options[0]]);
					choiceIsMade(options[0],courseStr, prob);
					validChoice=true;
					break;
				case 2:
					System.out.println("You chose " + courseStr[options[1]]);
					choiceIsMade(options[1],courseStr, prob);
					validChoice=true;
					break;
				case 3:
					System.out.println("You chose " + courseStr[options[2]]);
					choiceIsMade(options[2],courseStr, prob);
					validChoice=true;
					break;
				case 4: // random course
					System.out.println("You chose " + courseStr[47]);
					choiceIsMade(47,courseStr, prob);
					validChoice=true;
					break;
				case 5:
					validChoice=true;
					stillPlaying=false;
					System.out.println("Thanks for playing! Goodbye!");
					break;
				case 6:
					for(int k=0;k<48;k++ ) {
						System.out.println("index " + k + " prob: " + prob[k] + " course: " + courseStr[k]);
					}
					break;
				default:
					System.out.println("Enter a valid choice.");
					break;
				
				
				} // end switch
				
			} // end validChoice while loop

		} // end while stillPlaying loop
		sc.close();
		
	} // end main
	
	// options - holds index of 3 courses
	// prob - holds quotient of course being chosen
	// courseStr - hold name of course
	
	private static void selectCourses(int[] options, int NUMCOURSES, int[] prob) {
		// need to pick 3 courses
		// first, add up all course totals
		int total=0;
		for(int i = 0; i < NUMCOURSES;i++) {
			total += prob[i];
		}
		// now, pick 3
		for(int i=0;i<3;i++) {
			int choice = (int)((Math.random())*total); //choice is total of prob of picked course
			System.out.println("choice = " + choice);
			int counter=0; // will have index of course
			int subTotal=prob[0]; // used to find correct slot
			
			
			while(subTotal<choice) {
				subTotal+=prob[counter];
				counter++;
				//System.out.println(" subTotal = " + subTotal + "   counter = " + counter + "   choice = " + choice);
			}
			if(counter>47) {counter=47;}
			options[i]=counter;
			
		}
	}
	
	private static void cutTheDeck(String[] courses, int numCourses) {
		
		int cut = (int)((Math.random())*numCourses);
		System.out.println("Cut:" + cut);
		int j; // temp index
		// array will start at cut
		String[] tempCourseStr = new String[numCourses];
		//copy everything into new array
		for(int i=0;i<numCourses;i++) {
			tempCourseStr[i]=courses[i];
		}
		// everything get index of current index + cut % 48
		for(int i=0;i<numCourses;i++) {
			j=(i+cut)%numCourses;
			courses[j]=tempCourseStr[i];
		}
	}
	
	private static void displayAll(String[] course, int numCourses) {
		for(int i=0;i<numCourses;i++) {
			System.out.println(course[i]);
		}
	}
	
//	private static int getChoice() {
//		Scanner sc = new Scanner(System.in);
//		int choice=sc.nextInt();
//		sc.close();
//		return choice;
//	}
	
	private static void choiceIsMade(int choice,String[] courses, int[] prob) {
		// adjust prob 
		// choice is index of course
		// put choice at end of array
		// increment everything by one
		// prob[choice]=0;
		//System.out.println("choice= " + choice);
		String temp=courses[choice];
		for(int i=choice;i>=0;i--) {
//			if(i>choice) {
//			}
//			if(i==choice) {
//				temp=courses[i];
//				// prob should be 0
//			}
			
			if(i<choice) {
				courses[i+1]=courses[i];
				prob[i+1]=prob[i];
			}
			
			//if(prob[i]< 50) {prob[i]++;}
		}
		courses[0]=temp;
		prob[0]=0;
		
		for(int j=0;j<48;j++) {
			prob[j]++;
			if(prob[j]>50 ) {
				prob[j]=50;
			}
		}
		//System.out.println("exit choiceIsMade");
	} // end choiceIsMade
}



