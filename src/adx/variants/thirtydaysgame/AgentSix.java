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
 *Our AdX TAC agent to compete in impression autions
 *
 * @author Team 6
 */

public class AgentSix extends ThirtyDaysThirtyCampaignsAgent {

  public AgentSix(String host, int port) {
    super(host, port);
  }


  @Override
  protected ThirtyDaysBidBundle getBidBundle(int day) {

    //Making Distribution Map
    try {
	  Map<adx.structures.MarketSegment, Double> D = new HashMap<adx.structures.MarketSegment, Double>();
	  D.put(MarketSegment.MALE_YOUNG_LOW_INCOME,1836.0);
	  D.put(MarketSegment.MALE_YOUNG_HIGH_INCOME,517.0);
	  D.put(MarketSegment.MALE_OLD_LOW_INCOME,1795.0);
	  D.put(MarketSegment.MALE_OLD_HIGH_INCOME,808.0);
	  D.put(MarketSegment.FEMALE_YOUNG_LOW_INCOME,1980.0);
	  D.put(MarketSegment.FEMALE_YOUNG_HIGH_INCOME,256.0);
	  D.put(MarketSegment.FEMALE_OLD_LOW_INCOME,2401.0);
	  D.put(MarketSegment.FEMALE_OLD_HIGH_INCOME,407.0);
    D.put(MarketSegment.YOUNG_LOW_INCOME,3816.0);
    D.put(MarketSegment.YOUNG_HIGH_INCOME, 773.0);
    D.put(MarketSegment.OLD_LOW_INCOME, 4196.0);
    D.put(MarketSegment.OLD_HIGH_INCOME,1215.0);
    D.put(MarketSegment.MALE_LOW_INCOME, 3631.0);
    D.put(MarketSegment.MALE_HIGH_INCOME,1325.0);
    D.put(MarketSegment.FEMALE_LOW_INCOME, 4381.0);
    D.put(MarketSegment.FEMALE_HIGH_INCOME, 663.0);
    D.put(MarketSegment.MALE_YOUNG,2353.0);
    D.put(MarketSegment.MALE_OLD, 2603.0);
    D.put(MarketSegment.FEMALE_YOUNG,2236.0);
    D.put(MarketSegment.FEMALE_OLD,2808.0);
    D.put(MarketSegment.LOW_INCOME, 8012.0);
    D.put(MarketSegment.HIGH_INCOME, 1988.0);
    D.put(MarketSegment.YOUNG, 4589.0);
    D.put(MarketSegment.OLD,5411.0);
    D.put(MarketSegment.MALE, 4956.0);
    D.put(MarketSegment.FEMALE,5044.0);



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

      double pfactor = 1.05;
      for ( MarketSegment m : MarketSegment . values())
      {
        if(m.name().length() >= 18)
        {
          if(MarketSegment.marketSegmentSubset(c.getMarketSegment(),m))
          {
            if(c.getBudget() > 0.1)
            {
              bidEntries.add(new SimpleBidEntry(m, ((c.getBudget()*pfactor*D.get(m))/((double)c.getReach()*D.get(c.getMarketSegment()))), c.getBudget()));
            }
            else
            {
              bidEntries.add(new SimpleBidEntry(m, 1, c.getReach()*0.4));
            }
          }
        }
      }
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
	  AgentSix agent = new AgentSix("localhost", 9898);
    agent.connect("agent0");
  }

}

