import java.util.ArrayList;
import java.util.Arrays;

class Solution2
{
    int finalCount=0;
    public void checkRoutes(int i,int j,int cnt,int countVisited,int [][]A)
    {
        if(i<0 || j<0 || i>A.length-1 || j>A[0].length-1)
        {
            return;
        }
        if(A[i][j]==-1)
        {
            return;
        }
        if(A[i][j]==2)
        {
            if(cnt==countVisited)
            {
                finalCount++;
            }
            return;
        }
        A[i][j]=-1;
        checkRoutes(i,j+1,cnt,countVisited+1,A);
        checkRoutes(i+1,j,cnt,countVisited+1,A);
        checkRoutes(i,j-1,cnt,countVisited+1,A);
        checkRoutes(i-1,j,cnt,countVisited+1,A);
        A[i][j]=0;
    }
    public int solve(int[][] A)
    {
        int cnt=0,u=-1,v=-1;
        int N=A.length;
        int M=A[0].length;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(A[i][j]==1)
                {
                    u=i;
                    v=j;
                }
                else if(A[i][j]==0)
                {
                    cnt++;
                }
            }
        }
        int countVisited=0;
        checkRoutes(u,v,cnt+1,countVisited,A);
        return finalCount;
    }
}
public class UniquePath
{
    public static void main(String args[])
    {
        Solution2 s=new Solution2();
      //  ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        int A[][]=new int[3][];
        A[0]=new int[]{1,0,0,0};
        A[1]=new int[]{0,0,0,0};
        A[2]=new int[]{0,0,2,-1};
        //s.solve(A);
        System.out.println(s.solve(A));
    }
}
