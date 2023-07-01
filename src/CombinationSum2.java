import java.util.ArrayList;
import java.util.Arrays;

class Solution
{
    ArrayList<ArrayList<Integer>> finalAns=new ArrayList<>();
    public void checkCombination(int index,int[] freq,ArrayList<Integer> ans,int sum,int B)
    {
       if(sum==B)
       {
           finalAns.add(new ArrayList<>(ans));
           return;
       }
       if(sum>B)
       {
           return;
       }
       for(int i=(index==-1)?0:index;i<21;i++)
       {
           if(freq[i]>0)
           {
               freq[i]--;
               ans.add(i);
               checkCombination(i,freq,ans,sum+i,B);
               freq[i]++;
               ans.remove(ans.size()-1);
           }
       }
    }
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        int freq[]=new int[21];
        int N=A.size();
        for(int i=0;i<N;i++)
        {
            freq[A.get(i)]++;
        }
        checkCombination(-1,freq,ans,0,B);
        return finalAns;
    }
}
public class CombinationSum2
{
    public static void main(String args[])
    {
        Solution s=new Solution();
       ArrayList<ArrayList<Integer>> ans=s.combinationSum(new ArrayList<>(Arrays.asList(4,5,6)),3);
       System.out.println(ans);
    }
}
