
/*
Possui endereços de k e um vetor de números inteiros, alem de metodos para ler e escrever (Read/Write) valores em endereços
especificos.Deve checar se os endereços para escrita/leitura são válidos ou não.
 */



public class Ram {
    Ram ram;
    int[] enderecos;

    public Ram(int size){
        enderecos= new int[(int) Math.pow(2,size)];
    }



    public int read(int ender) throws Exception {

        if(ender > enderecos.length){
             throw new Exception("Endereço inválido");
        }
        return enderecos[ender];
    }

    public void write(int ender, int valor) throws Exception {

        if(ender > enderecos.length){
            throw new Exception("Endereço inválido");
        }
        enderecos[ender]=valor;

    }


    public int Size() {
        return ram.Size();
    }
}




