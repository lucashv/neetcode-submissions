class Solution {
    // [2, 3, 4, 5]
    // 0 = 3x4x5 = 60
    // 1 = 2x4x5 = 40
    // 2 = 2x3x5 = 30
    // 3 = 2x3x4 = 24

    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        //int total = Integer.MAX_VALUE;

        for (int i = 0; i < ret.length; i++) {
            ret[i] = Integer.MAX_VALUE;
            //total = (total == Integer.MAX_VALUE ? 1 : total) * nums[i];
        }
            
        //System.out.println("Total = " + total);

        for (int i = 0; i < nums.length; i++) {
            //ret[i] = nums[i] == 0 ? 0 : total / nums[i];

            for (int y = 0; y < nums.length; y++) {
                if (y != i) {
                    ret[i] = (ret[i] == Integer.MAX_VALUE ? 1 : ret[i]) * nums[y];
                }
            }
        }

        return ret;
    }
}  
