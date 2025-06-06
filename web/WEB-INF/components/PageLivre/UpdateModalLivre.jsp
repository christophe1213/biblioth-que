<%-- 
    Document   : UpdateLivreModal
    Created on : 14 mai 2025, 22:02:42
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="modal fade" id="update">
        <div class="modal-dialog">
        <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modifier un livre</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
          <form  id="formUpd"  method="POST">
                <div class="mb-3 mt-3">
                  <label  class="form-label">Id Livre</label>
                  <input  id="idLivreUpdate" type="texte" class="form-control" placeholder="Enter email"  name="idlivre">
                </div>
                <div class="mb-3">
                  <label class="form-label">Designation</label>
                  <input id="designUpdate" type="texte" class="form-control" name="design">
                </div>
                <div class="mb-3">
                  <label class="form-label">nombre d'exemplaire</label>
                  <input id="exemplaireUpdate" type="number" class="form-control"    name="exemplaire">
                </div>
          <button type="submit" class="btn btn-primary">modifier</button>
        </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
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
    const data= new URLSearchParams(formData)
    console.log(data)
    updateLivre(data)
    })
</script>