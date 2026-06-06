class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        int[] aux = Arrays.copyOf(nums, nums.length);

        Arrays.sort(aux);

        while (left < right) {
            if (left != right) {
                sum = aux[left] + aux[right];
                if (sum == target) {
                    int i = -1, j = -1;
                    for (int x = 0; x < nums.length; x++) {
                        if (i == -1 && j != x && nums[x] == aux[left]) {
                            i = x;
                        }
                        if (j == -1 && i != x && nums[x] == aux[right]) {
                            j = x;
                        }
                    }
                    return new int[] { Math.min(i, j), Math.max(i, j) };
                } else if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                }
            }
        }

        return new int[] {};
    }
}
