<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"  %>
<%@page import="Models.Livre" %>
<%@page import="java.util.List"  %>
<%@page import="Models.Membre"  %>

<%
      List<Livre> livres=  (List<Livre>)request.getAttribute("livres");
      livres=  (List<Livre>)request.getAttribute("livres");
       List<Membre> membres=  (List<Membre>)request.getAttribute("membres");
      membres=  (List<Membre>)request.getAttribute("membres");
      String error = (String)request.getAttribute("error");
      
%>

<!DOCTYPE html>
<html>
    <jsp:include page="../components/Header.jsp" />
    <body>
         <jsp:include page="../components/NavBar.jsp" />
         <jsp:include page="../components/SideBar.jsp"/>
         <div class="content">
           
            <div  class="section">
                  <jsp:include page="../components/Emprunt/FormEmprunt.jsp" />
             </div>
            </div>
         </div>  
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
         
         <script>
               const livres = [
            
                 <%
                   
                        for(Livre livre:livres){
                
                 %>
                  { id:'<%=livre.getIdLivre()%>', code:"<%=livre.getCodeLivre()%>", titre:"<%=livre.getDesign()%>",

                  },
                <%
             
                    }
                %>
            ]; 
              const user=[
                 <%
                    if(membres!=null)
                        for(Membre membre:membres){
                    %>
                    {id:"<%=membre.getId()%>",name:"<%=membre.getNom()%>"},
                
                <%}%>
                ]
            console.log(livres)
            </script>
         <script src="<%=request.getContextPath()%>/js/formEmprunt.js"></script>
    </body>
</html>
