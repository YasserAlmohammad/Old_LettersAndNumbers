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
public class LettersMatch extends Match{
    private int count=0;
    static final int maxCount=18;

    static final StringBuffer vowelSet=new StringBuffer("aeiou");
    static final StringBuffer nonVowelSet=new StringBuffer("bcdfghjklmnpqrstuvwxyz");
    static final int vowelLength=vowelSet.length();
    static final int nonVowelLength=nonVowelSet.length();

    StringBuffer buffer1=new StringBuffer();
    StringBuffer buffer2=new StringBuffer();

    public LettersMatch() {
    }

    public char getVowel(){
        if(count>=maxCount)
            return ' ';
        int rand=(int)(Math.random()*vowelLength);
        char c=vowelSet.charAt(rand);
        count++;
        if((count%2) ==0)
            buffer2.append(c);
        else
            buffer1.append(c);
        return c;
    }

    public char getNonVowel(){
        if(count>=maxCount)
            return ' ';
        int rand=(int)(Math.random()*nonVowelLength);
        char c=nonVowelSet.charAt(rand);
        count++;
        if((count%2) ==0)
            buffer2.append(c);
        else
            buffer1.append(c);
        return c;
    }

    public boolean canGetMore(){
        if(count<maxCount)
            return true;
        else
            return false;
    }

}
