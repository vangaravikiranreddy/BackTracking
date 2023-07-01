import java.nio.charset.StandardCharsets;
import java.util.*;

class Combination
{
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
   // HashMap<Integer,Integer> index=new HashMap<>();
    public void findCombination(ArrayList<Integer> A,int B,int sum,ArrayList<Integer> al,int index)
    {
        if(B==sum)
        {
           ArrayList<Integer> temp=new ArrayList<>(al);
           ans.add(temp);
           return;
        }
        if(sum>B)
        {
            return;
        }
        for(int i=index+1;i<A.size();i++)
        {
            al.add(A.get(i));
            findCombination(A,B,sum+A.get(i),al,i);
            al.remove(al.size()-1);
        }
    }
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        Collections.sort(A);
        int sum=0;
        ArrayList<Integer> al=new ArrayList<Integer>();
        int index=-1;
        findCombination(A,B,sum,al,index);
        return ans;
    }
}
public class CombinationSum
{
    public static void main(String args[])
    {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
        Combination c=new Combination();
        ArrayList<ArrayList<Integer>> ans=c.combinationSum(A,8);
        System.out.println(ans);

    }
}