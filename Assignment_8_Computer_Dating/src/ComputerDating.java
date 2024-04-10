// CS1A Fall 2023 - Computer Dating
// Timothy Kwock
public class ComputerDating
{
   public static void main(String[] args)
   {
      final String NEW_LINE = "\n";
      final int NUM_OF_PROFILES = 4;
// instantiate new profile objects
      DateProfile[] profiles = new DateProfile[NUM_OF_PROFILES];
      for (int i = 0; i < profiles.length; i++)
      {
         profiles[i] = new DateProfile();
      }
// set profiles for each person
      profiles[0].setAll(2, 1, 8, 2, "Benjamin");
      profiles[1].setAll(1, 2, 9, 9, "Elizabeth");
      profiles[2].setAll(2, 2, 4, 8, "Tyler");
      profiles[3].setAll(1, 1, 2, 2, "Jennifer");
// display profiles for each pairing (including oneself)
      for (int i = 0; i < profiles.length; i++)
      {
         for (int j = 0; j < profiles.length; j++)
         {
            displayTwoProfiles(profiles[i], profiles[j]);
         }
         System.out.print(NEW_LINE);
      }
   }
   // displays the fitValue between two profiles and their names
   static void displayTwoProfiles(DateProfile profile1, DateProfile
           profile2)
   {
      System.out.println("Fit between " + profile1.getName() + " and "
              + profile2.getName() + ": " + profile1.fitValue(profile2));
   }
}
class DateProfile
{
   // instance members
   private int distance;
   private int searchDistance;
   private int romance;
   private int finance;
   private String name;
   // constants
   public static final int DIST_LESS_THAN_5_MILES = 1;
   public static final int DIST_MORE_THAN_5_MILES = 2;
   public static final int MIN_ROMANCE = 1;
   public static final int MAX_ROMANCE = 10;
   public static final int MIN_FINANCE = 1;
   public static final int MAX_FINANCE = 10;
   public static final int MIN_NAME_LEN = 1;
   // default values
   public static final int DEFAULT_DIST = 1;
   public static final int DEFAULT_SEARCH_DIST = 1;
   public static final int DEFAULT_ROMANCE = 1;
   public static final int DEFAULT_FINANCE = 1;
   public static final String DEFAULT_NAME = "(missing name)";
   // default constructor
   DateProfile()
   {
      setDistance(DEFAULT_DIST);
      setSearchDistance(DEFAULT_DIST);
      setRomance(DEFAULT_ROMANCE);
      setFinance(DEFAULT_FINANCE);
      setName(DEFAULT_NAME);
   }
   // parameterized constructor
   DateProfile(int distance1, int searchDistance1, int romance1, int
           finance1,
               String name1)
   {
      setDistance(distance1);
      setSearchDistance(searchDistance1);
      setRomance(romance1);
      setFinance(finance1);
      setName(name1);
   }
   // accessors (getters)
   public int getDistance()
   {
      return distance;
   }
   public int getSearchDistance()
   {
      return searchDistance;
   }
   public int getRomance()
   {
      return romance;
   }
   public int getFinance()
   {
      return finance;
   }
   public String getName()
   {
      return name;
   }
   // mutators (setters)
   public boolean setDistance(int newDistance)
   {
      if (newDistance == DIST_LESS_THAN_5_MILES)
      {
         distance = DIST_LESS_THAN_5_MILES;
         return true;
      }
      else if (newDistance == DIST_MORE_THAN_5_MILES)
      {
         distance = DIST_MORE_THAN_5_MILES;
         return true;
      }
      else
      {
         System.out.println("Please provide distance 1 or 2.");
         return false;
      }
   }
   public boolean setSearchDistance(int newSearchDistance)
   {
      if (newSearchDistance == DIST_LESS_THAN_5_MILES)
      {
         searchDistance = DIST_LESS_THAN_5_MILES;
         return true;
      }
      else if (newSearchDistance == DIST_MORE_THAN_5_MILES)
      {
         searchDistance = DIST_MORE_THAN_5_MILES;
         return true;
      }
      else
      {
         System.out.println("Please provide a search distance 1 or 2.");
         return false;
      }
   }
   public boolean setRomance(int newRomance)
   {
      if (newRomance >= MIN_ROMANCE && newRomance <= MAX_ROMANCE)
      {
         romance = newRomance;
         return true;
      }
      else
      {
         System.out.println("Please provide a value between 1 and 10.");
         return false;
      }
   }
   public boolean setFinance(int newFinance)
   {
      if (newFinance >= MIN_FINANCE && newFinance <= MAX_FINANCE)
      {
         finance = newFinance;
         return true;
      }
      else
      {
         System.out.println("Please provide a value between 1 and 10.");
         return false;
      }
   }
   public boolean setName(String newName)
   {
      if (newName.length() > MIN_NAME_LEN)
      {
         name = newName;
         return true;
      }
      else
      {
         System.out.println("Please enter a name.");
         return false;
      }
   }
   // setAll, given 5 arguments
   public void setAll(int distance1, int searchDistance1, int romance1,
                      int finance1, String name1)
   {
      setDefaults();
      setDistance(distance1);
      setSearchDistance(searchDistance1);
      setRomance(romance1);
      setFinance(finance1);
      setName(name1);
   }
   // setDefaults for each member
   public void setDefaults()
   {
      distance = DEFAULT_DIST;
      searchDistance = DEFAULT_DIST;
      romance = DEFAULT_ROMANCE;
      finance = DEFAULT_FINANCE;
      name = DEFAULT_NAME;
   }
   // determines fitValue based on distance, romance and finance fit
   public double fitValue(DateProfile partner)
   {
      double testFitValue = determineDistanceFit(partner) *
              ((determineRomanceFit(partner) + determineFinanceFit(partner)) /
                      2);
      return Math.round(testFitValue * 100) / 100.;
   }
// determineDistanceFit based off mutual compatability of person's
   search
   // distance vs partner's distance, and visa versa
   private double determineDistanceFit(DateProfile partner)
   {
      if ((partner.getSearchDistance() >= this.getDistance())
              && (this.getSearchDistance() >= partner.getDistance()))
      {
         return 1; // compatible
      }
      else
      {
         return 0; // not compatible
      }
   }
   // determineRomanceFit between person and partner
   private double determineRomanceFit(DateProfile partner)
   {
      double inherentRomance = (double)this.getRomance();
      double partnerRomance = (double)partner.getRomance();
      double romanceFitResult = calculateFit(partnerRomance,
              inherentRomance);
      return romanceFitResult;
   }
   // determineFinanceFit between person and partner
   private double determineFinanceFit(DateProfile partner)
   {
      double inherentFinance = (double)this.getFinance();
      double partnerFinance = (double)partner.getFinance();
      double financeFitResult = calculateFit(partnerFinance,
              inherentFinance);
      return financeFitResult;
   }
// calculateFit returns between 0.0 (terrible fit) and 1.0 (perfect
   fit)
   private double calculateFit(double partnerValue, double inherentValue)
   {
      double result = 1 - Math.abs((partnerValue - inherentValue) / 9);
      return result;
   }
}
/* -------------------------- Output Result ------------------------------
-----
Fit between Benjamin and Benjamin: 0.0
Fit between Benjamin and Elizabeth: 0.56
Fit between Benjamin and Tyler: 0.0
Fit between Benjamin and Jennifer: 0.0
Fit between Elizabeth and Benjamin: 0.56
Fit between Elizabeth and Elizabeth: 1.0
Fit between Elizabeth and Tyler: 0.67
Fit between Elizabeth and Jennifer: 0.22
Fit between Tyler and Benjamin: 0.0
Fit between Tyler and Elizabeth: 0.67
Fit between Tyler and Tyler: 1.0
Fit between Tyler and Jennifer: 0.0
Fit between Jennifer and Benjamin: 0.0
Fit between Jennifer and Elizabeth: 0.22
Fit between Jennifer and Tyler: 0.0
Fit between Jennifer and Jennifer: 1.0
--------------------------------------------------------------------------
-- */
