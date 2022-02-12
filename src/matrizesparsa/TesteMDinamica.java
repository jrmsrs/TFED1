package matrizesparsa;

public class TesteMDinamica {



    public static void main(String[] args) {

        MatrizDinamica matriz = new MatrizDinamica(5,5);

        //formar um triangulo superior:
        //elementos na diagonal principal
        matriz.insere(0,0, 4); matriz.insere(1,1, 6); matriz.insere(2,2, 5);
        matriz.insere(3,3, 3); matriz.insere(4,4, 1);

        //elementos em uma coluna
        matriz.insere(0,4, 8); matriz.insere(1,4, 9); matriz.insere(2,4, 7);
        matriz.insere(3,4, 3);

        //elementos em uma linha
        matriz.insere(0,1, 1); matriz.insere(0,2, 6); matriz.insere(0,3, 2);

        matriz.imprime();
        
        /* ~realiza os métodos de verificação~
        
        System.out.println("É Matriz Diagonal? " + matriz.isDiagonal());
        System.out.println("É Matriz Linha? "    + matriz.isLinha());
        System.out.println("É Matriz Coluna? "   + matriz.isColuna());
        System.out.println("É Matriz Triangular Sup? " + matriz.isTriangularSup());
        System.out.println("É Matriz Triangular Inf? " + matriz.isTriangularInf()+"\n");

        */

        //para fazer triangulo inferior: bastaria transpor a matriz
        //MatrizDinamica matriz2 = matriz.transpor();
        //matriz2.imprime();

        //~realiza os métodos de verificação novamente~

        //~realiza metodos de soma e multiplicaçao entre: matriz e matriz2~
        //matriz.soma(matriz2);
        //matriz.multiplica(matriz2);
        
    }
}
