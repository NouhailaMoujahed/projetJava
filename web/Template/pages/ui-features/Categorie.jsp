<%-- 
    Document   : Categorie
    Created on : 18 nov. 2022, 21:51:55
    Author     : RANIA
--%>

<%@page import="entities.Categorie"%>
<%@page import="service.CategorieService"%>
<%@page import="ajout.CategorieControlleur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Fashion NR Catégorie</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="../../vendors/feather/feather.css">
        <link rel="stylesheet" href="../../vendors/ti-icons/css/themify-icons.css">
        <link rel="stylesheet" href="../../vendors/css/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <link rel="stylesheet" href="../../css/vertical-layout-light/style.css">
        <!-- endinject -->
        <link rel="shortcut icon" href="../../images/nr1.png" />
    </head>

    <body>
        <div class="container-scroller">
            <!-- partial:../../partials/_navbar.html -->
            <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
                <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
                    <a class="navbar-brand brand-logo mr-5" href="../../../index.jsp"><img src="../../images/nr1.png" class="mr-2" alt="logo"/></a>
                    <a class="navbar-brand brand-logo-mini" href="../../../index.jsp"><img src="../../images/NR.jpg" alt="logo"/></a>
                </div>
                <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
                    <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
                        <span class="icon-menu"></span>
                    </button>
                    <ul class="navbar-nav mr-lg-2">
                        <li class="nav-item nav-search d-none d-lg-block">
                            <div class="input-group">
                                <div class="input-group-prepend hover-cursor" id="navbar-search-icon">
                                    <span class="input-group-text" id="search">
                                        <i class="icon-search"></i>
                                    </span>
                                </div>
                                <input type="text" class="form-control" id="navbar-search-input" placeholder="Search now" aria-label="search" aria-describedby="search">
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav navbar-nav-right">
                        <li class="nav-item dropdown">
                           <!-- <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
                                <i class="icon-bell mx-0"></i>
                                <span class="count"></span>
                            </a>-->
                            <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="notificationDropdown">
                                <p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
                                <a class="dropdown-item preview-item">
                                    <div class="preview-thumbnail">
                                        <div class="preview-icon bg-success">
                                            <i class="ti-info-alt mx-0"></i>
                                        </div>
                                    </div>
                                    <div class="preview-item-content">
                                        <h6 class="preview-subject font-weight-normal">Application Error</h6>
                                        <p class="font-weight-light small-text mb-0 text-muted">
                                            Just now
                                        </p>
                                    </div>
                                </a>
                                <a class="dropdown-item preview-item">
                                    <div class="preview-thumbnail">
                                        <div class="preview-icon bg-warning">
                                            <i class="ti-settings mx-0"></i>
                                        </div>
                                    </div>
                                    <div class="preview-item-content">
                                        <h6 class="preview-subject font-weight-normal">Settings</h6>
                                        <p class="font-weight-light small-text mb-0 text-muted">
                                            Private message
                                        </p>
                                    </div>
                                </a>
                                <a class="dropdown-item preview-item">
                                    <div class="preview-thumbnail">
                                        <div class="preview-icon bg-info">
                                            <i class="ti-user mx-0"></i>
                                        </div>
                                    </div>
                                    <div class="preview-item-content">
                                        <h6 class="preview-subject font-weight-normal">New user registration</h6>
                                        <p class="font-weight-light small-text mb-0 text-muted">
                                            2 days ago
                                        </p>
                                    </div>
                                </a>
                            </div>
                        </li>
                        <li class="nav-item nav-profile dropdown">
                            <!--<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
                                <img src="../../images/faces/face28.jpg" alt="profile"/>
                            </a>-->
                            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
                                <a class="dropdown-item">
                                    <i class="ti-settings text-primary"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item">
                                    <i class="ti-power-off text-primary"></i>
                                    Logout
                                </a>
                            </div>
                        </li>
                        <li class="nav-item nav-settings d-none d-lg-flex">
                            <a class="nav-link" href="#">
                                <i class="icon-ellipsis"></i>
                            </a>
                        </li>
                    </ul>
                    <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                        <span class="icon-menu"></span>
                    </button>
                </div>
            </nav>
            <!-- partial -->
            <div class="container-fluid page-body-wrapper">
                <!-- partial:../../partials/_settings-panel.html -->
                <div class="theme-setting-wrapper">
                    <div id="settings-trigger"><i class="ti-settings"></i></div>
                    <div id="theme-settings" class="settings-panel">
                        <i class="settings-close ti-close"></i>
                        <p class="settings-heading">SIDEBAR SKINS</p>
                        <div class="sidebar-bg-options selected" id="sidebar-light-theme"><div class="img-ss rounded-circle bg-light border mr-3"></div>Light</div>
                        <div class="sidebar-bg-options" id="sidebar-dark-theme"><div class="img-ss rounded-circle bg-dark border mr-3"></div>Dark</div>
                        <p class="settings-heading mt-2">HEADER SKINS</p>
                        <div class="color-tiles mx-0 px-4">
                            <div class="tiles success"></div>
                            <div class="tiles warning"></div>
                            <div class="tiles danger"></div>
                            <div class="tiles info"></div>
                            <div class="tiles dark"></div>
                            <div class="tiles default"></div>
                        </div>
                    </div>
                </div>
                <div id="right-sidebar" class="settings-panel">
                    <i class="settings-close ti-close"></i>
                 
                    <div class="tab-content" id="setting-content">
                      
                        <!-- To do section tab ends -->
                        <div class="tab-pane fade" id="chats-section" role="tabpanel" aria-labelledby="chats-section">
                            <div class="d-flex align-items-center justify-content-between border-bottom">
                                <p class="settings-heading border-top-0 mb-3 pl-3 pt-0 border-bottom-0 pb-0">Friends</p>
                                <small class="settings-heading border-top-0 mb-3 pt-0 border-bottom-0 pb-0 pr-3 font-weight-normal">See All</small>
                            </div>
                            <ul class="chat-list">
                                <li class="list active">
                                    <div class="profile"><img src="../../images/faces/face1.jpg" alt="image"><span class="online"></span></div>
                                    <div class="info">
                                        <p>Thomas Douglas</p>
                                        <p>Available</p>
                                    </div>
                                    <small class="text-muted my-auto">19 min</small>
                                </li>
                                <li class="list">
                                    <div class="profile"><img src="../../images/faces/face2.jpg" alt="image"><span class="offline"></span></div>
                                    <div class="info">
                                        <div class="wrapper d-flex">
                                            <p>Catherine</p>
                                        </div>
                                        <p>Away</p>
                                    </div>
                                    <div class="badge badge-success badge-pill my-auto mx-2">4</div>
                                    <small class="text-muted my-auto">23 min</small>
                                </li>
                                <li class="list">
                                    <div class="profile"><img src="../../images/faces/face3.jpg" alt="image"><span class="online"></span></div>
                                    <div class="info">
                                        <p>Daniel Russell</p>
                                        <p>Available</p>
                                    </div>
                                    <small class="text-muted my-auto">14 min</small>
                                </li>
                                <li class="list">
                                    <div class="profile"><img src="../../images/faces/face4.jpg" alt="image"><span class="offline"></span></div>
                                    <div class="info">
                                        <p>James Richardson</p>
                                        <p>Away</p>
                                    </div>
                                    <small class="text-muted my-auto">2 min</small>
                                </li>
                                <li class="list">
                                    <div class="profile"><img src="../../images/faces/face5.jpg" alt="image"><span class="online"></span></div>
                                    <div class="info">
                                        <p>Madeline Kennedy</p>
                                        <p>Available</p>
                                    </div>
                                    <small class="text-muted my-auto">5 min</small>
                                </li>
                                <li class="list">
                                    <div class="profile"><img src="../../images/faces/face6.jpg" alt="image"><span class="online"></span></div>
                                    <div class="info">
                                        <p>Sarah Graves</p>
                                        <p>Available</p>
                                    </div>
                                    <small class="text-muted my-auto">47 min</small>
                                </li>
                            </ul>
                        </div>
                        <!-- chat tab ends -->
                    </div>
                </div>
                <!-- partial -->
                <!-- partial:../../partials/_sidebar.html -->
                <%@include file="side.jsp"%>
                <!-- partial -->
                <div class="main-panel">          
                    <div class="content-wrapper">
                        <div class="row">
                            <div class="col-md-6 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Ajout d'une catégorie</h4>
                                        <form method="GET" action="../../../Categorie" class="forms-sample">

                                            <div class="form-group">
                                                <label for="exampleInputUsername1">nom</label>
                                                <input type="text" name="nom" class="form-control" id="exampleInputUsername1" placeholder="nom">
                                            </div>
                                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                                            <a href="Categorie.jsp" class="btn btn-light">Cancel</a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Ajout d'une sous catégorie :</h4>

                                        <form method="GET" action="../../../SousCategorieControlleur" class="forms-sample">
                                            <div class="form-group row">
                                                <label for="exampleInputUsername2" class="col-sm-3 col-form-label">Nom</label>
                                                <div class="col-sm-9">
                                                    <input type="text" name="nom" class="form-control" id="exampleInputUsername2" placeholder="SousCategorie">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <select name="categorie" class="js-example-basic-single w-100" >
                                                    <option></option>
                                                    <%
                                                      CategorieService cs = new CategorieService();
                                                        for (Categorie c : cs.findAll()) {
                                                            if(c.getCategorie()==null){
                                                            
                                                    %>
                                                    <option value="<%= c.getId()%>"><%= c.getNom()%></option>
                                                    <%}}%>
                                                </select>
                                            </div>
                                            <button type="submit" class="btn btn-primary mr-2">Submit</button>
                                            <a href="Categorie.jsp" class="btn btn-light">Cancel</a>

                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Liste des catégories :</h4>
                                      
                                         <form method="GET" action="../../../DeleteCategorieControlleur" class="forms-sample">
                                              
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Nom</th>
                                                        <th>Catégorie</th>
                                                         <th>supprimer </th>
                                                        
                                                    </tr>
                                                </thead>
                                               
                                                <tbody>
                                              
                                                    <%
                                                            for (Categorie c : cs.findAll()) {
                                                                
                                                                    
                                                    %>
                                               
                                                    <tr>
                                                        <td><%= c.getNom()%></td>
                                                        <% if(c.getCategorie()==null){    
                                                        %>
                                                        <td>principale</td>
                                                        <%
                                                        }
                                                        else{
                                                        %>
                                                        <td><%= c.getCategorie().getNom()%> </td>
                                                     
                                                        <%}%>
                                                       <!-- <td><input type="reset" id="reset" value="reset" name="reset" class="btn btn-warning" /></td>-->
                                                      <td><a  class= "btn btn-danger " onclick="return confirm('Etes vous sur que vous voulez le supprimer ?')"  href="../../../DeleteCategorieControlleur?id=<%=c.getId()%>"> Cancel </button> </a></td>
                                                    <!--  <td><a href="../../../UpdateCategorieControlleur?id=<%=c.getId()%>">Edit</a> </td>-->
                                                      </tr>
                                                   
                                                    <%}%>
                                                      
                                                </tbody>
                                              
                                            </table>
                                    </div>
                                              </form>
                                                 
                                </div>
                            </div>
                            </div>

                            <div class="col-md-8 grid-margin stretch-card">
                               <!-- <div class="card">
                                   
                    </div>
                    
                   
                </div>
                <!-- main-panel ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="../../vendors/js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page -->
        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="../../js/off-canvas.js"></script>
        <script src="../../js/hoverable-collapse.js"></script>
        <script src="../../js/template.js"></script>
        <script src="../../js/settings.js"></script>
        <script src="../../js/todolist.js"></script>
        <!-- endinject -->
    </body>

</html>