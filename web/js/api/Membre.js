function getMembre(){
    let tbody=document.getElementById('membreTbody')
    api.get('Membre/get').then((r)=>{
        console.log("success")
        tbody.innerHTML=r
    }).catch((console.error()))
}

async function addMembre(d){
    return await api.post('Membre/add',d)
   
} 
async function updateMembre (d) {
    // try{
    //     const r = await api.post('Membre/update',d)
    //     console.log(r)
    // }catch(e){
    //     console.log(e)
    // }
    return api.post('Membre/update',d)

}
function deleteMembre(id){
    const formData = new URLSearchParams();
    console.log(id)
    formData.append("idpers", id);
    api.post('Membre/delete',formData).then((r)=>{
        console.log(r)
        if(r=="success")getMembre()
    }).catch((e)=>{ console.log(e)})
}
function setDataMembreUpdate(id,num,nom,sexe,age,contact,email){
    let idMembreInput=document.getElementById('idMembreUpdate')
    let numMembreInput=document.getElementById('numMembreUpdate')
    let nomInput=document.getElementById('nomUpdate')
    let sexeMInput=document.getElementById('sexeM')
    let sexeFInput=document.getElementById('sexeF')
    let ageInput=document.getElementById('ageUpdate')
    let contactInput=document.getElementById('contactUpdate')
    let emailInput=document.getElementById('emailUpdate')


    idMembreInput.value=id
    numMembreInput.value=num
    nomInput.value=nom
    //sexeInput.value=sexe
    if(sexe=="M")sexeMInput.checked=true
    else sexeFInput.checked=true
    console.log(sexeMInput)
    ageInput.value=age
    contactInput.value=contact
    emailInput.value=email
    
}

function searchMembre(search=''){
    let tbody=document.getElementById('membreTbody')
    api.get(`Membre/get?search=${search}`).then((r)=>{
        console.log(search)
        tbody.innerHTML=r
    }).catch((console.error()))
}
