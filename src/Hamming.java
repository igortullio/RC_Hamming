
import java.util.ArrayList;
import java.util.Random;


public class Hamming {
    
    Random gerador = new Random();

    public ArrayList Emissor () { //Método do Emissor, onde é gerada a mensagem com os bits de paridade
        
        int tamanho = 7; //Gerar o tamanho da mensagem
        
        ArrayList<Integer> mensagem = new ArrayList<Integer>(); //Cria um ArrayList para a mensagem
        for (int i = 0; i < tamanho; i++) {
            mensagem.add(gerador.nextInt(2)); //Carrega o ArrayList aleatoriamente com 0s ou 1s
        }                
        
        System.out.println("--------------------------------EMISSOR----------------------------------");
        System.out.println("Mensagem Inicial:");
        System.out.println(mensagem.toString());
        
        System.out.println("Quantidade de bits de paridade: "+ CalculaQtdBitsParidade(tamanho)); //Determina a quantidade de bits de paridade necessarios para a mensagem
        
        ArrayList<Integer> hamming = BitsRedundanciaNasPosicoes(mensagem, tamanho); //ArrayList para colocar a mensagem e a paridade
        
        System.out.println("Mensagem com a bits de paridade (2) na suas posições:");
        System.out.println(hamming.toString());                        
        
        hamming = CalculaParidadeR1(mensagem);
        
        System.out.println("Mensagem com a paridade correta na posição 0:");
        System.out.println(hamming.toString());
        
        hamming = CalculaParidadeR2(mensagem);
        
        System.out.println("Mensagem com a paridade correta na posição 1:");
        System.out.println(hamming.toString());
        
        hamming = CalculaParidadeR3(mensagem);
        
        System.out.println("Mensagem com a paridade correta na posição 3:");
        System.out.println(hamming.toString());
        
        hamming = CalculaParidadeR4(mensagem);
        
        System.out.println("Mensagem com a paridade correta na posição 4:");
        System.out.println(hamming.toString());
        
        hamming = Inverso(hamming);
        System.out.println("Mensagem que será enviada, na ordem correta, direita para esquerda:");
        System.out.println(hamming.toString());
        
        System.out.println("----------------------------FIM DO EMISSOR-------------------------------");
        
        return hamming;
    }
    
    public void Receptor(ArrayList hamming) {
        
    }
    
    public ArrayList Inverso (ArrayList<Integer> hamming) { //Método para inverter o vetor e coloca-lo da direita para esquerda
        int tamanho = hamming.size();
        ArrayList<Integer> inverso = new ArrayList<Integer>(tamanho);

        for (int i = tamanho - 1; i >= 0; i--) {
            inverso.add(hamming.get(i));
        }

        return inverso;
    }
    
    public ArrayList CalculaParidadeR1 (ArrayList<Integer> mensagem) { //Método que calcula a paridade de R1
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
    
    public ArrayList CalculaParidadeR2 (ArrayList<Integer> mensagem) { //Método que calcula a paridade de R2
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
    
    public ArrayList CalculaParidadeR3 (ArrayList<Integer> mensagem) { //Método que calcula a paridade de R3
        int quantidade1 = 0;
        for (int i = 3; i < 11; i = i + 8) {
            if (mensagem.get(i) == 1) {
                quantidade1++;
            }
            if (mensagem.get(i+1) == 1) {
                quantidade1++;
            }
            if (mensagem.get(i+2) == 1) {
                quantidade1++;
            }
            if (mensagem.get(i+3) == 1) {
                quantidade1++;
            }
        }
        if (quantidade1 % 2 == 0) {
            mensagem.set(3, 0);
        } else {
            mensagem.set(3, 1);
        }
                
        return mensagem;
    }
    
    public ArrayList CalculaParidadeR4 (ArrayList<Integer> mensagem) { //Método que calcula a paridade de R4
        int quantidade1 = 0;
        for (int i = 7; i < 11; i = i + 16) {
            if (mensagem.get(i) == 1) {
                quantidade1++;
            }
            if (mensagem.get(i+1) == 1) {
                quantidade1++;
            }
            if (mensagem.get(i+2) == 1) {
                quantidade1++;
            }
            if (mensagem.get(i+3) == 1) {
                quantidade1++;
            }
        }
        if (quantidade1 % 2 == 0) {
            mensagem.set(7, 0);
        } else {
            mensagem.set(7, 1);
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
