package controller;

import alerts.AlertBox;
import alerts.AlertBox2;
import data.Automobilis;
import data.Sutartis;
import data.Vartotojas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML public TableView<Automobilis> autoTableView;

    @FXML public TableView<Vartotojas> vartTableView;

    @FXML public TableView<Sutartis> sutartisTableView;

    public Button alertBox = new Button();
    public Button calculateCarPriceButton = new Button();
    ObservableList<Automobilis> cars = FXCollections.observableArrayList();

    @FXML public TableColumn<Automobilis, Integer> autoIDCol;
    @FXML public TableColumn<Automobilis, String> markeCol;
    @FXML public TableColumn<Automobilis, String> modelisCol;
    @FXML public TableColumn<Automobilis, String> spalvaCol;
    @FXML public TableColumn<Automobilis, String> kurasCol;
    @FXML public TableColumn<Automobilis, Integer> metaiCol;
    @FXML public TableColumn<Automobilis, Integer> kainaCol;
    @FXML public TableColumn<Automobilis, String> arLaisvaCol;
    @FXML public TableColumn<Automobilis, String> onlyVIPCol;

    @FXML public TextField autoIDField;
    @FXML public TextField markeField;
    @FXML public TextField modelisField;
    @FXML public TextField spalvaField;
    @FXML public TextField kurasField;
    @FXML public TextField metaiField;
    @FXML public TextField kainaField;
    @FXML public TextField arLaisvaField;
    @FXML public TextField onlyVIPField;

    @FXML public TextField rentStart;
    @FXML public TextField rentEnd;
    @FXML public TextField price;

    // sutarties tabe esantis sutarties pasirasymo laukai
    public ObservableList<Sutartis> sutartisObservableList = FXCollections.observableArrayList();

    @FXML public TextField sutartiesNuomPradziosData;
    @FXML public TextField sutartiesNuomPabaigosData;
    @FXML public TextField sutartiesNuomPasirasymoData;
    @FXML public TextField sutartiesNuomKaina;

    @FXML public TableColumn<Sutartis, Vartotojas> vartotojasCol;
    @FXML public TableColumn<Sutartis, String> sutNuomPradCol;
    @FXML public TableColumn<Sutartis, String> sutNuomPabCol;
    @FXML public TableColumn<Sutartis, String> sutNuomPasirasymoDataCol;
    @FXML public TableColumn<Sutartis, Integer> sutNrCol;
    @FXML public TableColumn<Sutartis, Integer> sutNuomKainaCol;
    @FXML public TableColumn<Sutartis, Integer> sutNuomAutoIDCol;



    //Vartotojo klase
    public ObservableList<Vartotojas> user_list = FXCollections.observableArrayList();

    @FXML public TextField vartVardasField;
    @FXML public TextField vartPavardeField;
    @FXML public TextField vartAkField;
    @FXML public TextField vartTelNrField;

    @FXML public TextField vartAKCheckField;
    @FXML public TextField carID;

    @FXML public TableColumn<Vartotojas, String> vartVardasCol;
    @FXML public TableColumn<Vartotojas, String> vartPavardeCol;
    @FXML public TableColumn<Vartotojas, Integer> vartAkCol;
    @FXML public TableColumn<Vartotojas, Integer> vartTelNrCol;
    @FXML public TableColumn<Vartotojas, Boolean> vartVipCol;

    @FXML public TextField carBelowOrEqualPrice;

    @FXML private ComboBox carBox;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println(System.getProperties().get("javafx.runtime.version"));

        //addCarsTodatabase();

        autoIDCol.setCellValueFactory(new PropertyValueFactory<Automobilis, Integer>("id"));
        markeCol.setCellValueFactory(new PropertyValueFactory<Automobilis, String>("marke"));
        modelisCol.setCellValueFactory(new PropertyValueFactory<Automobilis, String>("Modelis"));
        spalvaCol.setCellValueFactory(new PropertyValueFactory<Automobilis, String>("Spalva"));
        kurasCol.setCellValueFactory(new PropertyValueFactory<Automobilis, String>("Kuras"));
        metaiCol.setCellValueFactory(new PropertyValueFactory<Automobilis, Integer>("Metai"));
        kainaCol.setCellValueFactory(new PropertyValueFactory<Automobilis, Integer>("Kaina"));
        arLaisvaCol.setCellValueFactory(new PropertyValueFactory<Automobilis, String>("arLaisva"));
        onlyVIPCol.setCellValueFactory(new PropertyValueFactory<Automobilis, String>("onlyVIP"));

        vartVardasCol.setCellValueFactory(new PropertyValueFactory<Vartotojas, String>("Vardas"));
        vartPavardeCol.setCellValueFactory(new PropertyValueFactory<Vartotojas, String>("Pavarde"));
        vartAkCol.setCellValueFactory(new PropertyValueFactory<Vartotojas, Integer>("asKod"));
        vartTelNrCol.setCellValueFactory(new PropertyValueFactory<Vartotojas, Integer>("num"));
        vartVipCol.setCellValueFactory(new PropertyValueFactory<Vartotojas, Boolean>("vip"));

        vartotojasCol.setCellValueFactory(new PropertyValueFactory<>("var"));
        sutNuomPradCol.setCellValueFactory(new PropertyValueFactory<>("sutNuomPrad"));
        sutNuomPabCol.setCellValueFactory(new PropertyValueFactory<>("sutNuomPab"));
        sutNuomPasirasymoDataCol.setCellValueFactory(new PropertyValueFactory<>("sutData"));
        sutNrCol.setCellValueFactory(new PropertyValueFactory<>("sutNr"));
        sutNuomKainaCol.setCellValueFactory(new PropertyValueFactory<>("sutNuomosKaina"));
        sutNuomAutoIDCol.setCellValueFactory(new PropertyValueFactory<>("sutAutoID"));


        autoTableView.setItems(inputCarsFromDatabaseToTable());
        vartTableView.setItems(inputUsersFromDatabaseToTableView());
        sutartisTableView.setItems(inputContractsFromDatabaseToTable());

        autoTableView.setEditable(true);
        arLaisvaCol.setCellFactory(TextFieldTableCell.forTableColumn());

        vartTableView.setEditable(true);
        vartVardasCol.setCellFactory(TextFieldTableCell.forTableColumn());
        vartPavardeCol.setCellFactory(TextFieldTableCell.forTableColumn());

        sutartisTableView.setEditable(true);
        sutNuomPasirasymoDataCol.setCellFactory((TextFieldTableCell.forTableColumn()));


        carBox.setValue("choose car");
        carBox.setItems(cars);

}


    public static void showStage(String errorMsg){
        Stage newStage = new Stage();
        VBox comp = new VBox();
        newStage.setTitle("KLAIDA");
        Text msg = new Text(errorMsg);
        msg.setX(150.0);
        msg.setY(150.0);
        comp.getChildren().add(msg);

        Scene stageScene = new Scene(comp, 270, 50);
        newStage.setScene(stageScene);
        newStage.show();
    }

    /**
     * Parodo tarp carTableView visas automobilius, kuriu kaina yra mazesne arba lygi ivestai.
     */
    public ObservableList<Automobilis> showCarsBelowOrEqualPrice(int carBoEP){
        Connection myConn = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            Statement myStmt = myConn.createStatement();
            PreparedStatement pstmt = myConn.prepareStatement("select * from masinu_databse.masinos where Kaina <= (?)");
            pstmt.setInt(1, carBoEP);
            ResultSet rs = pstmt.executeQuery();
            autoTableView.getItems().clear();

            while(rs.next()){
                cars.add(new Automobilis(rs.getInt("id"), rs.getString("Marke"), rs.getString("Modelis"),
                        rs.getString("Spalva"), rs.getString("Kuras"), rs.getInt("Metai"), rs.getInt("Kaina"),
                        rs.getString("arLaisva"), rs.getString("onlyVIP")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cars;

    }

    /**
     * Mygtukas, kuri paspaudus, rodys selecto pagal kaina automobilius tarp autoTableView.
     */
    public void showCarsBelowPriceButtonClicked(){
        showCarsBelowOrEqualPrice(Integer.parseInt(carBelowOrEqualPrice.getText()));
        autoTableView.setItems(cars);
    }


    /**
     *Istrina viena pasirinkta automobili is tableview ir duomenu bazes
     */
    public void deleteCarFromDatabase(int selectedID){
        Connection myConn = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement pstmt = myConn.prepareStatement("delete from masinu_databse.masinos where id = (?)");
            pstmt.setInt(1, selectedID);
            pstmt.executeUpdate();
            System.out.println("Pavyko istrinti automobili");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Istrina visus automobilius is duomenu bazes
     */
    public void deleteAllCarsFromDatabase(){
        Connection myConn = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement pstmt = myConn.prepareStatement("delete from masinu_databse.masinos where id > 0");
            pstmt.executeUpdate();
            System.out.println("Pavyko istrinti visus automobilius is duomenu bazes");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Galima pakeisti automobiliu prieinamuma tiesiai i duomenu baze
     */
    public void updateCarToDatabase(String newStatusValue, int selectedID){
        Connection myConn = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement pstmt = myConn.prepareStatement("update masinu_databse.masinos set arLaisva = (?) where id = (?)");
            pstmt.setString(1, newStatusValue);
            pstmt.setInt(2, selectedID);
            pstmt.executeUpdate();
            System.out.println("Pavyko atnaujinti");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateSutartisDateToDatabase(String newSutDate, int sutNrId){
        Connection myConn = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement pstmt = myConn.prepareStatement("update masinu_databse.sutartys set sutData = (?) where sutNr = (?)");
            pstmt.setString(1, newSutDate);
            pstmt.setInt(2, sutNrId);
            pstmt.executeUpdate();
            System.out.println("Pavyko atnaujinti sutarties Nr");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Nuskaito masinas is duomenu bazes ir prideda jas i autotableview
     */
    public ObservableList<Automobilis> inputCarsFromDatabaseToTable(){
        Connection myConn = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            Statement myStmt = myConn.createStatement();

            String sql = "select * from masinu_databse.masinos";
            ResultSet rs = myStmt.executeQuery(sql);
            while(rs.next()){
                cars.add(new Automobilis(rs.getInt("id"), rs.getString("Marke"), rs.getString("Modelis"),
                        rs.getString("Spalva"), rs.getString("Kuras"), rs.getInt("Metai"), rs.getInt("Kaina"),
                        rs.getString("arLaisva"), rs.getString("onlyVIP")));
           }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return cars;
    }

    public ObservableList<Sutartis> inputContractsFromDatabaseToTable(){
        Connection myConn = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            Statement myStmt = myConn.createStatement();

            String sql = "select * from masinu_databse.sutartys";
            ResultSet rs = myStmt.executeQuery(sql);

            while(rs.next()){
                sutartisObservableList.add(new Sutartis(returnUserByAsKod(rs.getInt("varAsKod")), rs.getString("sutNuomPrad"), rs.getString("sutNuomPab"),
                        rs.getString("sutData"), rs.getInt("sutNr"), rs.getInt("sutNuomosKaina"), rs.getInt("sutAutoID")));

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return sutartisObservableList;
    }

    public ObservableList<Vartotojas> inputUsersFromDatabaseToTableView(){
        Connection myConn = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            Statement myStmt = myConn.createStatement();

            String sql = "select * from masinu_databse.vartotojai";
            ResultSet rs = myStmt.executeQuery(sql);

            while(rs.next()){
                user_list.add(new Vartotojas(rs.getString("vardas"), rs.getString("pavarde"), rs.getInt("asKod"),
                        rs.getInt("num"), rs.getBoolean("vip")));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return user_list;
    }

    /**
     * Galima prideti automobili tiesiai i duomenu baze
     */
    public void addCarsTodatabase(int index, String markedb, String modelisdb, String spalvadb, String kurasdb, int metaidb, int kainadb, String arLaisvadb, String onlyVIPdb){
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement pstmt = myConn.prepareStatement("INSERT INTO masinu_databse.masinos (id, Marke, Modelis, Spalva, Kuras, Metai, Kaina, arLaisva, onlyVIP) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, index );
            pstmt.setString(2, markedb);
            pstmt.setString(3, modelisdb);
            pstmt.setString(4, spalvadb);
            pstmt.setString(5, kurasdb );
            pstmt.setInt(6, metaidb );
            pstmt.setInt(7, kainadb );
            pstmt.setString(8, arLaisvadb );
            pstmt.setString(9, onlyVIPdb );
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodas prideda vartotojus i mysql database
     */
    public void addUserToDatabase(String v, String p, int ak, int tnr, boolean vipsts){
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement pstmt = myConn.prepareStatement("INSERT INTO masinu_databse.vartotojai (vardas, pavarde, asKod, num, vip) " +
                    "VALUES (?,?,?,?,?)");
            pstmt.setString(1, v );
            pstmt.setString(2, p);
            pstmt.setInt(3, ak);
            pstmt.setInt(4, tnr);
            pstmt.setBoolean(5, vipsts );
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Sis metodas nauja automobili ir prides i autoTableView
     */

    public void newCarButtonClicked(){
        try {
            if ((Integer.parseInt(kainaField.getText()) > 0) && (metaiField.getText().length() == 4)) {
                Automobilis newAuto = new Automobilis(Integer.parseInt(autoIDField.getText()), markeField.getText(), modelisField.getText(), spalvaField.getText(),
                        kurasField.getText(), Integer.parseInt(metaiField.getText()), Integer.parseInt(kainaField.getText()), arLaisvaField.getText(), onlyVIPField.getText());

                addCarsTodatabase(Integer.parseInt(autoIDField.getText()), markeField.getText(), modelisField.getText(), spalvaField.getText(),
                        kurasField.getText(), Integer.parseInt(metaiField.getText()), Integer.parseInt(kainaField.getText()), arLaisvaField.getText(), onlyVIPField.getText());


                autoTableView.getItems().add(newAuto);
                //cars.add(newAuto);
                carBox.setItems(cars);
                autoTableView.refresh();


                autoIDField.setText("");
                markeField.setText("");
                modelisField.setText("");
                spalvaField.setText("");
                kurasField.setText("");
                metaiField.setText("");
                kainaField.setText("");
                arLaisvaField.setText("");
                onlyVIPField.setText("");
            } else{
                showStage("Kaina turi buti didesne uz 0");
            }
        }
        catch(NumberFormatException e){
          showStage("Yra palikta tusciu lauku!");
        }
    }


    /**
     * Sis metodas leis pasalinti automobili is saraso
     */

    public void deleteCarButtonClicked(){
        Automobilis selectedCar = autoTableView.getSelectionModel().getSelectedItem();
        selectedCar.getId();

        ObservableList<Automobilis> selectedRows, allCars;
        allCars = autoTableView.getItems();
        //duoda visas pasirinktas eilutes masinu
        selectedRows = autoTableView.getSelectionModel().getSelectedItems();


        for(Automobilis automobilis: selectedRows){
            allCars.remove(automobilis);
        }
        deleteCarFromDatabase(selectedCar.getId());


    }

    /**
     * Grazina sutarti pagal vartotojo asmens koda
     */
    public Sutartis returnSutartisByUser(int ak){
        for (Sutartis st : this.sutartisObservableList) {
            if (st.getUserAK() == (ak)) {
                return st;
            }
        }
        return null;
    }

    /**
     * Grazina 'taip' ar 'ne' ar egzistuoja sutartys su tokiu asmens kodu
     */
    public boolean returnBooleanSutartisByAK(int ak) {
        for (Sutartis st : this.sutartisObservableList) {
            if (st.getUserAK() == (ak)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Istrina vartotoja ir jo sutarti
     */
    public void deleteUserButtonClicked(){
        ObservableList<Vartotojas> selectedRows, allUsers;
        allUsers = vartTableView.getItems();
        Vartotojas userToDelete = vartTableView.getSelectionModel().getSelectedItem();

        deleteUserFromDatabase(userToDelete.getAsKod());
        System.out.println("asmens kodas kuri istrynete: " + userToDelete.getAsKod());

        //duoda visas pasirinktas eilutes vartotoju
        selectedRows = vartTableView.getSelectionModel().getSelectedItems();


        for(Vartotojas var: selectedRows){
            allUsers.remove(var);
            System.out.println("pasalinote vartotoja");
        }

        Sutartis sut22 = returnSutartisByUser(userToDelete.getAsKod());
        //for(int i=0;i<sutartisObservableList.size();i++) {
        while(sutartisObservableList.contains(sut22)){
            Sutartis sut1 = returnSutartisByUser(userToDelete.getAsKod());
            sutartisObservableList.remove(sut1);
            sutartisTableView.getItems().remove(sut1);
            deleteContractFromDatabase(sut1.getSutNr()+1);
            updateCarToDatabase("true", sut1.getSutAutoID());
        }
        System.out.println("sutartys: " + sutartisObservableList);
        sutartisTableView.refresh();


        while(returnBooleanSutartisByAK(userToDelete.getAsKod())){
            Sutartis sut1 = returnSutartisByUser(userToDelete.getAsKod());
            sutartisObservableList.remove(sut1);
            sutartisTableView.getItems().remove(sut1);
            deleteContractFromDatabase(sut1.getSutNr());
            updateCarToDatabase("true", sut1.getSutAutoID());
        }

    }


    public void deleteAllCarsFromDatabaseButtonClicked(){
        ObservableList<Automobilis> selectedRows, allCars;
        allCars = autoTableView.getItems();
        //duoda visas pasirinktas eilutes masinu
        //selectedRows = autoTableView.getSelectionModel().getSelectedItems();


        /*for(Automobilis automobilis: selectedRows){
            allCars.removeAll(automobilis);
        }*/
        autoTableView.getItems().clear();
        deleteAllCarsFromDatabase();
        autoTableView.refresh();
    }


    /**
     * Sis metodas leis update'inti automobilio VIP statusa
     */
    public void changeVIPStatusOfCar(TableColumn.CellEditEvent edittedCell){
        Automobilis selectedCar = autoTableView.getSelectionModel().getSelectedItem();
        String nw = selectedCar.setVIPauto(edittedCell.getNewValue().toString());
        updateCarToDatabase(nw, selectedCar.getId());
        selectedCar.setVIPauto(edittedCell.getNewValue().toString());
    }

    /**
     * Sis metodsa leis update'inti vartotojas varda ir pavarde
     */
    public void changeUser(TableColumn.CellEditEvent edittedCell){
        Vartotojas pickedUser = vartTableView.getSelectionModel().getSelectedItem();
        pickedUser.setPavarde(edittedCell.getNewValue().toString());
    }

    public void changeContractSignDate(TableColumn.CellEditEvent edittedCell){
        Sutartis pickedContract = sutartisTableView.getSelectionModel().getSelectedItem();
        String n = pickedContract.setSutData(edittedCell.getNewValue().toString());
        updateSutartisDateToDatabase(n, pickedContract.getSutNr()+1);
    }

    public void CalculatePriceOfCarButtonClicled(){

        if(rentStart.getText().equals("") || rentEnd.getText().equals("") || price.getText().equals("")) {
            System.out.println("yra tusciu lauku");
        } else{
            calculateCarPriceButton.setOnAction(e -> AlertBox.display("Price of Car", "Calculated price $: ", rentStart.getText(), rentEnd.getText(), price.getText()));
        }
    }

    /**
     * Patikrina ar vartotojas egziztuoja liste
     */
    public boolean userExists(Vartotojas user) {
        return this.user_list.contains(user);
    }

    /**
     * Grazina vartotoja pagal asmens koda
     */
    public Vartotojas returnUserByAsKod(Integer asmenskodas) {
        for (Vartotojas vt : this.user_list) {
            if (vt.getAsKod() == (asmenskodas)) {
                return vt;
            }
        }
        return null;
    }

    /**
     * Kolkas sis metodas prideda tik vartotojas i vartTableView
     */
    public void addNewUserButtonClicked(ActionEvent event){
        if((vartVardasField.getText().length() != 0) && (vartPavardeField.getText().length() != 0)){
        Vartotojas vrt_check = returnUserByAsKod(Integer.parseInt(vartAkField.getText()));
        if(!userExists(vrt_check)) {

                Vartotojas newVartotojas = new Vartotojas(vartVardasField.getText(), vartPavardeField.getText(),  Integer.parseInt(vartAkField.getText()),
                    Integer.parseInt(vartTelNrField.getText()), status);

            //vartTableView.getItems().add(newVartotojas);
            user_list.add(newVartotojas);

            addUserToDatabase(vartVardasField.getText(), vartPavardeField.getText(), Integer.parseInt(vartAkField.getText()), Integer.parseInt(vartTelNrField.getText()), status);

            vartVardasField.setText(""); vartPavardeField.setText("");
            vartAkField.setText(""); vartTelNrField.setText("");
        }
        else{
            showStage("Vartotojas jau egzistuoja");
        }
        System.out.println(user_list);
        }
        else{
            showStage("Vardo arba Pavardes laukas yra tuscias");
        }

    }

    /**
     * Metodas su radioButtonu nustato vip value true or false
     */
    boolean status;
    @FXML public RadioButton yesRb;
    @FXML public RadioButton noRb;

    public void radioSelect(ActionEvent event){
        if(yesRb.isSelected()){
            status = true;
        }
        if(noRb.isSelected()){
            status = false;
        }

    }

    /**
     * Metodas skirtas apskaiciuoti, kiek kainuotu automobilio nuoma
     */
    public int calculateRentPrice(int nPrad, int nPab){
        return nPab-nPrad;
    }

    /**
     *  Metodas skirtas pasirasyti sutarti
     */
    public void signContractButtonClicked(){
        Vartotojas vrtt = returnUserByAsKod(Integer.parseInt(vartAKCheckField.getText()));

        if(userExists(vrtt)) {
            boolean arVartotojasVIP = vrtt.getVip();
            //carBox.getValue();
            Automobilis at = (Automobilis) carBox.getValue();
            int id = at.getId();
            String arAutomobilisVIP = at.getOnlyVIP();
            //changeCarStatus(id, "false");

            if((at.getArLaisva().equals("true")) && (arVartotojasVIP == Boolean.parseBoolean(arAutomobilisVIP)) || arVartotojasVIP == true && arAutomobilisVIP.equals("false")) {
                Sutartis newSutartis = new Sutartis(vrtt, sutartiesNuomPradziosData.getText(), sutartiesNuomPabaigosData.getText(), sutartiesNuomPasirasymoData.getText(), sutartisObservableList.size() + 1,
                        Integer.parseInt(sutartiesNuomKaina.getText()) * (calculateRentPrice(Integer.parseInt(sutartiesNuomPradziosData.getText()), Integer.parseInt(sutartiesNuomPabaigosData.getText()))), id);

                sutartisObservableList.add(newSutartis);
                autoTableView.refresh();
                carBox.setItems(cars); //veike ir be sito, GALI PRIREIKT ISTRINT
                //sutartisTableView.getItems().add(newSutartis);
                sutartisTableView.refresh();

                addSignedSutartisToDatabase(vrtt.getAsKod(), sutartiesNuomPradziosData.getText(), sutartiesNuomPabaigosData.getText(), sutartiesNuomPasirasymoData.getText(), sutartisObservableList.size() + 1,
                        Integer.parseInt(sutartiesNuomKaina.getText()) * (calculateRentPrice(Integer.parseInt(sutartiesNuomPradziosData.getText()), Integer.parseInt(sutartiesNuomPabaigosData.getText()))), id);

                changeCarStatus(id, "false");
                updateCarToDatabase("false", id);
            }
            else{
                System.out.println("Automobilio prieinamumo statusas yra 'false'");
                System.out.println("Vartotojo statusas: " + arVartotojasVIP + " , automobilio statusas: " + arAutomobilisVIP);
            }
        }
        sutartiesNuomPradziosData.setText(""); sutartiesNuomPabaigosData.setText("");
        sutartiesNuomPasirasymoData.setText(""); sutartiesNuomKaina.setText("");
        vartAKCheckField.setText(""); carID.setText("");
        //System.out.println(sutartisObservableList);
    }

    /**
    *Prideda pasirasyta sutarti i duomenubaze
    */
    public void addSignedSutartisToDatabase(int askod, String sutnuomprad, String sutnuompab, String sutsigndate, int sutnr, int nuomprice, int sutcarid){
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement pstmt = myConn.prepareStatement("INSERT INTO masinu_databse.sutartys (varAsKod, sutNuomPrad, sutNuomPab, sutData, sutNr, sutNuomosKaina, sutAutoID) " +
                    "VALUES (?,?,?,?,?,?,?)");
            pstmt.setInt(1, askod);
            pstmt.setString(2, sutnuomprad);
            pstmt.setString(3, sutnuompab);
            pstmt.setString(4, sutsigndate);
            pstmt.setInt(5, sutnr );
            pstmt.setInt(6, nuomprice );
            pstmt.setInt(7, sutcarid );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Grazina sutarti pagal duota sutarties numeri
     */
    public Sutartis returnSutartisByNr(int sutNr) {
        for (Sutartis st : this.sutartisObservableList) {
            if (st.getSutNr() == (sutNr)) {
                return st;
            }
        }
        return null;
    }

    /**
     * Grazina vartotojo asmens koda pagal duota sutarties numeri
     */
    public int returnAKByContractID(int contractID){
        for (Sutartis st : this.sutartisObservableList) {
            if (st.getSutNr() == (contractID)) {
                return st.getUserAK();
            }
        }
        return 0;
    }

    /**
     * Metodas skirtas istrinti sutarti. Kol nebus istrintos visos sutartis, tol vartotojas neissitrins
     */
    public void deleteContractButtonClicked(){
        Sutartis sutartisToDelete = sutartisTableView.getSelectionModel().getSelectedItem();

        int sutNr = sutartisToDelete.getSutNr();
        int x = returnAKByContractID(sutNr);
        Sutartis sut3 = returnSutartisByNr(sutNr);

        sutartisObservableList.remove(sut3);
        sutartisTableView.getItems().remove(sut3);
        deleteContractFromDatabase(sutNr+1);
        changeCarStatus(sutartisToDelete.getSutAutoID(), "true");
        updateCarToDatabase("true", sutartisToDelete.getSutAutoID());

        // kol bus sutarciu su tam tikru vartotoju, jis nebus istrinamas is vartotoju saraso
        if(!returnBooleanSutartisByAK(x)){
            System.out.println(returnBooleanSutartisByAK(x));
            Vartotojas var1 = returnUserByAsKod(x);
            user_list.remove(var1);
            vartTableView.getItems().remove(var1);
            deleteUserFromDatabase(x);
        }
        System.out.println("vartotojai: " + user_list);
        System.out.println("sutartys: " + sutartisObservableList);
        vartTableView.refresh();
        sutartisTableView.refresh();
    }

    public void deleteContractFromDatabase(int selectedSutID){
        Connection myConn = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement pstmt = myConn.prepareStatement("delete from masinu_databse.sutartys where sutNr = (?)");
            pstmt.setInt(1, selectedSutID);
            pstmt.executeUpdate();
            System.out.println("Pavyko istrinti sutarti");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteUserFromDatabase(int userAK){
        Connection myConn = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement pstmt = myConn.prepareStatement("delete from masinu_databse.vartotojai where asKod = (?)");
            pstmt.setInt(1, userAK);
            pstmt.executeUpdate();
            System.out.println("Pavyko istrinti vartotoja");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Metodas skirtas surasti automobili pagal duota autoId
     */
    public Automobilis returnCarbyId(Integer id) {
        for (Automobilis at : this.cars) {
            if (at.getId() == (id)) {
                return at;
            }
        }
        return null;
    }

    /**
     * Metodas skirtas pakeisti automobilio statusa is true -> false, kai yra pasirasoma sutartis
     */
    public String changeCarStatus(int id, String newStatus){
        Automobilis auto = returnCarbyId(id);
        auto.setArLaisva(newStatus);

        //return Boolean.parseBoolean(Boolean.toString(auto.getArLaisva()));
        return auto.getArLaisva();
    }

    /**
     * Pasirinkus automobilio objekta is combobox grazina automobilio ID
     */
        public void comboChanged(ActionEvent event){
            Automobilis a = (Automobilis) carBox.getValue();
            carID.setText(String.valueOf(a.getId()));
            sutartiesNuomKaina.setText(String.valueOf(a.getKaina()));

        }

    }




