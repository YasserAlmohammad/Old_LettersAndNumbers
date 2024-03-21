package lettersandnumbers;
import java.util.HashSet;
import java.io.*;
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
public class Dictionary {
    public HashSet set=new HashSet();
    public Dictionary() {
    }

    public String add(String str){
        set.add(str);
        return str;
    }

    public boolean contains(String str){
        return set.contains(str);
    }

    public void loadFromFile(String str){
     File file=new File(str);
    try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line=reader.readLine())!=null){
            StringTokenizer t=new StringTokenizer(line);
            while(t.hasMoreTokens()){
                String s=t.nextToken();
                set.add(s);
                UI.dictTxt.append(s+"\n");
            }
        }
    } catch (Exception ex) {
        System.out.println("Error in loading dictionary data"+ex.getMessage());
    }
 }
}
