

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.http.HttpSession;

public class Search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Search</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/cs212";

        String USER = "root";
        String PASS = "liv77vis";

        response.setContentType("text/html");

        String docType
                = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType
                + "<html>\n");
         HttpSession sess = request.getSession();
        if(sess.getAttribute("isLoggedIn").equals("100")){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM cereal";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int cerealid = rs.getInt("idcereal");
                String brand = rs.getString("brand");
                String name = rs.getString("name");
                int sugargram = rs.getInt("sugargram");
                int fibergram = rs.getInt("fibergram");
                String expdate = rs.getString("expiredate");
                float price = rs.getFloat("price");
                String desc = rs.getString("productdescription");

                if ((request.getParameter("category").equals("Brand")) && (request.getParameter("brand").equals(brand))) {
                    out.println("ID: " + cerealid + "<br>");
                    out.println("brand: " + brand + "<br>");
                    out.println("Name: " + name + "<br>");
                    out.println("sugar: " + sugargram + "g" + "<br>");
                    out.println("fiber: " + fibergram + "g" + "<br>");
                    out.println("expiration: " + expdate + "<br>");
                    out.println("price: " + price + "<br>");
                    out.println("product description: " + desc + "<br>");
                    out.println("<br>");
                } else if ((request.getParameter("category").equals("Name")) && (request.getParameter("name").equals(name))) {
                    out.println("ID: " + cerealid + "<br>");
                    out.println("brand: " + brand + "<br>");
                    out.println("Name: " + name + "<br>");
                    out.println("sugar: " + sugargram + "g" + "<br>");
                    out.println("fiber: " + fibergram + "g" + "<br>");
                    out.println("expiration: " + expdate + "<br>");
                    out.println("price: " + price + "<br>");
                    out.println("product description: " + desc + "<br>");
                    out.println("<br>");
                } else if ((request.getParameter("category").equals("Sugar"))) {
                    if (request.getParameter("compare").equals("Equal") && (Integer.valueOf(request.getParameter("sugar")) == sugargram)) {
                        out.println("ID: " + cerealid + "<br>");
                        out.println("brand: " + brand + "<br>");
                        out.println("Name: " + name + "<br>");
                        out.println("sugar: " + sugargram + "g" + "<br>");
                        out.println("fiber: " + fibergram + "g" + "<br>");
                        out.println("expiration: " + expdate + "<br>");
                        out.println("price: " + price + "<br>");
                        out.println("product description: " + desc + "<br>");
                        out.println("<br>");
                    } else if (request.getParameter("compare").equals("More") && (Integer.valueOf(request.getParameter("sugar")) < sugargram)) {
                        out.println("ID: " + cerealid + "<br>");
                        out.println("brand: " + brand + "<br>");
                        out.println("Name: " + name + "<br>");
                        out.println("sugar: " + sugargram + "g" + "<br>");
                        out.println("fiber: " + fibergram + "g" + "<br>");
                        out.println("expiration: " + expdate + "<br>");
                        out.println("price: " + price + "<br>");
                        out.println("product description: " + desc + "<br>");
                        out.println("<br>");
                    } else if (request.getParameter("compare").equals("Less") && (Integer.valueOf(request.getParameter("sugar")) > sugargram)) {
                        out.println("ID: " + cerealid + "<br>");
                        out.println("brand: " + brand + "<br>");
                        out.println("Name: " + name + "<br>");
                        out.println("sugar: " + sugargram + "g" + "<br>");
                        out.println("fiber: " + fibergram + "g" + "<br>");
                        out.println("expiration: " + expdate + "<br>");
                        out.println("price: " + price + "<br>");
                        out.println("product description: " + desc + "<br>");
                        out.println("<br>");
                    }
                } else if ((request.getParameter("category").equals("Fiber"))) {
                    if (request.getParameter("compare").equals("Equal") && (Integer.valueOf(request.getParameter("fiber")) == fibergram)) {
                        out.println("ID: " + cerealid + "<br>");
                        out.println("brand: " + brand + "<br>");
                        out.println("Name: " + name + "<br>");
                        out.println("sugar: " + sugargram + "g" + "<br>");
                        out.println("fiber: " + fibergram + "g" + "<br>");
                        out.println("expiration: " + expdate + "<br>");
                        out.println("price: " + price + "<br>");
                        out.println("product description: " + desc + "<br>");
                        out.println("<br>");
                    } else if (request.getParameter("compare").equals("More") && (Integer.valueOf(request.getParameter("fiber")) < fibergram)) {
                        out.println("ID: " + cerealid + "<br>");
                        out.println("brand: " + brand + "<br>");
                        out.println("Name: " + name + "<br>");
                        out.println("sugar: " + sugargram + "g" + "<br>");
                        out.println("fiber: " + fibergram + "g" + "<br>");
                        out.println("expiration: " + expdate + "<br>");
                        out.println("price: " + price + "<br>");
                        out.println("product description: " + desc + "<br>");
                        out.println("<br>");
                    } else if (request.getParameter("compare").equals("Less") && (Integer.valueOf(request.getParameter("fiber")) > fibergram)) {
                        out.println("ID: " + cerealid + "<br>");
                        out.println("brand: " + brand + "<br>");
                        out.println("Name: " + name + "<br>");
                        out.println("sugar: " + sugargram + "g" + "<br>");
                        out.println("fiber: " + fibergram + "g" + "<br>");
                        out.println("expiration: " + expdate + "<br>");
                        out.println("price: " + price + "<br>");
                        out.println("product description: " + desc + "<br>");
                        out.println("<br>");
                    } 
                } else if ((request.getParameter("category").equals("Expiration Date")) && (request.getParameter("expiration").equals(expdate))) {
                    out.println("ID: " + cerealid + "<br>");
                    out.println("brand: " + brand + "<br>");
                    out.println("Name: " + name + "<br>");
                    out.println("sugar: " + sugargram + "g" + "<br>");
                    out.println("fiber: " + fibergram + "g" + "<br>");
                    out.println("expiration: " + expdate + "<br>");
                    out.println("price: " + price + "<br>");
                    out.println("product description: " + desc + "<br>");
                    out.println("<br>");
                } else if ((request.getParameter("category").equals("Price"))) {
                    if (request.getParameter("compare").equals("Equal") && (Float.valueOf(request.getParameter("price")) == price)) {
                        out.println("ID: " + cerealid + "<br>");
                        out.println("brand: " + brand + "<br>");
                        out.println("Name: " + name + "<br>");
                        out.println("sugar: " + sugargram + "g" + "<br>");
                        out.println("fiber: " + fibergram + "g" + "<br>");
                        out.println("expiration: " + expdate + "<br>");
                        out.println("price: " + price + "<br>");
                        out.println("product description: " + desc + "<br>");
                        out.println("<br>");
                    } else if (request.getParameter("compare").equals("More") && (Float.valueOf(request.getParameter("price")) < price)) {
                        out.println("ID: " + cerealid + "<br>");
                        out.println("brand: " + brand + "<br>");
                        out.println("Name: " + name + "<br>");
                        out.println("sugar: " + sugargram + "g" + "<br>");
                        out.println("fiber: " + fibergram + "g" + "<br>");
                        out.println("expiration: " + expdate + "<br>");
                        out.println("price: " + price + "<br>");
                        out.println("product description: " + desc + "<br>");
                        out.println("<br>");
                    } else if (request.getParameter("compare").equals("Less") && (Float.valueOf(request.getParameter("price")) > price)) {
                        out.println("ID: " + cerealid + "<br>");
                        out.println("brand: " + brand + "<br>");
                        out.println("Name: " + name + "<br>");
                        out.println("sugar: " + sugargram + "g" + "<br>");
                        out.println("fiber: " + fibergram + "g" + "<br>");
                        out.println("expiration: " + expdate + "<br>");
                        out.println("price: " + price + "<br>");
                        out.println("product description: " + desc + "<br>");
                        out.println("<br>");
                    } 
                } 
                

            }
            

        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
        else{
         out.println("<!DOCTYPE html>");
                out.println("<html");
                out.println("<head>");
                out.println("User not authorized please Log in");
                out.println("<a href='login.html'>Click to login</a>");
                out.println("<a href='search.html'>Click to Search</a><br>");
                out.println("</head>");
                out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
