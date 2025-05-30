<%-- 
    Document   : InfoMembre
    Created on : 29 mai 2025, 15:00:17
    Author     : Thierry Christophe
--%>
<%@page import="Models.Membre"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
      Membre membre=  (Membre)request.getAttribute("membre");
      membre=  (Membre)request.getAttribute("membre");
      String error = (String)request.getAttribute("error");
%>
   <div class="p-4 custom-border">
                        <h4 class="fs-5 fw-medium text-dark mb-3">Informations de l'emprunteur</h4>
                        <div class="row ">
                            <p><strong>numéro du Membre :</strong><%=membre.getNumMembre()%></p>
                            <p><strong>Nom :</strong><%=membre.getNom()%></p>
                            <p><strong>email :</strong><%=membre.getEmail()%></p>
                            <p><strong>contact :</strong><%=membre.getContact()%></p>
                            
                        </div>
                      
</div>
