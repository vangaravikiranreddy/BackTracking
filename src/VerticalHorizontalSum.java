class Solution3
{
    public int rec(int opr,int [][]A,int allowed)
    {
        if(opr==-1)
        {
            return 0;
        }
        int ret=1;
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<A[0].length;j++)
            {
                int sum=0;
                for(int k=j;k<A[0].length;k++)
                {
                    sum+=A[i][k];
                    if(sum>allowed)
                    {
                        ret=0;
                        for(int l=j;j<=k;l++)
                        {
                            A[i][l]=-A[i][l];
                            ret|=rec(opr-1,A,allowed);
                            A[i][l]=-A[i][l];
                        }
                        return ret;
                    }
                }
            }
        }
        for(int j=0;j<A[0].length;j++)
        {
            for(int i=0;i<A.length;i++)
            {
                int sum=0;
                for(int k=i;k<A.length;k++)
                {
                    sum+=A[k][j];
                    if(sum>allowed)
                    {
                        ret=0;
                        for(int l=i;l<=k;l++)
                        {
                            A[l][j]=-A[l][j];
                            ret|=rec(opr-1,A,allowed);
                            A[l][j]=-A[l][j];
                        }
                        return ret;
                    }
                }
            }
        }
        return ret;
    }
    public int solve(int A, int[][] B, int C)
    {
        return rec(A,B,C);
    }
}

public class VerticalHorizontalSum
{
    public static void main(String args[])
    {
        Solution3 s=new Solution3();
        int A[][]=new int[4][];
        A[0]=new int[]{7};
        A[1]=new int[]{-4};
        A[2]=new int[]{-5};
        A[3]=new int[]{-6};
        s.solve(4,A,0);
    }
}
