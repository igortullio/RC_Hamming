
import java.util.ArrayList;
import java.util.Random;


public class Hamming {
    
    Random gerador = new Random();

    public void Emissor () {
        
        //int tamanho = gerador.nextInt(10) + 1; //Gerar o tamanho da mensagem
        int tamanho = 7;
        
        ArrayList<Integer> mensagem = new ArrayList<Integer>(); //Cria um ArrayList para a mensagem
        for (int i = 0; i < tamanho; i++) {
            mensagem.add(gerador.nextInt(2)); //Carrega o ArrayList aleatoriamente com 0s ou 1s
        }
        
        int quatBitsParidade = CalculaQtdBitsParidade(tamanho); //Determina a quantidade de bits de paridade necessarios para a mensagem
        
        System.out.println("Mensagem Inicial");
        System.out.println(mensagem.toString());
        
        ArrayList<Integer> hamming = BitsRedundanciaNasPosicoes(mensagem, tamanho); //ArrayList para colocar a mensagem e a paridade
        
        System.out.println("Mensagem com a bits de paridade na suas posições");
        System.out.println(hamming.toString());                        
        
        hamming = CalculaParidadeR1(mensagem);
        
        System.out.println("Mensagem com a paridade correta na posição 0");
        System.out.println(hamming.toString());
        
        hamming = CalculaParidadeR2(mensagem);
        
        System.out.println("Mensagem com a paridade correta na posição 1");
        System.out.println(hamming.toString());
        
    }
    
    public void Receptor() {
        
    }
    
    public ArrayList CalculaParidadeR1 (ArrayList<Integer> mensagem) {
        int quantidade1 = 0;
        for (int i = 2; i < 11; i = i + 2) {
            if (mensagem.get(i) == 1) {
                quantidade1++;
            }
        }
        
        if (quantidade1 % 2 == 0) {
            mensagem.set(0, 0);
        } else {
            mensagem.set(0, 1);
        }
                
        return mensagem;
    }
    
    public ArrayList CalculaParidadeR2 (ArrayList<Integer> mensagem) {
        int quantidade1 = 0;
        for (int i = 1; i < 11; i = i + 4) {
            if (mensagem.get(i) == 1) {
                quantidade1++;
            }
            if (mensagem.get(i+1) == 1) {
                quantidade1++;
            }
        }
        
        if (quantidade1 % 2 == 0) {
            mensagem.set(1, 0);
        } else {
            mensagem.set(1, 1);
        }
                
        return mensagem;
    }
    
    public ArrayList CalculaParidadeR3 (ArrayList<Integer> mensagem) {
        int quantidade1 = 0;
        for (int i = 2; i < 11; i = i + 2) {
            if (mensagem.get(i) == 1) {
                quantidade1++;
            }
        }
        if (quantidade1 % 2 == 0) {
            mensagem.set(0, 0);
        } else {
            mensagem.set(0, 1);
        }
                
        return mensagem;
    }
    
    public ArrayList CalculaParidadeR4 (ArrayList<Integer> mensagem) {
        int quantidade1 = 0;
        for (int i = 2; i < 11; i = i + 2) {
            if (mensagem.get(i) == 1) {
                quantidade1++;
            }
        }
        if (quantidade1 % 2 == 0) {
            mensagem.set(0, 0);
        } else {
            mensagem.set(0, 1);
        }
                
        return mensagem;
    }
    
    public ArrayList BitsRedundanciaNasPosicoes (ArrayList<Integer> mensagem, int tamanho) { //Método para adicionar 2 nas posições do bits de paridade       
        mensagem.add(0,2);
        mensagem.add(1,2);
        mensagem.add(3,2);
        mensagem.add(7,2);
        
        return mensagem;
    }
        
    public int CalculaQtdBitsParidade(int tamanho){ //Método para calcular a quantidade de bits de paridade/redundância     
        int r = 1;        
        while ( Math.pow(2, r) < tamanho + r + 1) {
            r++;
        }        
        
        return r;                      
    }
    
}
