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

            
            
              <!-- Contenu dynamique -->
                    <%
                    if(livres!=null)
                        for(Livre livre:livres){
                    %>
                   <tr>
                            <td><%=livre.getCodeLivre()%></td>
                            <td><%=livre.getDesign()%></td>
                            <td><%=livre.getExemplaire() %></td>
                            <td>
                              <button class="btn btn-sm btn-success me-2" 
                                 data-bs-toggle="modal" data-bs-target="#update"     
                                 onclick="setDataUpdate(
                                             '<%=livre.getIdLivre()%>',
                                             '<%=livre.getDesign()%>',
                                             <%=livre.getExemplaire()%>,
                                             )""
                                 >Modifier</button>
                              <button class="btn btn-sm btn-danger" id=""  onclick="deleteLivre('<%=livre.getIdLivre()%>')">Supprimer</button>
                            </td>
                    </tr>
                 
                     <%
                
                        
                    }
            %>
  
        