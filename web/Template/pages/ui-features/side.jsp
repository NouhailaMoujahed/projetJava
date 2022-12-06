<%-- 
    Document   : side
    Created on : 18 nov. 2022, 22:20:42
    Author     : RANIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fashion NR </title>
    </head>
    <body>
             <!-- partial:../../partials/_sidebar.html -->
       <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="../../../index.jsp">
              <i class="icon-grid menu-icon"></i>
              <span class="menu-title">Tableau de bord</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="icon-layout menu-icon"></i>
              <span class="menu-title">Gestion</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="../../pages/ui-features/Categorie.jsp">Catégories</a></li>
                <li class="nav-item"> <a class="nav-link" href="../../pages/ui-features/Marque.jsp">Marques</a></li>
                <li class="nav-item"> <a class="nav-link" href="../../pages/ui-features/Produits.jsp">Produits</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#tables" aria-expanded="false" aria-controls="tables">
              <i class="icon-grid-2 menu-icon"></i>
              <span class="menu-title">Tables</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="tables">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="../../pages/tables/users.jsp">Users</a></li>
              </ul>
            </div>
          </li>
        
          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#auth" aria-expanded="false" aria-controls="auth">
              <i class="icon-head menu-icon"></i>
              <span class="menu-title">User Pages</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="auth">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="../../pages/samples/login.jsp"> Login </a></li>
                <li class="nav-item"> <a class="nav-link" href="../../pages/samples/register.html"> Register </a></li>
              </ul>
            </div>
          </li>
         
        </ul>
      </nav>
    </body>
</html>