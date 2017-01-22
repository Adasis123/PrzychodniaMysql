package przychodnia.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import przychodnia.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by adam on 21/01/2017.
 */
public class VisitsDAO {

    public static Integer row_num;


    //SELECT
    public static ObservableList<Visits> searchVisits() throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT pacjenci.pacjentImie, pacjenci.pacjentNazwisko, lekarze.lekarzNazwisko," +
                " lekarze.lekarzImie, wizyty.wizytaData, wizyty.wizytaId from wizyty join pacjenci ON wizyty.pacjentId =" +
                " pacjenci.pacjentId JOIN lekarze ON wizyty.lekarzId = lekarze.lekarzId;";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsVisits = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Visits> visitsList = getVisitsList(rsVisits);

            //Return employee object
            return visitsList;

        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //SELECT
    private static ObservableList<Visits> getVisitsList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Visits> visitsList = FXCollections.observableArrayList();
        row_num = 0;
        while (rs.next()) {
            row_num++;
            Visits vis = new Visits();
            vis.setvIndex(row_num);
            vis.setpName(rs.getString("pacjentImie"));
            vis.setpSurname(rs.getString("pacjentNazwisko"));
            vis.setdSurname(rs.getString("lekarzNazwisko"));
            vis.setdName(rs.getString("lekarzImie"));
            vis.setvDate(rs.getString("wizytaData"));
            vis.setvId(rs.getInt("wizytaId"));
            visitsList.add(vis);
           }
        return visitsList;

    }

    public static void deleteVisit(Integer vId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt = "DELETE FROM wizyty\n" +
                "WHERE wizytaId =" + vId + ";";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

}

