class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();

        if (strs.length == 1) {
            List<String> single = new ArrayList<>();
            single.add(strs[0]);
            ret.add(single);
            return ret;
        }

        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String s : strs) {
            char[] sArr = s.toCharArray();
            
            Arrays.sort(sArr);
            String key = new String(sArr);

            if (anagramsMap.containsKey(key)) {
                anagramsMap.get(key).add(s);
            } else {
                List<String> first = new ArrayList<>();
                first.add(s);
                anagramsMap.put(key, first);
            }
        }

        for (String k : anagramsMap.keySet()) {
            ret.add(anagramsMap.get(k));
        }

        return ret;
    }
}
