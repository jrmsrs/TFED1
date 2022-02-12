package matrizesparsa;

public class Teste {

    //metodo pra gerar matriz aleatoria com exatos (ou aproximadamente) x% de zeros
    public static int[][] gerarMatrizEstaticaAleatoria(int size, double esparsidade){
        int[][] matriz = new int[size][size]; 
        long total = size*size;
        double qtdZeros = total * esparsidade;
        double qtdValores = total - qtdZeros;
        int atualZeros=0; 
        int atualValores=0; 

        for (int i = 0; i < size; i++) 
        for (int j = 0; j < size; j++) {
            double sorteia = Math.random();

            //sorteia os valores de acordo com a variavel esparsidade, que inicializa com parametro
            if (sorteia<esparsidade){
                matriz[i][j]=0;
                atualZeros++;
            }else{
                matriz[i][j] = (int) (1 + Math.floor( (int) (Math.random() * 9) ));
                atualValores++;
            }

            //a variavel esparsidade passa a ser 1 ou 0 quando alguma quantidade predefinida (qtdXXXX) 
            //tiver sido atingido, entao as proximas posicoes serao preenchidas com o que ainda faltar 
            if (atualValores>=qtdValores)
                esparsidade=1;
            if (atualZeros>=qtdZeros)
                esparsidade=0;
        }
        
        //System.out.println("Matriz gerada: "+ ((double)atualZeros/total)*100 + "% de zeros.");
        return matriz;
    } //adaptar esse metodo para funcionar para gerar matriz estatica e dinamica(?)

    public static void main(String[] args) {

        long tempoInicial, tempoFinal;
        
        int[][] m = {
            {0, 2, 0, 0, 0, 8},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 4, 3, 1, 0},
            {5, 0, 0, 0, 0, 0},
            {0, 6, 0, 0, 0, 7}
        };
        int[][] m1 = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 4, 3, 1, 5},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        };
        int[][] m2 = {
            {0, 2, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0},
            {0, 4, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 5, 0, 0, 0, 0}
        };
        int[][] m3 = {
            {5, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 3, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 2}
        };
        int[][] mGerada = gerarMatrizEstaticaAleatoria(6,.6);
        
        //1.1 testar classe matriz estatica
        MatrizEstatica matriz = new MatrizEstatica(m);

        matriz.imprime();
        //verifica se e linha coluna diagonal etc etc etc
        System.out.println("É Matriz Diagonal? " + matriz.isDiagonal());
        System.out.println("É Matriz Linha? "    + matriz.isLinha());
        System.out.println("É Matriz Coluna? "   + matriz.isColuna());
        System.out.println("É Matriz Triangular Sup? " + matriz.isTriangularSup());
        System.out.println("É Matriz Triangular Inf? " + matriz.isTriangularInf()+"\n");

        //metodos de inserçao e remoçao
        /*
        System.out.println("\nAtualizando matriz: ");
        matriz.insere(1, 1, 5);
        matriz.remove(0, 4);
        matriz.imprime();
        */

        System.out.println("Transpondo matriz: ");
        matriz = matriz.transpor();
        matriz.imprime();

        //teste extremo gerarMatrizEstaticaAleatoria()
        int tamanhoTeste = 10000;
        System.out.println("Gerando matriz tamanho " + tamanhoTeste + "x" + tamanhoTeste + " aleatoria...");

        tempoInicial = System.currentTimeMillis();
        gerarMatrizEstaticaAleatoria(tamanhoTeste,.6);
        tempoFinal = (System.currentTimeMillis() - tempoInicial);

        System.out.println("Tempo levado para gerar matriz: " + tempoFinal + " milisegundos.");
        
    }
}

//.......