package lettersandnumbers;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.*;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import java.util.StringTokenizer;

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
public class UI extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JButton begin = new JButton();
    JPanel player2Pan = new JPanel();
    JPanel player1Pan = new JPanel();
    JPanel controlPan = new JPanel();
    JPanel northPan = new JPanel();
    XYLayout xYLayout1 = new XYLayout();
    JTextField player1InputTxt = new JTextField();
    JButton getNonV1 = new JButton();
    JButton getVowel1 = new JButton();
    JTextField player1Answer = new JTextField();
    JButton done1 = new JButton();
    JTextField player2InputTxt = new JTextField();
    XYLayout xYLayout2 = new XYLayout();
    JButton getV2 = new JButton();
    JButton getNonV2 = new JButton();
    JTextField player2Answer = new JTextField();
    JButton done2 = new JButton();
    JButton nextMatch = new JButton();
    XYLayout xYLayout3 = new XYLayout();
    static JTextArea dictTxt = new JTextArea();
    JTextArea player1Res = new JTextArea();
    JTextArea player2Res = new JTextArea();
    JLabel player1Total = new JLabel();
    JLabel player2Total = new JLabel();
    JLabel info = new JLabel();
    JLabel matchLbl = new JLabel();
    JTextField timeoutTxt = new JTextField();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JScrollPane jScrollPlayer1Res = new JScrollPane(player1Res);
    JScrollPane jScrollDict = new JScrollPane(dictTxt);
    JScrollPane jScrollPlayer2Res = new JScrollPane(player2Res);
    JLabel scores1 = new JLabel();
    JLabel jLabel1 = new JLabel();
    public long timeout = 60000;
    public UI() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(694, 439));
        setTitle("Letters & Numbers game");
        begin.setText("new game");
        begin.addActionListener(new UI_begin_actionAdapter(this));
        player2Pan.setBackground(Color.gray);
        player2Pan.setPreferredSize(new Dimension(200, 10));
        player2Pan.setLayout(xYLayout2);
        player1Pan.setBackground(Color.gray);
        player1Pan.setPreferredSize(new Dimension(200, 10));
        player1Pan.setLayout(xYLayout1);
        controlPan.setBackground(Color.orange);
        controlPan.setLayout(xYLayout3);
        northPan.setBackground(Color.lightGray);
        northPan.setPreferredSize(new Dimension(10, 30));
        player1InputTxt.setText("");
        getNonV1.setToolTipText("");
        getNonV1.setText("get non vowel");
        getNonV1.addActionListener(new UI_getNonV1_actionAdapter(this));
        getVowel1.setToolTipText("");
        getVowel1.setText("get vowel");
        getVowel1.addActionListener(new UI_getVowel1_actionAdapter(this));
        player1Answer.setText("");
        done1.setText("done");
        done1.addActionListener(new UI_done1_actionAdapter(this));
        player2InputTxt.setText("");
        getV2.setText("get vowel");
        getV2.addActionListener(new UI_getV2_actionAdapter(this));
        getNonV2.setText("get non vowel");
        getNonV2.addActionListener(new UI_getNonV2_actionAdapter(this));
        player2Answer.setText("");
        done2.setText("done");
        done2.addActionListener(new UI_done2_actionAdapter(this));
        nextMatch.setText("next match>>");
        nextMatch.addActionListener(new UI_nextMatch_actionAdapter(this));
        dictTxt.setText("");
        player1Res.setText("");
        player2Res.setText("");
        player1Total.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
        player1Total.setText("total:0");
        player2Total.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
        player2Total.setText("total:0");
        matchLbl.setText("match: 0");
        jLabel5.setText("time out for a match(in sec.)");
        jLabel6.setFont(new java.awt.Font("Dialog", Font.BOLD, 14));
        jLabel6.setForeground(Color.green);
        jLabel6.setText("Player1");
        jLabel7.setFont(new java.awt.Font("Dialog", Font.BOLD, 14));
        jLabel7.setForeground(Color.green);
        jLabel7.setToolTipText("");
        jLabel7.setText("Player2");
        timeoutTxt.setPreferredSize(new Dimension(60, 20));
        timeoutTxt.setText("60");
        jLabel8.setText("input ur answer here then click done");
        jLabel9.setText("input ur answer here then click done");
        scores1.setText("scores");
        jLabel1.setText("scores");
        info.setToolTipText("");
        info.setText("info");
        timeLbl.setFont(new java.awt.Font("Dialog", Font.BOLD, 18));
        timeLbl.setText("0 sec.");
        jLabel2.setToolTipText("");
        jLabel2.setText("best match:");
        player1BestMatch.setText("xxxxxxxxxxx");
        jLabel3.setToolTipText("");
        jLabel3.setText("best match");
        player2BestMatch.setText("xxxxxxxxxx");
        player1Pan.add(jLabel6, new XYConstraints(66, 1, -1, -1));
        contentPane.add(northPan, java.awt.BorderLayout.NORTH);
        northPan.add(jLabel5);
        northPan.add(timeoutTxt);
        northPan.add(begin);
        player2Pan.add(jLabel7, new XYConstraints(80, 0, -1, -1));
        player2Pan.add(getNonV2, new XYConstraints(93, 55, 105, 29));
        player1Pan.add(getNonV1, new XYConstraints(90, 55, -1, 30));
        player1Pan.add(getVowel1, new XYConstraints(3, 55, 84, 31));
        player2Pan.add(getV2, new XYConstraints(3, 56, 88, 29));
        player2Pan.add(player2InputTxt, new XYConstraints(3, 24, 193, 28));
        player1Pan.add(player1InputTxt, new XYConstraints(4, 25, 188, 27));
        player1Pan.add(done1, new XYConstraints(4, 170, 192, 28));
        player1Pan.add(jLabel8, new XYConstraints(7, 116, -1, -1));
        player1Pan.add(player1Answer, new XYConstraints(5, 137, 190, 33));
        player2Pan.add(done2, new XYConstraints(4, 167, 191, 28));
        player2Pan.add(player2Answer, new XYConstraints(5, 132, 192, 34));
        player2Pan.add(jLabel9, new XYConstraints(7, 114, -1, -1));
        contentPane.add(player1Pan, java.awt.BorderLayout.WEST);
        contentPane.add(player2Pan, java.awt.BorderLayout.EAST);
        player1Pan.add(scores1, new XYConstraints(9, 206, -1, -1));
        player2Pan.add(jLabel1, new XYConstraints(14, 207, -1, -1));
        contentPane.add(controlPan, java.awt.BorderLayout.CENTER);
        controlPan.add(nextMatch, new XYConstraints(181, 142, 105, 27));
        controlPan.add(matchLbl, new XYConstraints(183, 174, -1, -1));
        controlPan.add(jScrollDict, new XYConstraints(3, 3, 166, 369));
        controlPan.add(timeLbl, new XYConstraints(181, 199, 71, 45));
        controlPan.add(info, new XYConstraints(167, 17, 126, 54));
        player1Pan.add(jScrollPlayer1Res, new XYConstraints(5, 225, 108, 131));
        player1Pan.add(player1Total, new XYConstraints(8, 360, -1, -1));
        player1Pan.add(jLabel2, new XYConstraints(118, 313, -1, -1));
        player1Pan.add(player1BestMatch, new XYConstraints(118, 337, -1, -1));
        player2Pan.add(jScrollPlayer2Res, new XYConstraints(6, 223, 112, 130));
        player2Pan.add(player2Total, new XYConstraints(6, 359, -1, -1));
        player2Pan.add(jLabel3, new XYConstraints(123, 302, -1, -1));
        player2Pan.add(player2BestMatch, new XYConstraints(123, 326, -1, -1));
    }

    Game game = null;
    boolean player1Done = false;
    boolean player2Done = false;
    TimeOutThread timeoutThread = null;
    public void begin_actionPerformed(ActionEvent e) {
        JFileChooser openDlg = new JFileChooser();
        int res = openDlg.showOpenDialog(this);
        if (res == openDlg.APPROVE_OPTION) {

            player1Res.setText("");
     player2Res.setText("");
            game = new Game("player1", "player2",
                            openDlg.getSelectedFile().getPath());

            game.playNextMatch();
            matchLbl.setText("match 1: Letters match");
        }

    }

    boolean playingMatch=false;
    public void beginMatch(){
        playingMatch=true;
            player1CanGo = player2CanGo = false;
            player1Done=player2Done=false;
            doneMatch=false;
            timeout = Long.parseLong(timeoutTxt.getText());
            game.turn=1;
            timeoutThread = new TimeOutThread(this);
            timeoutThread.start();



    }

    public void endMatch(){

        timeoutThread.stop=true;
        calcMatchRes();
playingMatch=false;
        player1InputTxt.setText("");
player1Answer.setText("");
player2InputTxt.setText("");
player2Answer.setText("");


    }

    public void done2_actionPerformed(ActionEvent e) {
        player2Done = true;
        if (player1Done) {
            timeoutThread.stop=true;
        }
    }

    public void done1_actionPerformed(ActionEvent e) {
        player1Done = true;
        if (player2Done) {
            timeoutThread.stop=true;


        }
    }

    public void calcMatchRes() {
        timeoutThread.stop = true;
        player1Done=player2Done=true;
        if (game == null) {
            System.out.println("choose new game");
            return;
        }

        if (game.match instanceof LettersMatch) {
            //player1
            //     LettersMatch match = (LettersMatch) game.match;
            String word = player1Answer.getText();
            int score = 0;
            if (game.dict.contains(word)) {
                score = word.length();
                game.player1.add2score(score);
            }
            player1Total.setText("total:" + game.player1.getScore());
            player1Res.append("" + score + "\n");
            player1BestMatch.setText(game.getBestWord(new StringBuffer(
                    player1InputTxt.getText())));

            //player2
            word = player2Answer.getText();
            score = 0;
            if (game.dict.contains(word)) {
                score = word.length();
                game.player2.add2score(score);
            }
            player2Total.setText("total:" + game.player2.getScore());
            player2Res.append("" + score + "\n");
            player2BestMatch.setText(game.getBestWord(new StringBuffer(
                    player2InputTxt.getText())));
            doneMatch = true;
       //     player1Done=player2Done=false;

        } else {
            NumbersMatch match = (NumbersMatch) game.match;
            player1BestMatch.setText(match.mix[0] + " " + match.mix[1] + " " +
                                     match.mix[2] + " " + match.mix[3] + " " +
                                     match.mix[4]);
            player2BestMatch.setText(match.mix[0] + " " + match.mix[1] + " " +
                                     match.mix[2] + " " + match.mix[3] + " " +
                                     match.mix[4]);
            doneMatch = true;
       //     player1Done=player2Done=false;
            //parse player1 answer
            StringTokenizer t = new StringTokenizer(player1Answer.getText());
            int i = 0;
            char ops[] = new char[5];
            int res=0;
            while (t.hasMoreTokens()) {
                String next = t.nextToken();
                if (next.equals("+")) {
                    ops[i] = '+';
                } else if (next.equals("-")) {
                    ops[i] = '-';
                } else if (next.equals("*")) {
                    ops[i] = '*';
                } else if (next.equals("/")) {
                    ops[i] = '+';
                } else {
                    try {
                        res = Integer.parseInt(next);
                    } catch (Exception ex) {
                        //error
                        System.out.println("error answer marked 0");
                        i=0;
                       break;
                    }

                }
                i++;

            }
            boolean fail1=false;
            boolean fail2=false;
            if(res!=NumbersMatch.calcRes(match.numbers,ops)){
                i = 0;
                fail1=true;
                System.out.println("Sum doesnt match for player1->0");
            }


            int distance1 =Math.abs(res-match.res);
        //   if(i==6)
        //    distance1=Math.abs(NumbersMatch.calcRes(match.numbers, ops) -
                     //                match.res);
            //parse player2 answer
            t = new StringTokenizer(player2Answer.getText());
           i = 0;
            while (t.hasMoreTokens()) {
                String next = t.nextToken();
                if (next.equals("+")) {
                    ops[i] = '+';
                } else if (next.equals("-")) {
                    ops[i] = '-';
                } else if (next.equals("*")) {
                    ops[i] = '*';
                } else if (next.equals("/")) {
                    ops[i] = '+';
                } else {
                    try {
                        res = Integer.parseInt(next);
                    } catch (Exception ex) {
                        //error
                        System.out.println("error answer marked 0");
                        i=0;
                        break;
                    }
                }
                i++;

            }

            if(res!=NumbersMatch.calcRes(match.numbers,ops)){
                i = 0;
                System.out.println("Sum doesnt match for player2->0");
                fail2=true;
            }

            int distance2 =Math.abs(res-match.res);;
      //      if(i==6)
      //          distance2=Math.abs(NumbersMatch.calcRes(match.numbers, ops) -
                               //      match.res);

            if(fail1 && fail2)
                distance1=distance2=0;
            else
                if(fail1 && !fail2){
                    distance1=0;
                    distance2=1;
                }
                else
                    if(!fail1 && fail2){
                        distance1=1;
                        distance2=2;
                    }
            if (distance1 < distance2) {
                player1Res.append(6 + "\n");
                game.player1.add2score(6);

                player2Res.append(0 + "\n");
            } else
            if (distance1 > distance2) {
                player1Res.append(0 + "\n");

                game.player2.add2score(6);
                player2Res.append(6 + "\n");
            } else {

                player1Res.append(0 + "\n");

                player2Res.append(0 + "\n");
            }
            player1Total.setText("total:" + game.player1.getScore());

            player2Total.setText("total:" + game.player2.getScore());
        }

    }

    boolean doneMatch = false;
    public void nextMatch_actionPerformed(ActionEvent e) {

        if (game == null) {
            System.out.println("choose new game");
            return;
        }

        if (!doneMatch) {
            System.out.println("complete the match first");
            return;
        }

        if (!game.playNextMatch()) {
            //   calcMatchRes();
            if (game.player1.getScore() > game.player2.getScore())
                info.setText("game over player1 wins");
            else if (game.player2.getScore() > game.player1.getScore())
                info.setText("game over player2 wins");
            else
                info.setText("game over EVEN");

        } else {

            //init
            doneMatch = false;
            player1InputTxt.setText("");
            player1Answer.setText("");
            player2InputTxt.setText("");
            player2Answer.setText("");
            player1Done=player2Done=false;
            player1CanGo = player2CanGo = false;

            timeout = Long.parseLong(timeoutTxt.getText());
            turn = 1;
            if (game.match instanceof NumbersMatch) {
                NumbersMatch m = (NumbersMatch) game.match;
                player1InputTxt.setText(m.numbers[0] + "-" + m.numbers[1] + "-" +
                                        m.numbers[2] + "-" + m.numbers[3] + "-" +
                                        m.numbers[4] + "-" + m.numbers[5] +
                                        "-->" + m.res);
                player2InputTxt.setText(m.numbers[0] + "-" + m.numbers[1] + "-" +
                                        m.numbers[2] + "-" + m.numbers[3] + "-" +
                                        m.numbers[4] + "-" + m.numbers[5] +
                                        "-->" + m.res);

                beginMatch();

                matchLbl.setText("Numbers Match");
            } else
                matchLbl.setText("Letters Match");

        }
    }

    int turn = 1;
    JLabel timeLbl = new JLabel();
    boolean player1CanGo = false;
    boolean player2CanGo = false;
    boolean playing=false;
    JLabel jLabel2 = new JLabel();
    JLabel player1BestMatch = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel player2BestMatch = new JLabel();
    boolean inMatch=false;
    public void getVowel1_actionPerformed(ActionEvent e) {
        if(playingMatch)
            return;

        if (game == null) {
            System.out.println("choose new game first");
            return;
        }

        if (game.turn != 1) {
            System.out.println("it's not ur turn");
            info.setText("Not your turn");
            return;
        }

        if (player1CanGo && player2CanGo) {
            System.out.println("can not make more choices");
            return;
        }

        if (game.match instanceof LettersMatch) {
            LettersMatch match = (LettersMatch) game.match;
            if (match.canGetMore()) {
                match.getVowel();
                player1InputTxt.setText(match.buffer1.toString());
            } else { //no more
                System.out.println("can't get more letters");
                player1CanGo = true;
                if (player2CanGo && player1CanGo) {
                    beginMatch();
                   }
            }
        }
        game.turn = 2; //switch turn
    }

    public void getV2_actionPerformed(ActionEvent e) {
        if(playingMatch)
      return;


        if (game == null) {
            System.out.println("choose new game first");
            return;
        }

        if (game.turn != 2) {
            System.out.println("it's not ur turn");
            info.setText("Not your turn");
            return;
        }

        if (player1CanGo && player2CanGo) {
            System.out.println("can make more choices");
            return;
        }

        if (game.match instanceof LettersMatch) {
            LettersMatch match = (LettersMatch) game.match;
            if (match.canGetMore()) {
                match.getVowel();
                player2InputTxt.setText(match.buffer2.toString());
            } else { //no more
                player2CanGo = true;
                if (player1CanGo && player2CanGo) {
                    beginMatch();
                }
                System.out.println("can't get more letters");
            }
        }
        game.turn = 1; //switch turn
    }

    public void getNonV1_actionPerformed(ActionEvent e) {
        if(playingMatch)
      return;


        if (game == null) {
            System.out.println("choose new game first");
            return;
        }

        if (game.turn != 1) {
            System.out.println("it's not ur turn");
            info.setText("Not your turn");
            return;
        }

        if (player1CanGo && player2CanGo) {
            System.out.println("can make more choices");
            return;
        }

        if (game.match instanceof LettersMatch) {
            LettersMatch match = (LettersMatch) game.match;
            if (match.canGetMore()) {
                match.getNonVowel();
                player1InputTxt.setText(match.buffer1.toString());
            } else { //no more
                System.out.println("can't get more letters");
                player1CanGo = true;
                if (player1CanGo && player2CanGo) {
                    beginMatch();
                }

            }
        }
        game.turn = 2; //switch turn
    }

    public void getNonV2_actionPerformed(ActionEvent e) {
        if(playingMatch)
      return;


        if (game == null) {
            System.out.println("choose new game first");
            return;
        }

        if (game.turn != 2) {
            System.out.println("it's not ur turn");
            info.setText("Not your turn");
            return;
        }

        if (player1CanGo && player2CanGo) {
            System.out.println("can make more choices");
            return;
        }

        if (game.match instanceof LettersMatch) {
            LettersMatch match = (LettersMatch) game.match;
            if (match.canGetMore()) {
                match.getNonVowel();
                player2InputTxt.setText(match.buffer2.toString());
            } else { //no more
                System.out.println("can't get more letters");
                player2CanGo = true;
                if (player1CanGo && player2CanGo) {
                    beginMatch();
                }

            }
        }
        game.turn = 1; //switch turn
    }
}


