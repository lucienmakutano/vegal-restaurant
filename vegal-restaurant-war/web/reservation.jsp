<%-- 
    Document   : reservation
    Created on : 15-Aug-2020, 14:19:05
    Author     : kenne
--%>

<%@page import="ejb.entities.Table"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Reserve a table</title>

  <!-- Bootstrap core CSS -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="assets/css/simple-sidebar.css" rel="stylesheet">
  
  <link rel="alternate" type="application/json+oembed" href="https://www.jotform.com/oembed/?format=json&amp;url=https%3A%2F%2Fform.jotform.com%2F202207122956550" title="oEmbed Form">
<link rel="alternate" type="text/xml+oembed" href="https://www.jotform.com/oembed/?format=xml&amp;url=https%3A%2F%2Fform.jotform.com%2F202207122956550" title="oEmbed Form">
<meta property="og:title" content="Restaurant Reservation Form" >
<meta property="og:url" content="https://form.jotform.com/202207122956550" >
<meta property="og:description" content="Please click the link to complete this form.">
<meta name="slack-app-id" content="AHNMASS8M">
<link rel="shortcut icon" href="https://cdn.jotfor.ms/favicon.ico">
<link rel="canonical" href="https://form.jotform.com/202207122956550" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=1" />
<meta name="HandheldFriendly" content="true" />
<title>Restaurant Reservation Form</title>
<link type="text/css" media="print" rel="stylesheet" href="https://cdn.jotfor.ms/css/printForm.css?3.3.19459" />
<link type="text/css" rel="stylesheet" href="https://cdn.jotfor.ms/themes/CSS/5e6b428acc8c4e222d1beb91.css?themeRevisionID=5eb3b4ae85bd2e1e2966db96"/>
<link type="text/css" rel="stylesheet" href="https://cdn.jotfor.ms/css/styles/payment/payment_styles.css?3.3.19459" />
<link type="text/css" rel="stylesheet" href="https://cdn.jotfor.ms/css/styles/payment/payment_feature.css?3.3.19459" />
<style type="text/css" id="form-designer-style">
    /* Injected CSS Code */
.form-label.form-label-auto {
        
        display: inline-block;
        float: left;
        text-align: left;
      
      }
    /* Injected CSS Code */
</style>

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
        <h1 class="mt-4">Ready to book a table?</h1>
        <p>Click the link below to fill out the reservation form.</p>
        
        <form class="jotform-form" 
              action="make-reservation" method="post" 
              name="form_202207122956550" 
              accept-charset="utf-8" 
              autocomplete="off"
        >
            <div role="main" class="form-all">
              <ul class="form-section page-section">
                <li id="cid_18" class="form-input-wide" data-type="control_head">
                  <div class="form-header-group  header-large">
                    <div class="header-text httal htvam">
                      <h1 id="header_18" class="form-header" data-component="header">
                        Reservation Form
                      </h1>
                      <div id="subHeader_18" class="form-subHeader">
                        Please fill the form below accurately to enable us serve you better!.. welcome!
                      </div>
                    </div>
                  </div>
                </li>
                <li class="form-line" data-type="control_textbox" id="id_6">
                  <label class="form-label form-label-left form-label-auto" id="label_6" for="input_6">Telephone number </label>
                  <div id="cid_6" class="form-input" data-layout="half">
                    <input type="text" id="input_6" name="phone" data-type="input-textbox" required class="form-textbox" style="width:20px" size="20" value="" maxLength="100" placeholder=" " data-component="textbox" aria-labelledby="label_6" />
                  </div>
                </li>
                <li class="form-line" data-type="control_dropdown" id="id_13">
                  <label class="form-label form-label-left form-label-auto" id="label_13" for="input_13">Number of seats </label>
                  <div id="cid_13" class="form-input" data-layout="half">
                      <select class="form-dropdown" id="input_13" name="table_id" required style="width:150px" data-component="dropdown" aria-labelledby="label_13">
                      <option value=""> Please Select </option>
                      <option value="value"> Please </option>
                      <%
                            List<Table> tables = (List<Table>) request.getAttribute("tables");

                            for (Table table : tables) {
                                out.print("<option value='"+ table.getId() +"'> "+ table.getNumOfSeats() +" </option>");
                            }
                      %>
                    </select>
                  </div>
                </li>
                <li class="form-line" data-type="control_textbox" id="id_6">
                  <label class="form-label form-label-left form-label-auto" id="label_6" for="input_6">Table number </label>
                  <div id="cid_6" class="form-input" data-layout="half">
                    <input type="text" id="tableNumber" data-type="input-textbox" required readonly class="form-textbox" style="width:20px" placeholder=" " data-component="textbox" aria-labelledby="label_6" />
                  </div>
                </li>
                <li class="form-line" data-type="control_textbox" id="id_6">
                  <label class="form-label form-label-left form-label-auto" id="label_6" for="input_6"> Date and time </label>
                  <div id="cid_6" class="form-input" data-layout="half">
                      <input type="datetime-local" id="input_6" name="reservation_date" data-type="input-textbox" required class="form-textbox" style="width:20px" value="" placeholder=" " data-component="textbox" aria-labelledby="label_6" />
                  </div>
                </li>
                <li class="form-line" data-type="control_button" id="id_1">
                  <div id="cid_1" class="form-input-wide" data-layout="full">
                    <div data-align="auto" class="form-buttons-wrapper form-buttons-auto   jsTest-button-wrapperField">
                      <button id="input_1" type="submit" class="form-submit-button submit-button jf-form-buttons jsTest-submitField" data-component="button" data-content="">
                        Make your reservation
                      </button>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
        </form>
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
  
  <script>
      $(document).ready(function () {
        $("select#input_13").change(function() {
           let id = $(this).children("option:selected").val();
           alert(id);
           $("#tableNumber").val(id);
        });
      });
  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/punycode/1.4.1/punycode.min.js"></script>
  <script src="https://cdn.jotfor.ms/static/prototype.forms.js" type="text/javascript"></script>
  <script src="https://cdn.jotfor.ms/static/jotform.forms.js?3.3.19459" type="text/javascript"></script>

  
</body>

</html>

