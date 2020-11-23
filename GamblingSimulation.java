import java.util.Random;  
public class GamblingSimulation {
	public static final int START_STAKE = 100;
	public static final int BET = 1;
	public static void main(String[] args) {
		stakeCalculation();
    }
        public static int gamble() {
		Random random = new Random();
		int decision = random.nextInt(2);
		return decision;
        }
	public static void stakeCalculation() {
		int daily_stake = START_STAKE;
		int daily_bet=BET;
		while(daily_stake > START_STAKE/2 ) {
			int outcome = gamble();
			if(outcome == 1){
				daily_stake+=daily_bet;
			}
			else
				daily_stake-=daily_bet;
		}
	}
}
