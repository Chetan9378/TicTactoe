package TicTacToe;

public class TicTacToe 
{

	public static void main(String[] args) 
	{
		char [] board = {'1','2','3',
						 '4','5','6',
						 '7','8','9'};	
		
		var numberofSquaresPlayed = 0;
		var whoseturnItIs = 'X';
		var gameEndingMessage = "Hard Battle fought to a draw";
		
		 while(numberofSquaresPlayed < 9)      //checking the No of squares played by user should be less than 9 square
		 {
			 printTheBoard(board);
			 getTheUserToSelectTheirSquare(board, whoseturnItIs);
			 
			 if (theyWontheGame(board, whoseturnItIs))   //check for a Win
			 {
				 gameEndingMessage = "Congratulations Player " + whoseturnItIs + " has Won the Game ";
				 printTheBoard(board);
				 break;	 
			 }
			 else 
			 {
				numberofSquaresPlayed++;
				whoseturnItIs = (whoseturnItIs == 'X') ? 'O' : 'X';		 		
			 }
			 
		 }
		 
		 System.out.println(gameEndingMessage);
	}

	private static boolean theyWontheGame(char[] board, char whoseturnItIs) {
		return (board[0] + board[1] + board[2]) == (whoseturnItIs * 3)
		 || (board[3] + board[4] + board[5]) == (whoseturnItIs * 3)
		 || (board[6] + board[7] + board[8]) == (whoseturnItIs * 3)
		 || (board[0] + board[3] + board[6]) == (whoseturnItIs * 3)
		 || (board[1] + board[4] + board[7]) == (whoseturnItIs * 3)
		 || (board[2] + board[5] + board[8]) == (whoseturnItIs * 3)
		 || (board[0] + board[4] + board[8]) == (whoseturnItIs * 3)
		 || (board[2] + board[4] + board[6]) == (whoseturnItIs * 3);
	}

	private static void getTheUserToSelectTheirSquare(char[] board, char whoseturnItIs) {
		do {
			try {
				System.out.printf("Choose a sqaure played %s: ", whoseturnItIs);
				var scanner = new java.util.Scanner(System.in); //Taking input from User
				var input = scanner.nextInt();
				if(Character.isDigit(board[input-1]))
					{	
					board[input - 1] = whoseturnItIs;
					break;
					} 
					else 
					{
					System.out.println("Sorry , that Square is Taken!");
					}
				}
			catch (Exception e) 
			{
				System.out.println("Something Went Wrong. Please Enter a sqauare again...");
			}
		} while (true);
	}

	private static void printTheBoard(char[] board)    //Printing a board
	{
		System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
		System.out.println("- + - + - ");
		System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
		System.out.println("- + - + - ");
		System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
		 
	}
}
