import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rating {
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[]args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		Scanner s = new Scanner(new File("portugal.txt"));
		ArrayList<Player> players = new ArrayList<Player>();
		
		int counter = 1;
		int i1 = 0;
		int i2 = 0;
		String n1 = "";
		int i3 = 0;
		String[] s1 = new String[0];
		String s2 = "";
		while(s.hasNextLine())
		{
//			System.out.println(counter);
			if(counter == 1) {
				s2 = s.nextLine();
				if(s2.substring(0, 1).equals("€"))
					s2 = s.nextLine();
				i1 = Integer.parseInt(s2);
//				System.out.println(i1);
			}
			
			else if(counter == 2) {
				s2 = s.nextLine();
				if(s2.equals(""))
					i2 = 100;
				else
					i2 = Integer.parseInt(s2);
//				System.out.println(i2);
			}
			else if(counter == 3 || counter == 4 || counter == 7 || counter == 8) {
				s2 = s.nextLine();
				
			}
			else if(counter == 5) {
				String[] tokens = s.nextLine().split(", ");
				s1 = new String[tokens.length];
				for(int i = 0; i < s1.length; i++) {
					s1[i] = tokens[i];
				}
//				System.out.println(tokens[0]);
			}
			else if(counter == 6) {
				i3 = Integer.parseInt(s.nextLine());
//				System.out.println(i3);
			}
			else if(counter == 9) {
				players.add(new Player(i3, i1, i1, s1, false, 0));
//				System.out.print("yrs");
//				System.out.print(players.get(players.size() - 1));
				s2 = s.nextLine();
				counter = 0;
				
			}
			counter++;
		
		}
		int a1 = 0;
		int ap1 = -1;
		int a2 = 0;
		int ap2 = -1;
		int a3 = 0;
		int ap3 = -1;
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).getAge() == 27)
				players.get(i).setCalc(players.get(i).getRat());
			else if(players.get(i).getAge() == 28)
				players.get(i).setCalc(players.get(i).getRat() - 2);
			else if(players.get(i).getAge() == 29)
				players.get(i).setCalc(players.get(i).getRat() - 5);
			else if(players.get(i).getAge() == 30)
				players.get(i).setCalc(players.get(i).getRat() - 8);
			else if(players.get(i).getAge() == 31)
				players.get(i).setCalc(players.get(i).getRat() - 11);
			else if(players.get(i).getAge() == 34)
				players.get(i).setCalc(players.get(i).getRat() - 14);
			else if(players.get(i).getAge() == 26)
				players.get(i).setCalc(Math.min(players.get(i).getRat() +5, players.get(i).getPot()));
			else if(players.get(i).getAge() == 25 || players.get(i).getAge() == 24 || players.get(i).getAge() == 23 || players.get(i).getAge() == 22)
				players.get(i).setCalc(Math.min(players.get(i).getRat() + 6, players.get(i).getPot()));
			else
				players.get(i).setCalc(Math.min(players.get(i).getRat() + 7, players.get(i).getPot()));
		}
		
		for(int i = 0; i < players.size(); i++) {
			
			for(int j = 0; j < players.get(i).getPos().length; j++) {
				String str = players.get(i).getPos()[j];
				if((str.length() >= 2 && str.substring(0, 2).equals("ST") || str.length() >= 3 && str.substring(0, 3).equals("AMR") || str.length() >= 2 && str.substring(0, 2).equals("AML")) && !players.get(i).isTaken()) {
					if(players.get(i).getCalcRat() > a1) {
						
						if(ap3 != -1)
							players.get(ap3).setTaken(false);
						ap3 = ap2;
						ap2 = ap1;
						a3 = a2;
						a2 = a1;
						ap1 = i;
						a1 = players.get(i).getCalcRat();
						players.get(ap1).setTaken(true);
						
					}
					else if(players.get(i).getCalcRat() > a2) {
						if(ap3 != -1)
							players.get(ap3).setTaken(false);
						a3 = a2;
						ap3 = ap2;
						ap2 = i;
						a2 = players.get(i).getCalcRat();
						players.get(ap2).setTaken(true);
					}
					else if(players.get(i).getCalcRat() > a3) {
						if(ap3 != -1)
							players.get(ap3).setTaken(false);
						ap3 = i;
						a3 = players.get(i).getCalcRat();
						players.get(ap3).setTaken(true);
					}
				}
			}
			
		}
		int m1 = 0;
		int mp1 = -1;
		int m2 = 0;
		int mp2 = -1;
		int m3 = 0;
		int mp3 = -1;
		for(int i = 0; i < players.size(); i++) {
			
			for(int j = 0; j < players.get(i).getPos().length; j++) {
				String str = players.get(i).getPos()[j];
				if((str.length() >= 2 && str.substring(0, 2).equals("MR") || str.length() >= 2 && str.substring(0, 2).equals("ML") || str.length() >= 2 && str.substring(0, 2).equals("DM") || str.length() >= 2 && str.substring(0, 2).equals("CM") || str.length() >= 3 && str.substring(0, 3).equals("CAM")) && !players.get(i).isTaken()) {
					if(players.get(i).getCalcRat() > m1) {
						if(mp3 != -1)
							players.get(mp3).setTaken(false);
						mp3 = mp2;
						mp2 = mp1;
						m3 = m2;
						m2 = m1;
						mp1 = i;
						m1 = players.get(i).getCalcRat();
						players.get(mp1).setTaken(true);
					}
					else if(players.get(i).getCalcRat() > m2) {
						
						if(mp3 != -1)
							players.get(mp3).setTaken(false);
						
						m3 = m2;
						mp3 = mp2;
						mp2 = i;
						m2 = players.get(i).getCalcRat();
						players.get(mp2).setTaken(true);
					}
					else if(players.get(i).getCalcRat() > m3) {
						if(mp3 != -1)
							players.get(mp3).setTaken(false);
						mp3 = i;
						m3 = players.get(i).getCalcRat();
						players.get(mp3).setTaken(true);
					}
				}
			}
			
		}
		int dl1 = 0;
		int dlp1 = -1;
