
public class Player {
	private int age;
	private int rat;
	private int pot;
	private String[] position;
	private boolean taken;
	private int calcRat;
	
	public Player(int a, int r, int p, String[] pos, boolean t, int c)
	{
	
		age = a;
		rat = r;
		pot = p;
		position = pos;
		taken = t;
		calcRat = c;
		
		
		
	}
	
	
			public int getAge() {
				return age;
			}
			public int getRat() {
				return rat;
			}
			public int getPot() {
				return pot;
			}
			public String[] getPos() {
				return position;
			}
			public boolean isTaken() {
				return taken;
			}
			public int getCalcRat() {
				return calcRat;
			}
			
			public void setCalc(int c) {
				calcRat = c;
			}
			public void setTaken(boolean b) {
				taken = b;
			}
	
}
