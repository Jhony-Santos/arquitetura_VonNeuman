

public class Cache {

    private Ram ram = null;
    private int capacidade = 0;
    private int end_ram = -1;
    private boolean modif = false;
    private int [] bloco = null;

    public Cache(int tam, Ram prox) {
        ram = prox;
        capacidade = tam;
        bloco = new int [capacidade];
    }

    public int Read(int ender) throws Exception {

        int x=Integer.parseInt(Integer.toBinaryString(ender));
        int w=x & 0b111111;
        int r= x & (x & 0b1111111000000) >> 6;
        int t=(x & 0b1111111111100000000000) >>13;


        Valida(ender);
        VerificaCache(ender);
        return bloco[ender - end_ram];
    }

    private void Valida(int ender) {
    }

    public void Write(int ender, int w) throws Exception {
        Valida(ender);
        VerificaCache(ender);
        bloco[ender - end_ram] = w;
        modif = true;
    }

    private void VerificaCache(int ender) throws Exception {
        if (Hit(ender))
            System.out.println("Cache HIT: " + ender);
        else {
            System.err.println("Cache MISS: " + ender);
            TrazParaCache(ender);
        }
    }

    private boolean Hit(int ender) {
        if (end_ram > 0)
            return ((ender >= end_ram) && (ender < end_ram + capacidade));
        else
            return false;
    }

    private void TrazParaCache(int ender) throws Exception {

        if (modif) {

            for (int i=0; i<capacidade; ++i)
                ram.write(end_ram+i, bloco[i]);
            modif = false;
        }

        end_ram = ender;
        for (int a=ender; a<ender+capacidade && a < ram.Size(); ++a)
            bloco[a-ender] = ram.read(a);
    }


    class InvalidAddress extends Exception {
        private final int ender;
        public InvalidAddress(int e) {
            super();
            ender = e;
        }
        @Override
        public String toString() {
            return "Endereço " + ender + " inválido!";
        }
    }
}
