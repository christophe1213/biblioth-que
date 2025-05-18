<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../components/Header.jsp" />
    <body>
        <script src="js/api/Membre.js"></script>
        <jsp:include page="../components/NavBar.jsp" />
        <jsp:include page="../components/SideBar.jsp"/>
        <jsp:include page="../components/PageMembre/InsertMembreModal.jsp"/>
        <jsp:include page="../components/PageMembre/UpdateMembreModal.jsp"/>

         <div class="content">
        
            <div  class="section">
               <div class="d-flex justify-content-between align-items-center mb-4">
                        <h2>Liste des membres </h2>
                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#add">Ajouter</button>
               </div>
                <div class="row">
                    <jsp:include page="../components/PageMembre/TableMembre.jsp"/>
                </div>
            </div>
        </div>       
     <script src="bootstrap/js/bootstrap.js"></script>
     <script>
         document.title="géstion des membres"
     </script>
    </body>
</html>