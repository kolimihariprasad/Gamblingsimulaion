import java.util.Random;  
import java.util.*;  
public class GamblingSimulation {
	public static final int START_STAKE = 100;
	public static final int BET = 1;
	public static final float STAKE_VALUE = 0.5f;
	public static void main(String[] args) {
		stakeCalculationForEachDay();
		
	}
        public static int gamble() {
		Random random = new Random();
		int decision = random.nextInt(2);
		return decision;
        }
	public static int stakeCalculation() {
		int daily_stake = START_STAKE;
		int daily_bet=BET;
		int winningamt = Math.round(daily_stake + daily_stake * STAKE_VALUE);
		int lossingamt = Math.round(daily_stake - daily_stake * STAKE_VALUE);
		while(daily_stake > lossingamt && daily_stake < winningamt) {
			int outcome = gamble();
			if(outcome == 1){
				daily_stake+=daily_bet;
			}
			else
				daily_stake-=daily_bet;
		}
		return daily_stake;
	}
	public static void stakeCalculationForEachDay(){
		int[] stakeForEachDay= new int[20];
		Map MonthlyStakemap=new HashMap();
		for(int i=0;i<20;i++){
			int dailyAmt = stakeCalculation();
			stakeForEachDay[i] = dailyAmt;
		}
		for(int i=0;i<20;i++){
			System.out.print(stakeForEachDay[i] +" ");
		}
		for(int i=0;i<20;i++){
			int dailyAmt = stakeForEachDay[i];
			MonthlyStakemap.put(i, dailyAmt);
		}
		Iterator it = MonthlyStakemap.entrySet().iterator();
		System.out.println("");
		while(it.hasNext()){  
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(" Day " + pair.getKey() + "  " + pair.getValue());
			it.remove();  
		}  
	}		
}
