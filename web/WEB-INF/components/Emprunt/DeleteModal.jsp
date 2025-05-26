<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      
      <div class="modal-header">
        <h5 class="modal-title" id="deleteModalLabel">Confirmer la suppression</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fermer"></button>
      </div>
      
      <div class="modal-body">
        Êtes-vous sûr de vouloir supprimer cette emprunt ? Cette action est irréversible.
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
        <button type="button" onclick=" deleteEmprunt()" class="btn btn-danger" id="confirmDelete">Supprimer</button>
      </div>

    </div>
  </div>
</div>
<script>
</script>