import java.util.ArrayList;



public class Cache {

    Ram ram=new Ram(7);

    int [] memory_cache;

    public Cache(int size_cache){
        memory_cache=new int[size_cache];
    }

    public int read(int posicao) throws Exception{

        if(posicao > memory_cache.length){
            throw new Exception("Endereço inválido");
        }
        else if(posicao < memory_cache.length){
            boolean update_data=false;

            int[]dadosCache=new int[7];
            int[] R=ram.enderecos.clone();
            // função para comparar dois arrays

           // verificar dadosCache
           // verificar dadosRam


            for(int i=0;i<memory_cache.length;++i){

            }









        }




        return memory_cache[posicao];

    }


    public void write(int posicao, int valor) throws Exception {

        if(posicao > memory_cache.length){
            throw new Exception("Endereço inválido");
        }
        memory_cache[posicao]=valor;

    }





   /* pegar requisição do processador
    verificar se já possui os dados solicitados
      memória cache inicia vazia
        -se possuir retorna eles
            -- possui mais os dados estão desatualizados
        - se não possuir faz uma copia


    dizer tamanho
    onde está a ram
    terá de ler o*/


}
