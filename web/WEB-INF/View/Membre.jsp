<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../components/Header.jsp" />
    <body>
        <script src="js/dd/Livre.js"></script>
        <jsp:include page="../components/NavBar.jsp" />
        <jsp:include page="../components/SideBar.jsp"/>
       
         <div class="content">
        
            <div  class="section">
               <div class="d-flex justify-content-between align-items-center mb-4">
                        <h2>Liste des membres </h2>
                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Ajouter un membres</button>
               </div>
                <div class="row">
                   
                </div>
            </div>
        </div>       
     <script src="bootstrap/js/bootstrap.js"></script>
     <script>
         document.title="géstion des membres"
     </script>
    </body>
</html>