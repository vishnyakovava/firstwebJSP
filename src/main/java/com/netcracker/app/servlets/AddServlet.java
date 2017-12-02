package com.netcracker.app.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;

@WebServlet("/addservlet")
public class AddServlet  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("views/add.jsp").forward(req, resp); //передается управление из сервлета в jsp

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Connection conn = null;
        PreparedStatement ps;
        String url = "jdbc:mysql://localhost:3306/netcracker";
        String msg = null;

        try {
            String input = req.getParameter("input");
            String sqlQuery = "INSERT INTO  storage (inputtext) " + "VALUES (?)";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "root");
            ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, input);
            int row = ps.executeUpdate();
            if (row > 0) {
                msg = "Input data successfully uploaded and saved into database";
            }
        } catch (Exception e) {
            msg = "ERROR" + e.getMessage();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        req.setAttribute("Message", msg);
        getServletContext().getRequestDispatcher("/Message.jsp").forward(req, resp);
    }

}
