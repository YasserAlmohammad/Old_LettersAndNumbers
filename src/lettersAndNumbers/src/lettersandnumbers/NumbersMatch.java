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
public class NumbersMatch extends Match{
    public int[] numbers=new int[6];
    public char[] mix=new char[5];
    public int res;

    public NumbersMatch() {
        generateNumbers();
        suggestMixOp();
        res=calcRes(numbers,mix);
    }

    public void generateNumbers(){
        for(int i=0;i<6;i++){
            numbers[i]=(int)(Math.random()*100)+1;
        }
    }

    public void suggestMixOp(){
        for(int i=0;i<5;i++){
            int res=(int)(Math.random()*4);
            switch (res){
            case 0:
                mix[i]='+';
                break;
            case 1:
                mix[i]='-';
                break;
            case 2:
                mix[i]='*';
                break;
            case 3:
                mix[i]='/';
                break;
            }
        }
    }

    public static int calcRes(int[] list,char[]op){
        int res=list[0];
        for(int i=0;i<op.length;i++){
            switch(op[i]){
            case '+':
                res+=list[i+1];
                break;
            case '-':
                res -= list[i + 1];
                break;
            case '*':
                res *= list[i + 1];
                break;
            case '/':
                res /= list[i + 1];
                break;
            }
        }
        return res;
    }

    public void solve(int[] nums,int res){

    }
}
