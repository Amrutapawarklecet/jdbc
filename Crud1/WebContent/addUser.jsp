<%@page import="com.bean.StudentBean"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	table,td{
	border:1px solid black;
	border-collapse:collapse;
	
	}
	table.center{
	margin-left:auto;
	margin-right:auto;
	}

</style>
</head>

<body style="background-color:Lightblue">
 <h1>Welcome to Student Portal</h1>
 <hr/>


<!-- add java code in jsp using scrpit late -->
<% 
  /*
   Object obj=request.getAttribute("msg");
   String msg=(String)obj;
   */
   
  String msg=(String)request.getAttribute("msg");
  if(msg!=null){
 %>
  <!-- printing the value using expression-->
  <p style="color:red"><%= msg %></p>	
  <%
    
   }
%>


<!-- <a href="ViewAllStudentServlet">View All Student</a> -->
<h2>Add User</h2>
   
  
 

<form action="AddStudentServlet">
  <input type="text" name="sid" placeholder="Student Id"/><br>
  <input type="text" name="sname" placeholder="Student Name"/><br>
  <input type="text" name="email" placeholder="Email"/><br>
  <input type="submit" value="Add User"/>
  </form>
 
   
  
   <!-- From -->
 <!-- <div class="col-sm-4">
 	 	<form  method="POST" action="AddStudentServlet">
 	 		<div align="left">
 	 		   <label class="form-label">Student Id</label>
 	 		   <input type="text" class="form-control" placeholder="Student Id" 
 	 		         name="sid" id="sid" requried>
 	 		</div></br>
 	 	
 	 	    <div align="left">
 	 		   <label class="form-label">Student Name</label>
 	 		   <input type="text" class="form-control" placeholder="Student Name" 
 	 		         name="sname" id="sname" requried>
 	 		</div></br>
 	 		
 	 		<div align="left">
 	 		   <label class="form-label">Student Email</label>
 	 		   <input type="text" class="form-control" placeholder="Student Email" 
 	 		         name="email" id="email" requried>
 	 		</div></br>
 	 		
 	 		<div align="left">
 	 		   <input type="submit" name="submit" id="submit"  value="submit" class="btn-info">
 	 		    <input type="reset" name="reset" id="reset"  value="reset" class="btn-warning">
 	 		</div><br>
 	 	
 	 	</form>
 	</div>
    -->
  
  <!--  Reading Student List --> 
  <%
    Object obj=request.getAttribute("studentList");
  if(obj!=null){
	  List<StudentBean>  studentList=(List)obj;
	  %>
	 
 	
 	<!-- table -->

	 <table class="center">
 			
 				<tr>
 					<th>Student Id</th>
 					<th>Student Name</th>
 					<th>Student Email</th>
 					<th>Edit</th>
 					<th>Delete</th>
 			   </tr>
 			   
 			   <c:forEach var="s" items="${list}">

                <tr>
                    <td><c:out value="${s.sid}" /></td>
                    <td><c:out value="${s.sname}" /></td>
                    <td><c:out value="${s.email}" /></td>
                    <td>
                        <a href="EditServlet?sid=${s.sid}">Edit</a>
                        </td>
                     <td>  <a href="DeleteServlet?sid=${s.sid}">Delete</a>
                    </td>   
                </tr>
                </c:forEach>
            

      <% 
      }
      %>
</body>
</html>