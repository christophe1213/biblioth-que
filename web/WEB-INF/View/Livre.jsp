<!DOCTYPE html>
<html>
    <head>
        <title>G�stion d'un biblioth�que</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/fetchCustomers.js"></script>
    </head>
    <body>
      <div class="container my-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Liste des livres </h2>
            <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Ajouter un livre</button>
        </div>
        
        <div class="row">
             <div class="table-responsive">
          <table class="table table-bordered table-striped">
            <thead class="table-dark">
              <tr>
                <th>#</th>
                <th>Livre</th>
                <th>exemplaire</th>
                <th>Actions</th>
              </tr>
            </thead>
            
            <tbody id="employeeTableBody">
            </tbody>
          </table>
        </div>
        </div>
      </div>
        
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
      </div>
      <script src="js/dd/Livre.js"></script>
      <script>
           getLivre();
           
           //api.post('Livre',())
      </script>
    
        
        <script src="bootstrap/js/bootstrap.js"></script>
    </body>
</html>