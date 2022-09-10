package kvbdev;

public class BinOps {
    public String sum(String a, String b) {
        int aInt = Integer.parseInt(a, 2);
        int bInt = Integer.parseInt(b, 2);
        int result = aInt + bInt;
        return Integer.toBinaryString(result);
    }

    public String mult(String a, String b) {
        int aInt = Integer.parseInt(a, 2);
        int bInt = Integer.parseInt(b, 2);
        int result = aInt * bInt;
        return Integer.toBinaryString(result);
    }
}