<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <style>

.dropbtn {
    background-color: white;
    color: purple;
    padding: 16px;
    font-size: 16px;
    border: 1px;
    border: none;
    cursor: pointer;
    max-width: 200px;
       
}

.dropbtn:hover{
        background-color: purple;
     color:white;
     transition:0.5s;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
    cursor: pointer
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: white;
     color:purple;
     transition:0.5s;
     cursor: pointer
}

.NavBar{
         border-radius:1px;
    background-color:white;
    color: purple;
}
.space{ 
    width:1300px;
    display:inline-block;
 
}

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=submit] {
  width: 100px;
  height: 40px;
  background-color: purple;
  color: white;
  padding: 14px 20px; 
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=submit]:hover {
  background-color: white;
  color: purple;
  border: purple;
  transition: 0.8s;
  opacity: 1
  
}
    </style>
    
  
    <body>
    <div class="NavBar">
    <a href="/home">    <button class="dropbtn">Home </button></a> 
            
            
 <div class="dropdown">
  <button class="dropbtn">Enquiry</button>
  <div class="dropdown-content">
    <a href="/enquiryPlace">Place Enquiry</a>
    <a href="/showEnquiry">View Enquiries</a>
    </div>
    </div>
            
 <div class="dropdown">
  <button class="dropbtn">Orders</button>
  <div class="dropdown-content">
   <a href="/deliveryDetails">Confirm Order</a>
    <a href="/showOrder">Show Orders</a>
    <a href="/selectOrder">Show Order Items</a>
    <a href="/returnItems">Return Products</a>
    <a href="/cancelledOrders">Cancelled Orders</a>
    <a href="/viewReturns">Show returned products</a>
    </div>
    </div>

    <a href="/showDelivery">    <button class="dropbtn"> Deliveries </button></a> 
    
 <div class="space"></div>
  <div class="dropdown">
  <button class="dropbtn">Client Settings    </button>
  <div class="dropdown-content">
    <a href="/registerClient">Register Client</a>
    <a href="/manageAccount">Manage Clients</a>
     <a href="/clientHistory">View Client History</a>
    </div>
    </div>
         <hr />
          
     
      </div>
    </body>
</html>
