/**
 * Player interface for HumanPlayer and AutomaticPlayer classes
 * @author Tony Gonzalez
 * @version 8/9/22
 */
public interface Player {
    /**
     * Prints player's name and their respective token 
     * @param color Assigned player color
     */
    void init(Boolean color);
    /**
     * Assigns player name
     * @return Returns player name
     */
    String name();
    /**
     * Prompts player to enter the column they want to play
     * @return Returns player's column choice
     */
    int move();
    /**
     * Prints which column their opponent played
     * @param i The row where the opponent played
     */
    void inform(int i);
}