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
 * Created by adam on 19/01/2017.
 */
public class DoctorsDAO {

        public static Integer row_number;


        //SELECT
        public static ObservableList<Doctors> searchDoctors() throws SQLException, ClassNotFoundException {

            String selectStmt = "SELECT * FROM lekarze";

            //Execute SELECT statement
            try {
                //Get ResultSet from dbExecuteQuery method
                ResultSet rsDoctors = DBUtil.dbExecuteQuery(selectStmt);

                //Send ResultSet to the getEmployeeList method and get employee object
                ObservableList<Doctors> doctorsList = getDoctorsList(rsDoctors);

                //Return employee object
                return doctorsList;
            } catch (SQLException e) {
                System.out.println("SQL select operation has been failed: " + e);
                //Return exception
                throw e;
            }
        }

        //SELECT
        private static ObservableList<Doctors> getDoctorsList(ResultSet rs) throws SQLException, ClassNotFoundException {
            //Declare a observable List which comprises of Employee objects
            ObservableList<Doctors> doctorLists = FXCollections.observableArrayList();
            row_number = 0;
            while (rs.next()) {
                row_number++;
                Doctors doc = new Doctors();
                doc.setdIndex(row_number);
                doc.setdId(rs.getInt("lekarzId"));
                doc.setdSurname(rs.getString("lekarzNazwisko"));
                doc.setdName(rs.getString("lekarzImie"));
                doc.setdSpec(rs.getString("lekarzSpec"));
                doc.setdPhoneNumber(rs.getString("lekarzTelefon"));
                //Add employee to the ObservableList
                doctorLists.add(doc);
            }
            //return empList (ObservableList of Employees)
            return doctorLists;
        }

        //SELECT
        public static ObservableList<Doctors> searchDoctors(String dSurname, String dName, String dSpec, String dPhone) throws SQLException, ClassNotFoundException {
            boolean isQueryvalid = false;
            PreparedStatement ps = null;
            List<String> bindVariables = new ArrayList<>();
            StringBuilder query = new StringBuilder(
                    "SELECT * FROM lekarze WHERE ");

            if (dSurname.length() > 0) {
                query.append("lekarzNazwisko='").append(dSurname).append("'");
                isQueryvalid = true;

            }
            if (dName.length() > 0 && isQueryvalid) {
                query.append("AND lekarzImie='").append(dName).append("'");
            } else {
                if (dName.length() > 0) {
                    query.append("lekarzImie='").append(dName).append("'");
                    isQueryvalid = true;
                }
            }
            if (dSpec.length() > 0 && isQueryvalid) {
                query.append("AND lekarzSpec='").append(dSpec).append("'");
            } else {
                if (dSpec.length() > 0) {
                    query.append("lekarzSpec='").append(dSpec).append("'");
                    isQueryvalid = true;
                }
            }

            if (dPhone.length() > 0 && isQueryvalid) {
                query.append("AND lekarzTelefon='").append(dPhone).append("'");
            } else {
                if (dPhone.length() > 0) {
                    query.append("lekarzTelfon='").append(dPhone).append("'");
                }
            }

            try {
                //Get ResultSet from dbExecuteQuery method
                ResultSet rsDoctor = DBUtil.dbExecuteQuery(query.toString());

                //Send ResultSet to the getEmployeeList method and get employee object
                ObservableList<Doctors> doctorsList = getDoctorsList(rsDoctor);

                //Return employee object
                return doctorsList;
            } catch (SQLException e) {
                System.out.println("SQL select operation has been failed: " + e);
                //Return exception
                throw e;
            }
        }

        //SELECT
        private static ObservableList<Doctors> getDoctorList(ResultSet rs) throws SQLException, ClassNotFoundException {
            //Declare a observable List which comprises of Employee objects
            ObservableList<Doctors> doctorList = FXCollections.observableArrayList();
            row_number = 0;
            while (rs.next()) {
                row_number++;
                Doctors doc = new Doctors();
                doc.setdIndex(row_number);
                doc.setdId(rs.getInt("lekarzId"));
                doc.setdSurname(rs.getString("lekarzNazwisko"));
                doc.setdName(rs.getString("lekarzImie"));
                doc.setdSpec(rs.getString("lekarzSpec"));
                doc.setdPhoneNumber(rs.getString("lekarzTelefon"));
                //Add employee to the ObservableList
                doctorList.add(doc);
            }
            //return empList (ObservableList of Employees)
            return doctorList;
        }


        //INSERT
        public static void insertDoctor(String dSurname, String dName, String dSpec, String dPhone) throws SQLException, ClassNotFoundException {
            //Declare a DELETE statement
            String updateStmt = "INSERT INTO lekarze " +
                    "(lekarzNazwisko, lekarzImie, lekarzSpec, lekarzTelefon)" +
                    " VALUES ('" + dSurname + "', '" + dName + "', '" + dSpec + "', '" + dPhone + "')";
            //Execute DELETE operation
            try {
                DBUtil.dbExecuteUpdate(updateStmt);
            } catch (SQLException e) {
                System.out.print("Error occurred while DELETE Operation: " + e);
                throw e;
            }
        }


        public static void deleteDoctor(Integer dId) throws SQLException, ClassNotFoundException {
            //Declare a DELETE statement
            String updateStmt = "DELETE FROM lekarze\n" +
                    "WHERE lekarzId =" + dId + ";";

            try {
                DBUtil.dbExecuteUpdate(updateStmt);
            } catch (SQLException e) {
                System.out.print("Error occurred while DELETE Operation: " + e);
                throw e;
            }
        }

        //*************************************
        //UPDATE 
        //*************************************
        public static void updateDoctor(Integer dId, String dSurname, String dName, String dSpec, String dPhone) throws SQLException, ClassNotFoundException {
            //Declare a UPDATE statement
            String updateStmt = "UPDATE lekarze\n" +
                    "SET lekarzNazwisko = '" + dSurname + "',\n" +
                    "lekarzImie = '" + dName + "',\n" +
                    "lekarzSpec = '" + dSpec + "',\n" +
                    "lekarzTelefon = '" + dPhone + "'\n" +
                    "WHERE lekarzId = " + dId + ";";
            //Execute UPDATE operation
            System.out.println(updateStmt);
            try {
                DBUtil.dbExecuteUpdate(updateStmt);
            } catch (SQLException e) {
                System.out.print("Error occurred while UPDATE Operation: " + e);
                throw e;
            }
        }

    }


