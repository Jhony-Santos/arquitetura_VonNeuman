import java.util.Scanner;

public class Main {


    public static void main(String[]args) throws Exception {

        IO es = new IO(System.out);
        Ram ram=new Ram(7);
        Cpu cpu= new Cpu(ram,es);


        ram.write(0,120); // a

        ram.write(1,127); // b

        cpu.Run(0);

    }

}
