<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../components/Header.jsp" />
    <body>
        <script src="js/api/Livre.js"></script>
        <jsp:include page="../components/NavBar.jsp" />
        <jsp:include page="../components/SideBar.jsp"/>
       

         <div class="content">
        
            <div  class="section">
                <main class="container py-4 ">
                    <div class="bg-white shadow-sm rounded overflow-hidden mb-4">
                         <div class="px-3 py-3 custom-border">
                            <h3 class="fs-4 fw-medium text-dark">Historique des prêts </h3>
                        </div>
                         <jsp:include page="../components/Historique/InfoMembre.jsp" />
                         <jsp:include page="../components/Historique/ListePrets.jsp" />
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
