<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../components/Header.jsp" />
    <body>
        <jsp:include page="../components/NavBar.jsp" />
        <jsp:include page="../components/SideBar.jsp"/>
         <div class="content">

             <div  class="section">
               <div class="d-flex justify-content-between align-items-center mb-4">
                        <h2>Listes d'emprunt </h2>
                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Ajouter un emprunt</button>
               </div>
                <div class="row">
                        <jsp:include page="../components/Emprunt/TableEmprunt.jsp"/>
                </div>
              <a href="Membre" class="link-sidebar" >Membres</a>
            </div>
            </div>
         </div>  
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
         <script>
             
         </script>
    </body>
</html>
