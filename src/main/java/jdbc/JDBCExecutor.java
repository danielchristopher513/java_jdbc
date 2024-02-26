package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {


    public static void main(String... args){

        DatabaseConnectionManager dcm= new DatabaseConnectionManager("localhost"
                ,"postgres","postgres","");

        try {
            Connection connection= dcm.getConnection();
            CustomerDAO customerDAO=new CustomerDAO(connection);
            //update Data from Database
            Customer customer=customerDAO.findById(100);
            System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());
            customer.setEmail("update it yet");
            customer=customerDAO.update(customer);
            System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());




        }catch (SQLException e){

            e.printStackTrace();

        }
    }
}
