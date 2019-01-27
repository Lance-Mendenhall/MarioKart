
public class Racers {
	
	// need to select racers, select how good they are
	// member variables
	
	// array (size 12) of selected racers
	// possible matching array of skill levels?
	// selectRacers(racers);
	// assign skill level
	// race - die rolls
	// print results
	// ask if another race
	
	// array of all potential racers
	private String[] allRacers = {
			"Mario",
			"Luigi",
			"Peach",
			"Daisy",
			"Bowser",
			"Koopa Troopa",
			"Donkey Kong",
			"Diddy Kong",
			"Link",
			"Cat Peach",
			"Tanooki Mario",
			"Birdo",
			"Wario",
			"Waluigi",
			"Rosalina",
			"Yoshi",
			"Toad",
			"Toadette",
			"Sonic",
			"Tails",
			"Knuckles",
			"Dr. Eggman",
			"Shy Guy",
			"PJ",
			"Patrick",
			"Mariah",
			"King Boo"
			
	};
	
	final static int NUMRACERS = 12;
	private static String racers[] = new String[NUMRACERS];
	private static int skills[] = new int[NUMRACERS];
	private static int resultSum[] = new int[NUMRACERS];
	
	
	public Racers() {
		selectRacers();
		setSkills();
	}
	
	public void selectRacers() {
		int len = allRacers.length;
		String temp;
		for(int i=0;i<NUMRACERS;i++) {
			int rn = (int)((Math.random()*len));
			racers[i] = allRacers[rn];
			
			temp = allRacers[len-1];
			allRacers[len-1] = allRacers[rn];
			allRacers[rn] = temp;	
			
			len--;
			
		}
	}
	
	public void setSkills() {
		for(int i=0;i<NUMRACERS;i++) {
			skills[i]=(int)((Math.random()*10));
		}
	}
	
	public void displayRacers() {
		for(int i=0;i<NUMRACERS;i++) {
			System.out.println(racers[i]);
		}
	}
	
	public void displayRacersWithSkill() {
		for(int i=0;i<NUMRACERS;i++) {
			System.out.println(racers[i] + "\t" + skills[i]);
		}
	}
	
	public void displayResults() {
		for(int i=0;i<NUMRACERS;i++) {
			System.out.println(racers[i] + "\t" + resultSum[i]);
		}
	}
	
	public void haveARace() {
		for(int i=0;i<NUMRACERS;i++) {
			int roll = skills[i];
			for(int j=0;j<5;j++) {
				roll+=(int)(Math.random()*10);
			}
			resultSum[i]=roll;
		}
		sort();
		displayResults();
	}
	
	public static void sort() {
		for(int i=0;i<(NUMRACERS);i++) {
			int temp;
			String tempR;
			int greatest = -1;
			int gIndex=0;
			
			for(int j=i;j<NUMRACERS;j++) {
				// find greatest
				if(greatest < resultSum[j]) {
					greatest = resultSum[j];
					gIndex=j;
				}
			}
								
				temp=resultSum[gIndex];
				resultSum[gIndex]=resultSum[i];
				resultSum[i]=temp;
				
				tempR=racers[gIndex];
				racers[gIndex]=racers[i];
				racers[i]=tempR;
				
				temp=skills[gIndex];
				skills[gIndex]=skills[i];
				skills[i]=temp;
				
			}
	
	}

}
