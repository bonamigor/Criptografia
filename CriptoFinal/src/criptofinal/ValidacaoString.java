package criptofinal;
public class ValidacaoString {
    
    void validaStringC(String mensagemParaCodificar){
        mensagemParaCodificar.matches("[a-zA-Z]+");
    }
    
    void validaStringD(String criptografada){
        criptografada.matches("[a-zA-Z]+");
    }

    
}
