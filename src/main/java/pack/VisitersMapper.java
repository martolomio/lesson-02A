package pack;

import java.sql.ResultSet;
import java.sql.SQLException;


public class VisitersMapper {

    public  static Visiters map(ResultSet results) throws SQLException {
        int id =results.getInt("id");
        String firstName = results.getString("first_name");
        String lastName = results.getString("last_name");
        String gender = results.getString("gender");

        return new Visiters(id, firstName, lastName, gender);

    }
}
