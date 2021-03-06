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

        public String toString() { 
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

        if (newDado==0) {
            remove(newLin, newCol);
            return;
        }

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
    public boolean remove(int removeLin, int removeCol){
        //realiza o metodo de busca (privada) ate encontrar o elemento
        Elo elo = buscaPriv(removeLin, removeCol);
        //se nao encontrou
        if (elo == null) return false;
        //se encontrou remove
        primArray[removeLin] = primArray[removeLin].prox; 
        return true;
    }

    //3. Busca por um elemento espec??fico;
    public int busca(int lin, int col){
        if (lin>this.lin-1 || col>this.col-1) return -1;
        Elo elo;
        //apenas anda com o cursor at?? achar (ou n??o) a coluna
        for(elo = primArray[lin]; ((elo!=null)&&(elo.col!=col)); elo = elo.prox){}
        //se nao encontrou
        if (elo == null) return 0;
        //se encontrou
        return elo.dado;
    }
    //3.1. Busca auxiliar
    private Elo buscaPriv(int lin, int col){
        if (lin>this.lin || col>this.col) return null;
        Elo elo;
        //apenas anda com o cursor at?? achar (ou n??o) a coluna
        for(elo = primArray[lin]; ((elo!=null)&&(elo.col!=col)); elo = elo.prox){}
        //se nao encontrou
        if (elo == null) return null;
        //se encontrou
        return elo;
    }

    //4. Impress??o da matriz;
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

    //6. Verificar se ?? uma matriz vazia;
    public boolean isVazia(){
        if (primArray==null) return true;
        for (int i = 0; i < primArray.length; i++) {
            if (primArray[i] != null) return false;
        }
        return true;
    }

    //7. Verificar se ?? uma matriz diagonal (s?? tem elementos na diagonal principal);
    public boolean isDiagonal(){
        if (isVazia()) return false;

        //percorre a matriz
        for (int i = 0; i < this.lin; i++) 
        for (int j = 0; j < this.col; j++) {
            if (i!=j) if (buscaPriv(i, j) != null) 
            //se encontrar algum valor quando i != j, ou seja, fora da diagonal principal
                return false;
        }
        //caso contr??rio
        return true;
    }

    //8. Verificar se ?? uma matriz linha (s?? tem elementos em uma ??nica linha);
    public boolean isLinha(){
        if (isVazia()) return false;
        if (this.lin==1) return true;

        int contador=0;

        //so precisa saber se tem referencias nao nulas em mais de uma linha
        for (int i = 0; i < primArray.length; i++) 
            if (primArray[i]!=null)
                if (++contador>1) 
                    return false;

        return true;
    }

    //9. Verificar se ?? uma matriz coluna (s?? tem elementos em uma ??nica coluna);
    public boolean isColuna(){
        if (isVazia()) return false;
        if (this.col==1) return true;

        int contador=0;

        //precisara verificar pra cada posicao
        for (int i = 0; i < this.col; i++) 
        for (int j = 0; j < this.lin; j++) {
            if (buscaPriv(j,i)!=null){
                if (++contador>1) return false;
                break;
            }
        }

        return true;
    }
    
    //10. Verificar se ?? uma matriz triangular inferior (s?? tem elementos da diagonal principal para baixo);
    public boolean isTriangularInf(){
        return false;
    }
    
    //11. Verificar se ?? uma matriz triangular superior (s?? tem elementos da diagonal principal para cima);
    public boolean isTriangularSup(){
        return false;
    }
    
    //12. Verificar se a matriz ?? sim??trica; (A[i,j] = A[j,i] para todo i, j);
    public boolean isSimetrica() {
        for (int i = 0; i < this.lin; i++) 
        for (int j = 0; j < this.col; j++) 
            if (busca(i,j) != busca(i,j)) return false;
        
        return true;
    }
    
    //13. Somar duas matrizes esparsas;
    
    //14. Multiplicar duas matrizes esparsas; e
    
    //15. Obter a matriz transposta.
    public MatrizDinamica transpor() {

        MatrizDinamica m = new MatrizDinamica(lin,col);

        if (this.lin != this.col) 
            return null;

        for (int i = 0; i < this.lin; i++) 
        for (int j = 0; j < this.col; j++) {
            int ij = busca(i,j);
            int ji = busca(j,i);
            if (i > j){
                m.insere(j, i, ij);
                m.insere(i, j, ji);
            }else{ 
                m.insere(i, j, ij);
            }
        }
        return m;
    }

    //metodo estatico pra gerar matriz aleatoria com exatos (ou o mais aproximado de) x% de zeros
    public static MatrizDinamica gerarMatrizAleatoria(int size, double esparsidade){ //esparsidade 0.6
        MatrizDinamica matriz = new MatrizDinamica(size,size); 
        long total = (long)size*size;
        //double qtdValores = total - (total * esparsidade);
        long qtdValores = (long)(total - (total * esparsidade));
        long atualValores=0;
        int lin,col,dado;

        while(atualValores<qtdValores){
            //sorteia linha e coluna entre 0 e size
            lin= (int) (  Math.floor( (int) (Math.random() * (size) ) ));
            col= (int) (  Math.floor( (int) (Math.random() * (size) ) ));
            //sorteia dado entre 1 e 9
            dado=(int) (1+Math.floor( (int) (Math.random() *    9   ) ));
            //se nao esta preenchido, preenche e aumenta atual valores
            if (matriz.busca(lin,col)==0){
                matriz.insere(lin, col, dado);
                atualValores++;
            }
        }
        
        return matriz;
    }

}
