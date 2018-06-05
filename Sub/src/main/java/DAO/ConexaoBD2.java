package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD2{ 

public static String status = "Não conectou...";
      public ConexaoBD2() {
  }
      
public static java.sql.Connection getConexaoMySQL() {
      Connection connection = null;
try {
String driverName = "com.mysql.cj.jdbc.Driver";
Class.forName(driverName);
          String serverName = "localhost";
          String mydatabase ="bank2";
          String port ="3306";
          String aux = "?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
          String url = "jdbc:mysql://"+serverName+":"+port +"/" +mydatabase+aux;
          String username = "root";      
          String password = "root";
          connection = DriverManager.getConnection(url, username, password);

          if (connection != null) {
              status = ("STATUS--->Conectado com sucesso!");
          } else {
              status = ("STATUS--->Não foi possivel realizar conexão");
          }
          return connection;
      } catch (ClassNotFoundException e) {
    	  
          System.out.println("O driver expecificado nao foi encontrado.");
          return null;
      } catch (SQLException e) {
          System.out.println("Nao foi possivel conectar ao Banco de Dados.");
          return null;
      }
  }

  public static String statusConection() {
      return status;
  }

public static boolean FecharConexao() {
      try {
    	  ConexaoBD1.getConexaoMySQL().close();
          return true;
      } catch (SQLException e) {
          return false;
      }
  } 

public static java.sql.Connection ReiniciarConexao() {
      FecharConexao();
      return ConexaoBD1.getConexaoMySQL();
  }
}