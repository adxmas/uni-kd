package data;

public class Automobilis extends VIP_Automobilis {

    private int id;
    private String marke;
    private String modelis;
    private String spalva;
    private String kuras;
    private int metai;
    private int kaina;
    private String arLaisva;
    private String onlyVIP;


    public Automobilis(int id, String marke, String modelis, String spalva, String kuras, int metai, int kaina, String arLaisva, String onlyVIP){
        this.id = id;
        this.marke = marke;
        this.modelis = modelis;
        this.spalva = spalva;
        this.kuras = kuras;
        this.metai = metai;
        this.kaina = kaina;
        this.arLaisva = arLaisva;
        this.onlyVIP = super.setVIPauto(onlyVIP);
    }


    //set'eriai
    public void setId(int id) {this.id = id;}
    public void setMarke(String marke){
        this.marke = marke;
    }
    public void setModelis(String modelis){
        this.modelis = modelis;
    }
    public void setSpalva(String spalva){
        this.modelis = modelis;
    }
    public void setKuras(String kuras){
        this.kuras = kuras;
    }
    public void setMetai(int metai){
        this.metai = metai;
    }
    public void setKaina(int kaina){
        this.kaina = kaina;
    }
    public void setArLaisva(String arLaisva){
        this.arLaisva = arLaisva;
    }
    public void setOnlyVIP(String onlyVIP){
        this.onlyVIP = onlyVIP;
    }

    //get'eriai
    public int getId() {return this.id; }
    public String getMarke(){
        return this.marke;
    }
    public String getModelis(){
        return this.modelis;
    }
    public String getSpalva(){
        return this.spalva;
    }
    public String getKuras(){
        return this.kuras;
    }
    public int getMetai(){
        return this.metai;
    }
    public int getKaina(){
        return this.kaina;
    }
    public String getArLaisva(){
        return this.arLaisva;
    }
    public String getOnlyVIP(){
        return this.onlyVIP;
    }


    @Override
    public String toString() {
        return "Automobilis{" + "Id="+ this.id + ", Marke=" + this.marke + ", modelis=" + this.modelis + ", spalva=" + this.spalva + ", kuras=" + this.kuras
                + ", gamybos metai=" + this.metai + ", kaina/diena= " + this.kaina + ", ar laisva= " + this.arLaisva + ", ar tik VIP= " + this.onlyVIP + '}' + '\n';
    }
}
