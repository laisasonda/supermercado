/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Supermercado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tela.manutencao.ManutencaoSupermercado;

/**
 *
 * @author Laisa
 */
public class DaoSupermercado {
    
    public static boolean inserir(Supermercado objeto) {
        String sql = "INSERT INTO pais (nomefantasia, razaosocial, fundacao, nrfuncionarios, valorbolsa) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getRazaosocial());
            ps.setString(2, objeto.getNomefantasia());
           ps.setDate(3, Date.valueOf(objeto.getFundacao()));
           ps.setInt(4, objeto.getCodigo());
           ps.setDouble(5, objeto.getValorbolsa());
           
           
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Supermercado objeto = new Supermercado();
        objeto.setNomefantasia("Super util");
        objeto.setRazaosocial("supermercado");
        objeto.setFundacao(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setNrfuncionarios(15);
        objeto.setValorbolsa(1.50);
       
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
      public static boolean alterar(Supermercado objeto) {
        String sql = "UPDATE supermercado SET nomefantasia = ?, razaosocial = ?, fundacao = ?, nrfuncionarios = ?, valorbolsa = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getRazaosocial());
            ps.setString(2, objeto.getNomefantasia());
            ps.setDate(3, Date.valueOf(objeto.getFundacao()));
            ps.setInt(4, objeto.getCodigo());
            ps.setDouble(5, objeto.getValorbolsa());
            ps.setInt(6, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       public static boolean excluir(Supermercado objeto) {
        String sql = "DELETE FROM supermercado WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       
       public static List<Supermercado> consultar() {
        List<Supermercado> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nomefantasia, razasocial, fundacao, nrfuncionarios, valorbolsa FROM supermercado";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Supermercado objeto = new Supermercado();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNomefantasia(rs.getString("nome"));
                objeto.setRazaosocial(rs.getString("razaosocial"));
                objeto.setFundacao(rs.getDate("fundacao").toLocalDate());
                objeto.setNrfuncionarios(rs.getInt("nrfuncionarios"));
                objeto.setValorbolsa(rs.getDouble("valorblosa"));
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
}
        public static Supermercado consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nomefantasia, razaosocial, fundacao, nrfuncionarios, valorbolsa FROM supermercado WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Supermercado objeto = new Supermercado();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNomefantasia(rs.getString("nome"));
                objeto.setRazaosocial(rs.getString("razaosocial"));
                objeto.setFundacao(rs.getDate("fundacao").toLocalDate());
                objeto.setNrfuncionarios(rs.getInt("nrfuncionarios"));
                objeto.setValorbolsa(rs.getDouble("valorblosa"));
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
        }
}
