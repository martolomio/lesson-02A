package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisitersDoa {


    private static  String READ_ALL= "select * from visiters";
    private static  String CREATE= "insert into visiters(`first_name`,`last_name`,`gender`) values (?,?,?)";
    private static  String READ_BY_ID= "select * from visiters where id =?";
    private static  String UPDATE_BY_ID= "update visiters set first_name=?, last_name=? where id=?";
    private static  String DELETE_BY_ID= "delete from visiters where id=?";

    private  Connection connection = ConnectionPool.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    public VisitersDoa(Connection connection){
        this.connection= connection;
    }

    public void insert(Visiters visiters) throws SQLException {
       preparedStatement = connection.prepareStatement(CREATE);
       preparedStatement.setString(1,visiters.getFirstName());
       preparedStatement.setString(2,visiters.getLastName());
       preparedStatement.setString(3,visiters.getGender());
       preparedStatement.executeUpdate();

    }
     public  Visiters read(int id) throws SQLException {
         preparedStatement = connection.prepareStatement(READ_BY_ID);
         preparedStatement.setInt(1, id);
         ResultSet result = preparedStatement.executeQuery();
         result.next();
         return VisitersMapper.map(result);
     }

    public void update(Visiters visiters) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        preparedStatement.setString(1, visiters.getFirstName());
        preparedStatement.setString(2, visiters.getLastName());
        preparedStatement.setInt(3, visiters.getId());
        preparedStatement.executeUpdate();
    }

    public  void delete(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
     public List<Visiters> readAll()throws SQLException {
        List<Visiters> listOfEmployee = new ArrayList<Visiters>();
         preparedStatement = connection.prepareStatement(READ_ALL);
        ResultSet result= preparedStatement.executeQuery();

        while (result.next()){
            listOfEmployee.add(VisitersMapper.map(result));
        }
        return  listOfEmployee;
     }






}
