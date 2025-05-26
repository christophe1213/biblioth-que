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
    formData.append("idPret", id);
    api.post('Preter/delete',formData).then((r)=>{
        console.log(r)
        if(r=="success")getEmprunt()
    }).catch((e)=>{ console.log(e)})
}


function getIdDelete(id){
    
}