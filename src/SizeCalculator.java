import java.util.HashMap;

public class SizeCalculator {
    private static char[] sizeMultipliers = {'B', 'K', 'M', 'G', 'T'};
    private static HashMap<Character, Integer> char2multiplier = getMultipliers();


    public static String getHumanReadableSize (long size) {

        for (int i = 0; i < sizeMultipliers.length; i++) {

            double value = size / Math.pow(1024, i);
            if (value < 1024) {
                return Math.round(value) + "" + sizeMultipliers[i] +
                        (i > 0 ? "b" : "");
            }
        }
        return "Very big folder";
    }

    public static long getSizeFromHumanReadable (String size) {

        char sizeFactor = size
                .replaceAll("[0-9\\s+]", "")
                .charAt(0);
        int multiplier = char2multiplier.get(sizeFactor);
        long sizeInteger = Long.parseLong(size
                .replaceAll("[^0-9]", "")) * multiplier;
        return sizeInteger;
    }

    private static HashMap<Character, Integer> getMultipliers () {

        HashMap<Character, Integer> char2multiplier = new HashMap<>();
        for (int i = 0; i < sizeMultipliers.length; i++) {
            char2multiplier.put(sizeMultipliers[i], (int) Math.pow(1024, i));
        }
        return char2multiplier;
    }
}
