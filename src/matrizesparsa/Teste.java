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

        //1.1 testar classe matriz estatica
        MatrizEstatica matriz = new MatrizEstatica(m);

        matriz.insere(1, 1, 5);
        matriz.remove(0, 4);
        matriz.imprime();
        //verifica se e linha coluna diagonal etc etc etc

        //1.2 obter tempo de execucao

        //1.1 testar classe matriz dinamica

        //1.2 obter tempo de execucao
        
    }
}

//.......