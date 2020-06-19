package data;

public class Sutartis {

    private String sutNuomPrad;
    private String sutNuomPab;
    private String sutData;
    private int sutNr;
    private int sutNuomosKaina;
    private int sutAutoID;
    private Vartotojas var;


    public Sutartis(/*String sutvardas, String sutpavarde, int sutAk,*/Vartotojas var999,  String sutNuomPrad, String sutNuomPab,
                                                                       String sutData, int sutNr, int sutNuomosKaina, int sutAutoID){

        this.var = var999;
        this.sutNuomPrad = sutNuomPrad;
        this.sutNuomPab = sutNuomPab;
        this.sutData = sutData;
        this.sutNr = sutNr;
        this.sutNuomosKaina = sutNuomosKaina;
        this.sutAutoID = sutAutoID;
    }

    //set'eriai
    public String setSutData(String sutData) {this.sutData = sutData;
        return sutData;
    }
    public void setSutNuomPrad(String sutNuomPrad) {this.sutNuomPrad = sutNuomPrad; }
    public void setSutNuomPab(String sutNuomPab) {this.sutNuomPab = sutNuomPab; }
    public void setSutNr(int sutNr) { this.sutNr = sutNr; }
    public void setSutNuomosKaina(int sutNuomosKaina) { this.sutNuomosKaina = sutNuomosKaina; }
    public void setSutAutoID (int sutAutoID) {this.sutAutoID = sutAutoID; }

    public void setVar(Vartotojas var) {
        this.var = var;
    }

    public Vartotojas getVar() {
        return var;
    }

    //get'eriai
    public String getSutNuomPrad() {return this.sutNuomPrad; }
    public String getSutNuomPab() { return this.sutNuomPab; }
    public String getSutData() {return this.sutData; }
    public int getSutNr() {return this.sutNr; }
    public int getSutNuomosKaina() {return this.sutNuomosKaina; }
    public int getSutAutoID() {return this.sutAutoID; }
    public int getUserAK() {return this.var.getAsKod();}


    @Override
    public String toString() {
        return "Sutartis : " + var + ", nPrad: " + this.sutNuomPrad + ", nPab: " + this.sutNuomPab + ", sutNr: " + this.sutNr + ", kaina: "
                + this.sutNuomosKaina + ", sutCarID: " + this.sutAutoID;
    }





}

