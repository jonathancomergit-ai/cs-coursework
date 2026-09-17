public class AboveAverage
{
    public static void main(String[] args)
    {
        int[] nums = {4, 8, 6, 2, 10};
        int result = countAboveAverage(nums);
        System.out.println(result);

    }

    static int countAboveAverage(int[] nums)
    {
        int totalSum = 0;
        int finalCount = 0;

        for (int i = 0; i < nums.length; i++)
        {
            totalSum = totalSum + nums[i];
        }

        int average = (totalSum/nums.length);

        for (int i = 0; i < nums.length; i++)
        {
         if (nums[i] > average)
         {
             finalCount = finalCount + 1;
         }

    }
        return finalCount;
    }
}
