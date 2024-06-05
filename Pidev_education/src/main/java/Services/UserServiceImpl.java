package Services;

import Entities.User;
import Utils.DataSource;

import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;

public class UserServiceImpl implements Iservice<User>{


    private Connection cnx= DataSource.getInstance().getCon();
    private Statement ste;

    public UserServiceImpl() {
        try {
            ste=cnx.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private String generateRandomPassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);


        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    @Override
    public Boolean add(User u) throws SQLException {
        String req = "INSERT INTO user "
                + "( nom, prenom, email, mdp, role)\r\n"
                + "VALUES ( ?, ?, ?, ?, ?)";
        PreparedStatement pst = cnx.prepareStatement(req);
        try {
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setString(3 , u.getEmail()) ;
            pst.setString(4 , u.getPassword()) ;
            pst.setString(5 , u.getRole()) ;
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Ajout réussi");
                return true;
            } else  {
                System.out.println("Échec de l'ajout");
                return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
      return false ;
    }

    @Override
    public Boolean delete(User obj) throws SQLException {
        return null;
    }

    public Boolean deleteById (int id) throws SQLException {
        String req = "DELETE FROM user WHERE id = ?";
        PreparedStatement st = cnx.prepareStatement(req);
        try {
            st.setInt(1, id);

            int deletedRows = st.executeUpdate();
            return deletedRows > 0; // Return true if at least one row was deleted
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false on SQL error
        } finally {
            st.close(); // Close the PreparedStatement
        }
    }

    @Override
    public Boolean update(User U) throws SQLException {
        int er = 0;

        System.out.println(U.getId());
        String req = "UPDATE user "
                + "SET nom='" + U.getNom() + "', "
                + "prenom='" + U.getPrenom()+ "', "
                + "email='" + U.getEmail() + "', "
                + "WHERE id=" + U.getId() + "";
        Statement st;

        try {
            st = cnx.createStatement();
            er = st.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return er != 0;
    }

    @Override
    public ArrayList<User> readAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();

        String req = "SELECT u.id, u.nom, u.prenom, u.email, u.role FROM user u";
        Statement st;
        try {
            ResultSet res = ste.executeQuery(req);
            while (res.next()) {
                User user = new User();
                user.setId(res.getInt("id"));
                user.setNom(res.getString("nom"));
                user.setPrenom(res.getString("prenom"));
                user.setEmail(res.getString("email"));
                user.setRole(res.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
