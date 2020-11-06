package FabricaAutomoviles.Controler;
import FabricaAutomoviles.DTOS.ClienteDTO;
import FabricaAutomoviles.Exception.ServiceException;
import FabricaAutomoviles.Service.ClienteService;
import FabricaAutomoviles.Service.Impl.ClienteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ClienteControler extends HttpServlet {



    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();


        ClienteService clienteService = new ClienteServiceImpl();


        try {
            clienteService.consultarCliente((Integer.parseInt(req.getParameter("idCliente"))));  //(Integer.parseInt(req.getParameter("id")))
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        // Obtenemos un objeto Print Writer para enviar respuesta


        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Metodo GET</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Llamar al recurso Cliente</p>");
        pw.println("<p>*Cliente </p>");
        pw.println("</body>");
        pw.close();


    }
    public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        ClienteDTO clienteDTO = new ClienteDTO();
        ClienteService clienteService = new ClienteServiceImpl();

        clienteDTO.setIdCliente((Integer.parseInt(req.getParameter("idCliente"))));
        clienteDTO.setNombre(req.getParameter("Nombre"));
        clienteDTO.setCuit(req.getParameter("Apellido"));


        try {
            clienteService.ingresarCliente(clienteDTO);
        } catch (ServiceException e) {

            e.printStackTrace();
        }

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Método Post</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Llamar al recurso Cliente</p>");
        pw.println(req.getParameter("nombre"));
        pw.println(req.getParameter("apellido"));
        pw.println("</body>");
        pw.close();


    }


    public void doPut (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


    }


    protected void doDelete (HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

    }


}
