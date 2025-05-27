<!DOCTYPE html>
<html>
    <jsp:include page="../components/Header.jsp" />
    <body>
        <script src="js/api/Livre.js"></script>
        <jsp:include page="../components/NavBar.jsp" />
        <jsp:include page="../components/SideBar.jsp"/>
        <jsp:include page="../components/PageLivre/InsertModalLivre.jsp" />
        <jsp:include page="../components/PageLivre/UpdateModalLivre.jsp" />

         <div class="content">
        
            <div  class="section">
               <div class="d-flex justify-content-between align-items-center mb-4">
                        <h2>Liste des livres </h2>
                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Ajouter un livre</button>
               </div>
                 <div class="input-group">
                        <span class="input-group-text bg-white">
                               <i class="ri-search-line text-secondary"></i>
                               <input type="text" class="form-control" placeholder="Rechercher un membre..." id="searchInput">
                        </span>
                                  
                </div>
                <div class="row">
                        <jsp:include page="../components/PageLivre/TableLivre.jsp" />
                </div>
            </div>
        </div>       
    <script src="js/LivreManagement.js"></script>   
    <script src="bootstrap/js/bootstrap.js"></script>
     <script>
         document.title="gestion des livres"
     </script>
    </body>
</html>