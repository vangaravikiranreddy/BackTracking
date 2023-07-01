import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class PerfectSquarePermutation
{
    static ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
    public static void permutation(TreeMap<Integer,Integer> t,int N,int[] al,int index)
    {
        if(index==N)
        {
            ans.add(new ArrayList<Integer>());
            for(int i=0;i<al.length;i++)
            {
                ans.get(ans.size()-1).add(al[i]);
            }
            return;
        }
        for(int i:t.keySet())
        {
            if(t.get(i)>0)
            {
                t.put(i,t.get(i)-1);
                al[index]=i;
                permutation(t,N,al,index+1);
                t.put(i,t.get(i)+1);
            }
        }
    }
    public static boolean Validate(ArrayList<Integer> A)
    {
        int count=0;
        for(int i=1;i<A.size();i++)
        {
            int value=A.get(i-1)+A.get(i);
            for(int j=1;j*j<=value;j++)
            {
                if(j*j==value)
                {
                    count++;
                }
            }
        }
        return (count==A.size()-1) ? true : false;
    }
    public static int solve(ArrayList<Integer> A)
    {
        //int F[]=new int[11];
        TreeMap<Integer,Integer> t=new TreeMap<Integer,Integer>();
        int N=A.size();
        int al[]=new int[N];
        for(int i=0;i<N;i++)
        {
            t.put(A.get(i),t.getOrDefault(A.get(i),0)+1);
            // F[A.get(i)]++;
        }
        int index=0;
        permutation(t,N,al,index);
        int count=0;
        for(int i=0;i<ans.size();i++)
        {
            count+=(Validate(ans.get(i)) ? 1 : 0);
        }
        return count;
        //return ans;
    }
    public static void main(String args[])
    {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(783000521, 766639918, 195102639, 230793946, 757604720, 77842679, 674858911, 496636809, 855231289));
        int ans=solve(A);
        System.out.println(ans);
    }
}
