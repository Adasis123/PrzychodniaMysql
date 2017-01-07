package przychodnia.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import przychodnia.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by adam on 06/01/2017.
 */
public class PatientsDAO {

    //*******************************
    //SELECT Employees
    //*******************************
    public static ObservableList<Patients> searchPatients () throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM pacjenci";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsPatients = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Patients> patientsList = getPatientsList(rsPatients);

            //Return employee object
            return patientsList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<Patients> getPatientsList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Patients> patientsList = FXCollections.observableArrayList();

        while (rs.next()) {
            Patients pat = new Patients();
            pat.setpId(rs.getInt("pacjentId"));
            pat.setpSurname(rs.getString("pacjentNazwisko"));
            pat.setpName(rs.getString("pacjentImie"));
            pat.setpCity(rs.getString("pacjentMiasto"));
            pat.setpStreet(rs.getString("pacjentUlica"));
            pat.setpNumber(rs.getString("pacjentNumer"));
            pat.setpPesel(rs.getString("pacjentPesel"));
            //Add employee to the ObservableList
            patientsList.add(pat);
        }
        //return empList (ObservableList of Employees)
        return patientsList;
    }

}
