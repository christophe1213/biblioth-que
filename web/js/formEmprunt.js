   console.log(dateNow())
      
    
        const resultatList=document.getElementById('resultats-recherche')
        const suggestions=document.getElementById('resultats-recherche-membre')

        const livreSearch=document.getElementById('recherche-livre')
        const membreSearch=document.getElementById('numero-carte')
        const nbLivre=document.getElementById('nb')
        const dateEmprunt=document.getElementById('date-emprunt')
        const classNonelist="d-none position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto"
        const showClasslist="position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto"
        dateEmprunt.value=dateNow()
        let data={
            membre:{},
            livres:[],
            datePres:dateEmprunt.value,
            dateRetoure:''
        } 
        let livreAdd={
            id:'',
            codelivre:'',
            titre:'',
            nb:1
        }
        let membreAdd={}
        nbLivre.addEventListener('input',()=>{
            livreAdd={...livreAdd,nb:nbLivre.value}
        })
        dateEmprunt.addEventListener('input',()=>{
            data={...data,datePres:dateEmprunt.value}
        })

        document.getElementById('')
        const livreSelect=[]
        
       
        const user=[
            {id:"140", name:'rabe'},
            {id:"141",name:'jao'},
            {id:"250",name:'p'},
        ]
        const filterBook=(query)=>{
            const matches= livres.filter(l=>l.titre.toLowerCase().includes(query))
            return matches
        }
        const filterMembre=(query)=>{
            const matches=  user.filter(u=>u.id.includes(query))
            console.log(matches)
            return matches
        }
        const select=(book)=>{

            livreAdd={...livreAdd,nb:document.getElementById('nb').value}

            if(!livreSelect.includes(book.id)){
                
                const tr=document.createElement("tr")
                tr.innerHTML=`
                    <td>${book.codelivre}</td>
                    <td>${book.titre}</td>
                    <td>${book.nb}</td>
                    <td><button class="btn btn-danger btn-sm">X</button></td>
                `
                if(livreSelect.length!=0)
                document.getElementById('liste-livres').appendChild(tr)
                else {
                 document.getElementById('liste-livres').innerHTML=''
                document.getElementById('liste-livres').appendChild(tr)
                
                 //  document.getElementById('liste-livre').appendChild(tr)
                
                }
                
                livreSearch.value=""
                document.getElementById('nb').value=1
                livreSelect.push(book)
                

            }

            


        }
        const event=(matches=[])=>{
            matches.forEach(b=>{
                const li = document.createElement("li");
                li.className = "list-group-item list-group-item-action";
                li.textContent = b.titre;
                li.dataset.id = b.id;
                li.addEventListener("click", () =>{
                    livreSearch.value=b.titre
                    resultatList.className="d-none position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto"
                    livreAdd={...livreAdd,id:b.id,codelivre:b.code,titre:b.titre}

                });
                if(livreSearch.value=="")
                    resultatList.className="d-none position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto"
                else resultatList.className="position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto"

                resultatList.appendChild(li)
            })
        }

        const eventInputCartMembre=(matches=[])=>{
            matches.forEach(u=>{
                const li=document.createElement('li')
                li.className = "list-group-item list-group-item-action";
                li.textContent=u.id+"-"+u.name
                li.addEventListener("click",()=>{
                    membreSearch.value=u.id
                    suggestions.className=classNonelist
                    membreAdd=u
                })
                if(membreSearch.value=="")
                    suggestions.className=classNonelist
                else suggestions.className=showClasslist
                suggestions.append(li)
            })
        }
        
        autocomplete(livreSearch,resultatList,livres,filterBook,event)
        autocomplete(membreSearch,suggestions,user,filterMembre,eventInputCartMembre)
        
         let forms={
                idlivre:'',
                idpers:'',
                nb:'',
                datePres:'',
                dateRetour:''
        }
        
        
        const emprunt=()=>{
            console.log(livreSelect)
            let dateEmprunt= new Date(data.datePres)
            let nb=parseInt(document.getElementById('duree-pret').value)
            dateEmprunt.setDate(dateEmprunt.getDate()+nb)
            data={...data,livres:livreSelect,membre:membreAdd,dateRetoure:new Date(dateEmprunt).toISOString()}
           
            console.log(data)

            document.getElementById('resume-membre').innerHTML=`${data.membre.name}`
            let list =document.getElementById('resume-list-livre')
             list.innerHTML=''
            data.livres.forEach(book=>{
                let tr= document.createElement('tr')
               
                tr.innerHTML=`
                    <td>${book.codelivre}</td>
                    <td>${book.titre}</td>
                    <td>${book.nb}</td>
                ` 
               
                list.appendChild(tr)
                forms.idlivre+=book.id+','
                forms.nb+=book.nb+','
            })

            document.getElementById('resume-date-emprunt').innerHTML=new Date(data.datePres).toLocaleDateString('fr-Fr')
            document.getElementById('resume-date-rendu').innerHTML=new Date(data.dateRetoure).toLocaleDateString('fr-Fr')
            forms.idpers=data.membre.id
            forms.datePres=data.datePres
            forms.dateRetour=data.dateRetoure
            console.log(forms)


        }
