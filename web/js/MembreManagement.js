  document.getElementById('searchInput').addEventListener('keyup', function () {
    const searchValue = this.value.toLowerCase();
    searchMembre(searchValue)
  });
  document.getElementById('formadd').addEventListener('submit',(e)=>{
    e.preventDefault()
    console.log(e.target)
    const form =e.target
    const formData= new FormData(form)
    const data= new URLSearchParams(formData)
    console.log(data)
    addMembre(data).then((r)=>{
      console.log(r)
      if(r=="success"){
        getMembre()
        var modalElement = document.getElementById('add');
        var modalInstance = bootstrap.Modal.getInstance(modalElement)
        modalInstance.hide();
        document.getElementById('formadd').reset()
      }else{
        alert('e')
      }
    }).catch((e)=>{
      console.log(e)
      console.error()
    })
     
})