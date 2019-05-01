package adx.variants.thirtydaysgame;

import java.util.HashSet;
import java.util.Vector;


import java.util.Set;

import adx.exceptions.AdXException;
import adx.structures.Campaign;
import adx.structures.MarketSegment;
import adx.structures.SimpleBidEntry;
import adx.util.Logging;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * An example of a simple agent playing the TwoDays game.
 *
 * @author Ayush Deva and Mohit Chandra
 */

public class No_NameAgentb extends ThirtyDaysThirtyCampaignsAgent {

  public No_NameAgentb(String host, int port) {
    super(host, port);
  }

  public int isSubset(String s, String ss) {
	  if (s.equals(ss))
		  return 1;
//	  System.out.println(s+" "+ss);
	  String[] sps = s.split("_");
	  String[] spss = ss.split("_");
	  int fl = 1, fl2 = 0;
	  for (int i = 0; i<sps.length; i++)
	  {
		  fl2 = 0;
		  for (int j = 0; j< spss.length; j++)
		  {
			  if (sps[i].equals(spss[j]))
			  {
//				  System.out.println(sps[i]+spss[j]);
				  fl2 = 1;
				  break;
			  }
		  }
//		  System.out.println("fl2 "+fl2);
		  fl = fl*fl2;
	  }
//	  System.out.println("fl "+fl);
	  return fl;
  }

  public int computef1(String s)
  {
	  int ans=1;
//	  String[] sps = s.split("_");
	  if(s.length()>=18)
	  {
		  return 9;
	  }

	  else if(s.length()>=8)
	  {
		  return 3;
	  }

	 return ans;
  }

//  public adx.structures.MarketSegment getMktSegm(String s)

