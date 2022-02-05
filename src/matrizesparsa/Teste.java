package matrizesparsa;

public class Teste {

    //funcoes pra gerar as matrizes
    public static void main(String[] args) {
        int[][] m = {
            {0, 2, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 4, 3, 1},
            {5, 0, 0, 0, 0}
        };
        int[][] m1 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 4, 3, 1},
            {0, 0, 0, 0, 0}
        };
        int[][] m2 = {
            {0, 2, 0, 0, 0},
            {0, 3, 0, 0, 0},
            {0, 4, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0}
        };
        int[][] m3 = {
            {5, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 3, 0},
            {0, 0, 0, 0, 1}
        };

        //1.1 testar classe matriz estatica
        MatrizEstatica matriz = new MatrizEstatica(m3);

        matriz.imprime();
        //verifica se e linha coluna diagonal etc etc etc
        System.out.println("É Matriz Diagonal? " + matriz.isDiagonal());
        System.out.println("É Matriz Linha? "    + matriz.isLinha());
        System.out.println("É Matriz Coluna? "   + matriz.isColuna());

        //matriz.insere(1, 1, 5);
        //matriz.remove(0, 4);
        //matriz.imprime();

        //1.2 obter tempo de execucao

        //1.1 testar classe matriz dinamica

        //1.2 obter tempo de execucao
    }
}

//.......