package matrizesparsa;

public class TesteMatrizes {

    public static void main(String[] args) {
        
        //testar classe matriz estatica
        MatrizEstatica mEstatica = new MatrizEstatica(6,6);
        //testar classe matriz dinamica
        MatrizDinamica mDinamica = new MatrizDinamica(6,6);
        

        //metodos de inserçao e remoçao 
        System.out.println("\nTestando inserçao (estatica):");
        mEstatica.insere(0, 0, 5); mEstatica.insere(5, 5, 2);
        mEstatica.imprime();
        System.out.println("\nTestando inserçao (dinamica):");
        mDinamica.insere(0, 0, 5); mDinamica.insere(5, 5, 2);
        mDinamica.imprime();

        /* para testar matriz dinamica

        System.out.println("Matriz diagonal? " + mDinamica.isDiagonal());
        System.out.println("Matriz linha? " + mDinamica.isLinha());
        System.out.println("Matriz coluna? " + mDinamica.isColuna());
        System.out.println("Matriz simetrica? " + mDinamica.isSimetrica());
        System.out.println("Matriz vazia? " + mDinamica.isVazia()+"\n");

        MatrizDinamica trans = mDinamica.transpor();
        trans.imprime();

        */

        System.out.println("\nTestando remoção (estatica):");
        mEstatica.remove(0, 0); mEstatica.remove(5, 5);
        mEstatica.imprime();
        System.out.println("\nTestando remoção (dinamica):");
        mDinamica.remove(0, 0); mDinamica.remove(5, 5);
        mDinamica.imprime();
        

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

        //para testar alguma matriz pré montada ou gerada acima (m0,m1,m2,m3)
        System.out.println("Matriz selecionada:");
        mEstatica = new MatrizEstatica(m0);
        mEstatica.imprime();
        //verifica se e linha coluna diagonal etc etc etc
        System.out.println("É Matriz Diagonal? " + mEstatica.isDiagonal());
        System.out.println("É Matriz Linha? "    + mEstatica.isLinha());
        System.out.println("É Matriz Coluna? "   + mEstatica.isColuna());
        System.out.println("É Matriz Triangular Sup? " + mEstatica.isTriangularSup());
        System.out.println("É Matriz Triangular Inf? " + mEstatica.isTriangularInf()+"\n");
        

        System.out.println("Transpondo matriz: ");
        MatrizEstatica transposta = mEstatica.transpor();
        transposta.imprime();

    }
}

//.......
