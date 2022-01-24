<%-- 
    Document   : game
    Created on : 17-gen-2022, 10.24.51
    Author     : paoloaliprandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MineSweeper</title>
        <style>
            .cella {
                width: 20px;
                height: 20px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h2>Ciao <%= request.getParameter("username") %></h2>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            
            
            
            //$(document).ready(function () {
            //  console.log("Inizio");       
            //   generateGriglia();
            //});
            
            window.onload = function() {
                generateGriglia();
            }
            
            function f(elem) {
             var id=elem.id;
             console.log("Cella "+id);
             $.ajax({
                    type: 'GET',
                    url: 'GetValueServlet',
                    data: 'id='+id+'&username=<%= request.getParameter("username") %> ',
                    datatype: 'html',
                    success: function (data) {
                      var json = JSON.parse(data);
                      if (json.isBomba) {
                          alert("BOMBAAAAA!!!!!");
                          document.getElementById(id).style="border-color: red; color: red; border-width: thick; margin:0; padding:20px; display:inline-block;";
                          document.getElementById(id).innerText = "B";
                          
                      } else {
                        
                        document.getElementById(id).style="border-color: blue; border-width: thick; margin:0; padding:20px; display:inline-block;";
                        document.getElementById(id).innerText = json.valore;
                        }
                        document.getElementById(id).disable;
                    }
                        
                });
            }
            
            function restart() {
                location.replace('StartGameServlet?username=<%= request.getAttribute("username") %>');
                console.log("New Game");
            }
            
            function test(elem) {
                
                var row=document.getElementById("riga").value;
                var col=document.getElementById("colonna").value;
                
                console.log("Riga: "+row+" Colonna: "+col);
                
                var id = ""+row+col;
                console.log(id);
                
                $.ajax({
                    type: 'GET',
                    url: 'GetValueServlet',
                    data: 'id='+id+'&username=<%= request.getParameter("username") %> ',
                    datatype: 'html',
                    success: function (data) {
                        var json = JSON.parse(data);
                      document.getElementById("result").innerText="Result is "+json.valore;
                    }
                        
                });
                
            }
            
            function generateGriglia() {
            
                table = document.getElementById("grid");
                
                for (var i =1; i<=9; i++) {
                    
                    var tr=document.createElement("tr");
                    
                    for (var j=1; j<=9; j++) {
                        
                        let style="";
                        
                        var td = document.createElement("td");
                        var button = document.createElement("button");                        

                        button.id = ""+i+""+j;
                        style = style + "border-color: green; border-width: thick; margin:0; padding:20px; display:inline-block;";                      
                        
                        button.style = style;
                        button.setAttribute("onclick","f(this)");
                        button.setAttribute("class","cella");
                        
                        td.appendChild(button);
                        tr.appendChild(td);                       
                    }                   
                    table.appendChild(tr);
                    //console.log("*****"+table);
                }
            }
            
        </script>
          <table id="grid"></table>
          <br>
          <div>
              <select id="riga">
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
              <option>6</option>
              <option>7</option>
              <option>8</option>
              <option>9</option> 
              </select> 
              <select id="colonna">
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
              <option>6</option>
              <option>7</option>
              <option>8</option>
              <option>9</option> 
              </select> 
            <button onclick="test()">Test</button>
            <p id="result">Result is </p>
          </div>
          <button onclick="restart()">Restart</button>
    </body>
</html>
