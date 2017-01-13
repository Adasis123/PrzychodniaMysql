package przychodnia.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import przychodnia.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 06/01/2017.
 */
public class PatientsDAO {

    public static Integer row_number;


    //SELECT
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

    //SELECT
    private static ObservableList<Patients> getPatientsList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Patients> patientsList = FXCollections.observableArrayList();
        row_number = 0;
        while (rs.next()) {
            row_number ++;
            Patients pat = new Patients();
            pat.setpIndex(row_number);
            pat.setpId(rs.getInt("pacjentId"));
            pat.setpSurname(rs.getString("pacjentNazwisko"));
            pat.setpName(rs.getString("pacjentImie"));
            pat.setpCity(rs.getString("pacjentMiasto"));
            pat.setpZipCode(rs.getString("pacjentKodPocztowy"));
            pat.setpStreet(rs.getString("pacjentUlica"));
            pat.setpNumber(rs.getString("pacjentNumer"));
            pat.setpPesel(rs.getString("pacjentPesel"));
            //Add employee to the ObservableList
            patientsList.add(pat);
        }
        //return empList (ObservableList of Employees)
        return patientsList;
    }

    //SELECT
    public static ObservableList<Patients> searchPatient (String pSurname, String pName, String pCity, String pStreet, String pPesel) throws SQLException, ClassNotFoundException {
        boolean isQueryvalid = false;
        PreparedStatement ps = null;
        List<String> bindVariables = new ArrayList<>();
        StringBuilder query = new StringBuilder(
                "SELECT * FROM pacjenci WHERE ");

        if (pSurname.length() > 0) {
            query.append("pacjentNazwisko='").append(pSurname).append("'");
            isQueryvalid = true;

        }
        if (pName.length() > 0 && isQueryvalid) {
            query.append("AND pacjentImie='").append(pName).append("'");
        }
        else {
            if(pName.length() > 0){
                query.append("pacjentImie='").append(pName).append("'");
                isQueryvalid = true;
            }
        }
        if (pCity.length() > 0 && isQueryvalid) {
            query.append("AND pacjentMiasto='").append(pCity).append("'");
        }
        else {
            if(pCity.length() > 0){
                query.append("pacjentMiasto='").append(pCity).append("'");
                isQueryvalid = true;
            }
        }

        if (pStreet.length() > 0 && isQueryvalid) {
            query.append("AND pacjentUlica='").append(pStreet).append("'");
        }
        else {
            if(pStreet.length() > 0){
                query.append("pacjentUlica='").append(pStreet).append("'");
            }
        }

        if (pPesel.length() > 0 && isQueryvalid) {
            query.append("AND pacjentPesel='").append(pPesel).append("'");
        }
        else {
            if(pPesel.length() > 0){
                query.append("pacjentPesel='").append(pPesel).append("'");
            }
        }

        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsPatient = DBUtil.dbExecuteQuery(query.toString());

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Patients> patientsList = getPatientsList(rsPatient);

            //Return employee object
            return patientsList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //SELECT
    private static ObservableList<Patients> getPatientList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Patients> patientList = FXCollections.observableArrayList();
        row_number = 0;
        while (rs.next()) {
            row_number ++;
            Patients pat = new Patients();
            pat.setpIndex(row_number);
            pat.setpId(rs.getInt("pacjentId"));
            pat.setpSurname(rs.getString("pacjentNazwisko"));
            pat.setpName(rs.getString("pacjentImie"));
            pat.setpCity(rs.getString("pacjentMiasto"));
            pat.setpZipCode(rs.getString("pacjentKodPocztowy"));
            pat.setpStreet(rs.getString("pacjentUlica"));
            pat.setpNumber(rs.getString("pacjentNumer"));
            pat.setpPesel(rs.getString("pacjentPesel"));
            //Add employee to the ObservableList
            patientList.add(pat);
        }
        //return empList (ObservableList of Employees)
        return patientList;
    }


    //INSERT
    public static void insertPatient (String pSurname, String pName, String pCity, String pZipCode, String pStreet, String pNumber, String pPesel) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt = "INSERT INTO pacjenci " +
                "(pacjentNazwisko, pacjentImie, pacjentMiasto, pacjentKodPocztowy, pacjentUlica, pacjentNumer, pacjentPesel)" +
                " VALUES ('"+pSurname+"', '"+pName+"', '"+pCity+"', '"+pZipCode+"', '"+
                " "+pStreet+"', '"+pNumber+"', '"+pPesel+"')";
        //Execute DELETE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }


    public static void deletePatient (Integer pId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt = "DELETE FROM pacjenci\n" +
                            "WHERE pacjentId ="+pId+";";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //UPDATE an employee's email address
    //*************************************
    public static void updatePatient (Integer pId, String pSurname, String pName, String pCity, String pZipCode, String pStreet, String pNumber, String pPesel) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt = "UPDATE pacjenci\n" +
                        "SET pacjentNazwisko = '"+pSurname+"',\n" +
                        "pacjentImie = '"+pName+"',\n" +
                        "pacjentMiasto = '"+pCity+"',\n" +
                        "pacjentKodPocztowy = '"+pZipCode+"',\n" +
                        "pacjentUlica = '"+pStreet+"',\n" +
                        "pacjentNumer = '"+pNumber+"',\n" +
                        "pacjentPesel = '"+pPesel+"'\n" +
                        "WHERE pacjentId = "+pId+";";
        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

}
