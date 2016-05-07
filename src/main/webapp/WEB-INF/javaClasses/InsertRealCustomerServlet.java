import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

/**
 * Created by Dotin school 6 on 5/3/2016.
 */
@WebServlet("/InsertRealCustomerServlet")
public class InsertRealCustomerServlet extends HttpServlet {
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter printOut=response.getWriter();
    String firstName=request.getParameter("firstName");
    String lastName=request.getParameter("lastName");
    String fatherName=request.getParameter("fatherName");
    String birthDate= request.getParameter("birthDate");
    String nationalCode=request.getParameter("nationalCode");

    RealCustomerType realCustomer=new RealCustomerType();
    realCustomer.setName(firstName);
    realCustomer.setLastName(lastName);
    realCustomer.setFatherName(fatherName);
    realCustomer.setBirthDate(Date.valueOf(birthDate));
    realCustomer.setNationalCode(nationalCode);

    int status=CrudRealCustomer.insert(realCustomer);

    if(status>0) {
        printOut.print("<p>Records saved successfully!</p>");
        request.getRequestDispatcher("realCustomer.html").include(request, response);

    }
    else
    {
        printOut.print("Sorry! unable to save record ");
    }
printOut.close();
}

}
