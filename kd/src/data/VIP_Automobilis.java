package data;

public class VIP_Automobilis {

    private String VIPauto;

    public VIP_Automobilis(String VIPauto){
        this.VIPauto = VIPauto;
    }

    public VIP_Automobilis() {
    }


    public String setVIPauto(String VIPauto){
        this.VIPauto = VIPauto;
        return (VIPauto);
    }
    public String getVIPauto(){
        return this.VIPauto;
    }

}
