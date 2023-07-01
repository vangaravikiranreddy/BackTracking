import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

class C implements Comparator<ArrayList<Integer>>
{
    public int compare(ArrayList<Integer> a,ArrayList<Integer> b)
    {
        int N=a.size();
        int M=b.size();
        for(int i=0;i<Math.min(N,M);i++)
        {
           if (a.get(i)==b.get(i))
           {
               continue;
           }
           else
           {
               return a.get(i)-b.get(i);
           }
        }
        return 1;
    }
}
public class SubsetClass
{
    static ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    static HashMap<Integer,Integer> freq=new HashMap<>();
   /*public static void subset(int index,int N,ArrayList<Integer> A,ArrayList<Integer> al)
    {
       if(index==N)
       {
           //ans.add(new ArrayList<Integer>());
           ArrayList<Integer> temp=new ArrayList<Integer>(al);
           ans.add(temp);
           //al.clear();
           return;
       }
       subset(index+1,N,A,al);
       al.add(A.get(index));
       subset(index+1,N,A,al);
       al.remove(al.size()-1);
      // al.clear();
    }*/
  /*  public static void subset(int index,int N,int[] F,ArrayList<Integer> al)
    {
       if(index==N)
       {
           int sum=0;
           for(int i=0;i<al.size();i++)
           {
               sum+=al.get(i);
           }
           if(!hs.contains(sum))
           {
               ArrayList<Integer> temp=new ArrayList<>(al);
               ans.add(temp);
               hs.add(sum);
           }
           return;
       }
       for(int i=0;i<7;i++)
       {
           if(F[i]>0 && )
           {
               F[i]--;
               subset(index+1,N,F,al);
               al.add(i);
               subset(index+1,N,F,al);
               F[i]++;
               al.remove(al.size()-1);
           }
       }
    }*/
    public static void subset(int index,ArrayList<Integer> A,ArrayList<Integer> al)
    {
        if(index==A.size())
        {
            ArrayList<Integer> temp=new ArrayList<>(al);
            ans.add(temp);
            return;
        }
        for(int i=0;i<=freq.get(A.get(index));i++)
        {
            int j=0;
            for (;j<i;j++)
            {
                al.add(A.get(index));
            }
            subset(index+1,A,al);
            while(j-->0)
               al.remove(al.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        ArrayList<Integer> al=new ArrayList<>();
        ArrayList<Integer> uniqueList=new ArrayList<>();
        int index=0;
        int N=A.size();
        for(int i=0;i<N;i++)
        {
            if(freq.containsKey(A.get(i)))
            {
                freq.put(A.get(i),freq.get(A.get(i))+1);
            }
            else
            {
                freq.put(A.get(i),1);
                uniqueList.add(A.get(i));
            }
        }
        Collections.sort(uniqueList);
     /*   int F[]=new int[17];
        for(int i=0;i<N;i++)
        {
            F[A.get(i)]++;
        }*/
        subset(index,uniqueList,al);
        return ans;
    }
    public static void main(String args[])
    {
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(5,4));
        ArrayList<ArrayList<Integer>> ans=subsets(A);
        C c=new C();
        Collections.sort(ans,c);
        System.out.println(ans);

    }
}

//[] [4 ] [4 4 ] [4 4 5 ] [4 4 5 7 ] [4 4 7 ] [4 5 ] [4 5 7 ] [4 7 ] [5 ] [5 7 ] [7 ]