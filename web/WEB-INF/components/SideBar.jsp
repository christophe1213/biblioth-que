<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <div class="sidebar">
        <a href="Membre" class="link-sidebar" >Membres</a>
        <a href="Livre" class="link-sidebar">Livres</a>
        <a href="Preter" class="link-sidebar" >Emprunt</a>
        <a href="#" class="link-sidebar">Rendu</a>
        <a href="#" class="link-sidebar">Retards des Membres</a>
        <a href="#" class="link-sidebar">Historiques</a>
     
 </div>
 <script>
    const url= window.location.href
    const links= document.querySelectorAll('.link-sidebar') 
    links.forEach(l=>{
        if(url===l.href)l.classList.add('active');
    })
   
 </script>

