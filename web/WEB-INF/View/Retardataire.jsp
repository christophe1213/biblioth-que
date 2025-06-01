<%-- 
    Document   : Retardataire
    Created on : 1 juin 2025, 21:25:53
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <jsp:include page="../components/Header.jsp" />
    <body>
       
        <jsp:include page="../components/NavBar.jsp" />
        <jsp:include page="../components/SideBar.jsp"/>
       
      
       <div class="content">
        
            <div  class="section">
                <main class="container py-4 ">
                    <div class="bg-white shadow-sm rounded overflow-hidden mb-4">
                         <div class="px-3 py-3 custom-border">
                            <h3 class="fs-4 fw-medium text-dark">Listes des retardataires </h3>
                        </div>
                         <div class="row">
                         <jsp:include page="../components/Retardataire/RetardataireView.jsp" />
                        </div>
                       
                       
                    </div>
                </main>
            </div>
        </div>       
    <script src="js/LivreManagement.js"></script>   
    <script src="bootstrap/js/bootstrap.js"></script>
     <script>
         document.title="gestion des livres"
     </script>
         
    </body>
</html>
