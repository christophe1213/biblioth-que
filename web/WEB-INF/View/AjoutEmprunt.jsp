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
    <jsp:include page="../components/Header.jsp" />
    <body>
         <jsp:include page="../components/NavBar.jsp" />
         <jsp:include page="../components/SideBar.jsp"/>
          <div class="content">
        
            <div  class="section">
               <div class="d-flex justify-content-between align-items-center mb-4">
                        <h2>Emprunter un livre </h2>
                        
               </div>
                <div class="row">
                    
                        <div class="col-md-12">
                            
                            <div class="card p-4 shadow">
                                <h4>Preter un livre</h4>
                            <div class="mb-3">
                                <label class="form-label">numéro membre</label>
                                <input type="text" id="productName" class="form-control">
                            </div>
                               <div class="mb-4">
                    <label for="membre" class="form-label">livre</label>
                    <select id="membre" class="form-select" required>
                        <option value="">Sélectionnez un livre</option>
                        <option value="1">Jean Dupont</option>
                        <option value="2">Marie Martin</option>
                             <%
                    if(livres!=null)
                        for(Livre livre:livres){
                    %>
                        <option value="<%=livre.getIdlivre()%>"><%=livre.getDesign()%></option>
                     <%
                                
                        
                    }
            %>
                       
                    </select>
                </div>
                        
                            <button class="btn btn-primary" onclick="addToCart()">Ajouter</button>
                        </div>
                        </div>
                </div>
            </div>
        </div>  
          <script src="bootstrap/js/bootstrap.js"></script>
         <script>
                 const books = [
                          <%
                            if(livres!=null)
                                for(Livre livre:livres){
                          %>
                                
                     
                            { id:"<%=livre.getIdlivre()%>" , title: "<%=livre.getDesign()%>" },       
                          
              <%}%>
              console.log(books)
             document.title="ajouter emprunt"
         </script>
    </body>
</html>
