<%-- 
    Document   : AddModal
    Created on : 27 mai 2025, 13:56:28
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"  %>
<%@page import="Models.Livre" %>
<%@page import="java.util.List"  %>
<%@page import="Models.Membre"  %>

<%
      List<Livre> livres=  (List<Livre>)request.getAttribute("livres");
      livres=  (List<Livre>)request.getAttribute("livres");
       List<Membre> membres=  (List<Membre>)request.getAttribute("membres");
      membres=  (List<Membre>)request.getAttribute("membres");
      String error = (String)request.getAttribute("error");
      
%>
<div class="modal fade" id="addModal">
        <div class="modal-dialog">
        <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Ajouter une Rendu</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
          <form  id="formAdd"  method="POST">
                <input type="hidden" class="form-control border-start-0 date-input" id="idrendu" name="idrendu" required>
                <div class="mb-3 mt-3">
                      <label for="date-emprunt" class="form-label">Nom <span class="text-danger">*</span></label>
                          <div class="input-group">
                              <input type="texte" class="form-control border-start-0 date-input"  id="nomAdd"    required>
                              <input type="hidden" class="form-control border-start-0 date-input" id="idpersAdd" name="idpers"  required>
                          
                          
                      </div>
                           <ul id="resultats-recherche-membre"
                                        class="d-none position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto">
                                
                                </ul> 
                </div>
                <div class="mb-3">
                      <label for="date-emprunt" class="form-label">Livre <span class="text-danger">*</span></label>
                                <div class="input-group">
                                   
                                    <input type="texte" class="form-control border-start-0 date-input" id="livreAdd"  >
                                    <input type="hidden" class="form-control border-start-0 date-input" id="idlivreAdd" name="idlivre"  value="d" required>
                                </div>
                          <ul id="resultats-recherche"
                                        class="d-none position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto">
                                
                                    </ul> 
                </div>
                <div class="mb-3">
                  <label for="date-emprunt" class="form-label">Date de Rendu <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <span class="input-group-text bg-white border-end-0"><i class="ri-calendar-line text-secondary"></i></span>
                                    <input type="datetime-local" class="form-control border-start-0 date-input" name="dateRendu" id="dateRenduAdd" name="dateRendu" required >
                                </div>
                </div>
          <button type="submit" class="btn btn-primary">modifier</button>
        </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">fermer</button>
      </div>

    </div>
  </div>
</div>
<script>
    
    document.getElementById('formAdd').addEventListener('submit',(e)=>{
    e.preventDefault()
    console.log(e.target)
 /*     const formData = new FormData(e.target); // ou this
    const data = Object.fromEntries(formData.entries());
    console.log(data)
   */ const form =e.target
    const formData= new FormData(form)
    console.log(formData)
    console.log(Object.fromEntries(formData.entries()))
    const data= new URLSearchParams(formData)
    addRendu(data)
    
    })
</script>


 <script>
               const livres = [
            
                 <%
                   
                        for(Livre livre:livres){
                
                 %>
                  { id:'<%=livre.getIdLivre()%>', code:"<%=livre.getCodeLivre()%>", titre:"<%=livre.getDesign()%>",

                  },
                <%
             
                    }
                %>
            ]; 
              const user=[
                 <%
                    if(membres!=null)
                        for(Membre membre:membres){
                    %>
                    {id:"<%=membre.getId()%>",name:"<%=membre.getNom()%>"},
                
                <%}%>
                ]
            console.log(livres)
            </script>
<script src="<%=request.getContextPath()%>/js/autocomplet.js"></script>
<script src="<%=request.getContextPath()%>/js/dateNow.js"></script>
<script src="<%=request.getContextPath()%>/js/formRendus.js"></script>