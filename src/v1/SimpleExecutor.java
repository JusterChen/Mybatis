package v1;

import java.sql.*;

/**
 * @Author: JiangChen
 * @Description:
 * @Date 2018/5/5 15:57
 */
public class SimpleExecutor implements Executor{

    @Override
    public <T> T query(String statement, String parameter) {
        Connection connection = null;
        Test test = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/big-mac?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "admin", "jc201393");
            String sql = String.format(statement, Integer.valueOf(parameter));
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                test = new Test();
                test.setId(resultSet.getInt(1));
                test.setName(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T)test;
    }
}