class UI_getNonV2_actionAdapter implements ActionListener {
    private UI adaptee;
    UI_getNonV2_actionAdapter(UI adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.getNonV2_actionPerformed(e);
    }
}


class UI_getNonV1_actionAdapter implements ActionListener {
    private UI adaptee;
    UI_getNonV1_actionAdapter(UI adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.getNonV1_actionPerformed(e);
    }
}


class UI_getV2_actionAdapter implements ActionListener {
    private UI adaptee;
    UI_getV2_actionAdapter(UI adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.getV2_actionPerformed(e);
    }
}


class UI_getVowel1_actionAdapter implements ActionListener {
    private UI adaptee;
    UI_getVowel1_actionAdapter(UI adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {

        adaptee.getVowel1_actionPerformed(e);
    }
}


class UI_done1_actionAdapter implements ActionListener {
    private UI adaptee;
    UI_done1_actionAdapter(UI adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.done1_actionPerformed(e);
    }
}


class UI_done2_actionAdapter implements ActionListener {
    private UI adaptee;
    UI_done2_actionAdapter(UI adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.done2_actionPerformed(e);
    }
}


class UI_begin_actionAdapter implements ActionListener {
    private UI adaptee;
    UI_begin_actionAdapter(UI adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.begin_actionPerformed(e);
    }
}


class UI_nextMatch_actionAdapter implements ActionListener {
    private UI adaptee;
    UI_nextMatch_actionAdapter(UI adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.nextMatch_actionPerformed(e);
    }
}
