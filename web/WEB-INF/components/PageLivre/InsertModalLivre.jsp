<%@page contentType="text/html" pageEncoding="UTF-8"%>

   <div class="modal fade" id="myModal">
        <div class="modal-dialog">
        <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
          <form  id="formadd" action="Livre/add" method="POST">
                <div class="mb-3 mt-3">
                  <label  class="form-label">Id Livre</label>
                  <input type="texte" class="form-control" placeholder="Enter email" name="idlivre">
                </div>
                <div class="mb-3">
                  <label class="form-label">Designation</label>
                  <input type="texte" class="form-control" name="design">
                </div>
                <div class="mb-3">
                  <label class="form-label">nombre d'exemplaire</label>
                  <input type="number" class="form-control"    name="exemplaire">
                </div>
          <button type="submit" class="btn btn-primary">Submit</button>
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
    
    document.getElementById('formadd').addEventListener('submit',(e)=>{
    e.preventDefault()
    console.log(e.target)
    const form =e.target
    const formData= new FormData(form)
    const data= new URLSearchParams(formData)
    console.log(data)
    insertLivre(data)
    })
</script>
     