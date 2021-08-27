import org.w3c.dom.css.CSSImportRule;

import java.util.ArrayList;



public class Cache {

    Ram ram = new Ram(7);

    int[] memory_cache;
    int initialAdress=0;

    public Cache(int size_cache, Ram ram) {
        memory_cache = new int[size_cache];

    }
    // considerar leitura da primeira vez
    // considerar proximas leituras
    public int read(int posicao) throws Exception {


        int stop=memory_cache.length;

        if (posicao > memory_cache.length) {
            throw new Exception("Endereço inválido");
        }

        else if (posicao < memory_cache.length) {

            int fim= memory_cache.length;

            for(int inicio=posicao; inicio < fim ;++inicio){

                  memory_cache[inicio]=ram.enderecos[inicio]; //memory_cache[inicio]=ram.read(inicio);
              }
        }
        else if(posicao < memory_cache.length){
            if(posicao>=initialAdress && posicao> memory_cache.length){}


            for(initialAdress = 0;initialAdress == stop; initialAdress++){
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