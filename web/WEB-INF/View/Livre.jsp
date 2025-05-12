<!DOCTYPE html>
<html>
    <jsp:include page="../components/Header.jsp" />
    <body>
        <script src="js/dd/Livre.js"></script>
        <jsp:include page="../components/NavBar.jsp" />
        
        <jsp:include page="../components/PageLivre/InsertModalLivre.jsp" />
        <div class="container my-5">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h2>Liste des livres </h2>
                <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Ajouter un livre</button>
            </div>
        
        <div class="row">
              <jsp:include page="../components/PageLivre/TableLivre.jsp" />
        </div>
      </div>
     <script src="bootstrap/js/bootstrap.js"></script>
    </body>
</html>