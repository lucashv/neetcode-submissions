class Solution {

    private static final Map<Character, String> base20Map;
    private static final Map<String, Character> base20MapToChar;
    private static final char[] base20 = new char[] { 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'
    };

    static {
        base20Map = new HashMap<>();
        base20MapToChar = new HashMap<>();

        for (int c = 0; c < 256; c++) {
            char thisChar = (char) c;
            String b20Code = convertToBase20(thisChar);
            // System.out.println(" c = " + (char) c + " = " + c + " -> " + b20Code);
            base20Map.put(thisChar, b20Code);
            base20MapToChar.put(b20Code, thisChar);
        }
    }

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return null;
        }

        StringBuilder encodedStringsSb = new StringBuilder();

        for (String str : strs) {
            if (str.length() == 0) {
                encodedStringsSb.append(".");
                continue;
            }
            
            StringBuilder encodedString = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                Character c = str.charAt(i);
                String b20CharNumber = base20Map.get(c);
                encodedString.append(b20CharNumber);
            }

            encodedStringsSb.append(encodedString.toString()).append(".");
        }
    
        String encodedStrings = encodedStringsSb.toString();
        encodedStrings = encodedStrings.substring(0, encodedStrings.lastIndexOf("."));
        
        // System.out.println("Encoded string = " + encodedStrings);
        
        return encodedStrings;
    }

    public List<String> decode(String str) {
        if (str == null) {
            return Collections.emptyList();
        }

        String[] encodedStrings = null;

        if (str.equals(".")) {
            encodedStrings = new String[] {"",""};
        } else if (str.endsWith(".")) {
            List<String> auxList = new ArrayList<>(Arrays.asList(str.split("\\.")));
            auxList.add("");
            encodedStrings = auxList.toArray(new String[]{});
        } else {
            encodedStrings = str.split("\\.");
        }

        List<String> decodedStrings = new ArrayList<>();

        for (String encodedString : encodedStrings) { 
            if (encodedString.length() == 0) {
                decodedStrings.add("");
                continue;
            }

            StringBuilder decodedStringSb = new StringBuilder();
            for (int i = 0; i < encodedString.length(); i += 2) {
                String b20Code = encodedString.substring(i, i + 2);
                decodedStringSb.append(base20MapToChar.get(b20Code));
            }

            decodedStrings.add(decodedStringSb.toString());
        }
        
        return decodedStrings;
    }

    private static String convertToBase20(Character c) {
        int charNum = (int) c;
        
        if (charNum < 20) {
            return String.valueOf(base20[charNum]);
        }

        List<Character> results = new ArrayList<>();
        int divvy = charNum;
        do {
            int rest =  divvy % 20;
            int result = (int) divvy / 20;
            
            results.add(base20[rest]);
            
            if (result < 20) {
                results.add(base20[result]);
            }

            divvy = result;
        } while (divvy >= 20);

        Collections.reverse(results);

        return results.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
