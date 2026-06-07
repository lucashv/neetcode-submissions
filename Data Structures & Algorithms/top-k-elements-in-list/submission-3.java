class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new TreeMap<>();

        for (int n : nums) {
            counter.putIfAbsent(n, 0);
            counter.put(n, counter.get(n) + 1);
        }

        List<Integer> list = new ArrayList<>(counter.values());
        list.sort(Comparator.reverseOrder());

        List<Integer> retList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (Integer i : list) {
            for (Integer key : counter.keySet()) {
                if (counter.get(key) == i && !visited.contains(key)) {
                    retList.add(key);
                    visited.add(key);
                }
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < ret.length; i++)
            ret[i] = retList.get(i);

        return ret;
    }
}
