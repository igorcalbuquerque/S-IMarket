package entidades;

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
}
