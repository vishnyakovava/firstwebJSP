package com.netcracker.app.servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListServlet extends HttpServlet {
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/netcracker?useSSL=false";
    private String query = "select inputtext from storage";
    private Statement stmt = null;
    private ResultSet rs = null;
    private Connection con=null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        List<String> dataList = new ArrayList<String>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
            stmt.executeQuery(query);
            rs = stmt.getResultSet();
            while(rs.next()){
                dataList.add(rs.getString("inputtext"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("data", dataList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/list.jsp");
        if(dispatcher!= null) dispatcher.forward(req,resp);
    }
}
