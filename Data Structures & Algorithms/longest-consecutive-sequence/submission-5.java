class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }        

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int counter = 0;
        int streak = 0;

        for (Integer n : set) {
            if (!set.contains(n - 1)) {
                int x = n;
                while (set.contains(x + 1)) {
                    streak++;
                    x = x + 1;
                }

                if (counter < streak) {
                    counter = streak;
                }

                streak = 0;
            }
        }

        return counter + 1;
    }
}
