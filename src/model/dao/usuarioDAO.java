/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Conexao.ConnectionFactory;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.usuario;



/**
 *
 * @author natan
 */
public class usuarioDAO {
    public void Insert(usuario u){
    Connection con= ConnectionFactory.ObterConexao();
        PreparedStatement stmt =null;
        try {
            stmt=(PreparedStatement) con.prepareStatement("INSERT INTO tb01_usuarios (tb01_nome,tb01_email,tb01_senha)values(?,?,?)");
            stmt.setString(1, u.getNome() );
            stmt.setString(2, u.getEmail() );
            stmt.setString(3, u.getPass() );
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Deu Ruim!! "+ex);
        } finally{
        ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
     public List<usuario> read(){
    Connection con=ConnectionFactory.ObterConexao();
    PreparedStatement stmt=null;
    ResultSet rs =null;
    
    List<usuario> produtos = new ArrayList<>();
            
            
        try {
            stmt=(PreparedStatement) con.prepareStatement("SELECT * FROM tb01_produto");
            rs=stmt.executeQuery();
            
            while (rs.next()){
               usuario p=new usuario();
               p.setCod_us(rs.getInt("tb01_cod_us"));
               p.setNome(rs.getString("tb01_nome"));
               p.setEmail(rs.getString("tb01_email"));
               p.setPass(rs.getString("tb01_senha"));
               produtos.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        ConnectionFactory.closeConnection(con, (PreparedStatement) stmt, rs);
        }
    return produtos;
    }
}
