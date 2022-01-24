<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Benvenuto</title>
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <h2>Ciao! Come ti chiami?</h2>
            <form action="StartGameServlet" method="post">
                <input type="text" name="username">
                <input type="submit" name="Inizia Nuovo Gioco">
            </form>
        </div>
    </body>
</html>
