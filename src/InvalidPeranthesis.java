import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashSet;

class Solution4
{
    HashSet<String> hs=new HashSet<>();
    ArrayList<String> ans=new ArrayList<>();
    public void validate(String A,int ind,StringBuilder sb,int opR,int clR,int op)
    {
        if(ind==A.length())
        {
            if(op==0 && sb.length()>0 && !hs.contains(sb.toString()))
            {
                ans.add(sb.toString());
                hs.add(sb.toString());
            }
            return;
        }
        if(A.charAt(ind)=='(' && opR>0)
        {
           validate(A,ind+1,sb,opR-1,clR,op);
        }
        if(A.charAt(ind)==')' && clR>0)
        {
            validate(A,ind+1,sb,opR,clR-1,op);
        }
        if(A.charAt(ind)=='(')
        {
            sb.append('(');
            validate(A,ind+1,sb,opR,clR,op+1);
            sb.deleteCharAt(sb.length()-1);
        }
       if(A.charAt(ind)==')' && op>0)
        {
            sb.append(')');
            validate(A,ind+1,sb,opR,clR,op-1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(A.charAt(ind)!='(' && A.charAt(ind)!=')')
        {
            sb.append(A.charAt(ind));
            validate(A,ind+1,sb,opR,clR,op);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public ArrayList<String> solve(String A)
    {
        StringBuilder sb=new StringBuilder();
        int N=A.length();
        int op=0,cl=0;
        for(int i=0;i<N;i++)
        {
            if(A.charAt(i)=='(')
            {
                op++;
            }
            else if(A.charAt(i)==')')
            {
                if (op > 0)
                {
                    op--;
                    continue;
                }
                cl++;
            }
        }
        validate(A,0,sb,op,cl,0);
        if(ans.size()>0)
        {
            return ans;
        }
        ArrayList<String> a=new ArrayList<>();
        a.add(" ");
        return a;
    }
}
public class InvalidPeranthesis
{
    public static void main(String args[])
    {
        Solution4 s=new Solution4();
        ArrayList<String> ans=s.solve(")(");    //(a)())()
        System.out.println(ans);
    }
}
