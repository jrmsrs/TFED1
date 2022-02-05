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
        for (int i = 0; i < this.lin; i++) 
        for (int j = 0; j < this.col; j++) 
            if (matriz[i][j] == buscaDado) 
                return true;
        return false;
    }

    //4. Impressão da matriz;
    public void imprime() {
        for (int i = 0; i < this.lin; i++) {
            System.out.println();
            for (int j = 0; j < this.col; j++)
                System.out.print("  " + matriz[i][j] + "  ");
            System.out.println();
        }
        System.out.println();
    }

    //5. Representar uma matriz vazia;
    public MatrizEstatica(int l, int c) {
        this.matriz = new int[l][c];
        this.lin = l;
        this.col = c;
        for (int i = 0; i < lin; i++) 
        for (int j = 0; j < col; j++) 
            this.matriz[i][j] = 0;
    }

    //6. Verificar se é uma matriz vazia;
    public boolean isVazia() {
        if (matriz == null) return true;
        for (int i = 0; i < lin; i++) 
        for (int j = 0; j < col; j++) 
            if (matriz[i][j] != 0) 
                return false;
        return true;
    }

    //7. Verificar se é uma matriz diagonal (só tem elementos na diagonal principal);
    public boolean isDiagonal() {
        if (this.isVazia()) return false;

        //varre a matriz
        for (int i = 0; i < this.lin; i++) {
            for (int j = 0; j < this.col; j++) {
                if (i != j && matriz[i][j] != 0) {
                    //se encontrar algum valor quando i != j, ou seja, fora da diagonal principal
                    return false;
                }
            }
        }
        //caso contrario:
        return true;
    }

    //8. Verificar se é uma matriz linha (só tem elementos em uma única linha);
    public boolean isLinha() {
        if (this.isVazia()) return false;
        //se nao esta vazia pelo menos uma linha ja contem elemento(s)
        if (this.lin == 1) return true;
        //nao precisa percorrer em O(n*m) a matriz se ela tiver apenas uma linha

        int contador = 0;

        for (int i = 0; i < this.lin; i++)
        for (int j = 0; j < this.col; j++) 
            if (matriz[i][j] != 0) {
                contador++;
                if (contador>1) return false;
                break; //pula pra proxima linha
            }
        
        return true;
    }

    //9. Verificar se é uma matriz coluna (só tem elementos em uma única coluna);
    public boolean isColuna() {
        if (this.isVazia()) return false;
        if (this.col == 1) return true;

        int contador = 0;

        for (int i = 0; i < this.lin; i++)
        for (int j = 0; j < this.col; j++) 
            if (matriz[j][i] != 0) {
                contador++;
                if (contador>1) return false;
                break; 
            }
        
        return true;
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
