package src;
import java.util.*;

public class game {

	private static final ArrayList<String> CHOICES = new ArrayList<String>(Arrays.asList("rock","scissors","paper"));

	public static void main(String [] args){
		System.out.println("Let's play a game of rock, paper, scissors!");
	
		Scanner reader = new Scanner(System.in);
		while (true){
			System.out.print("Please enter your choice (\"rock\", \"paper\", \"scissors\", \"random\"): ");
			String response = reader.next();
			int check = CHOICES.indexOf(response);
			if (check < 0 && !response.equals("random"))
				throw new IllegalArgumentException("please enter a valid option!");
		
			System.out.println(calcWinner(response));
		
			System.out.print("want to play again? (y/n) ");
			if (reader.next().equals("n"))
				break;
		}
	}
	
	public static String calcWinner(String player){
		Random rand = new Random();
		String computer = CHOICES.get(rand.nextInt(3));
		
		if(player.equals("random"))
			player = CHOICES.get(rand.nextInt(3));
		
		System.out.println("I play " + computer + " and you played " + player);
		
		if((computer.equals("rock") && player.equals("paper")) || 
				(computer.equals("paper") && player.equals("scissors")) || 
				(computer.equals("scissors") && player.equals("rock")))
			return "you win";
		else if(computer.equals(player))
			return "tie";
		else
			return "i win";
		
	}
}
