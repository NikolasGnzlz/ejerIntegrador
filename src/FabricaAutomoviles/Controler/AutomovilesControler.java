package FabricaAutomoviles.Controler;

import FabricaAutomoviles.DTOS.AutomovilDTO;
import FabricaAutomoviles.Exception.DAOException;
import FabricaAutomoviles.Service.AutomovilService;
import FabricaAutomoviles.Service.Impl.AutomovilServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AutomovilesControler extends HttpServlet {

    private AutomovilService automovilService ;

    public AutomovilesControler( ){
        this.setAutomovilService(new AutomovilServiceImpl());

    }

    List<AutomovilDTO> automovilDTOS = null;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            automovilDTOS = this.automovilService.consultarAutos();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        res.setContentType("text/html");
    PrintWriter pw = res.getWriter();
            pw.println("<html><head>");
            pw.println("<TITLE>Servlet Curso Java Metodo GET</TITLE>");
            pw.println("</head><body>");
            pw.println("<h1>LISTADO DE AUTOMOVILES</h1>");

            pw.println("<table border=\"1\"> <tr> <th> ID </th> <th> nombre </th> <th> Precio Total</th> </tr>");
            for (AutomovilDTO A:  automovilDTOS ) {
                pw.println(("<tr><td>" + A.getId() + "</td>"));
                pw.println(("<tr<td>" + A.getNombre() + "</td>"));
                pw.println(("<td>" + A.getPrecioTotal() + "</td> </tr>"));
            }

            pw.println("</table>");
            pw.println("</body></html>");
            pw.close();

}
    public AutomovilService getAutomovilService() {
        return automovilService;
    }

    public void setAutomovilService(AutomovilService automovilService) {
        this.automovilService = automovilService;
    }




}
