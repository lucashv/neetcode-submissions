class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer> group = new ArrayList<>();
                        group.add(nums[i]);
                        group.add(nums[j]);
                        group.add(nums[k]);
                        Collections.sort(group);
                        if (!ret.contains(group)) {
                            ret.add(group);
                        }
                    }
                }
            }
        }

        return ret;
    }
}
