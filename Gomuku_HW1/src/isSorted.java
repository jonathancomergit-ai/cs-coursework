public class isSorted
{
    //main loop
    public static void main(String[] args)
    {
        int[] nums = {1, 5, 2};
        boolean result = isSorted(nums);
        System.out.println(result);
    }

    //method
    static boolean isSorted(int[] nums)
    {
        for (int i = 0; i < nums.length - 1; i++)
        {
            if (nums[i] > nums[i + 1])
            {
                return false;
            }
        }
        return true;
    }
}
