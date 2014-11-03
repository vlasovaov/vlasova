/**
 * Created by Admin on 22.09.2014.
 */

public class iteration
{
    private table model;

    public iteration ()
    {
        table model = new table();
    }

    public iteration (int size)
    {
        table model = new table(size);
    }

    public iteration (int size, boolean [][]ar)
    {
        model = new table(size, ar) ;
    }

    public void print()
    {
        for  (int i = 0; i < model.getSize(); i++)
        {
            for (int j = 0; j < model.getSize(); j++)
                if ( model.getOne(i,j)) System.out.print( "1 "); else System.out.print( "0 ");
            System.out.println("");
        }
    }

    public void Done()
    {
        table tmp = new table(model.getSize(),model.getTable());
        int n = tmp.getSize();
        for (int i = 0; i <= n-1; i++)
            for (int j = 0; j <= n-1; j++)
            {
                int k = 0;
                for (int l = 1; l <= 8; l++)
                    if (tmp.getNeighbour(i,j,l)) k++;
                if ( (k < 2) || (k > 3) ) model.setZnach(i,j,false);
                else if (k == 3) model.setZnach(i,j,true);
            }

    }
    public int size(){
        return model.getSize();
    }
    public boolean[][] getTable()
    {
        boolean ar[][] = new boolean[model.getSize()][model.getSize()];
        ar = model.getTable();
        return ar;
    }

}
