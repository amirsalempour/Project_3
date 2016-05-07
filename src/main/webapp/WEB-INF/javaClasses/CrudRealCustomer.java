import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dotin school 6 on 5/4/2016.
 */
public class CrudRealCustomer{
    public static Connection getConnection() {

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/EMP";
        final String USER = "root";
        final String PASSWORD = "root";
        Connection connection = null;

        try{
            Class.forName(JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,USER,PASSWORD);
        }catch (Exception e){
            System.out.println("Exception is: "+e);
        }
return connection;
    }
    public static int insert(RealCustomerType realCustomer){
        int status=0;
        try {
            Connection connection=CrudRealCustomer.getConnection();
            PreparedStatement statement=connection.prepareStatement("insert into banking.real_customer(pesron_id,firstName,lastName,fatherName,birthDate,nationalCode)  values (?,?,?,?,?,?)");
            statement.setInt(1,realCustomer.getPersonId());
            statement.setString(2,realCustomer.getName());
            statement.setString(3,realCustomer.getLastName());
            statement.setString(4,realCustomer.getFatherName());
            statement.setDate(5, Date.valueOf(String.valueOf(realCustomer.getBirthDate())));
            statement.setString(6,realCustomer.getNationalCode());
            status=statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
public static RealCustomerType getRealCustomerById(int id){
    RealCustomerType realCustomerType=new RealCustomerType();
    return  null;
}

    public static int update(RealCustomerType realCustomer) throws SQLException {
        int status=0;
        Connection connection=CrudRealCustomer.getConnection();
        PreparedStatement statement=connection.prepareStatement("update banking.real_customer set firstName=?,lastName=?,fatherName=?,birthDate=?,nationalCode=? where person_id=?");
        statement.setString(1,realCustomer.getName());
        statement.setString(2,realCustomer.getLastName());
        statement.setString(3,realCustomer.getFatherName());
        statement.setDate(4, Date.valueOf(String.valueOf(realCustomer.getBirthDate())));
        statement.setInt(5, realCustomer.getPersonId());
        status=statement.executeUpdate();
        connection.close();
        return status;
    }
public static List<RealCustomerType> getRecords() throws SQLException {
    List<RealCustomerType> list=new ArrayList<RealCustomerType>();
    Connection connection=CrudRealCustomer.getConnection();
    RealCustomerType realCustomer=new RealCustomerType();
    String checkIf="where ";
    if (realCustomer.getBirthDate()!=null) {
        checkIf = "birthDate=" + realCustomer.getBirthDate().toString()+ " AND";
    }
    if (realCustomer.getFatherName()!=null){
            checkIf=checkIf+" fatherName like "+realCustomer.getName() +" AND ";
        }
    if (realCustomer.getLastName()!=null){
        checkIf=checkIf+realCustomer.getLastName()+"AND";
    }
    if (realCustomer.getNationalCode()!=null){
        checkIf=checkIf+" nationalCode like "+realCustomer.getNationalCode()+" AND ";
    }
if (String.valueOf(realCustomer.getPersonId()) != null){
    checkIf=checkIf+"person_id="+realCustomer.getPersonId()+" AND ";
}
    checkIf=checkIf+"1=1";

    PreparedStatement statement=connection.prepareStatement("select * from banking.real_customer "+checkIf);
    ResultSet resultSet=statement.executeQuery();
    while (resultSet.next()){
        realCustomer.setPersonId(resultSet.getInt(1));
        realCustomer.setName(resultSet.getString(2));
        realCustomer.setLastName(resultSet.getString(3));
        realCustomer.setFatherName(resultSet.getString(4));
        realCustomer.setBirthDate(resultSet.getDate(5));
        realCustomer.setNationalCode(resultSet.getString(6));
   list.add(realCustomer);
    }
    connection.close();
    return list;
}


public static int delete(int id) throws SQLException {
    int status=0;
    Connection connection=CrudRealCustomer.getConnection();

    PreparedStatement statement=connection.prepareStatement("delete from banking.real_customer where person_id=?");
    statement.setInt(1,id);

    status=statement.executeUpdate();
    connection.close();
    return status;
}




    }