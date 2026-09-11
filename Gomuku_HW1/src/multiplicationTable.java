public class multiplicationTable
{
    public static void main(String[] args)
    {
        multiplicationTable();
    }

    static void multiplicationTable()
    {
        for (int row = 0; row <= 10 ; row++)
        {
            for (int col = 0; col <= 10 ; col++)
            {
                System.out.print(row * col + "  ");
            }
            System.out.println();
        }
    }
}
