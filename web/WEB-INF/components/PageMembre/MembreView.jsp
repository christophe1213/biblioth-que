<%-- 
    Document   : MembreView
    Created on : 17 mai 2025, 22:26:09
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"  %>
<%@page import="Models.Membre"  %>
<%
      List<Membre> membres=  (List<Membre>)request.getAttribute("membres");
      membres=  (List<Membre>)request.getAttribute("membres");
      String error = (String)request.getAttribute("error");
%>
      
              <!-- Contenu dynamique -->
                    <%
                    if(membres!=null)
                        for(Membre membre:membres){
                    %>
                   <tr>
                            <td><%=membre.getNumMembre()%></td>
                            <td><%=membre.getNom()%></td>
                            <td><%=membre.getSexe() %></td>
                            <td><%=membre.getAge() %></td>
                            <td><%=membre.getContact() %></td>
                            <td><%=membre.getEmail() %></td>
                            <td>
                              <!--button class="btn btn-sm btn-success me-2" 
                                 data-bs-toggle="modal" data-bs-target="#update"     
                                 onclick="setDataMembreUpdate(
                                             '<%=membre.getNumMembre()%>',
                                             '<%=membre.getNom()%>',
                                             '<%=membre.getSexe()%>',
                                             <%=membre.getAge()%>,
                                             '<%=membre.getContact()%>',
                                             ''
                                                         
                                             )""
                                 >Modifier</button>
                              <button class="btn btn-sm btn-danger" id=""  onclick="deleteMembre('<%=membre.getId()%>')">Supprimer</button>
                             <button class="btn btn-sm btn-outline-primary me-1" title="Modifier">
          <i class="ri-pencil-line"></i>
        </button>
        <button class="btn btn-sm btn-outline-danger me-1" title="Supprimer">
          <i class="ri-delete-bin-line"></i>
        </button>
        <button class="btn btn-sm btn-outline-secondary" title="Voir historique"
          onclick=" window.location.href='<%=request.getContextPath()%>/Historique/pret/get?id=4'">
          <i class="ri-book-2-line"></i>    
        </button>
          <button class="btn btn-sm btn-outline-info me-1" title="Voir emprunts"
  onclick="window.location.href = 'historique.html?id=${membre.id}&type=emprunt'">
  <i class="ri-book-open-line"></i>
</button>
<button class="btn btn-sm btn-outline-success" title="Voir rendus"
  onclick="window.location.href = 'historique.html?id=${membre.id}&type=rendu'">
  <i class="ri-check-double-line"></i>
</button-->
                            
                            </td>
                    </tr>
                 
                     <%
                
                        
                    }
            %>
  
            