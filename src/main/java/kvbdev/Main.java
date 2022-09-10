package kvbdev;

public class Main {

    public static void main(String[] args) {
        BinOps bins = new BinOps();

        System.out.println(bins.sum("11110000", "00001111"));   // 240 + 25 = 255
        System.out.println(bins.sum("10101010", "01010101"));   // 170 + 85 = 255

        System.out.println(bins.mult("00001001", "00011100"));  // 9 * 28 = 252
        System.out.println(bins.mult("00000111", "00100001"));  // 7 * 33 = 231

        try{
            System.out.println(bins.sum("12", "13"));
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }

        try{
            System.out.println(bins.sum("one", "two"));
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }

        try{
            System.out.println(bins.mult(null, null));
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }

        try{
            System.out.println(bins.mult("", ""));
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }

    }

}
