package przychodnia.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by adam on 04/01/2017.
 */
public class Doctors {

    public IntegerProperty dId;
    public StringProperty dSurname;
    public StringProperty dName;
    public StringProperty dSpec;
    public StringProperty dPhoneNumber;

    public Doctors() {
        this.dIndex = new SimpleIntegerProperty();
        this.dId = new SimpleIntegerProperty();
        this.dSurname = new SimpleStringProperty();
        this.dName = new SimpleStringProperty();
        this.dSpec = new SimpleStringProperty();
        this.dPhoneNumber = new SimpleStringProperty();

    }


    public int getdIndex() {
        return dIndex.get();
    }

    public IntegerProperty dIndexProperty() {
        return dIndex;
    }

    public void setdIndex(int dIndex) {
        this.dIndex.set(dIndex);
    }

    public IntegerProperty dIndex;

    public int getdId() {
        return dId.get();
    }

    public IntegerProperty dIdProperty() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId.set(dId);
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

    public String getdSpec() {
        return dSpec.get();
    }

    public StringProperty dSpecProperty() {
        return dSpec;
    }

    public void setdSpec(String dSpec) {
        this.dSpec.set(dSpec);
    }

    public String getdPhoneNumber() {
        return dPhoneNumber.get();
    }

    public StringProperty dPhoneNumberProperty() {
        return dPhoneNumber;
    }

    public void setdPhoneNumber(String dPhoneNumber) {
        this.dPhoneNumber.set(dPhoneNumber);
    }

}
