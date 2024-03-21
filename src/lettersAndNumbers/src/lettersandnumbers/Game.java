package lettersandnumbers;

import java.util.Iterator;

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
public class Game {
    Dictionary dict = new Dictionary();
    Player player1 = new Player("player1");
    Player player2 = new Player("player2");
    int matchCount = 1; //9 matches max
    static final int maxMatches = 9;
    Match match;
    int turn = 1;
    public Game(String name1, String name2, String path) {
        player1 = new Player(name1);
        player2 = new Player(name2);
        dict.loadFromFile(path);
    }

    private void playLetters() {
        if (matchCount > maxMatches) {
            System.out.println("game over");
            return;
        }
        matchCount++;
        match = new LettersMatch();
    }

    private void playNumbers() {
        if (matchCount > maxMatches) {
            System.out.println("game over");
            return;
        }
        matchCount++;
        match=new NumbersMatch();
    }

    /**
     * the match sequence is
     * L L N L L N L L N...
     */
    public boolean playNextMatch() {
        if (matchCount <= maxMatches) {
            if ((matchCount % 3 == 0))
                playNumbers();
            else
                playLetters();
            return true;
        } else { //do the math
            return false;
        }
    }



    /**
     * out of 9 letters form the longest word that exists in the dictionary
     * so this is how we do it:
     * instead of forming all possibilities out of 9 letters which could reach infinity we iterate
     * through all words in dictionary and see if the word could be formed out of the 9 letters
     * then we return the longest match
     * [alternative approach using a sorted list against lengths of strings in the dictionary or through another interface to it]
     * @param mix StringBuffer 9 letters buffer
     * @return String
     */
    public String getBestWord(StringBuffer mix) {
        int maxLen = 0;
        String longest = null;
        Iterator itr = dict.set.iterator();
        while (itr.hasNext()) {
            String temp = (String) itr.next();
            if (canMutate(mix, new StringBuffer(temp))) {
                if (temp.length() > maxLen) {
                    maxLen = temp.length();
                    longest = temp;
                }
            }
        }
        return longest;
    }

    /**
     * if we can constitute target string from a mix of letters then we can do the mutation and return true
     * @param mix StringBuffer
     * @param target StringBuffer
     * @return boolean
     */
    public boolean canMutate(StringBuffer mix, StringBuffer target) {
        for (int i = 0; i < target.length(); i++) {
            if (mix.indexOf("" + target.charAt(i)) < 0)
                return false;
        }
        return true;
    }

    /**
     * passing a list of integers, find the sequence of operations + - * / to get the result passed
     * try all possibilties tell one is found or none
     * no association or precedence is considered
     * @param list int[]
     * @param res int
     * @return char[]
     */
    public char[] getBestResult(int[] list,int res){

        char op[]=new char[list.length-1];
        if(mix(list,1,'+',list[0],op,res)){
            return op;
        }
        if (mix(list, 1, '-', list[0], op,res)) {
            return op;
        }
        if (mix(list, 1, '*', list[0], op,res)) {
            return op;
        }
        if (mix(list, 1, '/', list[0], op,res)) {
            return op;
        }


        return op;
    }

    public boolean mix(int[] list, int index/*use set from index tell last  */,char op,int res,char[] ops,int finalRes){
        boolean result=false;
        int temp=0;
        if(index==(list.length-1)){ //final state
            //check success
            switch (op) {
            case '+':
                temp = res + list[index];
                break;
            case '-':
                temp = res - list[index];
                break;
            case '*':
                temp = res + list[index];
                break;
            case '/':
                temp = res + list[index];
                break;
            }
            ops[index-1]=op;
            if(temp==finalRes)
                return true;
            else
                return false;

        }
        else{
            switch (op) {
            case '+':
                temp = res + list[index];
                break;
            case '-':
                temp = res - list[index];
                break;
            case '*':
                temp = res + list[index];
                break;
            case '/':
                temp = res + list[index];
                break;
            }

            if(mix(list,index+1,'+',temp,ops,finalRes)){
                ops[index-1]='+';
                return true;
            }

            else if(mix(list,index+1,'-',temp,ops,finalRes)){
                ops[index-1]='-';
                return true;
            }

            else if(mix(list,index+1,'*',temp,ops,finalRes)){
                ops[index-1]='*';
                return true;
            }

            else if(mix(list,index+1,'/',temp,ops,finalRes)){
                ops[index-1]='/';
                return true;
            }
            else
                return false;

            }
        }

}
