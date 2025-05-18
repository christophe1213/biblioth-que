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
         <tbody>
              <!-- Contenu dynamique -->
                    <%
                    if(membres!=null)
                        for(Membre membre:membres){
                    %>
                   <tr>
                            <td><%=membre.getIdpers()%></td>
                            <td><%=membre.getNom()%></td>
                            <td><%=membre.getSexe() %></td>
                            <td><%=membre.getAge() %></td>
                            <td><%=membre.getContact() %></td>
                            <td>
                              <button class="btn btn-sm btn-success me-2" 
                                 data-bs-toggle="modal" data-bs-target="#update"     
                                 onclick="setDataMembreUpdate(
                                             '<%=membre.getIdpers()%>',
                                             '<%=membre.getNom()%>',
                                             '<%=membre.getSexe()%>',
                 
                                             <%=membre.getAge()%>,
                                             ''
                                                         
                                             )""
                                 >Modifier</button>
                              <button class="btn btn-sm btn-danger" id=""  onclick="deleteMembre('<%=membre.getIdpers()%>')">Supprimer</button>
                            </td>
                    </tr>
                 
                     <%
                
                        
                    }
            %>
  
            </tbody>