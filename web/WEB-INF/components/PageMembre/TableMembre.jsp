<%-- 
    Document   : TableMembre
    Created on : 17 mai 2025, 22:43:27
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="table-responsive">
          <table class="table table-bordered table-striped">
            <thead class="table-dark">
              <tr>
                <th>#</th>
                <th>Nom</th>
                 <th>sexe</th>
                 <th>age</th>
                 <th>contact</th>
                <th>Actions</th>
              </tr>
            </thead>
           
            <tbody id="membreTbody">
                  <jsp:include page="MembreView.jsp"/>
            </tbody>
          </table>
 </div>
 <script>
     getMembre();
 </script>

