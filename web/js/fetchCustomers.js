const fetchCustomers = ()=>{
    const fetchData=async(url,method,data='')=>{
        
        const options={
            method:method,
            headers:{
                "Content-Type": "application/x-www-form-urlencoded",
            },        
        }
        if(method!='GET')options.body=data.toString()
   
    
        const r = await fetch(url,options)
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