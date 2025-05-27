<%-- 
    Document   : TableRendus
    Created on : 27 mai 2025, 08:47:02
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="table-responsive">
          <table class="table table-bordered table-striped">
            <thead class="table-dark">
              <tr>
                <th>Membre</th>
                <th>Livres</th>
                <th>date de rendus</th>
                <th>action</th>
              </tr>
            </thead>
            
            <tbody id="tableRendu" >
                 <jsp:include page="RendreView.jsp"/>
            </tbody>
          </table>
 </div>


