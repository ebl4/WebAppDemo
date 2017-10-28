package com.dito.app.factory;

import com.dito.app.bean.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 27/10/2017.
 */

public class ConnectionFactory {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory cf = new ConnectionFactory();
        ArrayList<Service> results = cf.readStatement("app");
        for (Service p : results){
            System.out.println(p.getDescricao());
        }
        System.out.println("Gravado");
    }

    public static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/dito";
        String user = "root", passwd = "1234";
        return DriverManager.getConnection(url, user, passwd);
    }

    public ArrayList<Service> getResultSet(ResultSet rs) throws SQLException {
        ArrayList<Service> results = new ArrayList<Service>();
        while (rs.next()){
            results.add(new Service(rs.getInt("id"),rs.getString("dname"),0));
        }
        return results;
    }

    public Service buscaPorId(Long idName){
        Connection connection = null;
        ArrayList<Service> results = new ArrayList<Service>();
        try {
            connection = createConnection();
            String sql = "SELECT id, dname FROM dito.dict WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, idName);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();

            results = getResultSet(rs);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
            return results.get(0);
        }
    }

    public ArrayList<Service> readStatement(String descricao){
        Connection connection = null;
        ArrayList<Service> results = new ArrayList<Service>();
        try {
            connection = createConnection();
            String sql = "SELECT id, dname FROM dito.dict WHERE dname LIKE ? LIMIT 5";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, descricao+"%");
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();

            results = getResultSet(rs);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
            return results;
        }
    }

    public void prepareStatement(List<String> datas) {
        Connection connection = null;
        try {
            connection = createConnection();
            String sql = "INSERT INTO dito.dict (iname) VALUES (?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            for (int i = 0; i < datas.size()-1; i++) {
                ps.setString(i+1, datas.get(i));
            }
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }
}

