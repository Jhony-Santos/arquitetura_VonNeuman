
/*
Possui endereços de k e um vetor de números inteiros, alem de metodos para ler e escrever (Read/Write) valores em endereços
especificos.Deve checar se os endereços para escrita/leitura são válidos ou não.
 */



public class Ram {

    int[] enderecos;

    public Ram(int size){
        enderecos= new int[(int) Math.pow(2,size)];
    }



    public int read(int posicao) throws Exception {

        if(posicao > enderecos.length){
             throw new Exception("Endereço inválido");
        }
        return enderecos[posicao];
    }

    public void write(int posicao, int valor) throws Exception {

        if(posicao > enderecos.length){
            throw new Exception("Endereço inválido");
        }
        enderecos[posicao]=valor;

    }





}




