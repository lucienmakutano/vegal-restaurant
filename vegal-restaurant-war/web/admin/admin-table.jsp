<%-- 
    Document   : admin-table
    Created on : 17-Aug-2020, 06:35:01
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

  <title>Admin Portal</title>

  <!-- Bootstrap core CSS -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="assets/css/simple-sidebar.css" rel="stylesheet">

  <link rel="shortcut icon" href="assets/images/signin-vegal.png">

</head>

<body>

  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">Admin Portal</div>
      <div class="list-group list-group-flush">
        <a href="adminfood.jsp" class="list-group-item list-group-item-action bg-light">Add food</a>
        <a href="admin-users.jsp" class="list-group-item list-group-item-action bg-light">Manage Users</a>
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
        <button class="btn btn-primary" id="menu-toggle">Menu</button>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="admin-table.jsp">Home Page <span class="sr-only">(current)</span></a>
            </li>
            <!--
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
        -->
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Options
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <!-- <a class="dropdown-item" href="#">User Profile</a> -->
                <!-- <a class="dropdown-item" href="#">Another action</a> -->
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="admin-login.jsp">Logout</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>

      <div class="container-fluid">
        <h1 class="mt-4">Table Allocation</h1>
        <div class="row justify-content-center">
            <table class="table">
              <thead>
                <tr>
                  <th>Table ID</th>
                  <th>Table Name</th>
                  <th>Table Status</th>
                  <th colspan="2">Action</th>
                </tr>
              </thead>
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                  <a href="" class ="btn btn-info"> Edit </a>
                  <a href="" class ="btn btn-danger"> Delete </a>
                </td>
              </tr>
          </table>
        </div>
        <div class="row justify-content-center">
          <form action="" method="POST">
            <div class="form-group">
            <label>Table ID</label>
            <input type="text" name="table-id" class="form-control" value="" placeholder="Table ID">
            </div>
            <div class="form-group">
            <label>Table Name</label>
            <input type="text" name="table-name" class="form-control" value="" placeholder="Table Name">
            </div>
            <div class="form-group">
            <label>Table Status</label>
            <input type="text" name="table-status" class="form-control" value="" placeholder="Table Status">
            </div>
            <div class="form-group">
            <button type="submit" name="update" class="btn btn-info">Update</button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <!-- /#page-content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Bootstrap core JavaScript -->
  <script src="assets/jquery/jquery.min.js"></script>
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

