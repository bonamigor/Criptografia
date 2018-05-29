package criptofinal;

import java.util.Scanner;

public class Criptografar {
    
    void Cripto(){
        
        Scanner recebe = new Scanner(System.in);
        int [][] chave = new int [2][2];
        chave[0][0] = 2;
        chave[0][1] = 1;
        chave[1][0] = -1;
        chave[1][1] = 4;
        
        char [] Alfabeto = { 'Z' , 'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' , 'H' , 'I' , 'J' , 'K' , 'L' , 'M' , 'N' , 'O' , 'P' , 'Q' , 'R' , 'S' , 'T' , 'U' , 'V' , 'X' , 'W' , 'Y' };
        
        System.out.print("Digite a mensagem: ");
        String mensagemParaCodificar = recebe.nextLine();
        
        if(mensagemParaCodificar.length() % 2 != 0){
            mensagemParaCodificar += "Y";
        }
        
        mensagemParaCodificar = mensagemParaCodificar.toUpperCase();
                
        int quantidadeDeLinhas = mensagemParaCodificar.length() / 2;
        
        int posicao1 = 0;
        int posicao2 = 1;
        
        int pares[][] = new int [quantidadeDeLinhas][2];
        
        for(int i=0; i < quantidadeDeLinhas; i++){
            
            char l1 = mensagemParaCodificar.charAt(posicao1);
            char l2 = mensagemParaCodificar.charAt(posicao2);
            
            int n1 = 0;
            int n2 = 0;
            
            for (int j = 0; j < Alfabeto.length; j++) {
               if(Alfabeto[j] == l1){
                   n1 = j;
               }
               if(Alfabeto[j] == l2){
                   n2 = j;
               }
            }
            
            pares[i][0] = n1;
            pares[i][1] = n2;
            
            posicao1+=2;
            posicao2+=2;
        }
        
        int valoresC [] = new int [pares.length*2];
        
        posicao1 = 0;
        posicao2 = 1;
        
        
        for(int i=0; i < pares.length; i++){
            
            int l0c0 = chave[0][0];
            int l0c1 = chave[0][1];
            int l1c0 = chave[1][0];
            int l1c1 = chave[1][1];
            
            int a = pares[i][0];
            int b = pares[i][1];
            
            int s1 = (a * chave[0][0]) + (b * chave[0][1]);
            int s2 = (a * chave[1][0]) + (b * chave[1][1]);
            
            int ns1 = 0;
            int ns2 = 0;
            
            if(s1 >= 26){
                ns1 = s1 % 26;
            }else if(s1 < 0){
                ns1 = s1 + 26;
            }else{
                ns1 = s1;
            }
            
            if(s2 >= 26){
                ns2 = s2 % 26;
            }else if(s2 < 0){
                ns2 = s2 + 26;
            }else{
                ns2 = s2;
            }
               
            valoresC[posicao1] = ns1;
            valoresC[posicao2] = ns2;
           
            posicao1+=2;
            posicao2+=2;
           
        }
        
        String criptografada = "";
      
        
        for (int i = 0; i < valoresC.length; i++) {
            int p = valoresC[i];
            criptografada += Alfabeto[p];
        }
        
        
        System.out.println(criptografada);
    
}
    
}
