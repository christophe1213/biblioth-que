<%-- 
    Document   : ListeRendu
    Created on : 30 mai 2025, 17:57:28
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"  %>
<%@page import="Models.Rendre"  %>
<%@page import="Models.RendreDao"  %>
<%@page import="Service.FormatDate"  %>

<%
     List<Rendre> rendus=  (List<Rendre>)request.getAttribute("rendus");
      rendus=  (List<Rendre>)request.getAttribute("rendus");
     String error = (String)request.getAttribute("error");
    
%>
 
 <div class="p-4 custom-border">
                      <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="fs-5 fw-medium text-dark">Rendus enregistrés</h4>
                       
                     </div>
   <div class="table-responsive">
          <table class="table table-bordered table-striped">
            <thead class="table-dark">
              <tr>
                <th>Code livres</th>
                <th>Livres</th>
                <th>date de rendus</th>
      
              </tr>
            </thead>
            
            <tbody id="tableRendu" >
                 <%
                        
                        if(rendus!=null)
                        for(Rendre rendu:rendus){
                    %>
                   <tr>
                           <td><%=rendu.livre.getCodeLivre()%></td>
                            <td><%=rendu.livre.getDesign()%></td>
                            <td><%=FormatDate.formatDDMMyyyy(rendu.getDateRendu())%></td>
                    
                    </tr>
                 
                     <%
                
                        
                    }else
                        out.print("data is null");
            %>
  
        
        

            </tbody>
          </table>
 </div>

</div>


