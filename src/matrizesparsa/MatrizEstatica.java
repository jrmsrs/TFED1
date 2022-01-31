package matrizesparsa;

public class MatrizEstatica {

    public int[][] matriz;
    public int lin;
    public int col;

    public MatrizEstatica(int[][] matriz) {
        this.matriz = matriz;
        this.lin = matriz[0].length;
        this.col = matriz.length;
    }
    
    //1. Inserir um elemento;
    public void insere(int insereLin, int insereCol, int insereDado) {
        matriz[insereLin][insereCol] = insereDado;
    }
    
    //2. Remover um elemento;
    public void remove(int removeLin, int removeCol) {
        matriz[removeLin][removeCol] = 0;
    }
    
    //3. Busca por um elemento específico;
    public boolean busca(int buscaDado) {
        return false;
    }
    
    //4. Impressão da matriz;
    public void imprime() {
    }

    //5. Representar uma matriz vazia;
    public MatrizEstatica(int l, int c) {
        //preenche tudo com 0
    }
    
    //6. Verificar se é uma matriz vazia;
    public boolean isVazia() {
        return false;
    }

    //7. Verificar se é uma matriz diagonal (só tem elementos na diagonal principal);
    public boolean isDiagonal() {
        return false;
    }

    //8. Verificar se é uma matriz linha (só tem elementos em uma única linha);
    public boolean isLinha() {
        return false;
    }

    //9. Verificar se é uma matriz coluna (só tem elementos em uma única coluna);
    public boolean isColuna() {
        return false;
    }

    //10. Verificar se é uma matriz triangular inferior (só tem elementos da diagonal principal para baixo);
    public boolean isTriangularInf() {
        return false;
    }

    //11. Verificar se é uma matriz triangular superior (só tem elementos da diagonal principal para cima);
    public boolean isTriangularSup() {
        return false;
    }

    //12. Verificar se a matriz é simétrica; (A[i,j] = A[j,i] para todo i, j);
    public boolean isSimetrica() {
        return false;
    }

    //13. Somar duas matrizes esparsas;
    public static MatrizEstatica somar() {
        return null;
    }

    //14. Multiplicar duas matrizes esparsas; e
    public static MatrizEstatica multiplicar() {
        return null;
    }

    //15. Obter a matriz transposta.
    public static MatrizEstatica transpor() {
        return null;
    }

}
