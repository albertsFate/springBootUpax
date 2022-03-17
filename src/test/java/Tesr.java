import com.examu.upaxrest.events.request.RequestEmployee;
import com.examu.upaxrest.models.Employee;
import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tesr {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen", "root", "admin");
        JOptionPane.showMessageDialog(null, "Connection Sucefull");

        CallableStatement cs;
        EmpleadoMuestra empleadoMuestra = new EmpleadoMuestra();

        cs = connection.prepareCall("SELECT id, gender_id, job_id, name, last_name, birthdate FROM employees WHERE id = 1");
        cs.execute();

        ResultSet resultSet = cs.getResultSet();
        List<EmpleadoMuestra> list = new ArrayList<>();

        while (resultSet.next()){
            empleadoMuestra.setId(resultSet.getInt(1));
            empleadoMuestra.setGender(resultSet.getInt(2));
            empleadoMuestra.setJob(resultSet.getInt(3));
            empleadoMuestra.setName(resultSet.getString(4));
            empleadoMuestra.setLastName(resultSet.getString(5));
            empleadoMuestra.setBirthdate(resultSet.getDate(6));

            list.add(empleadoMuestra);

        }
        System.out.println(list.stream().collect(Collectors.toList()));

    }

    public static String insertEmployee(Connection connection) throws SQLException {

        CallableStatement cs;
        EmpleadoMuestra empleadoMuestra = new EmpleadoMuestra();

        cs = connection.prepareCall("SELECT id, gender_id, job_id, name, last_name, birthdate FROM employees WHERE id = 1");
        cs.execute();

        return null;
    }

}
