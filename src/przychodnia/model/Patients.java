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
    public StringProperty pZipCode;
    public StringProperty pStreet;
    public StringProperty pNumber;
    public StringProperty pPesel;

    public Patients() {
        this.pIndex = new SimpleIntegerProperty();
        this.pId = new SimpleIntegerProperty();
        this.pSurname = new SimpleStringProperty();
        this.pName = new SimpleStringProperty();
        this.pCity = new SimpleStringProperty();
        this.pZipCode = new SimpleStringProperty();
        this.pStreet = new SimpleStringProperty();
        this.pNumber = new SimpleStringProperty();
        this.pPesel = new SimpleStringProperty();
    }

    public String getpZipCode() {
        return pZipCode.get();
    }

    public void setpZipCode(String pZipCode) {
        this.pZipCode.set(pZipCode);
    }

    public StringProperty pZipCodeProperty() {
        return pZipCode;
    }

    public int getpIndex() {
        return pIndex.get();
    }

    public void setpIndex(int pIndex) {
        this.pIndex.set(pIndex);
    }

    public IntegerProperty pIndexProperty() {
        return pIndex;
    }

    public String getpSurname() {
        return pSurname.get();
    }

    public void setpSurname(String pSurname) {
        this.pSurname.set(pSurname);
    }

    public StringProperty pSurnameProperty() {
        return pSurname;
    }

    public String getpName() {
        return pName.get();
    }

    public void setpName(String pName) {
        this.pName.set(pName);
    }

    public StringProperty pNameProperty() {
        return pName;
    }

    public String getpCity() {
        return pCity.get();
    }

    public void setpCity(String pCity) {
        this.pCity.set(pCity);
    }

    public StringProperty pCityProperty() {
        return pCity;
    }

    public String getpStreet() {
        return pStreet.get();
    }

    public void setpStreet(String pStreet) {
        this.pStreet.set(pStreet);
    }

    public StringProperty pStreetProperty() {
        return pStreet;
    }

    public String getpNumber() {
        return pNumber.get();
    }

    public void setpNumber(String pNumber) {
        this.pNumber.set(pNumber);
    }

    public StringProperty pNumberProperty() {
        return pNumber;
    }

    public String getpPesel() {
        return pPesel.get();
    }

    public void setpPesel(String pPesel) {
        this.pPesel.set(pPesel);
    }

    public StringProperty pPeselProperty() {
        return pPesel;
    }

    public int getpId() {
        return pId.get();
    }

    public void setpId(int pId) {
        this.pId.set(pId);
    }

    public IntegerProperty pIdProperty() {
        return pId;
    }

}