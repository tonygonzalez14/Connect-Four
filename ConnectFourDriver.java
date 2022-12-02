/**
 * Driver for AutomaticPlayer and HumanPlayer classes.
 * @author Tony Gonzalez
 * @version 8/9/22
 */
public class ConnectFourDriver{

    /**
     * Main function. 
     * Creates a board using a 2-D character array.
     * Uses while loop for game and promts human to make first move.
     * Updates board, informs computer, checks if move was a winning move, then switches turns.
     * Computer algorithm finds where opponent plays, finds how tokens are in each row/ column, then uses this info to make a choice. 
     * Keeps looping until the check winner method finds a winner. 
     * Prints who won.
     * @param args 
     */
    public static void main(String[] args) {

        //Create objects
        HumanPlayer tony = new HumanPlayer();
        AutomaticPlayer computer = new AutomaticPlayer();

        boolean winner = false;

        //Human player is red (1, true), computer is yellow (0, false)
        tony.init(true);
        computer.init(false);

        char token = '1';
        char[][] board = new char[6][7];

        //Creates a blank board
        for (int row = 0; row < board.length; row++){
			for (int column = 0; column < board[0].length; column++){
				board[row][column] = ' ';
			}
		}

        //Start of game 
        printBoard(board);

        gameLoop:
        while(winner == false)
        {
            //Tony's turn
            int humanMove = tony.move();
            token = '1';
            updateBoard(humanMove, board, token);
            computer.inform(humanMove);

            winner = checkWinner(token, board);
            printBoard(board);

            if(winner == true)
            {
                break gameLoop;
            }

            //Switches turns
            token = '0';

            //Comp's turn
            int colScore = computer.scoreCol(board);
            int rowScore = computer.scoreRow(board);
            int computerMove = 0;

            //Find where opponent has the most tokens 
            if(colScore > rowScore) //Column has multiple in a row
            {
                computerMove = computer.checkCol(board);
            }
            else if(colScore < rowScore) //Row has multiple in a row 
            {   
                computerMove = computer.checkRow(board);
            }
            else //Neither has multiple in a row 
            {
                computerMove = computer.checkCol(board) - 1;
            }
    
            updateBoard(computerMove, board, token);
            tony.inform(computerMove);

            winner = checkWinner(token, board);
            printBoard(board);
        }
    
        //Find winner based on who played last 
        if (winner)
        {
			if (token=='1')
            {
				System.out.println("Tony won");
			}
            else
            {
				System.out.println("The computer won");
			}
		}
        else
        {
			System.out.println("Tie game");
		}
    }

    /**
     * Displays the board.
     * @param board Current playing board. 
     */
    public static void printBoard(char[][] board)
    {
		System.out.println(" 0 1 2 3 4 5 6");
		for (int row = 0; row < board.length; row++){
			System.out.print("|");
			for (int col = 0; col < board[0].length; col++){
				System.out.print(board[row][col]);
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println();
	}

    /**
     * Places tokens in board. 
     * @param move Column played.
     * @param board Current playing board.
     * @param color Token color. 
     */
    public static void updateBoard(int move, char[][] board, char color)
    {
        for (int row = board.length-1; row >= 0; row--){
            if(board[row][move] == ' '){
                board[row][move] = color;
                break;
            }
        }
    }

    /**
     * Checks if there is a winner. 
     * @param token Token color.
     * @param board Current playing board. 
     * @return Returns true if winner is found. Returns false if no winner is found. 
     */
    public static boolean checkWinner(char token, char[][] board)
    {
		//Check for 4 across
		for(int row = 0; row < board.length; row++)
        {
			for (int col = 0; col < board[0].length - 3;col++)
            {
				if (board[row][col] == token   && 
					board[row][col+1] == token &&
					board[row][col+2] == token &&
					board[row][col+3] == token)
                    {
					return true;
				}
			}			
		}
		//Check for 4 vertically
		for(int row = 0; row < board.length - 3; row++)
        {
			for(int col = 0; col < board[0].length; col++)
            {
				if (board[row][col] == token   && 
					board[row+1][col] == token &&
					board[row+2][col] == token &&
					board[row+3][col] == token)
                    {
					return true;
				}
			}
		}
		//Check upward diagonal
		for(int row = 3; row < board.length; row++)
        {
			for(int col = 0; col < board[0].length - 3; col++)
            {
				if (board[row][col] == token   && 
					board[row-1][col+1] == token &&
					board[row-2][col+2] == token &&
					board[row-3][col+3] == token)
                    {
					return true;
				}
			}
		}
		//Check downward diagonal
		for(int row = 0; row < board.length - 3; row++)
        {
			for(int col = 0; col < board[0].length - 3; col++)
            {
				if (board[row][col] == token   && 
					board[row+1][col+1] == token &&
					board[row+2][col+2] == token &&
					board[row+3][col+3] == token)
                    {
					return true;
				}
			}
		}
		return false;
	}
}