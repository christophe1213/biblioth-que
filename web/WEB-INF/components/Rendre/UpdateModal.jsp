<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="updateModal">
        <div class="modal-dialog">
        <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modification d'une Rendu</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
          <form  id="formUpd"  method="POST">
                <input type="hidden" class="form-control border-start-0 date-input" id="idrendu" name="idrendu" required>
                <div class="mb-3 mt-3">
                      <label for="date-emprunt" class="form-label">Nom <span class="text-danger">*</span></label>
                          <div class="input-group">
                              <input type="texte" class="form-control border-start-0 date-input"  id="nameUpdate"  value="names" disabled required>
                              <input type="hidden" class="form-control border-start-0 date-input" id="idpers" name="idpers"  value="d" required>
                      </div>
                </div>
                <div class="mb-3">
                      <label for="date-emprunt" class="form-label">Livre <span class="text-danger">*</span></label>
                                <div class="input-group">
                                   
                                    <input type="texte" disabled class="form-control border-start-0 date-input" id="livresUpdate"  value="livres">
                                    <input type="hidden" class="form-control border-start-0 date-input" id="idlivre" name="idlivre"  value="d" required>
                                </div>
                </div>
                <div class="mb-3">
                  <label for="date-emprunt" class="form-label">Date de Rendu <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <span class="input-group-text bg-white border-end-0"><i class="ri-calendar-line text-secondary"></i></span>
                                    <input type="datetime-local" class="form-control border-start-0 date-input" name="dateRendu" id="dateRendu-update" name="dateRendu" required >
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
    
    document.getElementById('formUpd').addEventListener('submit',(e)=>{
    e.preventDefault()
    console.log(e.target)
     const form =e.target
    const formData= new FormData(form)
    console.log(formData)
    const data= new URLSearchParams(formData)
     console.log(data)
   updateRendu(data)
    })
</script>