<%@page contentType="text/html" pageEncoding="UTF-8"%>
<main class="container py-4">
        <div class="bg-white shadow-sm rounded overflow-hidden mb-4">
            <div class="px-3 py-3 custom-border">
                <h3 class="fs-4 fw-medium text-dark">Nouvel Emprunt</h3>
                <p class="mt-1 small text-muted">Créez un nouvel emprunt en remplissant les informations ci-dessous</p>

            </div>

            <div>
                <div class="p-4 custom-border">
                        <h4 class="fs-5 fw-medium text-dark mb-3">Informations de l'emprunteur</h4>
                        <div class="row g-4">
                            <div class="col-md-6 position-relative">
                                <label for="numero-carte" class="form-label">Numéro de carte de membre <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <span class="input-group-text bg-white border-end-0"><i class="ri-vip-crown-line text-secondary"></i></span>
                                    <input type="text" class="form-control border-start-0" id="numero-carte" name="numero-carte" required>
                                </div>
                                <ul id="resultats-recherche-membre"
                                        class="d-none position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto">
                                
                                </ul> 
                            </div>
                            <div class="col-md-6 position-relative">
                                <label for="date-emprunt" class="form-label">Date d'emprunt <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <span class="input-group-text bg-white border-end-0"><i class="ri-calendar-line text-secondary"></i></span>
                                    <input type="datetime-local" class="form-control border-start-0 date-input" id="date-emprunt" name="date-emprunt" required value="2025-05-21">
                                </div>
                            </div>
                            
                        </div>
                        <div class="row g-4">
                            <div class="col-md-4 position-relative">
                                <label for="" class="form-label">Livre</label>
                                <div class="input-group">
                                    <span class="input-group-text bg-white border-end-0">
                                        <i class="ri-search-line text-secondary"></i>
                                    </span>
                                    <input
                                        type="text"
                                        id="recherche-livre"
                                        class="form-control border-start-0 text-sm"
                                        placeholder="Rechercher un livre p  ar titre, auteur ou ISBN..."
                                    >
                                </div>
        
                                    <ul id="resultats-recherche"
                                        class="d-none position-absolute z-3 mt-1 w-100 bg-white shadow-sm rounded border border-secondary-subtle max-height-300 overflow-auto">
                                
                                    </ul> 
                            </div>
                            <div class="col-md-3 position-relative">
                                <label for="nombre-pret" class="form-label">Nombre d'exemplaires à prêter <span class="text-danger">*</span></label>
                                <div class="input-group">
                                    <!-- <span class="input-group-text bg-white border-end-0"><i class="ri-calendar-line text-secondary"></i></span> -->
                                    <input
                                        type="number"
                                        id="nb"
                                        min="1"
                                        value="1"
                                        class="w-24 px-3 py-2 border border-gray-300 rounded focus:ring-2 focus:ring-primary focus:border-primary outline-none transition text-sm"
                                    />
                                </div>
                            </div>
                            <div class="col-md-3">
                                <label for="" class="form-label">Durée de prêt (jours)</label>
                                <div class="input-group">
                                    <input
                                        type="number"
                                        id="duree-pret"
                                        min="1"
                                        value="14"
                                        class="w-24 px-3 py-2 border border-gray-300 rounded focus:ring-2 focus:ring-primary focus:border-primary outline-none transition text-sm"
                                 />

                                </div>
                            </div>
                            <div class="col-md-2 position-relative">
                                <div class="input-group">
                                    <button onclick="select(livreAdd)" style="position: relative;top: 35px;width: 100px;" class="btn btn-primary">ajouter</button>
                                </div>    
                            </div> 
                             


                        </div>

                </div>
                <div class="p-4 custom-border">
                      <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="fs-5 fw-medium text-dark">Liste des livres à prêter</h4>
                       
                     </div>



    <div id="liste-livres-container" class="table-responsive">
        <table class="table table-bordered table-hover align-middle">
            <thead class="table-light text-uppercase text-secondary small">
                <tr>
                    <th scope="col">Code livre</th>
                    <th scope="col">Intitulé</th>
                    <th scope="col">nombre preter</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody id="liste-livres">
                <tr id="aucun-livre" class="text-center">
                    <td colspan="5" class="text-muted small py-3">Aucun livre ajouté</td>
                </tr>
               
            </tbody>
        </table>
    </div>

    <div class="mt-3 d-flex justify-content-between align-items-center">
        <div class="text-muted small">
            <span id="compteur-livres">0</span> livre(s) sélectionné(s)
        </div>
        <div class="text-muted small">
            Durée maximale d'emprunt: <span class="fw-medium">14 jours</span>
        </div>
    </div>
                </div>
               
                <div class="p-4">
                    



 

  <div class="d-flex justify-content-end gap-2">
    <button type="button" id="annuler" class="btn btn-outline-secondary px-4 py-2">
      Annuler
    </button>
    <button type="submit" id="valider" class="btn btn-primary px-4 py-2" onclick="emprunt()"
        data-bs-toggle="modal" data-bs-target="#myModal"
    >
      Confirmer les emprunts
    </button>
  </div>
                </div>
        </div>
        </div>
        
    </main>
    <div class="modal fade" id="myModal">
     <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="text-lg font-semibold text-gray-800 mb-4">Résumé de l'emprunt</h4>

        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 mb-4">
        <div>
            <span class="text-sm text-gray-500">Nom du Membre :

                <span class="text-lg font-medium text-gray-900" id="resume-membre" >Jao</span>
            </span>
        </div>
        <div>
            <span class="text-sm text-gray-500">Livres à  preter:
                
            </span>
        </div>
        <div id="liste-resume" class="table-responsive">
        <table class="table table-bordered table-hover align-middle">
            <thead class="table-light text-uppercase text-secondary small">
                <tr>
                    <th scope="col">Code livre</th>
                    <th scope="col">Intitulé</th>
                    <th scope="col">nombre preter</th>
                 </tr>
            </thead>
            <tbody id="resume-list-livre">
                <tr id="aucun-livre" class="text-center">
                    <td colspan="5" class="text-muted small py-3">Aucun livre ajouté</td>
                </tr>
               
            </tbody>
        </table>
        </div>
        <div>
            <span class="text-sm text-gray-500">Prêt le :
                <span class="text-lg font-medium text-gray-900" id="resume-date-emprunt" >Jao</span>
            
            </span>
        </div>
        <div>
            <span class="text-sm text-gray-500">Doit être rendu:
                <span class="text-lg font-medium text-gray-900" id="resume-date-rendu" >Jao</span>
            
            </span>
        </div>
    </div>

    
      </div>

      <div class="modal-footer">
        <button type="button btn" class="btn btn-primary">Valider l'emprunt</button>
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
    </div>
<script src="js/autocomplet.js"></script>
<script src="js/dateNow.js"></script>
