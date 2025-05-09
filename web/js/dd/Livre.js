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
document.getElementById('formadd').addEventListener('submit',(e)=>{
    e.preventDefault()
    console.log(e.target)
    const form =e.target
    const formData= new FormData(form)
    const data= new URLSearchParams(formData)
    console.log(data)
   api.post('Livre/add',data).then((r)=>{
     console.log(r)
        console.log(r)
         if(r=="success")getLivre()
    }).catch((e)=>console.error())
    // XMLDocumentgi
})

function deleteLivre(id){
    const formData = new URLSearchParams();
    console.log(id)
    formData.append("idlivre", id);
    api.post('Livre/delete',formData).then((r)=>{
        console.log(r+'ff')
        if(r=="success")getLivre()
    }).catch((e)=>{ console.error()})
}