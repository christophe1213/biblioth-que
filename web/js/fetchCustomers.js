const fetchCustomers = ()=>{
    const fetchData=async(url,method,data='')=>{
        const r = await fetch(url,{
                method:method,
                headers:{
                    "Content-Type": "application/x-www-form-urlencoded",
                },
                // body:data.toString()
                
            }
        )
        if(r.ok) return r.text()
            else throw new Error('Erreur de url')
        }       
    
    return {
       
        get:async(url)=>{
            return await fetchData(url,'GET')
        },
        post:async(url,data)=>{
            console.log("dd")
            return await fetchData(url,'POST',data)
        },
        put:async(data)=>{
            console.log("ddd")
            return await fetchData('PUT',data)
        },
        delete:async(data)=>{
            return await fetchData('DELETE',data)
        }

    }
  
   
}
  const api= fetchCustomers()