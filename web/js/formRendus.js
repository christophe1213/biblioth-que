
const resultatList=document.getElementById('resultats-recherche')
const suggestions=document.getElementById('resultats-recherche-membre')

const livreSearch=document.getElementById('livreAdd')
const membreSearch=document.getElementById('nomAdd')
const dateRendu=document.getElementById('dateRenduAdd')
dateRendu.value=dateNow()
const classNonelist="d-none position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto"
const showClasslist="position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto"

let forms={
    idlivre:'',
    idpers:'',
    dateRendu:''
           
    }
 const filterBook=(query)=>{
            const matches= livres.filter(l=>l.titre.toLowerCase().includes(query))
            return matches
        }
const filterMembre=(query)=>{
            const matches=  user.filter(u=>u.id.includes(query)||u.name.includes(query))
            console.log(matches)
            return matches
}
 const eventInputCartMembre=(matches=[])=>{
            matches.forEach(u=>{
                console.log('d')
                const li=document.createElement('li')
                li.className = "list-group-item list-group-item-action";
                li.textContent=u.id+"-"+u.name
                li.addEventListener("click",()=>{
                    membreSearch.value=u.name                    
                    suggestions.className=classNonelist
                    document.getElementById('idpersAdd').value=u.id
                    
                })
                if(membreSearch.value=="")
                    suggestions.className=classNonelist
                else suggestions.className=showClasslist
                suggestions.append(li)
            })
        }

 const eventInputLivre=(matches=[])=>{
            matches.forEach(b=>{
                const li = document.createElement("li");
                li.className = "list-group-item list-group-item-action";
                li.textContent = b.titre;
                li.dataset.id = b.id;
                li.addEventListener("click", () =>{
                    livreSearch.value=b.titre
                    document.getElementById('idlivreAdd').value=b.id
                    resultatList.className=classNonelist
                

                });
                if(livreSearch.value=="")
                    resultatList.className=classNonelist
                else resultatList.className=showClasslist

                resultatList.appendChild(li)
            })
        }
autocomplete(livreSearch,resultatList,livres,filterBook,eventInputLivre)
autocomplete(membreSearch,suggestions,user,filterMembre,eventInputCartMembre)
        