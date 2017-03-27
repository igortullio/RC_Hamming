
import java.util.Random;


public class Hamming {
    
    Random gerador = new Random();

    public void Emissor () {
        
        //int tamanho = gerador.nextInt(10) + 1; //Gerar o tamanho da mensagem
        int tamanho = 7;
        
        int mensagem[] = new int [tamanho]; //Cria um vetor para a mensagem
        for (int i = 0; i < mensagem.length; i++) {
            mensagem[i] = gerador.nextInt(2); //Carrega o vetor aleatoriamente com 0s ou 1s
        }
        
        int quatBitsParidade = BitsParidade(tamanho); //Determina a quantidade de bits de paridade necessarios para a mensagem
        
        int bitsParidade[] = new int[quatBitsParidade]; //Vetor para colocar os bits de paridade
        int hamming[] = new int[tamanho + quatBitsParidade]; //Vetor para a mensagem e a paridade
        
        
        
        
        
        
    }
    
    public void Receptor() {
        
    }
    
    public int BitsParidade(int tamanho){        
        int r = 1;
        
        while ( Math.pow(2, r) < tamanho + r + 1) {
            r++;
        }
        
        return r;                      
    }
    
}
