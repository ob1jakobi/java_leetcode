package Easy;

public class GCDofStrings {

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        String result = str1.substring(0, gcd);
        return result;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        String a = "ABABAB";
        String b = "AB";

        String c = "CATCATCATCAT";
        String d = "TACTACTACTAC";

        String e = "LEET";
        String f = "CODE";

        String g = "FLEET";
        String h = "GREET";

        String i = "RACECAR";
        String j = "RACECAR";

        String r1 = gcdOfStrings(a, b);
        String r2 = gcdOfStrings(c, d);
        String r3 = gcdOfStrings(e, f);
        String r4 = gcdOfStrings(g, h);
        String r5 = gcdOfStrings(i, j);

    }
}
