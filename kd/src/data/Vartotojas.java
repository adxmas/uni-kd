package data;

public class Vartotojas {

    private String vardas, pavarde;
    private int asKod;
    private int num;
    private boolean vip;

    public Vartotojas(String vardas, String pavarde, int asKod, int num, boolean vip){
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.asKod = asKod;
        this.num = num;
        this.vip = vip;
    }


    //set'eriai
    public void setVardas(String vardas){
        this.vardas = vardas;
    }
    public void setPavarde(String pavarde){
        this.pavarde = pavarde;
    }
    public void setAsKod(int asKod){
        this.asKod = asKod;
    }
    public void setNum(int num){
        this.num = num;
    }
    public void setVip(boolean vip){
        this.vip = vip;
    }



    //get'eriai
    public String getVardas() {
        return this.vardas;
    }
    public String getPavarde(){
        return this.pavarde;
    }
    public int getAsKod(){
        return this.asKod;
    }
    public int getNum(){
        return this.num;
    }
    public boolean getVip(){
        return this.vip;
    }


    @Override
    public String toString() {
        return "Vartotojas : " +  "Vardas: " + this.vardas + " " + "Pavarde: " + this.pavarde + " " +
                "Asmens Kodas: " + this.asKod + " " + "Tel.Nr: " + this.num + " " + "VIP statusas: " + this.vip;
    }



}
