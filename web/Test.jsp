<%-- 
    Document   : Test
    Created on : 12 mai 2025, 17:38:26
    Author     : Thierry Christophe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultation - Gestion Bibliothèque</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
        }

        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #343a40;
            padding: 1rem;
            position: fixed;
            top: 56px;
        }

        .sidebar a {
            color: #ffffff;
            text-decoration: none;
            padding: 10px;
            display: block;
            margin-bottom: 10px;
        }

        .sidebar a.active, .sidebar a:hover {
            background-color: #495057;
            border-radius: 5px;
        }

        .content {
            flex-grow: 1;
            padding: 2rem;
            margin-left: 250px;
            padding-top: 80px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Gestion Bibliothèque</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ajouter Membre</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ajouter Livre</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Enregistrer Prêt</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Enregistrer Retour</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Sidebar -->
    <div class="sidebar">
        <h4 class="text-white mb-4">Consultation</h4>
        <a href="#" class="active" onclick="showSection('dashboard')">Tableau de bord</a>
        <a href="#" onclick="showSection('members')">Liste des Membres</a>
        <a href="#" onclick="showSection('history')">Historique des Prêts</a>
        <a href="#" onclick="showSection('search')">Recherche Avancée</a>
        <a href="#" onclick="showSection('overdue')">Retards des Membres</a>
    </div>

    <!-- Content Area -->
    <div class="content">
        <!-- Tableau de bord -->
        <div id="dashboard" class="section">
            <h2>Tableau de Bord</h2>
            <div class="row">
                <div class="col-md-4 mb-3">
                    <div class="card bg-primary text-white">
                        <div class="card-body">
                            Membres inscrits : 250
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <div class="card bg-success text-white">
                        <div class="card-body">
                            Prêts en cours : 120
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <div class="card bg-danger text-white">
                        <div class="card-body">
                            Retards : 15
                        </div>
                    </div>
                </div>
            </div>
        </div>
 </div>
  

    
        
        <!-- Retards des Membres -->
     
  
 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
