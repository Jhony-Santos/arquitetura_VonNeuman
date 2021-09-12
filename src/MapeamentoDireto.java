


public class MapeamentoDireto {


        /*
        * Poste aqui o seu programa Java (arquivo .java) relativo à implementação dos cálculos para o mapeamento direto de cache.
            Parâmetros:
            K = 64
            capacidade da cache = 8K
            capacidade da RAM = 16M
            Entrada:
            x = endereço da RAM
            Saídas:
            endereços de início e fim do bloco da RAM contendo o endereço x;
            índice da cache line onde o bloco contendo o endereço x pode estar;
            número do bloco da RAM ("tag") quem contém o endereço x;
            posição de x na cache line.
            (para mais detalhes, consulte aula gravada e slides disponíveis no BlackBoard.)
        0   1   2   3   4   5   6   7   8   9   10
        1   2   4   8   16  32  64  128 256 512 1024
        * */
        public static void main(String[] args) {
            //Para saber o endereço precisamos saber os tamanhos dos W|R|T
            //Para tanto então temos que a quantidade de memória RAM = 16MB ou (2^4) * (2^10) * (2^10) ou 2^24
            //Portanto a quantidade de endereços de RAM é de 24 bits e portanto o máximo de bits de endereço
            int maxEndereco = 0b1000000000000000000000000;
            String maxEnderecoBinary = Integer.toBinaryString(maxEndereco);
            int maxEnderecoBits = maxEnderecoBinary.length()-1;
            System.out.println(
                    String.format(
                            "Valor Máximo de Endereços da RAM( Int : %s ) ( bits : %s ) ( binary : %s)",
                            maxEndereco,maxEnderecoBits,maxEnderecoBinary
                    )
            );
            //Fora o máximo de Endereços temos que calcular os valores máximos da cache.
            //Tempos 3 valores
            //Quantidade de Palavras na Cache = capacidade da cache
            int maxCache = 8192;
            String maxCacheBinary = Integer.toBinaryString(maxCache);
            int maxCacheBits = maxCacheBinary.length()-1;
            System.out.println(
                    String.format(
                            "Valor Máximo de Palavras da Memória Cache ( Int : %s ) ( bits : %s ) ( binary : %s)",
                            maxCache,maxCacheBits,maxCacheBinary
                    )
            );
            //colunas por Linha -> está ali em cima
            int maxColunaCache = 64;
            String maxColunaCacheBinary = Integer.toBinaryString(maxColunaCache);
            int maxColunaCacheBits = maxColunaCacheBinary.length()-1;
            System.out.println(
                    String.format(
                            "Valor Máximo de Colunas Por Linha na Memória Cache ( Int : %s ) ( bits : %s ) ( binary : %s)",
                            maxColunaCache,maxColunaCacheBits,maxColunaCacheBinary
                    )
            );
            //Quantidade de Linhas da Cache
            //Quantidade de Linhas -> para calcular as linhas tem que ser feito calculo de Tabela:
            //total de palavras / quantidade de colunas para ser obtido o maximo de linhas
            int maxLinhaCache = maxCache / maxColunaCache;
            String maxLinhaCacheBinary = Integer.toBinaryString(maxLinhaCache);
            int maxLinhaCacheBits = maxLinhaCacheBinary.length()-1;
            System.out.println(
                    String.format(
                            "Valor Máximo de Linhas na Memória Cache ( Int : %s ) ( bits : %s ) ( binary : %s)",
                            maxLinhaCache,maxLinhaCacheBits,maxLinhaCacheBinary
                    )
            );
            //Beleza!! Com os dados acima temos que calcular o endereço de uma memória:
            //Endereço para procurar :
            int enderecoRam = 165555;
            String enderecoRamBinary = Integer.toBinaryString(enderecoRam);
            int enderecoRamBits = enderecoRamBinary.length()-1;
            //endereços de início e fim do bloco da RAM contendo o endereço x;
            System.out.println(
                    String.format(
                            "Endereço da Ram ( Int : %s ) ( bits : %s ) ( binary : %s)",
                            enderecoRam,enderecoRamBits,enderecoRamBinary
                    )
            );
            //na mão::
            // Numero inteiro 000000101000011010110011
            //            | ID DA RAM   | linha   | coluna
            // binary     | 00000010100 | 0011010 | 110011
            // letras     | T           | R       | W
            // resto s    | S                     | W
            //resto do valor
            int idEnderecoRam = (enderecoRam & 0b111111111110000000000000) >> maxColunaCacheBits+maxLinhaCacheBits;
            String idEnderecoRamBinary = Integer.toBinaryString(idEnderecoRam);
            int idEnderecoRamBits = idEnderecoRamBinary.length()-1;
            System.out.println(
                    String.format(
                            "Restante do Endereço da Ram ( Int : %s ) ( bits : %s ) ( binary : %s)",
                            idEnderecoRam,idEnderecoRamBits,idEnderecoRamBinary
                    )
            );
            //ID da Linha do Cache -> 6 primeiros valores da linha de cache
            int enderecoLinhaCache = (enderecoRam & 0b1111111000000) >> maxColunaCacheBits;
            String enderecoLinhaCacheBinary = Integer.toBinaryString(enderecoLinhaCache);
            int enderecoLinhaCacheBits = idEnderecoRamBinary.length()-1;
            System.out.println(
                    String.format(
                            "Endereço Linha de Cache ( Int : %s ) ( bits : %s ) ( binary : %s)",
                            enderecoLinhaCache,enderecoLinhaCacheBits,enderecoLinhaCacheBinary
                    )
            );
            //ID da Coluna na Linha do Cache
            int enderecoColunaCache = enderecoRam & 0b111111;
            String enderecoColunaCacheBinary = Integer.toBinaryString(enderecoColunaCache);
            int enderecoColunaCacheBits = idEnderecoRamBinary.length()-1;
            System.out.println(
                    String.format(
                            "Endereço da Coluna na linha de Cache ( Int : %s ) ( bits : %s ) ( binary : %s)",
                            enderecoColunaCache,enderecoColunaCacheBits,enderecoColunaCacheBinary
                    )
            );
        }
}






