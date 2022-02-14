package matrizesparsa;

public class TesteEstatica {

    public static void main(String[] args) {

        long tempoInicial, tempoFinal;
        
        int[][] m0 = {
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
        //int[][] mAleat = gerarMatrizAleatoria(6,.6);
        
        //1.1 testar classe matriz estatica
        MatrizEstatica matriz = new MatrizEstatica(6,6);

        //metodos de inserçao e remoçao
        System.out.println("\nTestando inserçao:");
        matriz.insere(0, 0, 5); matriz.insere(5, 5, 2);
        matriz.imprime();
        System.out.println("\nTestando remoção:");
        matriz.remove(0, 0); matriz.remove(5, 5);
        matriz.imprime();

        //para testar alguma matriz pré montada ou gerada acima (m0,m1,m2,m3,mGerada)
        System.out.println("Matriz selecionada:");
        matriz = MatrizEstatica.gerarMatrizEstaticaAleatoria(6,.6); //new MatrizEstatica(mAleat);
        matriz.imprime();
        //verifica se e linha coluna diagonal etc etc etc
        System.out.println("É Matriz Diagonal? " + matriz.isDiagonal());
        System.out.println("É Matriz Linha? "    + matriz.isLinha());
        System.out.println("É Matriz Coluna? "   + matriz.isColuna());
        System.out.println("É Matriz Triangular Sup? " + matriz.isTriangularSup());
        System.out.println("É Matriz Triangular Inf? " + matriz.isTriangularInf()+"\n");
        

        System.out.println("Transpondo matriz: ");
        MatrizEstatica transposta = matriz.transpor();
        transposta.imprime();

        System.out.println("Soma e multiplicaçao (respectivamente) entre matriz e transposta: ");
        MatrizEstatica soma = MatrizEstatica.somar(matriz, transposta);
        MatrizEstatica multi= MatrizEstatica.multiplicar(matriz, transposta);
        //soma.imprime();
        //multi.imprime();
        
    }
}

//.......