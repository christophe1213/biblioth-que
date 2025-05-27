<%-- 
    Document   : TableLivre
    Created on : 12 mai 2025, 21:27:56
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="table-responsive">
          <table class="table table-bordered table-striped">
            <thead class="table-dark">
              <tr>
                <th>#</th>
                <th>Livre</th>
                <th>exemplaire</th>
                <th>Actions</th>
              </tr>
            </thead>
            
            <tbody id="employeeTableBody">
                <jsp:include page="LivreView.jsp"/>
            </tbody>
          </table>
 </div>
 <script>
     getLivre();
 </script>