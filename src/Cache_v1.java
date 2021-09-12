import org.w3c.dom.css.CSSImportRule;

import java.util.ArrayList;


//initialAdress = ram.enderecos.length - memory_cache.length;

            /*for(initialAdress = 0; initialAdress == memory_cache.length; initialAdress++){
                memory_cache[initialAdress]=ram.enderecos[posicao];
                posicao+=1;
                initialAdress+=1;
            }*/


/*

initialAdress - com essa variavel eu consigo identificar se um endereço está na cache ou nao (cache hit/miss)
se chegar uma solicitação de leitura do endereco 7, vc precisa primeiro identificar se o endereço 7 está na cache ou não
 considerar leitura da primeira vez
 considerar proximas leituras
 */

//cache miss -> copia do bloco

//acesso a ram solicitando todas as posicoes da ram que cabem na cache a partir da posicao
// nesse caso eu preciso alterar o valor de initialAdress -> initialAdress=posicao
            /*ram=[1,2,3,4,5,6,7,8,9,10]
            cache=[6,7,8]*/


public class Cache_v1 {

    Ram ram = new Ram(7);

    int[] memory_cache;
    int initialAdress=0;  // representa qual a posição da ram, está representando na posição 0 da cache
    private int capacidade=0;
    private int end_ram=-1;
    private boolean modif=false;
    private int[] blocoCopiado=null;


    public Cache_v1(int size_cache, Ram ram) {
        this.ram=ram;
        memory_cache = new int[size_cache];
        blocoCopiado=new int[size_cache];

    }

    public int read(int posicao) throws Exception {


        if (posicao > memory_cache.length) {
            throw new Exception("Endereço inválido");
        }

        else if (posicao >= initialAdress && posicao < initialAdress + memory_cache.length) { // cache hit
                return memory_cache[posicao-initialAdress];
        }
        else { // cache miss

            initialAdress=posicao;

            for(int i=0; i< memory_cache.length; i++){
                memory_cache[i]=ram.enderecos[posicao+i];

            }
            return memory_cache[posicao-initialAdress];

        }

    }

    private void Copia_Ram_Cache(int posicao) throws Exception {
        if(modif==true){
            for(int i=0; i<capacidade;i++){
                ram.write(end_ram+i,blocoCopiado[i]);
                modif=false;
            }

        }
    }


        public void write ( int posicao, int valor) throws Exception {

            if (posicao > memory_cache.length) {
                throw new Exception("Endereço inválido");
            }
            memory_cache[posicao] = valor;

        }

}