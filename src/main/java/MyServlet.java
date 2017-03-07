import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Alexander on 18.02.2017.
 */

public class MyServlet extends HttpServlet {

    final List<Client> clients = new CopyOnWriteArrayList<Client>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "     <title>Clinic Pets</title>" +
                "</head>" +
                "<body>" +
                "<style> p {margin-top:15px;} </style>" +
                "<center>"+
                "<form action='" + request.getContextPath() + "/' method='post'>" +
                "<p><br> Name  : <input type='text' name='name'> </br></p>" +
                "<p><br> Login : <input type='text' login='login'> </br></p>" +
                "<p><br> Phone : <input type='text' phone='phone'> </br></p>" +
                "<p><br> Mail  : <input type='text' mail='mail'> </br></p>" +
                "<p><br><input type='submit' value='Submit'></br></p>" +
                "</form>" +
                "<center>"+
                this.viewPets() +
                "</body>" +
                "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.clients.add(new Client(request.getParameter("name"),
                                    request.getParameter("login"),
                                    request.getParameter("phone"),
                                    request.getParameter("mail")));
        doGet(request,response);
    }

    private String viewPets()
    {
        StringBuilder ad = new StringBuilder();
        ad.append("<p>Client</p>");
        ad.append("<table>");
        for (Client client: this.clients)
        {
            ad.append("<tr><td>").append(client.getName()).append("  ").append(client.getLogin()).append("  ").append(client.getPhone()).append("  ").append(client.getMail()).append("  ").append("</td></tr>");
        }
        ad.append("</table>");
        return ad.toString();
    }


}
