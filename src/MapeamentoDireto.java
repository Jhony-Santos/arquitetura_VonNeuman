
class Initialize {
    public static void main(String[] args) {
        int x = 10560325;
        int K = 64;
        int CAPACIDADE_TOTAL_CACHE = 8000;
        int CAPACIDADE_TOTAL_MEMORIA_PRINCIPAL = 160000000; //8192


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

    int t=1;
    int t_linha=0;
    int r=12;
    int w=98;
    int tamanho_total_endereco;

    if(t==t_linha){ // CACHE HIT
        return w;
    }
    else if(t!=t_linha){ // CACHE MISS
        A CACHE JÁ FOI MODIFICADA?
                SIM:
                    atualiza valores na memoria principal
                    endereco da MP na qual essa cache line está armazenada(t_linha)
                    int t_mais_r=t+r;
                    int qtd_zeros=tamanho_total_endereco - t_mais_r;
                    int valor_total=t_mais_r + qtd_zeros;
                    int endereco_inicio=valor_total;

                    a partir de enderco_inicio copia-se  a cache_line inteira e joga para a Ram
                    em paralelo a ocorre a atualização da memória ram para a cache




    }


}
