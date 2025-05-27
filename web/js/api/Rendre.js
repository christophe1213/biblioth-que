let idDelete=""
function deleteRendu(id){
    const formData = new URLSearchParams();
    console.log(idDelete)
    formData.append("idrendu", idDelete);
    api.post('Rendre/delete',formData).then((r)=>{
        console.log(r)
        if(r=="success")
        {
            getRendu()
            var modalElement = document.getElementById('deleteModal');
            var modalInstance = bootstrap.Modal.getInstance(modalElement)
            modalInstance.hide();
        }
         
    }).catch((e)=>{ console.log(e)})
    // alert(idDelete)
}
function getRendu(){
    let tbody=document.getElementById('tableRendu')
    api.get('Rendre/get').then((r)=>{
        console.log("success")
        tbody.innerHTML=r
    }).catch((console.error()))
}

function setIdDelete(id){
     idDelete=id
}