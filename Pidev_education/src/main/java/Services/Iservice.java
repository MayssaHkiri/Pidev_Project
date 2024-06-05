package Services;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Iservice <T>{
     Boolean add(T obj ) throws SQLException;
     Boolean delete(T obj ) throws SQLException ;
     Boolean update(T obj ) throws SQLException;
     ArrayList<T> readAll ()  throws SQLException ;

}
