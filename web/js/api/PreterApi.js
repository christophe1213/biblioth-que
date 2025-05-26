let idDelete=""
function getEmprunt(){
    let tbody=document.getElementById('tablePreter')
    api.get('Preter/get').then((r)=>{
        console.log("success")
        console.log(r)
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


function setIdDelete(id){
    idDelete=id
}

function setDataEmpruntUpdate(dp,dr){
    let datePInput=document.getElementById('datePIp')
    let dateRInput=document.getElementById('dateRUp')

    datePInput.value=dp
    dateRInput.value=dr
}