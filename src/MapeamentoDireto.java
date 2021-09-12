

class Initialize {
    public static void main(String[] args) {
        int x = 10560325;
        int K = 64;
        int CAPACIDADE_TOTAL_CACHE = 8000;
        int CAPACIDADE_TOTAL_MEMORIA_PRINCIPAL = 160000000;


        int K_BITS_LENGTH = (int) Math.ceil(Math.log(K) / Math.log(2));
        int CAPACIDADE_TOTAL_CACHE_BITS_LENGTH = (int) Math.ceil(Math.log(CAPACIDADE_TOTAL_CACHE) / Math.log(2));
        int CAPACIDADE_TOTAL_MEMORIA_PRINCIPAL_BITS_LENGTH = (int) Math.ceil(Math.log(CAPACIDADE_TOTAL_MEMORIA_PRINCIPAL) / Math.log(2));



        int w_mask = getMask(K_BITS_LENGTH) >> 1;
        int w = x & w_mask;
        System.out.println("w: " + Integer.toBinaryString(w));



        int r_mask = getMask(CAPACIDADE_TOTAL_CACHE_BITS_LENGTH-K_BITS_LENGTH);
        int r = x & (r_mask << K_BITS_LENGTH);
        System.out.println("r: " + Integer.toBinaryString(r));


        int t_mask = getMask(CAPACIDADE_TOTAL_MEMORIA_PRINCIPAL_BITS_LENGTH - (CAPACIDADE_TOTAL_CACHE_BITS_LENGTH + K_BITS_LENGTH));
        int t = x & (t_mask << (CAPACIDADE_TOTAL_CACHE_BITS_LENGTH + K_BITS_LENGTH));
        System.out.println("t: " + Integer.toBinaryString(t));
    }

    static int getMask(int item_length) {
        int mask = 0b1;
        for(int i = 1; i <= item_length; i++) {
            if(i==0) mask = mask >> 1;
            else {
                mask = mask | 0b1;
                mask = mask << 1;
            }
        }
        mask = mask >> 1;
        return mask;
    }
}








public class MapeamentoDireto {





}
