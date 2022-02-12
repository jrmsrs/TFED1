package matrizesparsa;

public class MatrizDinamica {

    private Elo[] primArray;
    private int col, lin;

    protected static class Elo {
        public int dado, lin, col;
        public Elo prox;

        public Elo(int elem, int lin, int col){
            this.lin = lin;
            this.col = col;
            this.dado = elem;
        }

        public Elo(int elem, Elo proxElem, int lin, int col) {
            this.lin = lin;
            this.col = col;
            this.dado = elem;
            this.prox = proxElem;
        }

        public String toString() { //imprimir cada elemento como [1][4]=50
            return ""+dado;
        }
    }

    private MatrizDinamica(Elo[] primLin, int col) {
        this.primArray = primLin;
        this.col = col;
        this.lin = primLin.length;
    }

    //1. Inserir um elemento;
    public void insere(int newLin, int newCol, int newDado) {
        Elo elo = primArray[newLin];

        if (newLin > this.lin || newCol > this.col) return;
        
        if (elo == null) {
            primArray[newLin] = new Elo(newDado, newLin, newCol);
            return;
        }

        if (elo.col > newCol) {
            Elo novoElo = new Elo(newDado, elo, newLin, newCol);
            primArray[newCol] = novoElo;
            novoElo.prox = elo;
            return;
        }

        while (elo != null) {
            if (elo.prox != null && elo.prox.col < newCol) {
                elo = elo.prox; // segue varrendo a matriz/lista
            } else if (elo.prox != null && elo.prox.col == newCol) {
                elo.prox.dado = newDado;
                return;
            } else {
                //se next for maior insere
                elo.prox = new Elo(newDado, elo.prox, newLin, newCol);
                return;
            }
        }
    }

    //2. Remover um elemento;
    public void remove(int removeLin, int removeCol){
        return;
    }

    //3. Busca por um elemento específico;
    public Elo busca(int lin, int col){
        return null;
    }

    //4. Impressão da matriz;
    public void imprime() {
        for (int i = 0; i < this.lin; i++) {
            Elo p = primArray[i];
            System.out.println();
            System.out.print("["+i+"] ->\t");
            int cont = 0;
            
            while (p != null) {

                //imprime X tabs pra alinhar como tabela
                
                for (int j = cont; j < p.col; j++)
                    System.out.print("\t");
                cont = p.col;

                System.out.print(p + " -> ");

                p = p.prox;
            }
            
            System.out.println("\n");
        }
    }

    //5. Representar uma matriz vazia;
    public MatrizDinamica(int l, int c) {
        this.lin = l;
        this.col = c;
        primArray = new Elo[c];
    }

    //6. Verificar se é uma matriz vazia;
    public boolean isVazia(){
        return false;
    }

    //7. Verificar se é uma matriz diagonal (só tem elementos na diagonal principal);
    public boolean isDiagonal(){
        return false;
    }

    //8. Verificar se é uma matriz linha (só tem elementos em uma única linha);
    public boolean isLinha(){
        return false;
    }

    //9. Verificar se é uma matriz coluna (só tem elementos em uma única coluna);
    public boolean isColuna(){
        return false;
    }
    
    //10. Verificar se é uma matriz triangular inferior (só tem elementos da diagonal principal para baixo);
    public boolean isTriangularInf(){
        return false;
    }
    
    //11. Verificar se é uma matriz triangular superior (só tem elementos da diagonal principal para cima);
    public boolean isTriangularSup(){
        return false;
    }
    
    //12. Verificar se a matriz é simétrica; (A[i,j] = A[j,i] para todo i, j);
    public boolean isSimetrica(){
        return false;
    }
    
    //13. Somar duas matrizes esparsas;
    
    //14. Multiplicar duas matrizes esparsas; e
    
    //15. Obter a matriz transposta.

}
