<%-- 
    Document   : adminreport
    Created on : Aug 14, 2020, 11:56:10 PM
    Author     : Lyvia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*;" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
            body > table{
    width: 80%;
}

table{
    border-collapse: collapse;
    
}
.container{
    margin: auto;
    width: 60%;
    border: 2px solid #dddddd;
    border-radius: 20px;
    padding: 50px;
}

table.list{
    width:100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

th{
    background-color: #1E90FF;
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
<script>
    function Redirect(){
        window.location="adminfood.jsp";
    }
</script>
    </head>
    <body>
        <div class="container">
         <table class="list" id="FoodList">
                    <thead>
                        <tr>
                            <th>Food ID</th>
                            <th>Food Name</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Date</th>
                            
                             
                        </tr>
                        
                            <%
                             try{
                             
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/vegal-restaurant?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",""); 
                             String Query="Select* from food";
                             Statement stm= conn.createStatement();
                             ResultSet rs= stm.executeQuery(Query);
                             while(rs.next()){
                             %>
                             <tr>
                             <td><%=rs.getInt("food_id")%></td>
                             <td><%=rs.getString("name")%></td>
                             <td><%=rs.getInt("price")%></td>
                             <td><%=rs.getString("image")%></td>
                             <td><%=rs.getDate("date_added")%></td>
                             </tr>
                             <%
                             }
                             
                             }
                             catch(Exception e){
                             out.println(e);}
                            
                            
                            
                            %>
                            
                        
                    </thead>
                    <tbody>

                    </tbody>
                </table>
                            <div  class="form-action-buttons">
                        <input type="button" value="Back" onclick="Redirect();">
                    </div>
        </div>
        </body>
</html>
