
/*
Possui um "contador de programa" (PC) e conexoes com RAM e IO. Para executar um programa em um dado endereco ender (metodo Run),
atualiza o valor de PC para o endereco fornecido, lê os valores a e b nos enderecos PC e PC + 1, respectivamente, e escreve os
numeros de 1 ate b -a + 1 nos enderecos de a ate b, enviando-os para o IO conectado
*/


public class Cpu {

    int pc = 0;
    Ram ram;

    IO es;

    public Cpu(Ram ram, IO es) {
        this.ram=ram;
        this.es=es;
    }

    public void Run(int ender) throws Exception {
         pc=ender;
         int registerA=ram.read(pc++); //120
         int registerB=ram.read(pc++); //127

         for(int i=registerA;i<=registerB;++i){


            ram.write(i,i-registerA+1);

            es.Output(i + " " + (i-registerA+1) );

         }

    }

}
