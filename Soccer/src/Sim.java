import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Random;
public class Sim {
	public static void main(String[]args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		Scanner s = new Scanner(new File("teams2.txt"));
		ArrayList<Team1> teams = new ArrayList<Team1>();
		

		while(s.hasNextLine())
		{
			String[] tokens = s.nextLine().split("	");
			String name = tokens[0];
			double d1 = Double.parseDouble(tokens[1]);
			double d2 = Double.parseDouble(tokens[2]);
			double d3 = Double.parseDouble(tokens[3]);
			teams.add(new Team1(name, d1, d2, d3));
		}
		int mn = 0;
		while(mn == 0)
		{
			System.out.println("Press 1 to start");
			mn++;
			
		}
		int choice = sc.nextInt();
		
		if(choice == 1)
		{
			Team1 team1 = new Team1("", 0, 0, 0);
			Team1 team2 = new Team1("", 0, 0, 0);
			String tteam1 = " ";
			String tteam2 = " ";
			System.out.println("Enter team 1: ");
			tteam1 = sc.next();
			System.out.println("Enter team 2: ");
			tteam2 = sc.next();
			for(int i = 0; i < teams.size(); i ++)
			{
				if(teams.get(i).getName().contentEquals(tteam1)) {
					team1 = teams.get(i);
				}
				if(teams.get(i).getName().contentEquals(tteam2)) {
					team2 = teams.get(i);
				
				
				}
			}

			double expt1Goal = ((team1.getAtt() - team2.getDef()) + (team1.getMid()/2 - team2.getMid()/2))/15;
			double expt2Goal = ((team2.getAtt() - team1.getDef()) + (team2.getMid()/2 - team1.getMid()/2))/15;
			expt1Goal += 0.4;
			expt2Goal -= 0.4;
			
			if(expt1Goal > 0) {
				expt1Goal = 1.3 + (expt1Goal*0.9);
			}
			if(expt2Goal > 0) {
				expt2Goal = 1.3 + (expt1Goal*0.9);
			}
			if(expt1Goal < 0) {
				expt1Goal = 1.3 + expt1Goal*.4;
			}
			if(expt1Goal < 0.1) {
				expt1Goal = 0.1;
			}
			if(expt2Goal < 0) {
				expt2Goal = 1.3 + expt2Goal*.4;
			}
			if(expt2Goal < 0.1) {
				expt2Goal = 0.1;
			}
			
			double team10 = Math.exp(-expt1Goal);
			double team11 = Math.pow(expt1Goal, 1)*Math.exp(-expt1Goal);
			double team12 = Math.pow(expt1Goal, 2)*Math.exp(-expt1Goal)/2;
			double team13 = Math.pow(expt1Goal, 3)*Math.exp(-expt1Goal)/6;
			double team14 = Math.pow(expt1Goal, 4)*Math.exp(-expt1Goal)/24;
			double team15 = Math.pow(expt1Goal, 5)*Math.exp(-expt1Goal)/120;
			double team16 = 1 - team10 - team11 - team12 - team13 - team14 - team15;
			
			double team20 = Math.exp(-expt2Goal);
			double team21 = Math.pow(expt2Goal, 1)*Math.exp(-expt2Goal);
			double team22 = Math.pow(expt2Goal, 2)*Math.exp(-expt2Goal)/2;
			double team23 = Math.pow(expt2Goal, 3)*Math.exp(-expt2Goal)/6;
			double team24 = Math.pow(expt2Goal, 4)*Math.exp(-expt2Goal)/24;
			double team25 = Math.pow(expt2Goal, 5)*Math.exp(-expt2Goal)/120;
			double team26 = 1 - team20 - team21 - team22 - team23 - team24 - team25;
			
			double rand1 = Math.random();
			double rand2 = Math.random();
			double team1Goals = 0;
			double team2Goals = 0;
			if(rand1 < team10)
				team1Goals = 0;
			else if(rand1 < team10+team11)
				team1Goals = 1;
			else if(rand1 < team10+team11+team12)
				team1Goals = 2;
			else if(rand1 < team10+team11+team12+team13)
				team1Goals = 3;
			else if(rand1 < team10+team11+team12+team13+team14)
				team1Goals = 4;
			else if(rand1 < team10+team11+team12+team13+team14+team15)
				team1Goals = 5;
			else
				team1Goals = 6;
			
			
			if(rand2 < team20)
				team2Goals = 0;
			else if(rand2 < team20+team21)
				team2Goals = 1;
			else if(rand2 < team20+team21+team22)
				team2Goals = 2;
			else if(rand2 < team20+team21+team22+team23)
				team2Goals = 3;
			else if(rand2 < team20+team21+team22+team23+team24)
				team2Goals = 4;
			else if(rand2 < team20+team21+team22+team23+team24+team25)
				team2Goals = 5;
			else
				team2Goals = 6;
			
			
			System.out.println("team1: " + team1Goals);
			System.out.println("team2: " + team2Goals);
			
		}
			

		
		
}
}
