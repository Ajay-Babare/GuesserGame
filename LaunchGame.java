package game.guesser;

import java.util.*;

class Guesser
{
	int guessNum;
	
	int guessNum()
	{
		guessNum = (int) (Math.random()*10);
		System.out.println(guessNum);
		System.out.println("Guess the number between 0 to 9");
		System.out.println("--------------------------------");
		
		return guessNum;
	}	
}

class Player
{
	int guessNum;

	int guessNum(int i)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Player "+(i+1)+" kindly guess the number");
		guessNum=scan.nextInt();
		return guessNum;
	}
}

class Umpire
{
	int numFromGuesser;
	
	int[] player = new int[3];
	
	void collectNumFromGuesser()
	{
		Guesser g=new Guesser();
		numFromGuesser=g.guessNum();
	}
	void collectNumFromPlayers(int p)
	{
		for(int i=0; i<p; i++)
		{
			Player obj = new Player();
			player[i] = obj.guessNum(i);			
		}
	}
	void compare()
	{
		System.out.println("--------------------------------");
		
		if(numFromGuesser==player[0])
		{
			if(numFromGuesser==player[1] && numFromGuesser==player[2])
			{
				System.out.println("All players won the game");
			}
			else if(numFromGuesser==player[1] )
			{
				System.out.println("Player 1 & Player 2 won");
			}
			else if(numFromGuesser==player[2])
			{
				System.out.println("Player 1 & Player 3 won");
			}
			else
			{
				System.out.println("Player 1 won the game");
			}
		}
		else if(numFromGuesser==player[1])
		{
			if(numFromGuesser==player[2])
			{
				System.out.println("Player 2 & Player 3 won");
			}
			else
			{
				System.out.println("Player 2 won the game");
			}
		}
		else if(numFromGuesser==player[2])
		{
			System.out.println("Player 3 won the game");
		}
		else
		{
			System.out.println("Game lost Try Again!");
		}
	}	
}
public class LaunchGame 
{
	public static void main(String[] args) 
	{
		System.out.println("* * * * * * * * * * * * * * * *");
		System.out.println("* Welcome To The Guesser Game *");
		System.out.println("* * * * * * * * * * * * * * * *");
			
		System.out.println("How many players are there 1, 2 or 3 ?");
		Scanner scan = new Scanner(System.in);
		int p = scan.nextInt();
		System.out.println("--------------------------------");
			
		Umpire u=new Umpire();
		u.collectNumFromGuesser();
		u.collectNumFromPlayers(p);
		u.compare();		
	}
}
