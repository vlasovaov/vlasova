/**
 * Created by Admin on 22.09.2014.
 */
public class table
{
    private int size;
    private boolean list[][];


    public table()
    {
        size = 1;
        list = new boolean[1][1];
        list[0][0] = false;
    }

    public table(int _size)
    {
        size = _size;
        list = new boolean[size][size];
        for (int i = 0; i < _size; i++)
            for (int j = 0; j < _size; j++)
                list[i][j]=false;
    }

    public table(int _size, boolean ar[][])
    {
        size = _size;
        list = new boolean[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                list[i][j] = ar[i][j];
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public void setTable(boolean ar[][])
    {
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; j++)
                list[i][j]=ar[i][j];
    }

    public void setZnach(int k, int l, boolean f)
    {
        list[k][l] = f;
    }

    public int getSize()
    {
        return size;
    }

    public boolean[][] getTable()
    {
        boolean ar[][] = new boolean[size][size];
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; j++)
                ar[i][j]=list[i][j];
        return ar;
    }

    public boolean getOne(int k, int l)
    {
        return list[k][l];
    }

    public boolean getNeighbour(int k, int l, int i)
    {
        switch (i)
        {
            case 1:  return list[(size + k - 1) % size][(size + l - 1) % size];
            case 2:  return list[(size + k) % size][(size + l - 1) % size];
            case 3:  return list[(size + k + 1) % size][(size + l - 1) % size];
            case 4:  return list[(size + k -1) % size][(size + l) % size];
            case 5:  return list[(size + k+  1) % size][(size + l) % size];
            case 6:  return list[(size + k - 1) % size][(size + l + 1) % size];
            case 7:  return list[(size + k) % size][(size + l + 1) % size];
            case 8:  return list[(size + k + 1) % size][(size + l + 1) % size];
            default: return false;
        }

    }
}
