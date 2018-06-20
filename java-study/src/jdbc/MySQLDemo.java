package jdbc;

import java.sql.*;

public class MySQLDemo {
	
	//JDBC驱动名及数据库URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	
	//数据库用户名密码
	static final String USER = "root";
    static final String PASS = "123456";
    
    public static void main(String[] args){
    	Connection connection = null;
    	Statement statement = null;
    	
    	try {
			//注册JDBC驱动
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		//打开连接
    		System.out.println("连接数据库。。。");
    		connection = DriverManager.getConnection(DB_URL,USER,PASS);
    		
    		//执行查询
    		System.out.println("实例化Statement对象...");
    		statement = connection.createStatement();
    		String sql;
    		sql = "SELECT id, name, url FROM websites";
    		ResultSet rsSet = statement.executeQuery(sql);
    		
    		//展开结果集
    		while(rsSet.next()){
    			//通过字段检索
    			int id = rsSet.getInt("id");
    			String name = rsSet.getString("name");
    			String url = rsSet.getString("url");
    			
    			// 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");

    		}
    		//完成后关闭连接
    		rsSet.close();
    		statement.close();
    		connection.close();
		} catch (SQLException e) { //处理 JDBC 错误
			e.printStackTrace();
		} catch (Exception e) {  // 处理 Class.forName 错误
			e.printStackTrace();
		} finally{
            // 关闭资源
            try{
                if(statement!=null) statement.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(connection!=null) connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    	System.out.println("Goodbye!");
    }
	
	
	
}















