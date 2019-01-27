
public class Courses {
	
	private String[] courseStr = {
	"Mario Kart Stadium",
	"Water Park",
	"Sweet Sweet Canyon",
	"Thwomp Ruins",
	"Mario Circuit (Flower)",
	"Toad Harbor",
	"Twisted Mansion",
	"Shy Guy Falls",
	"Sunshine Airport",
	"Dolphin Shoals",
	"Electrodrome",
	"Mount Wario",
	"Cloudtop Cruise",
	"Bone-dry Ruins",
	"Bowser's Castle",
	"Rainbow Road (Special)",
	"Yoshi Circuit",
	"Excitebike Arena",
	"Dragon Driftway",
	"Mute City",
	"Baby Park",
	"Cheese Land",
	"Wild Woods",
	"Animal Crossing",
	"Moo Moo Meadows",
	"Mario Circuit (Shell)",
	"Cheep Cheep Beach",
	"Toad's Turnpike",
	"Dry Dry Desert",
	"Donut Plains",
	"Royal Raceway",
	"DK Jungle",
	"Wario Stadium",
	"Sherbet Land",
	"Music Land",
	"Yoshi Valley",
	"Tick Tock Clock",
	"Piranha Plant Slide",
	"Grumble Volcano",
	"Rainbow Road (Lightning)",
	"Wario's Gold Mine",
	"Rainbow Road (Triforce)",
	"Ice Ice Outpost",
	"Hyrule Circuit",
	"Neo-Bowser City",
	"Ribbon Road",
	"Super Bell Subway",
	"Big Blue" };
	
	int numCourses = courseStr.length;
	
	private int[] prob = new int[numCourses];
	
	private int[] optionIndices = {-1,-1,-1};
	// private int indexChosen;
	
	public Courses( ) {
		cutTheDeck();
		initProb();
	}
	
	private void cutTheDeck() {
		
		int cut = (int)((Math.random())*numCourses);
		// System.out.println("Cut:" + cut);
		int j; // temp index
		// array will start at cut
		String[] tempCourseStr = new String[numCourses];
		//copy everything into new array
		for(int i=0;i<numCourses;i++) {
			tempCourseStr[i]=courseStr[i];
		}
		// everything get index of current index + cut % 48
		for(int i=0;i<numCourses;i++) {
			j=(i+cut)%numCourses;
			courseStr[j]=tempCourseStr[i];
		}
	}
	
	private void initProb() {
		for(int i=0;i<numCourses;i++) {
			prob[i] = 50;
		}
	}
	
	public void getDistinct() {
		optionIndices[0] = -1;
		optionIndices[1] = -1;
		optionIndices[2] = -1;
		boolean distinct=false;
	
		while(!distinct) {
			if((optionIndices[0]==optionIndices[1]) || (optionIndices[0]==optionIndices[2]) || (optionIndices[2]==optionIndices[1])){
				selectCourses();
			}
			else {
				distinct=true;
			}
		}
	}
	
	private void selectCourses() {
		// need to pick 3 courses
		// first, add up all course totals
		int total=0;
		for(int i = 0; i < numCourses;i++) {
			if(prob[i] > 0) {
				total += prob[i];
			}
		}
		// now, pick 3
		for(int i=0;i<3;i++) {
			int choice = (int)((Math.random())*total); //choice is total of prob of picked course
			// System.out.println("choice = " + choice);
			int counter=0; // will have index of course
			int subTotal=prob[0]; // used to find correct slot
			
			
			while(subTotal<choice) {
				if(prob[counter] > 0) {
					subTotal+=prob[counter];
				}
				counter++;
					//System.out.println(" subTotal = " + subTotal + "   counter = " + counter + "   choice = " + choice);
			}
			if(counter>47) {counter=47;}
			optionIndices[i]=counter;
			
		}
	}
	
	private void choiceIsMade(int choice) {
		// adjust prob 
		// choice is index of course
		// put choice at end of array
		// increment everything by one
		// prob[choice]=0;
		//System.out.println("choice= " + choice);
		String temp=courseStr[choice];
		for(int i=choice;i>=0;i--) {
			
			if(i<choice) {
				courseStr[i+1]=courseStr[i];
				prob[i+1]=prob[i];
			}
			
			//if(prob[i]< 50) {prob[i]++;}
		}
		courseStr[0]=temp;
		prob[0]=-5;
		
		for(int j=0;j<48;j++) {
			prob[j]++;
			if(prob[j]>999) {
				prob[j]=999;
			}
		}
		//System.out.println("exit choiceIsMade");
	} 
	
	public void displayAll() {
		for(int i=0;i<numCourses;i++) {
			System.out.println(courseStr[i]);
		}
	}
	
	public void displayWithIndex() {
		for(int k=0;k<numCourses;k++) {
			System.out.println("index " + k + " prob: " + prob[k] + " course: " + courseStr[k]);
		}
	}
	
	public void displayCourseAtIndex(int index) {
		System.out.println(courseStr[index]);
	}
	
	public void displayCourseChoices(int index) {
		System.out.print(courseStr[optionIndices[index]]);
		// choiceIsMade(index);
	}
	
	public void displayCourseSelection(int index) {
		// crsInx = course index for large array
		int crsInx = optionIndices[index];
		System.out.print(courseStr[crsInx]);
		choiceIsMade(crsInx);
	}
	
	public void pickedRandom() {
		int index=numCourses-1;
		while(index == optionIndices[0] || index == optionIndices[1] || index == optionIndices[2]) {
			index--;
		}
		if(index == 0) {
			System.out.println("Index too low.");
		}
		System.out.print(courseStr[index]);
		choiceIsMade(index);
	}
	
}
