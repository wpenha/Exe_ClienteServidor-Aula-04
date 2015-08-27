/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author logon
 */
public class Comprar extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            float valorTotal = 0;
         
            String modelo = request.getParameter("modRadio");
            String qtdPortas = request.getParameter("qtdPorta");
            String acesAC = request.getParameter("acesAC");
            String direcao = request.getParameter("direcao");
            String VE_TE = request.getParameter("VE_TE");
            
            // Definindo valor do modelo 
                if(modelo.equals("EX")){
                  valorTotal += 10000.0;  
                }
                if(modelo.equals("ELX")){
                  valorTotal += 20000.0;
                }
                if(modelo.equals("Master")){
                  valorTotal += 30000.0;
                }
                
            // Adicionando valor dependendo quantidade de portas 
                if(qtdPortas.equals("4P")){
                  valorTotal += 4000.0;  
                }
            // Adiciona valores aos acessórios
                String acesRespHTML = "";
                if(acesAC != null){
                   valorTotal += 3000.0;
                   acesRespHTML += "Ar Condionado, ";
                }
                if(direcao != null){
                   valorTotal += 2000.0;
                   acesRespHTML += "Direção Elétrica, ";
                }
                if(VE_TE != null){
                   valorTotal += 1000.0;
                   acesRespHTML += "VE / TE, ";
                }
                
            System.out.println("O modelo é " + modelo);
            System.out.println("O qtd portas é " + qtdPortas);
            System.out.println("O AC é " + acesAC);
            System.out.println("O direcao é " + direcao);
            System.out.println("O VE_TE é " + VE_TE);
            System.out.println("Valor Total " + valorTotal);
                        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Orçamento</title>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
"    </head>\n" +
"    <body background=\"img/back2.jpg\">\n" +
"        <div id=\"acessDenied\">\n" +
"            <img src=\"img/carro.png\" alt=\"Acesso Negado\">\n" +
"            <h1>O valor da máquina escolhida foi de: \n <br /> R$ " + valorTotal  + "</h1>" +
"            <h1>Com os Seguintes itens: </h1>" +       
"            <p> Modelo: " + modelo +        
"            <br /> Quantidade de Portas: " + qtdPortas +
"            <br /> Acessórios: " + acesRespHTML + "</p>" +                    
"            <a href=\"index.html\">Fazer outro orçamento</a>    \n" +
"        </div>\n" +
"\n" +
"        <div id=\"dviBrancaNegada\"></div>\n" +
"    </body>\n" +
"</html>");

        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.sendRedirect("acessDenied.html");
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