  @Override
  protected ThirtyDaysBidBundle getBidBundle(int day) {
	  //Logging.log(MarketSegment.FEMALE_OLD_HIGH_INCOME);
	  //Logging.log(MarketSegment.MALE_OLD_HIGH_INCOME);
    try {
	  Map<String, Double> map = new HashMap<String, Double>();
	  map.put("MALE_YOUNG_LOW_INCOME",1836.0);
	  map.put("MALE_YOUNG_HIGH_INCOME",517.0);
	  map.put("MALE_OLD_LOW_INCOME",1795.0);
	  map.put("MALE_OLD_HIGH_INCOME",808.0);
	  map.put("FEMALE_YOUNG_LOW_INCOME",1980.0);
	  map.put("FEMALE_YOUNG_HIGH_INCOME",256.0);
	  map.put("FEMALE_OLD_LOW_INCOME",2401.0);
	  map.put("FEMALE_OLD_HIGH_INCOME",401.0);

	  Map<adx.structures.MarketSegment, String> mp = new HashMap<adx.structures.MarketSegment, String>();
      mp.put(MarketSegment.YOUNG_LOW_INCOME,"YOUNG_LOW_INCOME");
      mp.put(MarketSegment.YOUNG_HIGH_INCOME,"YOUNG_HIGH_INCOME");
      mp.put(MarketSegment.OLD_LOW_INCOME,"OLD_LOW_INCOME");
      mp.put(MarketSegment.OLD_HIGH_INCOME,"OLD_HIGH_INCOME");
      mp.put(MarketSegment.MALE_LOW_INCOME,"MALE_LOW_INCOME");
      mp.put(MarketSegment.MALE_HIGH_INCOME,"MALE_HIGH_INCOME");
      mp.put(MarketSegment.FEMALE_LOW_INCOME,"FEMALE_LOW_INCOME");
      mp.put(MarketSegment.FEMALE_HIGH_INCOME,"FEMALE_HIGH_INCOME");
      mp.put(MarketSegment.MALE_YOUNG,"MALE_YOUNG");
      mp.put(MarketSegment.MALE_OLD,"MALE_OLD");
      mp.put(MarketSegment.FEMALE_YOUNG,"FEMALE_YOUNG");
      mp.put(MarketSegment.FEMALE_OLD,"FEMALE_OLD");

      mp.put(MarketSegment.MALE_YOUNG_LOW_INCOME,"MALE_YOUNG_LOW_INCOME");
      mp.put(MarketSegment.MALE_YOUNG_HIGH_INCOME,"MALE_YOUNG_HIGH_INCOME");
      mp.put(MarketSegment.MALE_OLD_LOW_INCOME,"MALE_OLD_LOW_INCOME");
      mp.put(MarketSegment.MALE_OLD_HIGH_INCOME,"MALE_OLD_HIGH_INCOME");
      mp.put(MarketSegment.FEMALE_YOUNG_LOW_INCOME,"FEMALE_YOUNG_LOW_INCOME");
      mp.put(MarketSegment.FEMALE_YOUNG_HIGH_INCOME,"FEMALE_YOUNG_HIGH_INCOME");
      mp.put(MarketSegment.FEMALE_OLD_LOW_INCOME,"FEMALE_OLD_LOW_INCOME");
      mp.put(MarketSegment.FEMALE_OLD_HIGH_INCOME,"FEMALE_OLD_HIGH_INCOME");

      mp.put(MarketSegment.LOW_INCOME,"LOW_INCOME");
      mp.put(MarketSegment.HIGH_INCOME,"HIGH_INCOME");
      mp.put(MarketSegment.YOUNG,"YOUNG");
      mp.put(MarketSegment.OLD,"OLD");
      mp.put(MarketSegment.MALE,"MALE");
      mp.put(MarketSegment.FEMALE,"FEMALE");

      Map<String, adx.structures.MarketSegment > imp = new HashMap<String, adx.structures.MarketSegment >();

      imp.put("MALE_YOUNG_LOW_INCOME",MarketSegment.MALE_YOUNG_LOW_INCOME);
      imp.put("MALE_YOUNG_HIGH_INCOME",MarketSegment.MALE_YOUNG_HIGH_INCOME);
      imp.put("MALE_OLD_LOW_INCOME",MarketSegment.MALE_OLD_LOW_INCOME);
      imp.put("MALE_OLD_HIGH_INCOME", MarketSegment.MALE_OLD_HIGH_INCOME);
      imp.put("FEMALE_YOUNG_LOW_INCOME",MarketSegment.FEMALE_YOUNG_LOW_INCOME);
      imp.put("FEMALE_YOUNG_HIGH_INCOME",MarketSegment.FEMALE_YOUNG_HIGH_INCOME);
      imp.put("FEMALE_OLD_LOW_INCOME",MarketSegment.FEMALE_OLD_LOW_INCOME);
      imp.put("FEMALE_OLD_HIGH_INCOME", MarketSegment.FEMALE_OLD_HIGH_INCOME);

	  Campaign c = null;
      if (day <= 30) {
        Logging.log("[-] Bid for campaign " + day + " which is: " + this.setCampaigns[day - 1]);
        c = this.setCampaigns[day - 1];
      }
      else {
        throw new AdXException("[x] Bidding for invalid day " + day + ", bids in this game are only for day 1 or 2.");
      }
      // Bidding only on the exact market segment of the campaign.
      Set<SimpleBidEntry> bidEntries = new HashSet<SimpleBidEntry>();
      String[] array = new String[8];
      //Logging.log(c.getMarketSegment());
      //Logging.log(mp.get(c.getMarketSegment()));
      int f1 = computef1(mp.get(c.getMarketSegment()));
      f1 = 26/f1 ;
//      int f1 = 3 ;
      Logging.log(f1);
      array[0]="MALE_YOUNG_LOW_INCOME"; array[1]="MALE_YOUNG_HIGH_INCOME"; array[2]="MALE_OLD_LOW_INCOME"; array[3]="MALE_OLD_HIGH_INCOME";
      array[4]="FEMALE_YOUNG_LOW_INCOME"; array[5]="FEMALE_YOUNG_HIGH_INCOME"; array[6]="FEMALE_OLD_LOW_INCOME"; array[7]="FEMALE_OLD_HIGH_INCOME";
      //isSubset("OLD", "YOUNG");
      int sum = 0 ;
//      Logging.log(array[0]);
      //System.out.println(c.getMarketSegment().getClass().getName());
//      Logging.log(c.getMarketSegment().getClass().getName());
//      Logging.log(MarketSegment.MALE_YOUNG_LOW_INCOME.getClass().getName());
//      if(isSubset("FEMALE_YOUNG","FEMALE_YOUNG_LOW_INCOME") == 1)
//      {
//    	  System.out.println("Ghus gaya!");
//      }
      for(int i=0;i<8;i++)
      {
    	  //Logging.log(isSubset(mp.get(c.getMarketSegment()),array[i]));
    	  if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
    		  sum += map.get(array[i]);
      }
      Logging.log(sum);
      for(int i=0;i<8;i++)
      {
    	  if(isSubset(mp.get(c.getMarketSegment()),array[i])==1)
    	  {
    		  double f2 = map.get(array[i])/sum ;
//    		  adx.structures.MarketSegment x = getMktSegm(array[i]) ;
    		  if(c.getBudget()>0.1){
    		  bidEntries.add(new SimpleBidEntry(imp.get(array[i]), (c.getBudget()*f2/(double)c.getReach()), c.getBudget()));
    		  }

    		  else{
    			  bidEntries.add(new SimpleBidEntry(imp.get(array[i]), 1, c.getReach()*0.4));
    		  }
    	  }
      }
      //bidEntries.add(new SimpleBidEntry(c.getMarketSegment(), c.getBudget() / (double) c.getReach(), c.getBudget()));
      Logging.log("[-] bidEntries = " + bidEntries);
//      return new ThirtyDaysBidBundle(day, c.getId(), Math.max(100,c.getBudget()), bidEntries);
      return new ThirtyDaysBidBundle(day, c.getId(), c.getBudget(), bidEntries);
    } catch (AdXException e) {
      Logging.log("[x] Something went wrong getting the bid bundle: " + e.getMessage());
    }
    return null;
  }

  /**
   * Agent's main method.
   *
   * @param args
   */
  public static void main(String[] args) {
	  No_NameAgentb agent = new No_NameAgentb("localhost", 9898);
    agent.connect("agent1");
  }

}
