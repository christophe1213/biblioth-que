<%-- 
    Document   : RetardataireView
    Created on : 1 juin 2025, 21:40:35
    Author     : Thierry Christophe
--%>
<%@page import="java.util.List"  %>
<%@page import="Models.Preter"  %>
<%@page import="Models.PreterDao"  %>
<%@page import="Service.FormatDate"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
      List<Preter> prets=  (List<Preter>)request.getAttribute("prets");
      prets=  (List<Preter>)request.getAttribute("prets");
      String error = (String)request.getAttribute("error");
       prets=  (List<Preter>)request.getAttribute("prets");
     //  prets= new PreterDao().getAll();
%>

    <div id="liste-livres-container" class="table-responsive">
        <table class="table table-bordered table-hover align-middle">
            <thead class="table-light text-uppercase text-secondary small">
                <tr>
                     <th scope="col">Numéro de membre</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Livre</th>
                    <th>Date Limite</th><th scope="col">nombre de jours de retard</th>
                    <th scope="col"></th>
                </tr>
            </thead>
 <tbody id="liste-livres">
<%
        if(prets!=null)  {              
                for(Preter pret:prets){
                    %>
                   <tr>
                             <td><%=pret.membre.getNumMembre()%></td>
                            <td><%=pret.membre.getNom()%></td>  
                            <td><%=pret.livre.getDesign()%></td>
                          
                            <td><%=FormatDate.formatDDMMyyyy(pret.getDateRetour())%></td>
                          <td><%=FormatDate.differrenceDay(pret.getDateRetour())%></td>
                    </tr>
                 
                     <%
                
                        
                    }

 }else {
            %>
               <tr id="aucun-livre" class="text-center">
                    <td colspan="5" class="text-muted small py-3">Aucun livre ajouté</td>
                </tr>
             <%
                
                        
                    }


            %>
    </tbody>
 </table>
     </div>