<%-- 
    Document   : connect
    Created on : Aug 14, 2020, 9:38:40 PM
    Author     : Lyvia
--%>

<%@ page import= "java.sql.*" %>
<%
 String Name= request.getParameter("name");  
 String Price= request.getParameter("price"); 
 String Image= request.getParameter("image"); 

try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/vegal-restaurant?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
PreparedStatement ps= conn.prepareStatement("INSERT INTO food(name, price, image) VALUES (?,?,?)");
ps.setString(1,Name);
ps.setString(2,Price);
ps.setString(3,Image);
int x=ps.executeUpdate();
response.sendRedirect("adminreport.jsp");
if(x > 0){
    System.out.println("Food added successfully..");
    
}else{
    System.out.println("Food not added..");
}

}catch(Exception e){
out.println(e);}


%>