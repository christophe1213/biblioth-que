let idDelete=""
function getEmprunt(){
    let tbody=document.getElementById('tablePreter')
    api.get('Preter/get').then((r)=>{
        console.log("success")
        tbody.innerHTML=r
    }).catch((console.error()))
}

function deleteEmprunt(id){
    const formData = new URLSearchParams();
    console.log(id)
    formData.append("idPret", idDelete);
    api.post('Preter/delete',formData).then((r)=>{
        console.log(r)
        if(r=="success")
        {
            getEmprunt()
            var modalElement = document.getElementById('deleteModal');
            var modalInstance = bootstrap.Modal.getInstance(modalElement)
           modalInstance.hide();
        }
         
    }).catch((e)=>{ console.log(e)})
    // alert(idDelete)
}

function updDateEmprunt(formData){
    api.post('Preter/update',formData).then((r)=>{
        console.log(r)
        if(r=="success")
        {
            getEmprunt()
            var modalElement = document.getElementById('updateModal');
            var modalInstance = bootstrap.Modal.getInstance(modalElement)
           modalInstance.hide();
        }
         
    }).catch((e)=>{ console.log(e)})
}
function setIdDelete(id){
    idDelete=id
}


function setFormDataEmprunt(  idpret,idpers,name, livre, idlivre, dateEmprunt, dateRetour,nb ) {
    // Récupérer les éléments du formulaire
    
    document.getElementById('idPret').value=idpret
    document.getElementById('nameUpdate').value = name;
    document.getElementById('idpers').value = idpers;

    document.getElementById('livresUpdate').value = livre;
    document.getElementById('idlivre').value = idlivre;

    document.getElementById('date-emprunt-update').value = dateEmprunt;
    document.getElementById('dateRetourUpdate').value = dateRetour;
    document.getElementById('nb').value=nb
}