
import java.util.Arrays;


public class Principal {

    public static void main(String[] args) {

        Hamming hamming = new Hamming(); //Cria uma instância da classe Hamming
       
        hamming.Receptor(hamming.Emissor()); //Chama o Emissor e passa a mensagem para o Receptor
        
    }
    
}
