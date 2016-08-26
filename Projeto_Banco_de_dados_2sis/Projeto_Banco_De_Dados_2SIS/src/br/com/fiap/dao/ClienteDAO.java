/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.conexao.ConnectionSingleton;
import br.com.fiap.modelo.Cliente;
import br.com.fiap.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rm75179
 */
public class ClienteDAO {

    private Connection con;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;
    private String msg;

    public void insert(Cliente cliente) {
        try {
            con = ConnectionSingleton.getConnection();
            sql = "INSERT INTO POO_CLIENTE VALUES(?,?,?,?,?)";
            p = con.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setDate(3, cliente.getDataNascimento());
            p.setString(4, cliente.getFone());
            p.setString(5, cliente.getCaminho());
            if (!p.execute()) {
                msg = "Cliente cadastrado com sucesso!";
            } else {
                msg = " Falha ao inserir cliente!";
            }

            JOptionPane.showMessageDialog(null, msg);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir usuário.\n Detalhes: " + e.getMessage());
        }
    }

    public void update(Cliente cliente, int id) {
        try {

            con = ConnectionSingleton.getConnection();
            sql = "UPDATE POO_CLIENTE SET (NOME = ?, DATA_NASCIMENTO = ?, ENDERECO = ?, FONE = ?, CAMINHO = ?)";
            p = con.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setDate(3, cliente.getDataNascimento());
            p.setString(4, cliente.getFone());
            p.setString(5, cliente.getCaminho());
            if (p.executeUpdate() > 0) {
                msg = "Cliente atualzado com sucesso";
            } else {
                msg = "Falha ao atualizar usuário";
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário.\n  Detalhes: " + e.getMessage());
        }
    }

    public Cliente getByName(String nomeCliente) {
        Cliente cli = null;
        try {

            con = ConnectionSingleton.getConnection();
            sql = "SELECT * FROM POO_CLIENTE WHERE nome LIKE ?";
            p = con.prepareStatement(sql);
            p.setString(1, nomeCliente);
            rs = p.executeQuery();
            
            while (rs.next()) {                
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                Date nasc = rs.getDate("data_nascimento");
                String fone = rs.getString("fone");
                String caminho = rs.getString("caminho");
                cli = new Cliente(nome, endereco, nasc, fone, caminho);
            }
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuário.\n  Detalhes: " + e.getMessage());
        }
        
        return cli;
    }

}

