package com.example.demo2.dao;

import com.example.demo2.entity.Address;
import com.example.demo2.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {
    public List<Address> findAll() {
        ArrayList<Address> list = new ArrayList<>();


        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from address");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getInt(1));
                address.setName(resultSet.getString(2));
                address.setStreet(resultSet.getString(3));
                address.setCity(resultSet.getString(4));
                address.setState(resultSet.getString(5));
                address.setZip(resultSet.getString(6));
                list.add(address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void delete(String id) {
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("delete from address where id = " + id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Address findById(String id) {

        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select * from address where id = " + id);
            ResultSet resultSet = pstmt.executeQuery();
            Address address = new Address();

            while (resultSet.next()) {
                address.setId(resultSet.getInt(1));
                address.setName(resultSet.getString(2));
                address.setStreet(resultSet.getString(3));
                address.setCity(resultSet.getString(4));
                address.setState(resultSet.getString(5));
                address.setZip(resultSet.getString(6));
            }
            return address;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void add(Address address) {
        int maxId = 0;
        System.out.println("2222222");
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("select  MAx(id) from address");
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                maxId = resultSet.getInt(1);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        maxId += 1;
        try {

            Connection connection = JdbcUtil.getConnection();

            PreparedStatement pstmt = connection.prepareStatement("insert into address(id, name, street, city, state, zip) " +
                    "values(" + maxId + "," + address.getName() + "," + address.getStreet() + "," + address.getCity() + ","
                    + address.getState() + "," + address.getZip() + ")");

            System.out.println("insert into address(id, name, street, city, state, zip) " +
                    "values(" + maxId + "," + address.getName() + "," + address.getStreet() + "," + address.getCity() + ","
                    + address.getState() + "," + address.getZip() + ")");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void update(Address address) {
//        int maxId = 0;
//        System.out.println("2222222");
//        try {
//            Connection connection = JdbcUtil.getConnection();
//            PreparedStatement pstmt = connection.prepareStatement("select  MAx(id) from address");
//            ResultSet resultSet = pstmt.executeQuery();
//
//            while (resultSet.next()) {
//                maxId = resultSet.getInt(1);
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("111111");
        System.out.println("Address" + address.getName());
//        maxId += 1;
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("update address set name=" + address.getName()
                    + ", street=" + address.getStreet() + ", city=" + address.getCity() + ", state=" + address.getState() + ", zip=" + address.getZip() +
                    " where id = " + address.getId()
            );
            System.out.println("update address set name=" + address.getName()
                    + ", street=" + address.getStreet() + ", city=" + address.getCity() + ", state=" + address.getState() + ", zip=" + address.getZip() +
                    "where id = " + address.getId());
//            PreparedStatement pstmt = connection.prepareStatement("insert into address(id, name, street, city, state, zip) " +
//                    "values(" + maxId + "," + address.getName() + "," + address.getStreet() + "," + address.getCity() + ","
//                    + address.getState() + "," + address.getZip() + ")");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
