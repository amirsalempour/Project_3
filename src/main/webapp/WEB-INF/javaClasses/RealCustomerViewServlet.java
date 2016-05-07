import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dotin school 6 on 5/7/2016.
 */
@WebServlet("RealCustomerViewServlet")
public class RealCustomerViewServlet extends HttpServlet {

protected  void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    response.setContentType("html/text");
    PrintWriter printWriter=response.getWriter();
    printWriter.println("<a href='index.html'> کاربر جدید را وارد نمایید </a>");
    printWriter.println("<h1> لیست کاربران </h1>");
    try {
        List<RealCustomerType> list=CrudRealCustomer.getRecords();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
