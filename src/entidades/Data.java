package entidades;

/**
 *
 *
 *
 * @author Saú Cesar
 */

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        if(a<99){
            a+=2000;
        }
        this.ano = a;
    }
    public int getDia(){return this.dia;}
    public void setDia(int d){this.dia = d;}
    public int getMes(){return this.mes;}
    public void setMes(int m){this.mes = m;}
    public int getAno(){return this.ano;}
    public void setAno(int a){this.ano = a;}
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Data){

            Data d = (Data)obj;
            if(this.dia == d.getDia() && this.mes == d.getMes()&& this.ano == d.getAno()){
                return true;
            }else return false;

        }else return false;
    }
    @Override
    public String toString(){
        String str = this.dia+"/"+this.mes+"/"+this.ano;
        return str;
    }
    public boolean eAntes(Data data){
        if(this.ano <= data.getAno()){
            return true;
        }
        if(this.ano > data.getAno()){
            return false;
        }
        if (this.mes <= data.getMes()){
            return true;
        }
        if(this.mes > data.getMes()){
            return false;
        }
        if(this.dia <= data.getDia()){
            return true;
        }else{
            return false;
        }
    }
    public boolean eDepois(Data data){
        if(this.ano >= data.getAno()){
            return true;
        }
        if(this.ano < data.getAno()){
            return false;
        }
        if (this.mes >= data.getMes()){
            return true;
        }
        if(this.mes < data.getMes()){
            return false;
        }
        if(this.dia >= data.getDia()){
            return true;
        }else{
            return false;
        }
    }
}
