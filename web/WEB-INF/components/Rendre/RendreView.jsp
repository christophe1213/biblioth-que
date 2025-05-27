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
 <%
                        
                        if(rendus!=null)
                        for(Rendre rendu:rendus){
                    %>
                   <tr>
                            <td><%=rendu.membre.getNom()%></td>
                            <td><%=rendu.livre.getDesign()%></td>
                            <td><%=FormatDate.formatDDMMyyyy(rendu.getDateRendu())%></td>
                            <td>
                                <button class="btn btn-success"
                                         data-bs-toggle="modal" data-bs-target="#updateModal" 
                                       
                                        >
                                        <div class="w-8 h-8 flex items-center justify-center">
                                            <i class="ri-edit-line"></i>
                                        </div>
                                    </button>
                                   <button class="btn btn-sm btn-danger me-2"
                                    
                                   data-bs-toggle="modal" data-bs-target="#deleteModal"
                                   >
                                        <div class="w-8 h-8 flex items-center justify-center">
                                            <i class="ri-delete-bin-line"></i>
                                        </div>
                                    </button>
                             </td>
                            <td>
                    </tr>
                 
                     <%
                
                        
                    }else
                        out.print("data is null");
            %>
  
        
        
