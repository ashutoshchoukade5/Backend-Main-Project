<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!doctype html>
<html lang="en">
  <head>
   
  <body>
  <div class="row">
  
    <h1 class="text-center mb-3">Enter the Employee Record</h1>
       <form action="addRecord" method="post">
  <div class="col">
    <input type="text" class="form-control" placeholder="Enter eid " aria-label="eid" name="eid">
  </div><br>
  <div class="col">
    <input type="text" class="form-control" placeholder="Enter EmployeeName"  name="ename">
  </div>
  <br>
  
  <div class="col">
    <input type="text" class="form-control" placeholder="Enter Employee Email " name="email">
  </div><br>
  
  <div class="col">
    <input type="text" class="form-control" placeholder="Enter Designation" name="desgn">
  </div><br>
  
  <div class="col">
    <input type="number" class="form-control" placeholder="Salary" name="salary">
  </div>
       
        <button type="submit" class="btn btn-primary">Add</button>
        </form>
</div>
        
  </body>
</html>