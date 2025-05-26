<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <div class="sidebar">
        <a href="<%=request.getContextPath()%>/Membre" class="link-sidebar" >Membres</a>
        <a href="<%=request.getContextPath()%>/Livre" class="link-sidebar">Livres</a>
        <a href="<%=request.getContextPath()%>/Preter" class="link-sidebar" >Emprunt</a>
        <a href="<%=request.getContextPath()%>/Rendre" class="link-sidebar">Rendu</a>
        <a href="<%=request.getContextPath()%>/Retardaire" class="link-sidebar">Retards des Membres</a>
        <a href="<%=request.getContextPath()%>/Historiques" class="link-sidebar">Historiques</a>
     
 </div>
 <script>
    const url= window.location.href
    const links= document.querySelectorAll('.link-sidebar') 
    links.forEach(l=>{
        if(url===l.href)l.classList.add('active');
    })
   
 </script>

