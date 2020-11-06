package FabricaAutomoviles.Controler;


import FabricaAutomoviles.Exception.DAOException;
import FabricaAutomoviles.Service.AutomovilService;
import FabricaAutomoviles.Service.Impl.AutomovilServiceImpl;
import FabricaAutomoviles.Service.Impl.ModeloServiceImpl;
import FabricaAutomoviles.Service.Impl.OpcionesServiceImpl;
import FabricaAutomoviles.Service.ModeloService;
import FabricaAutomoviles.Service.OpcionesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AutomovilControler extends HttpServlet {

    private AutomovilService automovilService ;
    private ModeloService modeloService;
    private OpcionesService opcionesService;

    public AutomovilControler( ){
        this.automovilService = new AutomovilServiceImpl();
        this.modeloService = new ModeloServiceImpl();
        this.opcionesService =new OpcionesServiceImpl();
    }


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer precioAutomovil = null;



        try {
            precioAutomovil = this.automovilService.mostrarPrecioAutos(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }




        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Metodo GET</TITLE>");
        pw.println("</head><body>");
        pw.println("<h1>Precio de auto</h1>");
        pw.println("<h2>El auto con Id " + id +"\n tiene un precio de " + precioAutomovil + "</h2>");
        pw.println("</body></html>");
        pw.close();







    }
    public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException {

        /*AutomovilDTO automovilDTO = new AutomovilDTO();

        automovilDTO.setId(Integer.parseInt(req.getParameter("id")));
        automovilDTO.setNombre(req.getParameter("Nombre"));




            automovilService.ingresarAutomovil(automovilDTO);


        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Método Post</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Llamar al recurso Automovil</p>");
        pw.println(req.getParameter("id"));
        pw.println(req.getParameter("Nombre"));
        pw.println("</body>");
        pw.close();*/


    }


    public void doPut (HttpServletRequest req, HttpServletResponse res) throws ServletException,  IOException {


    }


    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        try {
            this.automovilService.deleteAutomovil(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    public ModeloService getModeloService() {
        return modeloService;
    }

    public void setModeloService(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    public OpcionesService getOpcionesService() {
        return opcionesService;
    }

    public void setOpcionesService(OpcionesService opcionesService) {
        this.opcionesService = opcionesService;
    }


}
