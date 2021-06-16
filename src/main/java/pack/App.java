package pack;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main( String[] args ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, InvocationTargetException, NoSuchMethodException {

        VisitersDoa visitersDoa =new VisitersDoa(ConnetionUtil.openConnection());

       //read all
        visitersDoa.readAll().forEach( System.out::println);
        System.out.println("----------------------------------------------\n");

        List<Visiters> listOfVisiters = new ArrayList<Visiters>();
        listOfVisiters.add(new Visiters("Bob", "Brown", "male"));
        listOfVisiters.add(new Visiters("Karl", "Ret", "male"));
        listOfVisiters.add(new Visiters("Pita", "King", "male"));
        listOfVisiters.add(new Visiters("Opa", "Anderson", "female"));
        listOfVisiters.add(new Visiters("Mica", "Mela", "female"));


        //insert
        listOfVisiters.forEach(visiters -> {
        try {
            visitersDoa.insert(visiters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        });


            //read all
        visitersDoa.readAll().forEach( System.out::println);
        System.out.println("----------------------------------------------\n");

            // read by id
//            Visiters visitersFromdb;
//            visitersFromdb = visitersDoa.read(2);
//            System.out.println(visitersFromdb);

            //update by id
//        visitersFromdb.setLastName(visitersFromdb.getLastName()+"-Moritosi");
//        visitersDoa.update(visitersFromdb);

            //read all
//            visitersDoa.readAll().forEach(System.out::println);
//            System.out.println("----------------------------------------------\n");

//            visitersDoa.delete(6);

            //read all
//            visitersDoa.readAll().forEach(System.out::println);
//            System.out.println("----------------------------------------------\n");


        }
    }
