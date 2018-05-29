package criptofinal;

import java.util.Scanner;

public class Descriptografar {
    
    void Descripto(){
        
        Scanner recebe = new Scanner(System.in);
        int [][] chave = new int [2][2];
        chave[0][0] = 2;
        chave[0][1] = 1;
        chave[1][0] = -1;
        chave[1][1] = 4;
        
        char [] Alfabeto = { 'Z' , 'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' , 'H' , 'I' , 'J' , 'K' , 'L' , 'M' , 'N' , 'O' , 'P' , 'Q' , 'R' , 'S' , 'T' , 'U' , 'V' , 'X' , 'W' , 'Y' };
        
        System.out.print("Mensagem criptografada: ");
        String criptografada = recebe.nextLine();
        
        if(criptografada.length() % 2 != 0){
            criptografada += "Y";
        }
        
        criptografada = criptografada.toUpperCase();
                
        int quantidadeDeLinhas = criptografada.length() / 2;
        
        int posicao1 = 0;
        int posicao2 = 1;
        
        int paresC[][] = new int [quantidadeDeLinhas][2];
        
        for(int i=0; i < quantidadeDeLinhas; i++){
            
            char l1 = criptografada.charAt(posicao1);
            char l2 = criptografada.charAt(posicao2);
            
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
            
            paresC[i][0] = n1;
            paresC[i][1] = n2;
            
            posicao1+=2;
            posicao2+=2;
        }
        
        int valoresC [] = new int [paresC.length*2];
        
        posicao1 = 0;
        posicao2 = 1;
        
        int [][] chaveI = new int [2][2];
        chaveI[0][0] = 4;
        chaveI[0][1] = -1;
        chaveI[1][0] = 1;
        chaveI[1][1] = 2;
        
        int [][] chaveInversa = new int [2][2];
        chaveInversa[0][0] = chaveI[0][0]*3;
        chaveInversa[0][1] = chaveI[0][1]*3;
        chaveInversa[1][0] = chaveI[1][0]*3;
        chaveInversa[1][1] = chaveI[1][1]*3;
        
        if(chaveInversa[0][0] < 0){
            chaveInversa[0][0] = chaveInversa[0][0] + 26;
        }
        else if(chaveInversa[0][1] < 0){
            chaveInversa[0][1] = chaveInversa[0][1] + 26;
        }
        else if(chaveInversa[1][0] < 0){
            chaveInversa[1][0] = chaveInversa[1][0] + 26;
        }
        else if(chaveInversa[1][1] < 0){
            chaveInversa[1][1] = chaveInversa[1][1] + 26;
        }
        else{
            
        }
        
        for(int i=0; i < paresC.length; i++){
            
            int l0c0 = chaveInversa[0][0];
            int l0c1 = chaveInversa[0][1];
            int l1c0 = chaveInversa[1][0];
            int l1c1 = chaveInversa[1][1];
            
            int a = paresC[i][0];
            int b = paresC[i][1];
            
            int s1 = (a * chaveInversa[0][0]) + (b * chaveInversa[0][1]);
            int s2 = (a * chaveInversa[1][0]) + (b * chaveInversa[1][1]);
            
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
        
        String descriptografada = "";
      
        
        for (int i = 0; i < valoresC.length; i++) {
            int p = valoresC[i];
            descriptografada += Alfabeto[p];
        }
        
        
        System.out.println(descriptografada);
        
    }
    
}
