<%-- 
    Document   : menu
    Created on : 15-Aug-2020, 14:18:20
    Author     : kenne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>VegAl Food Menu</title>

  <!-- Bootstrap core CSS -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="assets/css/simple-sidebar.css" rel="stylesheet">

  <link rel="shortcut icon" href="assets/images/signin-vegal.png">

</head>

<body>

  <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        
        if (session.getAttribute("email") == null)
            response.sendRedirect("login.jsp");
    %>
  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">VegAl Home Page</div>
      <div class="list-group list-group-flush">
        <a href="reservation-page" class="list-group-item list-group-item-action bg-light">Reserve a table</a>
        <a href="order.jsp" class="list-group-item list-group-item-action bg-light">Order food</a>
        <a href="menu.jsp" class="list-group-item list-group-item-action bg-light">Menu</a>
       <!--
        <a href="#" class="list-group-item list-group-item-action bg-light">Events</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">Profile</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">Status</a>
      -->
      </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <!--            
            <li class="nav-item active">
              <a class="nav-link" href="home.jsp">Home Page <span class="sr-only">(current)</span></a>
            </li>
            -->
            <!--
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
        -->
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <% out.print(session.getAttribute("name")); %>
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <!-- <a class="dropdown-item" href="#">User Profile</a> -->
                <!-- <a class="dropdown-item" href="#">Another action</a> -->
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="logout">Logout</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>

      <div class="container-fluid">
        <h1 class="mt-4">Food Menu</h1>
        <p>Below is a list of scrumptious food offered in our restaurant.</p>
      </div>
      <div>
        <img src="assets/images/vegAl-menu.png" alt="Menu" width="800" height="1000">
      </div>
    </div>
    <!-- /#page-content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Bootstrap core JavaScript -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Menu Toggle Script -->
  <script>
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  </script>

</body>

</html>

