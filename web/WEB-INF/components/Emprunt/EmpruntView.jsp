<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"  %>
<%@page import="Models.Preter"  %>
<%@page import="Models.PreterDao"  %>
<%@page import="Service.FormatDate"  %>
<%
      List<Preter> prets=  (List<Preter>)request.getAttribute("prets");
      prets=  (List<Preter>)request.getAttribute("prets");
      String error = (String)request.getAttribute("error");
       prets=  (List<Preter>)request.getAttribute("prets");
     //  prets= new PreterDao().getAll();
%>
 <%
                        for(Preter pret:prets){
                    %>
                   <tr>
                            <td><%=pret.membre.getNom()%></td>
                            <td><%=pret.livre.getDesign()%></td>
                            <td><%=FormatDate.formatDDMMyyyy(pret.getDatePres())%></td>
                            <td><%=FormatDate.formatDDMMyyyy(pret.getDateRetour())%></td>
                            <td>
                                <!--button class="btn btn-success"
                                         data-bs-toggle="modal" data-bs-target="#updateModal" 
                                         onclick="setFormDataEmprunt('<%=pret.getIdPret()%>',
                                                                '<%=pret.membre.getId()%>',
                                                                '<%=pret.membre.getNom()%>',
                                                                '<%=pret.livre.getDesign()%>',
                                                                '<%=pret.getIdlivre()%>',
                                                                '2025-12-12 11:00',
                                                                '2025-12-12',
                                                                '<%=pret.getNb()%>'
                                                                )"
                                        >
                                        <div class="w-8 h-8 flex items-center justify-center">
                                            <i class="ri-edit-line"></i>
                                        </div>
                                    </button>
                                   <button class="btn btn-sm btn-danger me-2"
                                    onclick="setIdDelete('<%=pret.getIdPret()%>')"
                                    data-bs-toggle="modal" data-bs-target="#deleteModal"
                                   >
                                        <div class="w-8 h-8 flex items-center justify-center">
                                            <i class="ri-delete-bin-line"></i>
                                        </div>
                                    </button-->
                                        <div class="dropdown">
                                    <button class="btn btn-sm btn-outline-dark dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                      <i class="ri-settings-3-line"></i> ...
                                    </button>
                                    <ul class="dropdown-menu">
                                      <li><button class="dropdown-item btn btn-sm  btn-outline-info btn btn-success me-1"
                                                  data-bs-toggle="modal" data-bs-target="#updateModal" 
                                         onclick="setFormDataEmprunt('<%=pret.getIdPret()%>',
                                                                '<%=pret.membre.getId()%>',
                                                                '<%=pret.membre.getNom()%>',
                                                                '<%=pret.livre.getDesign()%>',
                                                                '<%=pret.getIdlivre()%>',
                                                                '2025-12-12 11:00',
                                                                '2025-12-12',
                                                                '<%=pret.getNb()%>'
                                                                )"
                                                  > <i  class="ri-pencil-line me-1"></i>Modifier   </button></li>
                                      <li><button class="dropdown-item btn btn-sm btn-outline-info me-1"
                                          onclick="setIdDelete('<%=pret.getIdPret()%>')"
                                    data-bs-toggle="modal" data-bs-target="#deleteModal"         
                                                  ><i class="ri-delete-bin-line me-1"></i>Supprimer</button>
                                      </li>
                                       <li><button class="dropdown-item btn btn-sm btn-outline-info me-1"
        
                                                  ><i class="ri-mail-send-line me-1"></i>mail</button>
                                      </li>
                                    </ul>
                                  </div>
                            
                             </td>
                            <td>
                    </tr>
                 
                     <%
                
                        
                    }
            %>
  
        
        
