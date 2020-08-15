<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*;" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            body > table{
    width: 100%;
}
.container{
    margin: auto;
    width: 60%;
    border: 2px solid #dddddd;
    border-radius: 20px;
    padding: 50px;
        
}
.head{
    background-color: #1E90FF;
    text-align: center;
}

table{
    border-collapse: collapse;
}
table.list{
    width:100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
tr:nth-child(even),table.list thead>tr {
    background-color: #dddddd;
}

input[type=text], input[type=number] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit]{
    width: 30%;
    background-color: #ddd;
    color: #000;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

form div.form-action-buttons{
    text-align: right;
}

a{
    cursor: pointer;
    text-decoration: underline;
    color: #0000ee;
    margin-right: 4px;
}

label.validation-error{
    color:   red;
    margin-left: 5px;
}

.hide{
    display:none;
}
        </style>
    </head>
    <body>
        <div class="container">
        <form action="connect.jsp" method="POST">
            <div class="head">
                
                <h2>Admin's Food </h2>
            </div>
                    <div>
                        <label>Food Name</label>
                        <input type="text" name="name" id="name">
                    </div>
                    <div>
                        <label>Price</label>
                        <input type="text" name="price" id="price">
                    </div>
                    <div>
                        <label>Image</label>
                        <input type="file" name="image" id="image">
                    </div>
                    <div  class="form-action-buttons">
                        <input type="submit" value="Submit">
                    </div>
                </form>
        </div>    
          
    </body>
</html>