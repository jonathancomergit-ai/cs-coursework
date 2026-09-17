public class numStats
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 11, 2, 5, 6, 7, 8};
        int resultSum = sum(nums);
        int resultMax = max(nums);
        double resultAverage = average(nums);

        System.out.println("Max: " + resultMax);
        System.out.println("Sum: " + resultSum);
        System.out.println("Average: " + resultAverage);
    }

    static int sum(int[] nums)
    {
        int total = 0;

        for (int i = 0; i < nums.length; i++)
        {
            total = nums[i] + total;
        }
        return total;
    }

    static int max(int[] nums)
    {
        int best = nums[0];

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > best)
            {
                best = nums[i];
            }
        }
        return best;
    }

    static double average(int[] nums)
    {
        return (double) sum(nums) / nums.length;
    }
}
