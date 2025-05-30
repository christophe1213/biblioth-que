<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="add">
    <div class="modal-dialog">
        <div class="modal-content">

      <!-- Modal Header -->
        <div class="modal-header">
            <h4 class="modal-title">Ajouter un membre</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>


        <div class="modal-body">
          <form  id="formadd"  method="POST">
             
                <div class="mb-3">
                  <label class="form-label">Nom</label>
                  <input type="texte" class="form-control" name="nom">
                </div>
                <div class="mb-3">
                  <label class="form-label">Sexe</label>
                  <div class="form-check">
                        <input type="radio" class="form-check-input" id="radio1" name="sexe" value="Masculin" checked>Masculin
                        <label class="form-check-label" for="radio1"></label>
                     </div>
                     <div class="form-check">
                        <input type="radio" class="form-check-input" id="radio2" name="sexe" value="Feminin">Féminin
                        <label class="form-check-label" for="radio2"></label>
                      </div>
                </div>
                <div class="mb-3">
                  <label class="form-label">age</label>
                  <input type="number" class="form-control" placeholder="age" name="age">
                </div>
                <div class="mb-3">
                  <label class="form-label">email</label>
                  <input type="email" class="form-control" placeholder="email" name="email">
                </div>
                <div class="mb-3">
                  <label class="form-label">contact</label>
                  <input type="texte" class="form-control" placeholder="contact" name="contact">
                </div>
              
                        
              
              
          <button type="submit" class="btn btn-primary">Submit</button>
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
    
 
</script>
     