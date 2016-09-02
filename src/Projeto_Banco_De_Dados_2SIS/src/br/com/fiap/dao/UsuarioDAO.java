package br.com.fiap.dao;

import br.com.fiap.conexao.ConnectionSingleton;
import br.com.fiap.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Pattern DAO => Data access object
 * @author rm75179
 */
public class UsuarioDAO {
    private Connection con;
    
    public boolean get(Usuario usuario){
        boolean achou = false;
        try {
            con = ConnectionSingleton.getConnection();
            String sql = "SELECT * FROM POO_USUARIO WHERE LOGIN = ? AND SENHA = ?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, usuario.getLogin());
            p.setString(2, usuario.getSenha());
            ResultSet rs = p.executeQuery();
            achou = rs.next();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuário.\n Detalhes: " + e.getMessage());
        }
        /*finally{
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar  conexão.\n Detalhes: " + ex.getMessage());
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        return achou;
    }
}
