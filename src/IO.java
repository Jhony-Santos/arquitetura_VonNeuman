
//Recebe strings e as imprime na saída especificada no momento da instaciação do objeto (metodo Output)

import java.io.PrintStream;

public class IO {

    PrintStream out;


    public IO(PrintStream out){
        this.out=out;
    }

    public void Output(int s){
        out.println(s);

    }


    public void Output(String s) {
        out.println(s);
    }
}
