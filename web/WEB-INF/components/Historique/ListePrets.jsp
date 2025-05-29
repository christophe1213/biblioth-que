<%-- 
    Document   : ListePrets.jsp
    Created on : 29 mai 2025, 15:05:02
    Author     : Thierry Christophe
--%>
<%@page import="java.util.List"  %>
<%@page import="Models.Preter"  %>
<%@page import="Models.PreterDao"  %>
<%@page import="Service.FormatDate"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
      List<Preter> prets=  (List<Preter>)request.getAttribute("prets");
      prets=  (List<Preter>)request.getAttribute("prets");
      String error = (String)request.getAttribute("error");
       prets=  (List<Preter>)request.getAttribute("prets");
     //  prets= new PreterDao().getAll();
%>

 <div class="p-4 custom-border">
                      <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="fs-5 fw-medium text-dark">Prêts enregistrés</h4>
                       
                     </div>
    <div id="liste-livres-container" class="table-responsive">
        <table class="table table-bordered table-hover align-middle">
            <thead class="table-light text-uppercase text-secondary small">
                <tr>
                    <th scope="col">Code livre</th>
                    <th scope="col">Titre du livre</th>
                    <th scope="col">Date d'emprunt</th>
                    <th scope="col">Date de retour</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody id="liste-livres">
              
                    <%
                        if(prets==null){
                        
                    %>
                        <tr id="aucun-livre" class="text-center">
                            <td colspan="5" class="text-muted small py-3"></td>
                        </tr>
                    <%
                         } else for(Preter pret:prets){
                    %>
                   <tr>
                            <td><%=pret.livre.getCodeLivre()%></td>
                            <td><%=pret.livre.getDesign()%></td>
                            <td><%=FormatDate.formatDDMMyyyy(pret.getDatePres())%></td>
                            <td><%=FormatDate.formatDDMMyyyy(pret.getDateRetour())%></td>
                           
                    </tr>
                 
                     <%
                
                        
                    }
            %>
  
            </tbody>
        </table>
    </div>

</div>
