<%-- 
    Document   : LivreView
    Created on : 14 avr. 2025, 12:14:18
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"  %>
<%@page import="Models.Livre" %>
<%
      List<Livre> livres=  (List<Livre>)request.getAttribute("livres");
      livres=  (List<Livre>)request.getAttribute("livres");
      String error = (String)request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Géstion d'un bibliothèque</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    </head>
    <body>
         <nav class="navbar navbar-expand-sm bg-light">

            <div class="container-fluid">
              <!-- Links -->
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="">Acceuil</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="Livre">Livre</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Rendre</a>
                </li>
              </ul>
            </div>
          
          </nav>
        <div>
            Livre
                 <p><%if(error!=null)
                     out.print(error);
                     %></p>
           <div class="table-responsive">
          <table class="table table-bordered table-striped">
            <thead class="table-dark">
              <tr>
                <th>#</th>
                <th>Livre</th>
                <th>exemplaire</th>
                <th>Actions</th>
              </tr>
            </thead>
            
            <tbody id="employeeTableBody">
              <!-- Contenu dynamique -->
                    <%
                    if(livres!=null)
                        for(Livre livre:livres){
                    %>
                   <tr>
                            <td><%=livre.getIdlivre()%></td>
                            <td><%=livre.getDesign()%></td>
                            <td><%=livre.getExemplaire() %></td>
                            <td>
                                <button class="btn btn-sm btn-success me-2">Modifier</button>
                              <button class="btn btn-sm btn-danger">Supprimer</button>
                            </td>
                    </tr>
                 
                     <%
                
                        
                    }
            %>
        </div>
            </tbody>
          </table>
        </div>
      </div>

    
        
        <script src="bootstrap/js/bootstrap.js"></script>
    </body>
</html>