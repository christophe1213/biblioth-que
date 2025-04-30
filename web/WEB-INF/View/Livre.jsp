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
            <button class="btn btn-primary">Ajouter un livre</button>
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
        
          
      </div>

      <script>
             let tbody=document.getElementById('employeeTableBody')
           api.get('Livre/get').then((r)=>{
                 console.log(r)
                  tbody.innerHTML=r
           }
                 
                   ).catch((console.error()))
           
           
           //api.post('Livre',())
      </script>
    
        
        <script src="bootstrap/js/bootstrap.js"></script>
    </body>
</html>