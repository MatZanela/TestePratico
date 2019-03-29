/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.CEP;

/**
 *
 * @author User
 */
public class CepDao {
    public void insereCep(CEP cep){
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO cep(cep, logradouro, complemento, bairro, "
                + "localidade, uf, unidade, ibge, gia) VALUES(?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ppstt = con.prepareStatement(sql);
            ppstt.setString(1, cep.getCep());
            ppstt.setString(2, cep.getLogradouro());
            ppstt.setString(3, cep.getComplemento());
            ppstt.setString(4, cep.getBairro());
            ppstt.setString(5, cep.getLocalidade());
            ppstt.setString(6, cep.getUf());
            ppstt.setString(7, cep.getUnidade());
            ppstt.setString(8, cep.getIbge());
            ppstt.setString(9, cep.getGia());
            ppstt.executeUpdate();
            ppstt.close();
            System.out.println("Adicionado ao Banco");
        }catch(SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    //Buscar um cep passado por parametro
    public CEP buscaCep(String srcCep){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ppstt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM cep "
                + "WHERE cep = ?";
        CEP cep = null;
        try{
            ppstt = con.prepareStatement(sql);
            ppstt.setString(1, srcCep);
            rs = ppstt.executeQuery();
            if(rs.next()){
                cep = new CEP();
                cep.setCep(rs.getString("cep"));
                cep.setLogradouro(rs.getString("logradouro"));
                cep.setComplemento(rs.getString("complemento"));
                cep.setBairro(rs.getString("bairro"));
                cep.setGia(rs.getString("gia"));
                cep.setIbge(rs.getString("ibge"));
                cep.setLocalidade(rs.getString("localidade"));
                cep.setUf(rs.getString("uf"));
                cep.setUnidade(rs.getString("unidade"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                }catch(SQLException ex){}
            }
            if(ppstt != null){
                try {
                    ppstt.close();
                }catch(SQLException ex){}
            }
            if(con != null){
                try{
                    con.close();
                }catch(SQLException ex){}
            }
        }
        return cep;
    }
}
