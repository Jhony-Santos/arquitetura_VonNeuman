import org.w3c.dom.css.CSSImportRule;

import java.util.ArrayList;


/*

initialAdress - com essa variavel eu consigo identificar se um enderço está na cache ou nao (cache hit/miss)
se chegar uma solicitação de leitura do endereco 7, vc precisa primeiro identificar se o endereço 7 está na cache ou não
 considerar leitura da primeira vez
 considerar proximas leituras
 */


            /*ram=[1,2,3,4,5,6,7,8,9,10]
            cache=[6,7,8]*/






public class Cache {

    Ram ram = new Ram(7);

    int[] memory_cache;



    int initialAdress;  // Ele representa qual a posição da ram, está representando na posição 0 da cache

    public Cache(int size_cache, Ram ram) {
        memory_cache = new int[size_cache];

    }

    public int read(int posicao) throws Exception {


        int position_zero_cache=memory_cache[0];


        if (posicao > memory_cache.length) { // cache miss
            throw new Exception("Endereço inválido");
        }

        else if (posicao <= memory_cache.length && posicao < initialAdress + memory_cache.length) {


                   initialAdress=ram.enderecos.length - posicao;
                   System.out.println(initialAdress);



              if (memory_cache == null) {
                  System.out.println("Temos a posição mas não tem nada");

            }



              for(initialAdress = 0; initialAdress == memory_cache.length; initialAdress++){
                memory_cache[initialAdress]=ram.enderecos[posicao];
                posicao+=1;
                initialAdress+=1;
            }
        }
        return memory_cache[posicao];
    }

        public void write ( int posicao, int valor) throws Exception {

            if (posicao > memory_cache.length) {
                throw new Exception("Endereço inválido");
            }
            memory_cache[posicao] = valor;

        }



}