package negocio.validacao;

import java.util.InputMismatchException;

import negocio.entidades.Data;

public class ValidaDados {

    private static ValidaDados validaDados;
    public static ValidaDados getInstance(){
        if(validaDados == null){ validaDados = new ValidaDados();}
        return validaDados;
    }
    public boolean isCPF(String CPF) {

        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;


        try {

            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {

                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) dig10 = '0';
            else dig10 = (char)(r + 48);


            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) return(true);
            else return(false);
        } catch (InputMismatchException erro) { return(false); }
    }
    public boolean isRg(String rg){
        char[] caracteres = rg.toCharArray();
        char[] invalidos = {'!','@','#','*','%','&','(',')', '<',',','>',';',':','/','?','[','{',']','}'};
        for(char c:caracteres){
            for(char i:invalidos){
                if(c == i){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isName(String name){

        char[] caracteres = name.toCharArray();
        char[] invalidos = {'1','!','2','@','3','#','4','*','5','%','6','7','&','8','9','(','0',')',
                '<',',','>','.',';',':','/','?','[','{',']','}'};

        for(char c:caracteres){
            for(char i:invalidos){
                if(c==i){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isData(Data data){
        if(data == null){
            return false;
        }
        if(data.getDia() > 0 && data.getDia()<=31 && data.getMes() > 0 && data.getMes() < 12 && data.getAno() > 0) { return true; }
        else { return false; }
    }
}