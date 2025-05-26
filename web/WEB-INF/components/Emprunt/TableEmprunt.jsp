<%-- 
    Document   : TableEmprunt
    Created on : 26 mai 2025, 06:10:43
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="table-responsive">
          <table class="table table-bordered table-striped">
            <thead class="table-dark">
              <tr>
                <th>Membre</th>
                <th>Livres</th>
                <th>date de prêts</th>
                <th>date de retour</th>
              </tr>
            </thead>
            
            <tbody id="tablePreter" >
                 <jsp:include page="EmpruntView.jsp"/>
            </tbody>
          </table>
 </div>
