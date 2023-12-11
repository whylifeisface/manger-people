package com.example.demo2.servlet;

import com.example.demo2.dao.AddressDao;
import com.example.demo2.entity.Address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@WebServlet(name = "addressServlet", value = "/addressServlet")
public class AddressServlet extends HttpServlet {


    private AddressDao addressDao = new AddressDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "list.jsp";

        String method = req.getParameter("me");
        if (method != null && method.equals("add")) {
            String name = String.valueOf(req.getParameter("name"));
            String street = String.valueOf(req.getParameter("street"));
            String city = String.valueOf(req.getParameter("city"));
            String state = String.valueOf(req.getParameter("state"));
            String zip = String.valueOf(req.getParameter("zip"));
            Address address = new Address(name, street, city, state, zip);

            addressDao.add(address);

        } else {
            int id = Integer.valueOf(req.getParameter("id"));

            String name = String.valueOf(req.getParameter("Name"));
            String street = String.valueOf(req.getParameter("Street"));
            String city = String.valueOf(req.getParameter("City"));
            String state = String.valueOf(req.getParameter("State"));
            String zip = String.valueOf(req.getParameter("Zip"));

            Address address = new Address(id, name, street, city, state, zip);

            addressDao.update(address);


            List<Address> list = addressDao.findAll();
            req.setAttribute("list", list);

        }

        req.getRequestDispatcher(path).forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "list.jsp";

        String method = req.getParameter("method");
        if (method == null) {
            List<Address> list = addressDao.findAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher(path).forward(req, resp);
        }

        if (method.equals("todelete")) {

            String id = req.getParameter("id");
            System.out.println("id " + id);
            addressDao.delete(id);
            List<Address> list = addressDao.findAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher(path).forward(req, resp);

        } else if (method.equals("toedit")) {

            String id = (req.getParameter("id"));

            Address address = addressDao.findById(id);
            path = "edit.jsp";
            req.setAttribute("address", address);
            System.out.println(address.getId());
            req.getRequestDispatcher(path).forward(req, resp);

        } else {

        }


    }
}