for(int i = 0; i < players.size(); i++) {
			
			for(int j = 0; j < players.get(i).getPos().length; j++) {
				String str = players.get(i).getPos()[j];
				if((str.length() >= 2 && str.substring(0, 2).equals("DL") || str.length() >= 3 && str.substring(0, 3).equals("WBL")) && !players.get(i).isTaken()) {
					if(players.get(i).getCalcRat() > dl1) {
						if(dlp1 != -1)
							players.get(dlp1).setTaken(false);
						
						dlp1 = i;
						dl1 = players.get(i).getCalcRat();
						players.get(dlp1).setTaken(true);
					}
					
				}
			}
			
		}
int dr1 = 0;
int drp1 = -1;
for(int i = 0; i < players.size(); i++) {
	
	for(int j = 0; j < players.get(i).getPos().length; j++) {
		String str = players.get(i).getPos()[j];
		if((str.length() >= 2 && str.substring(0, 2).equals("DR") || str.length() >= 3 && str.substring(0, 3).equals("WBR")) && !players.get(i).isTaken()) {
			if(players.get(i).getCalcRat() > dr1) {
				if(drp1 != -1)
					players.get(drp1).setTaken(false);
				
				drp1 = i;
				dr1 = players.get(i).getCalcRat();
				players.get(drp1).setTaken(true);
			}
			
		}
	}
	
}
int dc1 = 0;
int dcp1 = -1;
int dc2 = 0;
int dcp2 = -1;
for(int i = 0; i < players.size(); i++) {
	
	for(int j = 0; j < players.get(i).getPos().length; j++) {
		String str = players.get(i).getPos()[j];
		if((str.length() >= 2 && str.substring(0, 2).equals("DC")) && !players.get(i).isTaken()) {
			if(players.get(i).getCalcRat() > dc1) {
				if(dcp2 != -1)
					players.get(dcp2).setTaken(false);
				
				dcp2 = dcp1;
				dc2 = dc1;
				
				dcp1 = i;
				dc1 = players.get(i).getCalcRat();
				players.get(dcp1).setTaken(true);
			}
			else if(players.get(i).getCalcRat() > dc2) {
				if(dcp2 != -1)
					players.get(dcp2).setTaken(false);
				
				dcp2 = i;
				dc2 = players.get(i).getCalcRat();
				players.get(dcp2).setTaken(true);
			}
			
		}
	}
	
}
int gk1 = 0;
int gkp1 = -1;
for(int i = 0; i < players.size(); i++) {
	
	for(int j = 0; j < players.get(i).getPos().length; j++) {
		String str = players.get(i).getPos()[j];
		if((str.length() >= 2 && str.substring(0, 2).equals("GK")) && !players.get(i).isTaken()) {
			if(players.get(i).getCalcRat() > gk1) {
				if(gkp1 != -1)
					players.get(gkp1).setTaken(false);
				
				gkp1 = i;
				gk1 = players.get(i).getCalcRat();
				players.get(gkp1).setTaken(true);
			}
			
		}
	}
	
}
		
		double da1 = Double.valueOf(a1);
		double da2 = Double.valueOf(a2);
		double da3 = Double.valueOf(a3);
		double dm1 = Double.valueOf(m1);
		double dm2 = Double.valueOf(m2);
		double dm3 = Double.valueOf(m3);
	
		double ddc1 = Double.valueOf(dc1);
		double ddc2 = Double.valueOf(dc2);
		double ddr1 = Double.valueOf(dr1);
		double ddl1 = Double.valueOf(dl1);
		double dgk1 = Double.valueOf(gk1);
		
		System.out.println((da1+da2+da3)/3 + "	" + (dm1+dm2+dm3)/3 + "	" + (ddc1+ddc2+ddr1+ddl1+dgk1)/5);
		System.out.println((dm1+dm2+dm3)/3);
		System.out.println((ddc1+ddc2+ddr1+ddl1+dgk1)/5);
		
		
		
}
}
