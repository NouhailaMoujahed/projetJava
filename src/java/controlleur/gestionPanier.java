/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import entities.Client;
import entities.Commande;
import entities.Facture;
import entities.LigneCommande;
import entities.LigneCommandePK;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ClientService;
import service.CommandeService;
import service.FactureService;
import service.LigneService;
import service.ProduitService;

/**
 *
 * @author RANIA
 */
@WebServlet(name = "gestionPanier", urlPatterns = {"/gestionPanier"})
public class gestionPanier extends HttpServlet {

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
        ClientService cs = new ClientService();
        HttpSession session = request.getSession();
        String eid = (String)session.getAttribute("email");
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        Client c  =cs.findByEmail(email);
        
        
     
       // if (eid == null) {
            // response.setContentType("application/json");
             //Gson gson = new Gson();
             //response.getWriter().write(gson.toJson(-1));
        //}
       // else {
        CommandeService css = new CommandeService();
         if( "augqte".equals(action)){
                int qte= Integer.parseInt(request.getParameter("qte"));
                css.augmenterQte(qte); 
                
            }
           if("dimqte".equals(action)){
                int qte= Integer.parseInt(request.getParameter("qte"));
                css.diminuerQte(qte);
            }
         
            ClientService us = new ClientService();
            LigneService ls = new LigneService();
            ProduitService ps = new ProduitService();
            FactureService fs = new FactureService();
        if("ajouter".equals(action)){
            
            Client tmp = (Client) us.findByEmail(eid);
            Commande panier = css.getPanier();
            if(panier==null){
                panier = new Commande(new Date(),tmp,"en cours");
                css.create(panier);
            }
            int commandeid = panier.getId();
            int idProduit = Integer.parseInt(request.getParameter("id"));
            int nb = Integer.parseInt(request.getParameter("qte"));
            
            // ID de la commande en cours (a ajouter dans la couche service)
            
            LigneCommandePK lcpk = new LigneCommandePK(idProduit, commandeid);
            LigneCommande lctmp = ls.getByPK(lcpk);
            if(lctmp==null){
                ls.create(new LigneCommande(lcpk, (ps.findById(idProduit)).getPrix() ,nb ));
            }
            if(lctmp!=null) {
              //
                lctmp.setQuantite(lctmp.getQuantite()+nb);
                lctmp.setPrixVente((ps.findById(idProduit)).getPrix());
                ls.update(lctmp);
            }
            
        }
        if("supprimer".equals(action)){
        int idproduit = Integer.parseInt(request.getParameter("idproduit"));
        int commandeid = Integer.parseInt(request.getParameter("idcommande"));
        
        LigneService lcs = new LigneService();
        LigneCommandePK lcPK = new LigneCommandePK(idproduit,commandeid);
        LigneCommande tmp = lcs.getByPK(lcPK);
        lcs.delete(tmp);
        Commande commande = css.findById(commandeid);
         css.delete(commande);
        }
        
        
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
            rd.forward(request,response);
   
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
