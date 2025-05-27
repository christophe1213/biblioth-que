<%-- 
    Document   : Rendre.jsp
    Created on : 14 mai 2025, 16:46:10
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <jsp:include page="../components/Header.jsp" />
    <body>
        <script src="js/api/Rendre.js"></script>
        <jsp:include page="../components/NavBar.jsp" />
        <jsp:include page="../components/SideBar.jsp"/>
        <jsp:include page="../components/Rendre/UpdateModal.jsp"/>
        <jsp:include page="../components/Rendre/DeleteModal.jsp"/>
      
         <div class="content">

             <div  class="section">
               <div class="d-flex justify-content-between align-items-center mb-4">
                        <h2>Listes de rendus </h2>
                       
               </div>
               
                <div class="row">
                        <jsp:include page="../components/Rendre/TableRendus.jsp"/>
                </div>
            </div>
            </div>
         </div>  
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
         <script>
             document.title="emprunt"
         </script>
    </body>
</html>
