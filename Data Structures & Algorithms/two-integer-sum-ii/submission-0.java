class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> saw = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (saw.containsKey(diff)) {
                return new int[] { saw.get(diff) + 1, i + 1 };
            }
            saw.put(numbers[i], i);
        }
        return new int[] {};
    }
}
