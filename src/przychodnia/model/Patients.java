package przychodnia.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by adam on 04/01/2017.
 */
public class Patients {

    public IntegerProperty pIndex;
    public IntegerProperty pId;
    public StringProperty pSurname;
    public StringProperty pName;
    public StringProperty pCity;
    public StringProperty pStreet;
    public StringProperty pNumber;
    public StringProperty pPesel;

    public Patients() {
        this.pIndex = new SimpleIntegerProperty();
        this.pId = new SimpleIntegerProperty();
        this.pSurname = new SimpleStringProperty();
        this.pName = new SimpleStringProperty();
        this.pCity = new SimpleStringProperty();
        this.pStreet = new SimpleStringProperty();
        this.pNumber = new SimpleStringProperty();
        this.pPesel = new SimpleStringProperty();
    }

    public int getpIndex() {
        return pIndex.get();
    }

    public IntegerProperty pIndexProperty() {
        return pIndex;
    }

    public void setpIndex(int pIndex) {
        this.pIndex.set(pIndex);
    }

    public String getpSurname() {
        return pSurname.get();
    }

    public StringProperty pSurnameProperty() {
        return pSurname;
    }

    public String getpName() {
        return pName.get();
    }

    public StringProperty pNameProperty() {
        return pName;
    }

    public String getpCity() {
        return pCity.get();
    }

    public StringProperty pCityProperty() {
        return pCity;
    }

    public String getpStreet() {
        return pStreet.get();
    }

    public StringProperty pStreetProperty() {
        return pStreet;
    }

    public String getpNumber() {
        return pNumber.get();
    }

    public StringProperty pNumberProperty() {
        return pNumber;
    }

    public String getpPesel() {
        return pPesel.get();
    }

    public StringProperty pPeselProperty() {
        return pPesel;
    }

    public void setpSurname(String pSurname) {
        this.pSurname.set(pSurname);
    }

    public void setpName(String pName) {
        this.pName.set(pName);
    }

    public void setpCity(String pCity) {
        this.pCity.set(pCity);
    }

    public void setpStreet(String pStreet) {
        this.pStreet.set(pStreet);
    }

    public void setpNumber(String pNumber) {
        this.pNumber.set(pNumber);
    }

    public void setpPesel(String pPesel) {
        this.pPesel.set(pPesel);
    }

    public int getpId() {
        return pId.get();
    }

    public IntegerProperty pIdProperty() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId.set(pId);
    }

}