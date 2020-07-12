/**
 * https://leetcode-cn.com/problems/complex-number-multiplication/
 */
public class ComplexNumberMultiply {
    public String complexNumberMultiply(String a, String b) {
        if (a.equals("0+0i") || b.equals("0+0i")) return "0+0i";
        StringBuilder op = new StringBuilder();
        String[] aStr = a.split("\\+");
        String[] bStr = b.split("\\+");
        // a = "1+2i", b = "3+4i"
        // aa = 1 ab = 2i ba = 3 bb = 4i
        String aa = aStr[0];
        String ab = aStr[1];
        String ba = bStr[0];
        String bb = bStr[1];
        int first = Integer.parseInt(aa) * Integer.parseInt(ba); //首相乘首相
        int last = Integer.parseInt(ab.substring(0, ab.length() - 1)) * Integer.parseInt(bb.substring(0, bb.length() - 1));
        op.append(first - last);
        op.append("+");
        int midA = Integer.parseInt(ab.substring(0, ab.length() - 1)) * Integer.parseInt(ba);
        int midB = Integer.parseInt(bb.substring(0, bb.length() - 1)) * Integer.parseInt(aa);
        op.append(midA + midB);
        op.append("i");

        return op.toString();
    }
}
