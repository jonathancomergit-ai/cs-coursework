public class longestRun
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 2, 3, 4, 4, 4, 4, 5, 6, 9};
        int result = longestRun(nums);
        System.out.println(result);
    }

    static int longestRun(int[] nums)
    {
        int best = 1;
        int current = 1;

        for (int i = 0; i < nums.length - 1; i++)
        {
            if (nums[i] == nums[i + 1])
            {
                current++;
                if (current > best)
                    best = current;
            } else
            {
                current = 1;
            }
        }
        return best;
    }
}
