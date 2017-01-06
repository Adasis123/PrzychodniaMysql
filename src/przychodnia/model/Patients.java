package przychodnia.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by adam on 04/01/2017.
 */
public class Patients {

    private IntegerProperty pacjentId;
    private StringProperty pacjentNazwisko;
    private StringProperty pacjentImie;
    private StringProperty pacjentMiasto;
    private StringProperty pacjentUlica;
    private StringProperty pacjentNumer;
    private StringProperty pacjentPesel;


    public Patients() {

        this.pacjentId = new SimpleIntegerProperty();
        this.pacjentNazwisko = new SimpleStringProperty();
        this.pacjentImie = new SimpleStringProperty();
        this.pacjentMiasto = new SimpleStringProperty();
        this.pacjentUlica = new SimpleStringProperty();
        this.pacjentNumer = new SimpleStringProperty();
        this.pacjentPesel = new SimpleStringProperty();

    }

    public void setPacjentId(int pacjentId) {
        this.pacjentId.set(pacjentId);
    }

    public void setPacjentNazwisko(String pacjentNazwisko) {
        this.pacjentNazwisko.set(pacjentNazwisko);
    }

    public void setPacjentImie(String pacjentImie) {
        this.pacjentImie.set(pacjentImie);
    }

    public void setPacjentMiasto(String pacjentMiasto) {
        this.pacjentMiasto.set(pacjentMiasto);
    }

    public void setPacjentUlica(String pacjentUlica) {
        this.pacjentUlica.set(pacjentUlica);
    }

    public void setPacjentNumer(String pacjentNumer) {
        this.pacjentNumer.set(pacjentNumer);
    }

    public void setPacjentPesel(String pacjentPesel) {
        this.pacjentPesel.set(pacjentPesel);
    }

    public int getPacjentId() {
        return pacjentId.get();
    }

    public IntegerProperty pacjentIdProperty() {
        return pacjentId;
    }

    public String getPacjentNazwisko() {
        return pacjentNazwisko.get();
    }

    public StringProperty pacjentNazwiskoProperty() {
        return pacjentNazwisko;
    }

    public String getPacjentImie() {
        return pacjentImie.get();
    }

    public StringProperty pacjentImieProperty() {
        return pacjentImie;
    }

    public String getPacjentMiasto() {
        return pacjentMiasto.get();
    }

    public StringProperty pacjentMiastoProperty() {
        return pacjentMiasto;
    }

    public String getPacjentUlica() {
        return pacjentUlica.get();
    }

    public StringProperty pacjentUlicaProperty() {
        return pacjentUlica;
    }

    public String getPacjentNumer() {
        return pacjentNumer.get();
    }

    public StringProperty pacjentNumerProperty() {
        return pacjentNumer;
    }

    public String getPacjentPesel() {
        return pacjentPesel.get();
    }

    public StringProperty pacjentPeselProperty() {
        return pacjentPesel;
    }

}
