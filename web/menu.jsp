<%-- 
    Document   : menu
    Created on : 17 nov. 2022, 18:40:13
    Author     : RANIA
--%>

<%@page import="service.ProduitService"%>
<%@page import="service.CommandeService"%>
<%@page import="service.ClientService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Fashion NR</title>
    </head>
    <body>
        <%
        ClientService cs = new ClientService();
        CommandeService css = new CommandeService();
        ProduitService ps = new ProduitService();
        %>
        <div class="main-panel">
                    <div class="content-wrapper">
                        <div class="row">
                            <div class="col-md-12 grid-margin">
                                <div class="row">
                                    <div class="col-12 col-xl-8 mb-4 mb-xl-0">
                                        <h3 class="font-weight-bold">Bienvenue admin</h3>
                                        <h6 class="font-weight-normal mb-0">Ici vous pouvez gerer votre espace admin <!--<span class="text-primary">3 unread alerts!</span>--></h6>
                                    </div>
                                    <div class="col-12 col-xl-4">
                                      
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 grid-margin stretch-card">
                                <div class="card tale-bg">
                                    <div class="card-people mt-auto">
                                        <img src="Template/images/NR.jpg" alt="people">
                                        <div class="weather-info">
                                            <div class="d-flex">
                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 grid-margin transparent">
                                <div class="row">
                                    <div class="col-md-6 mb-4 stretch-card transparent">
                                        <div class="card card-tale">
                                            <div class="card-body">
                                                <p class="mb-4">Espace clients</p>
                                                <p class="fs-30 mb-2">Nombre de clients : <%=cs.nbrClient()%> </p>
                                             
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4 stretch-card transparent">
                                        <div class="card card-dark-blue">
                                            <div class="card-body">
                                                <p class="mb-4">Espace commandes</p>
                                                <p class="fs-30 mb-2">Nombre de commandes :<%=css.nbrCommande()%> </p>
                                              
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 mb-4 mb-lg-0 stretch-card transparent">
                                        <div class="card card-light-blue">
                                            <div class="card-body">
                                                <p class="mb-4">Espace Produits</p>
                                                <p class="fs-30 mb-2">Nombre de produits : <%=ps.nbrProduit()%> </p>
                                              
                                            </div>
                                        </div>
                                    </div>
                                  <!--  <div class="col-md-6 stretch-card transparent">
                                        <div class="card card-light-danger">
                                            <div class="card-body">
                                                <p class="mb-4">Number of Clients</p>
                                                <p class="fs-30 mb-2">47033</p>
                                                <p>0.22% (30 days)</p>
                                            </div>
                                        </div>
                                    </div>-->
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 grid-margin stretch-card">
                              
                    </div>
                   
                </div>

    </body>
</html>