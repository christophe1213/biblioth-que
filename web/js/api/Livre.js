/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function getLivre(){
    let tbody=document.getElementById('employeeTableBody')
    api.get('Livre/get').then((r)=>{
        console.log("succes")
        tbody.innerHTML=r
    }).catch((console.error()))
}

async function addLivre(d){
    const r = await api.post("Livre/add",d)
    console.log(r)
}
async function updateLivre(d){
    const r = await api.post("Livre/update",d);
    console.log(r);
}

function deleteLivre(id){
    const formData = new URLSearchParams();
    console.log(id)
    formData.append("idlivre", id);
    api.post('Livre/delete',formData).then((r)=>{
        console.log(r+'ff')
        if(r=="success")getLivre()
    }).catch((e)=>{ console.error()})
}
function setDataUpdate(idLivre,design,exemplaire){
    let idLivreInput=document.getElementById('idLivreUpdate')
    let designInput=document.getElementById('designUpdate')
    let exemplaireInput=document.getElementById('exemplaireUpdate')

    idLivreInput.value=idLivre
    designInput.value =design
    exemplaireInput.value=parseInt(exemplaire)    
    console.log(idLivreInput)
    
}