<%-- 
    Document   : UpdateMembreModal
    Created on : 18 mai 2025, 15:37:17
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="update">
    <div class="modal-dialog">
        <div class="modal-content">

      <!-- Modal Header -->
        <div class="modal-header">
            <h4 class="modal-title">Ajouter un membre</h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
      <a href="UpdateMembreModal.jsp"></a>

      <!--
      let idMembreInput=document.getElementById('idMembreUpdate')
    let nomInput=document.getElementById('nomUpdate')
    let sexeInput=document.getElementById('sexeUpdate')
    let ageInput=document.getElementById('ageUpdate')
    let contactInput=document.getElementById('contactUpdate')
    let emailInput=document.getElementById('emailUpdate')
      -->
        <div class="modal-body">
          <form  id="formUpd"  method="POST">
              <input type="hidden"  class="form-control border-start-0 date-input" id="idMembreUpdate" name="id" required>
                <div class="mb-3 mt-3">
                  <label  class="form-label">Num  Membre</label>
                  <input type="texte" disabled id="numMembreUpdate"  class="form-control" placeholder="id membre" name="i" required="">
                </div>
                <!--div class="mb-3">
                  <label class="form-label">Id</label>
                  <input type="texte"  id="numMembreUpdate" class="form-control" name="i">
                </div-->
                <div class="mb-3">
                  <label class="form-label">Nom</label>
                  <input type="texte" id="nomUpdate" class="form-control" name="nom">
                </div>
                <div class="mb-3">
                  <label class="form-label">Sexe</label>
                  <div class="form-check">
                        <input id="sexeM" type="radio" class="form-check-input" id="radio1" name="sexe" value="M" >M
                        <label class="form-check-label" for="radio1"></label>
                     </div>
                     <div class="form-check">
                         <input id="sexeF" type="radio" class="form-check-input" id="radio2" name="sexe" value="F">F
                        <label class="form-check-label" for="radio2"></label>
                      </div>
                </div>
              
                <div class="mb-3">
                  <label class="form-label">age</label>
                  <input id="ageUpdate" type="number" class="form-control" placeholder="age" name="age">
                </div>
                <div class="mb-3">
                  <label class="form-label">contact</label>
                  <input id="contactUpdate" type="texte" class="form-control" placeholder="contact" name="contact">
                </div>
                <div class="mb-3">
                  <label class="form-label">contact</label>
                  <input id="emailUpdate" type="texte" class="form-control" placeholder="contact" name="email">
                </div>
              
                        
              
              
          <button type="submit" class="btn btn-primary">Envoyer</button>
        </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">fermer</button>
      </div>

    </div>
  </div>
</div>
