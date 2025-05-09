function getLivre(){
    let tbody=document.getElementById('employeeTableBody')
    api.get('Livre/get').then((r)=>{
          console.log("get livre")
           tbody.innerHTML=r
    }).catch((console.error()))
}

async function addLivre(d){
    const r = await api.post("Livre/add",d)
    console.log(r)
}
