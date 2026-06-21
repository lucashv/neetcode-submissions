class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        int[] ret = new int[nums.length];

        pref[0] = 1;
        suff[suff.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            ret[i] = pref[i] * suff[i];
        }

        return ret;
    }
}  
