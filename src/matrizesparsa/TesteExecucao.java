package matrizesparsa;

//Testar criacao de matrizes esparsas aleatorias (dinamicas e estaticas) de:
//10x10, 20x20, 30x30, 50x50, 100x100, 200x200, 500x500, 1000x1000, 
//10000x10000, 20000x20000, 50000x50000, 100000x100000

public class TesteExecucao {

    public static void main(String[] args) {

        //propriedades do teste:
        int tamanhoMatriz=100000;   //tamanhoMatriz X tamanhoMatriz
        int repetirVezes = 1;      
        boolean dinamica = true;   //true=estatica false=dinamica

        rodarTeste(tamanhoMatriz,repetirVezes,dinamica);

    }

    private static void rodarTeste(int tamanhoMatriz, int repetirVezes, boolean dinamica) {

        long tempoInicialEstatica, tempoFinalEstatica;
        long tempoInicialDinamica, tempoFinalDinamica;
        long consumoInicialEstatica, consumoFinalEstatica;
        long consumoInicialDinamica, consumoFinalDinamica;
        double tempoMedioEstatica, tempoMedioDinamica, consumoMedioEstatica, consumoMedioDinamica;
        tempoMedioEstatica = consumoMedioEstatica = tempoMedioDinamica = consumoMedioDinamica = 0f;

        System.out.println("Gerando matriz tamanho " + tamanhoMatriz + "x" + tamanhoMatriz + " aleatoria...");

        for (int i = 0; i < repetirVezes; i++) {
            //se for matriz estatica ele gera matriz estatica
            if (!dinamica){
                
                tempoInicialEstatica =   getTempo();
                consumoInicialEstatica = getConsumo();
                MatrizEstatica.gerarMatrizAleatoria(tamanhoMatriz,.6);
                tempoFinalEstatica =     getTempo();
                consumoFinalEstatica =   getConsumo();

                tempoMedioEstatica   += tempoFinalEstatica   - tempoInicialEstatica;
                consumoMedioEstatica += consumoFinalEstatica - consumoInicialEstatica;

                //calcula a media das N vezes que rodou o codigo e mostra a saida no final do teste
                if (i == repetirVezes-1){
                    tempoMedioEstatica /= i+1;
                    System.out.println("Tempo médio (estatica): " + tempoMedioEstatica + " millisecs.");
                    consumoMedioEstatica /= i+1;
                    System.out.println("Consumo médio (estatica): " + (consumoMedioEstatica/1000) + " kilobytes.");
                }

            //se for matriz dinamica ele gera matriz dinamica
            }else{

                tempoInicialDinamica =   getTempo();
                consumoInicialDinamica = getConsumo();
                MatrizDinamica.gerarMatrizAleatoria(tamanhoMatriz,.6);
                tempoFinalDinamica =     getTempo();
                consumoFinalDinamica =   getConsumo();

                tempoMedioDinamica   += tempoFinalDinamica   - tempoInicialDinamica;
                consumoMedioDinamica += consumoFinalDinamica - consumoInicialDinamica;

                //calcula a media e mostra a saida no final do teste
                if (i == repetirVezes-1){
                    tempoMedioDinamica /= i+1;
                    System.out.println("Tempo médio (dinamica): " + tempoMedioDinamica + " millisecs.");
                    consumoMedioDinamica /= i+1;
                    System.out.println("Consumo médio (dinamica): " + (consumoMedioDinamica/1000) + " kilobytes.");
                }
            }
            
        }

    }

    private static long getTempo() { return System.currentTimeMillis(); }
    private static long getConsumo() { return Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory(); }

}
