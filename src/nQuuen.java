import java.util.ArrayList;

class Queen
{
    ArrayList<ArrayList<String>> answer=new ArrayList<>();
    ArrayList<ArrayList<String>> ans=new ArrayList<>();
    public void nQueen(int row,int col[],int N)
    {
        if(row==N)
        {

            ArrayList<String> temp=new ArrayList<>();
            for(int i=0;i<ans.size();i++)
            {
                String st="";
                for(int j=0;j<ans.size();j++)
                {
                    st+=ans.get(i).get(j);
                }
                temp.add(st);
            }
            answer.add(temp);
            return;
        }
        for(int c=0;c<N;c++)
        {
            if(isValid(row,c,col))
            {
                col[row]=c;
                ans.get(row).set(c,"Q");
                nQueen(row+1,col,N);
                ans.get(row).set(c,".");
            }
        }
    }
    public boolean isValid(int r,int c,int col[])
    {
        for(int i=0;i<r;i++)
        {
            int j=col[i];
            if(!attack(i,j,r,c))
            {
                return false;
            }
        }
        return true;
    }
    public boolean attack(int x1,int y1,int x2,int y2)
    {
        if(x1==x2 || y1==y2)
        {
            return false;
        }
        if((x2-x1)==(y2-y1) || (x1+y1)==(x2+y2))
        {
            return false;
        }
        return true;
    }
    public ArrayList<ArrayList<String>> solveNQueens(int A)
    {
        for(int i=0;i<A;i++)
        {
            ans.add(new ArrayList<>());
            for(int j=0;j<A;j++)
            {
                ans.get(i).add(".");
            }
        }
        int col[]=new int[A];
        nQueen(0,col,A);

        return answer;
    }
}
public class nQuuen
{
    public static void main(String args[])
    {
       Queen q=new Queen();
       int N=1;

       ArrayList<ArrayList<String>> ans =q.solveNQueens(N);
       System.out.println(ans);
    }
}
