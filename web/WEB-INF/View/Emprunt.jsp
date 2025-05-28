<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../components/Header.jsp" />
    <body>
        <script src="js/api/PreterApi.js"></script>
        <jsp:include page="../components/NavBar.jsp" />
        <jsp:include page="../components/SideBar.jsp"/>
        <jsp:include page="../components/Emprunt/DeleteModal.jsp"/>
        <jsp:include page="../components/Emprunt/UpdateModal.jsp"/>
      
         <div class="content">

             <div  class="section">
               <div class="d-flex justify-content-between align-items-center mb-4">
                        <h2>Listes d'emprunt </h2>
                        <button class="btn btn-primary" onclick="nav()" data-bs-toggle="modal" data-bs-target="#myModal">Ajouter un emprunt</button>
                             <script>
                                const  nav =()=>{
                                    window.location.href="<%=request.getContextPath()%>/Preter/add"
                                }
                             </script>
                             
                </div>
                 <div class="p-4 custom-border">
                       
                            
                       
                        <div class="row g-4">
                            <div class="col-md-4 position-relative">
                                <label for="" class="form-label">Date début</label>
                                <div class="input-group">
                                    <span class="input-group-text bg-white border-end-0">
                                        <i class="ri-search-line text-secondary"></i>
                                    </span>
                                    <input
                                        type="date"
                                        id="startDate" placeholder="Date début"
                                        class="form-control border-start-0 text-sm"
                                        
                                    >
                                </div>
        
                                
                            </div>
                            <div class="col-md-3 position-relative">
                                <label for="nombre-pret" class="form-label">Date fin</label>
                                <div class="input-group">
                                    <!-- <span class="input-group-text bg-white border-end-0"><i class="ri-calendar-line text-secondary"></i></span> -->
                                   <span class="input-group-text bg-white border-end-0">
                                        <i class="ri-search-line text-secondary"></i>
                                    </span>
                                    <input
                                        type="date"
                                        id="endDate" placeholder="Date fin"
                                        class="form-control border-start-0 text-sm"
                                        placeholder="Rechercher un livre p  ar titre, auteur ou ISBN..."
                                    >
                                </div>
                            </div>
                        
                            <div class="col-md-2 position-relative">
                                <div class="input-group">
                                    <button onclick="filtrerEmprunts()" style="position: relative;top: 35px;width: 100px;" class="btn btn-primary">ajouter</button>
                                </div>    
                            </div> 
                             


                        </div>

                </div> 
               
                <div class="row">
                        <jsp:include page="../components/Emprunt/TableEmprunt.jsp"/>
                </div>
            </div>
            </div>
         </div>
         <script src="js/Preter.js"></script>  
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
         <script>
             document.title="emprunt"
         </script>
    </body>
</html>
