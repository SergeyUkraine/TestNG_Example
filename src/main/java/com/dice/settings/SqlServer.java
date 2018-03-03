package com.dice.settings;

import java.sql.*;

public class SqlServer {

    private String dbUrl = "jdbc:sqlserver://11.45.111.56";
    private String username = "sb";
    private String password = "R0dth88!";

    private String userId = "";
    private String result = "";

    public static String getFirstName = "SELECT dbo.UserProfile.FirstName " +
            "FROM dbo.UserProfile " +
            "INNER JOIN dbo.ListOfUsers ON dbo.UserProfile.UserId = dbo.ListOfUsers.Id " +
            "WHERE dbo.ListOfUsers.Email = ";

    public static String getLastName = "SELECT dbo.UserProfile.LastName " +
            "FROM dbo.UserProfile " +
            "INNER JOIN dbo.ListOfUsers ON dbo.UserProfile.UserId = dbo.ListOfUsers.Id " +
            "WHERE dbo.ListOfUsers.Email = ";

    public String connectionToDatabase(String request, String email){
        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(request + "'" + email + "'");
            while (rs.next()){
                result = rs.getString(1);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteUserFromDatabase(String email){

        try {
            Connection con = DriverManager.getConnection(dbUrl,username,password);
            Statement stmt = con.createStatement();

            String queryToListOfUsers = "select * from dbo.ListOfUsers where Email = '" + email + "'";
            ResultSet rs = stmt.executeQuery(queryToListOfUsers);
            while (rs.next()){
                userId = rs.getString(1);
            }

            String deleteFromUserProfile = "delete from dbo.UserProfile where UserId = '" + userId + "'";
            stmt.execute(deleteFromUserProfile);

            String deleteFromListOfUsers = "delete from dbo.ListOfUsers where Email = '" + email + "'";
            stmt.execute(deleteFromListOfUsers);

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

}
