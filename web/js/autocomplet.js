    function autocomplete(input,list,data,filter=(a)=>{},action=(d)=>{}){
            
            input.addEventListener("input", function () {
                        const query = this.value.toLowerCase();
                        list.innerHTML = "";

                    if (query.length > 0) {
                            const matches = filter(query);
                            action(matches)
                    }
            }); 

        }