import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Dotin school 6 on 5/7/2016.
 */
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("http/text");
        PrintWriter printOut=response.getWriter();
        printOut.println("<h1>Update Employee</h1>");
        String sId=request.getParameter("id");
        int id=Integer.parseInt(sId);
        CrudRealCustomer crudRealCustomer=new CrudRealCustomer();
        try {
            RealCustomerType realCustomer= new RealCustomerType();

            crudRealCustomer.update(realCustomer);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        printOut.print("  رکورد مورد نظر با موفقیت ویرایش گردید  ");
        printOut.close();
        response.sendRedirect("http://localhost:8081");

    }
}
