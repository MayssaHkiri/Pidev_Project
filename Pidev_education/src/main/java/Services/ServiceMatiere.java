package Services;

import Entities.Matiere;

import java.sql.SQLException;
import java.util.List;

public class ServiceMatiere implements  IService<Matiere> {
    @Override
    public void ajouter(Matiere matiere) throws SQLException {

    }

    @Override
    public void supprimer(Matiere matiere) throws SQLException {

    }

    @Override
    public void update(Matiere matiere) throws SQLException {

    }

    @Override
    public Matiere findbyId(int e) throws SQLException {
        return null;
    }

    @Override
    public List<Matiere> readAll() throws SQLException {
        return List.of();
    }
}
