package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {    
    private static Connection connection;    
    private static String url = "jdbc:oracle:thin:@192.168.60.15:1521:ORCL";
    private static String usuario = "OPS$RM75179";
    private static String senha = "161190";
    
    public static Connection getConnection() {
	if (connection == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(url, usuario, senha);
            } 
            catch(ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar o driver de conexão\n"+e);
            }
            catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o banco de dados\n"+e);
            }
        }        
        return connection;
    }    
}