function filtrerEmprunts() {
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;
    console.log("start:"+startDate)
    console.log('end:'+endDate)
    searchBy2Date(startDate,endDate)
}