package Services;

import Entities.Cours;
import Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCours implements IService<Cours> {

    private Connection con1 = DataSource.getInstance().getCon();
    private Statement ste;


    public ServiceCours() {

        try {
            ste = con1.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void ajouter(Cours cours) throws SQLException {
        String req = "INSERT INTO `Cours` (`titre`, `description`, `format`, `enseignantId`) VALUES ('" + cours.getTitre() + "', '" + cours.getDescription() + "', '" + cours.getFormat() + "', '" + cours.getEnseignantId() + "');";
        ste.executeUpdate(req);
        ste.close(); // Close the Statement
        con1.close(); // Close the Connection
    }



    @Override
     public void supprimer(Cours cours) throws SQLException {
            String req = "DELETE FROM `Cours` WHERE `CoursId` = " + cours.getCoursId();
            ste.executeUpdate(req);
            ste.close(); // Close the Statement
            con1.close(); // Close the Connection
        }


    @Override
    public void update(Cours cours) throws SQLException {
            String req = "UPDATE `Cours` SET `titre` = '" + cours.getTitre() + "', `description` = '" + cours.getDescription() + "', `format` = '" + cours.getFormat() + "', `enseignantId` = '" + cours.getEnseignantId() + "' WHERE `id` = " + cours.getCoursId(); // Assuming id is the primary key of your Cours table
            ste.executeUpdate(req);
            ste.close(); // Close the Statement
            con1.close(); // Close the Connection



    }

    @Override
    public Cours findbyId(int e) throws SQLException {
        return null;
    }

    @Override
    public List<Cours> readAll() throws SQLException {
        return List.of();
    }
}
