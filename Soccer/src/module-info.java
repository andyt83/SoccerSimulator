import java.util.*;
public class Team {
		private int num;
		private String name;
		private int games;
		private double ppg;
		private double catches;
		private double passes;
		private double percentage;
		private double passYards;
		private double passTD;
		private double rushes;
		private double rushYards;
		private double avgRush;
		private double rushTD;
		private double plays;
		private double totYards;
		private double YPP;
		private double passFD;
		private double rushFD;
		private double penFD;
		private double totFD;
		private double penalties;
		private double penYds;
		private double fumbles;
		private double ints;
		private double turnovers;
		
		
	public Team(int nu, String n, int ga, double popg, double c, double pa, double pe, double py, double pt, double r, 
			double ry, double ar, double rt, double pl, double ty, double ypp, double pf, double rf, 
			double pef, double tf, double pn, double pny, double f, double in, double tr)
	{
		num = nu;
		name  = n;
		games  = ga;
		ppg = popg;
		catches = c;
		passes = pa;
		percentage = pe;
		passYards = py;
		passTD = pt;
		rushes = r;
		rushYards = ry;
		rushTD = rt;
		plays = pl;
		totYards = ty;
		YPP = ypp;
		passFD = pf;
		rushFD = rf;
		penFD = pef;
		totFD = tf;
		penalties = pn;
		penYds = pny;
		fumbles = f;
		ints = in;
		turnovers = tr;
		
		
		
	}
			public String getName()
			{
				return name;
			}
			
			public double getPpg()
			{
				return ppg;
			}
			public double getPasses()
			{
				return passes;
			}
			public double getRushes()
			{
				return rushes;
			}
			public double getPenYds()
			{
				return penYds;
			}
			public double getTotYards()
			{
				return totYards;
			}
			public double getPassYards()
			{
			    return passYards;
			}
			public double getRushYards()
			{
			    return rushYards;
			}
			public double getTurnovers()
			{
				return turnovers;
			}
			public double getPercentage()
			{
				return percentage;
			}
			
		
		
}