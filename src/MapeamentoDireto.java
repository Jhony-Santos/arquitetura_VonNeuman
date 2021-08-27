

public class MapeamentoDireto {

    public static void main(String[]args){

        int k = 64;

        int x = 10560325;

        int w = 10560325 & 0b11111111111;

        int r = 10560325 & 0b1111111;

        int t = 10560325 & 0b111111;

        System.out.println("Inicio: " + x);

        System.out.println("FIM: " + x + k);

        System.out.println("r: " + r);

        System.out.println("t: " + t);

        System.out.println("w: " + w);


    }


}
