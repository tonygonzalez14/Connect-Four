/**
 * Computer player class 
 * @author Tony Gonzalez
 * @version 8/9/22
 */
public class AutomaticPlayer implements Player{

    @Override
    public void init(Boolean color) {
        
        char token = ' ';
        if(color == false)
        {
            token = '0';
        }
        System.out.println("Player 2's tokens: " + "'" + token + "'"); 
    }

    @Override
    public String name() {

        return "Computer";
    }

    @Override
    public int move() {

        return 0;
    }

    @Override
    public void inform(int i) {
        System.out.println("Player 1 dropped a token in column " + i + "\n");
    }

    /**
     * Iterates through the board to find the location where their opponent played
     * @param board Current playing board
     * @return Returns location of where their opponent played 
     */
    public int checkCol(char[][] board)
    {
        int location = 0;
        outerloop:
        for (int col = 0; col < 7; col++){
            for(int row = 0; row < 6;)
            if(board[row][col] == '1')
            {
                location = col;
                break outerloop;
            }
            else
            {
                row++;
            }
        }
        return location;
    }

     /**
     * Iterates through the board to find the location where their opponent played
     * @param board Current playing board
     * @return Returns location of where their opponent played 
     */
    public int checkRow(char[][] board)
    {
        int location = 0;
        outerloop:
        for (int row = 0; row < 6; row++){
            for(int col = 0; col < 7;)
            if(board[row][col] == '1')
            {
                location = row;
                break outerloop;
            }
            else
            {
                col++;
            }
        }
        return location;
    }

    /**
     * Finds the amount of tokens their opponent has in each row 
     * @param board Current playing board
     * @return Returns the row with the most amount of player tokens 
     */
    public int scoreRow(char[][] board)
    {
        int rowZeroScore = 0;
        int rowOneScore = 0;
        int rowTwoScore = 0;
        int rowThreeScore = 0;
        int rowFourScore = 0;
        int rowFiveScore = 0;
        int largest = rowZeroScore;

        for (int row = 0; row < 6; row++){
            for(int col = 0; col < 7; col++)
            if(board[row][col] == '1')
            {
                //Adds amount of tokens in each row
                switch(row)
                {
                    case 0:
                    rowZeroScore++;
                    break;
                    case 1:
                    rowOneScore++;
                    break;
                    case 2:
                    rowTwoScore++;
                    break;
                    case 3:
                    rowThreeScore++;
                    break;
                    case 4:
                    rowFourScore++;
                    break;
                    case 5:
                    rowFiveScore++;
                    break;
                }
            }
        }
        //Find row with highest score 
        if(rowOneScore > largest)
        {
            largest = rowOneScore;
        }
        else if(rowTwoScore > largest)
        {
            largest = rowTwoScore;
        }
        else if(rowThreeScore > largest)
        {
            largest = rowThreeScore;
        }
        else if(rowFourScore > largest)
        {
            largest = rowFourScore;
        }
        else if(rowFiveScore > largest)
        {
            largest = rowFiveScore;
        }
        return largest;
    }

    /**
     * Finds the amount of tokens their opponent has in each column 
     * @param board Current playing board
     * @return Returns the column with the most amount of player tokens 
     */
    public int scoreCol(char[][] board)
    {
        int colZeroScore = 0;
        int colOneScore = 0;
        int colTwoScore = 0;
        int colThreeScore = 0;
        int colFourScore = 0;
        int colFiveScore = 0;
        int colSixScore = 0;
        int largest = 0;

        for (int row = 0; row < 6; row++){
            for(int col = 0; col < 7; col++)
            if(board[row][col] == '1')
            {
                //Adds amount of tokens in each column
                switch(col)
                {
                    case 0:
                    colZeroScore++;
                    break;
                    case 1:
                    colOneScore++;
                    break;
                    case 2:
                    colTwoScore++;
                    break;
                    case 3:
                    colThreeScore++;
                    break;
                    case 4:
                    colFourScore++;
                    break;
                    case 5:
                    colFiveScore++;
                    break;
                    case 6:
                    colSixScore++;
                    break;
                }
            }
        }
        //Find column with highest score 
        if(colZeroScore > largest)
        {
            largest = colZeroScore;
        }
        else if(colOneScore > largest)
        {
            largest = colOneScore;
        }
        else if(colTwoScore > largest)
        {
            largest = colTwoScore;
        }
        else if(colThreeScore > largest)
        {
            largest = colThreeScore;
        }
        else if(colFourScore > largest)
        {
            largest = colFourScore;
        }
        else if(colFiveScore > largest)
        {
            largest = colFiveScore;
        }
        else if(colSixScore > largest)
        {
            largest = colSixScore;
        }
        return largest;
    }
}