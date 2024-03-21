package lettersandnumbers;

/**
 * <p>Title: letters and numbers</p>
 *
 * <p>Description: simulation of the game Letters and Numbers</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Player {
    private int score=0;
    private String name;
    public Player(String name) {
        this.name=name;
    }

    public void add2score(int val){
        score+=val;
    }
    public int getScore(){
        return score;
    }
}
