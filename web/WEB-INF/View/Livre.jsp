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

      <script>
             let tbody=document.getElementById('employeeTableBody')
           api.get('Livre/get').then((r)=>{
                 console.log(r)
                  tbody.innerHTML=r
           }
                 
                   ).catch((console.error()))
           
           
      </script>
    
        
        <script src="bootstrap/js/bootstrap.js"></script>
    </body>
</html>