package przychodnia.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by adam on 04/01/2017.
 */
public class Visits {

    public IntegerProperty vIndex;
    public IntegerProperty vId;
    public StringProperty pSurname;
    public StringProperty pName;
    public StringProperty dSurname;
    public StringProperty dName;
    public StringProperty vDate;

    public Visits(){

        this.dName = new SimpleStringProperty();
        this.dSurname = new SimpleStringProperty();
        this.pName = new SimpleStringProperty();
        this.pSurname = new SimpleStringProperty();
        this.vId = new SimpleIntegerProperty();
        this.vIndex = new SimpleIntegerProperty();
        this.vDate = new SimpleStringProperty();

    }


    public int getvIndex() {
        return vIndex.get();
    }

    public IntegerProperty vIndexProperty() {
        return vIndex;
    }

    public void setvIndex(int vIndex) {
        this.vIndex.set(vIndex);
    }

    public int getvId() {
        return vId.get();
    }

    public IntegerProperty vIdProperty() {
        return vId;
    }

    public void setvId(int vId) {
        this.vId.set(vId);
    }

    public String getpSurname() {
        return pSurname.get();
    }

    public StringProperty pSurnameProperty() {
        return pSurname;
    }

    public void setpSurname(String pSurname) {
        this.pSurname.set(pSurname);
    }

    public String getpName() {
        return pName.get();
    }

    public StringProperty pNameProperty() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName.set(pName);
    }

    public String getdSurname() {
        return dSurname.get();
    }

    public StringProperty dSurnameProperty() {
        return dSurname;
    }

    public void setdSurname(String dSurname) {
        this.dSurname.set(dSurname);
    }

    public String getdName() {
        return dName.get();
    }

    public StringProperty dNameProperty() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName.set(dName);
    }

    public String getvDate() {
        return vDate.get();
    }

    public StringProperty vDateProperty() {
        return vDate;
    }

    public void setvDate(String vDate) {
        this.vDate.set(vDate);
    }

}
