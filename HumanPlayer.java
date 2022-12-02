import java.util.Scanner;
/**
 * Human Player class
 * @author Tony Gonzalez
 * @version 8/9/22 
 */
public class HumanPlayer implements Player{

    Scanner scanner = new Scanner(System.in);

    @Override
    public void init(Boolean color) {

        char token = ' ';
        if(color == true)
        {
            token = '1';
        }
        System.out.println("Player 1's tokens: " + "'" + token + "'"); 
    }

    @Override
    public String name() {

        return "Tony";
    }

    @Override
    public int move() {
        System.out.print("Player 1's turn. Please enter a column: ");
        int move = scanner.nextInt();

        return move;
    }

    @Override
    public void inform(int i) {
        System.out.println("Player 2 dropped a token in column " + i + "\n");
    }
    
}
