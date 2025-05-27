<%-- 
    Document   : UpdateModal
    Created on : 26 mai 2025, 17:48:18
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      
      <div class="modal-header">
        <h5 class="modal-title" id="deleteModalLabel">Modification de l'emprunt</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fermer"></button>
      </div>
  
      <div class="modal-body">
          <form id="upEmprunt">

              <input type="hidden" class="form-control border-start-0 date-input" id="idPret" name="idPret" required>
             <div class="mb-3">
                        <label for="date-emprunt" class="form-label">Nom <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <input type="texte" class="form-control border-start-0 date-input"  id="nameUpdate"  value="names" disabled required>
                                    <input type="hidden" class="form-control border-start-0 date-input" id="idpers" name="idpers"  value="d" required>
                                </div>
                   </div> 
                 <div class="mb-3">
                        <label for="date-emprunt" class="form-label">Nom <span class="text-danger">*</span></label>
                                <div class="input-group">
                                   
                                    <input type="texte" disabled class="form-control border-start-0 date-input" id="livresUpdate"  value="livres">
                                    <input type="hidden" class="form-control border-start-0 date-input" id="idlivre" name="idlivre"  value="d" required>
                                </div>
                   </div> 
                 <div class="mb-3">
                        <label for="date-emprunt" class="form-label">Date d'emprunt <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <span class="input-group-text bg-white border-end-0"><i class="ri-calendar-line text-secondary"></i></span>
                                    <input type="datetime-local" class="form-control border-start-0 date-input" name="datePret" id="date-emprunt-update" name="date-emprunt" required >
                                </div>
                   </div>
                <div class="mb-3">
                        <label for="date-emprunt" class="form-label">Date de retour <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <span class="input-group-text bg-white border-end-0"><i class="ri-calendar-line text-secondary"></i></span>
                                  
                                      <input type="date" class="form-control border-start-0 date-input" name="dateRetour" id="dateRetourUpdate" name="date-emprunt" required value="0">
                                </div>
                   </div>
              <div class="mb-3">
                  <label class="form-label">nombre d'emprunt</label>
                  <input id="nb" type="number" class="form-control" placeholder="nombre" name="nb">
                </div>
              
               <button type="submit" class="btn btn-primary" >Modifier</button>
           </form>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Fermer</button>
        
      </div>

    </div>
  </div>
</div>
<script>
    
    document.getElementById('upEmprunt').addEventListener('submit',(e)=>{
    e.preventDefault()
    console.log(e.target)
     const form =e.target
    const formData= new FormData(form)
    console.log(formData)
    const data= new URLSearchParams(formData)
     console.log(data)
    updDateEmprunt(data)
    })
</script>



