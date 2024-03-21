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
public class TimeOutThread extends Thread {
    long timeout;
    UI ui;
    int i=1;
    boolean stop=false;
    public TimeOutThread(UI ui) {
        super();
        this.ui=ui;
        timeout=ui.timeout;

    }
    public void run(){
        while((i<=timeout) && (!stop)){
            ui.timeLbl.setText((timeout-i)+" sec.");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
            }
            ++i;
        }
       // if(!ui.player1Done && !ui.player2Done && !stop)
            ui.endMatch();
    }
}
