<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<%@ page import="entites.Utilisateur"%>
<% 
	String username = "";
	String user_role = "";
	if(session.getAttribute("username") != null) {
		username = session.getAttribute("username").toString();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjee2", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select role from utilisateur where username = '" + username + "';");
            while (rs.next()) {
                user_role = rs.getString("role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!user_role.equals("ROLE_ADMIN")){
            response.sendRedirect("Home.jsp");
        }
    }else{
		response.sendRedirect("Home.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Supprimer Utilisateur</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.2/dist/journal/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=News+Cycle:wght@400;700&amp;display=swap">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.0/css/all.css">
    <link rel="stylesheet" href="../../assets/css/Articles-Cards-images.css">
    <link rel="stylesheet" href="../../assets/css/Navbar-Centered-Brand-icons.css">
    <link rel="stylesheet" href="../../assets/css/Pricing-Free-Paid-badges.css">
    <style>
        .bs-icon {
        --bs-icon-size: .75rem;
        display: flex;
        flex-shrink: 0;
        justify-content: center;
        align-items: center;
        font-size: var(--bs-icon-size);
        width: calc(var(--bs-icon-size) * 2);
        height: calc(var(--bs-icon-size) * 2);
        color: var(--bs-primary);
        }
        
        .bs-icon-xs {
        --bs-icon-size: 1rem;
        width: calc(var(--bs-icon-size) * 1.5);
        height: calc(var(--bs-icon-size) * 1.5);
        }
        
        .bs-icon-sm {
        --bs-icon-size: 1rem;
        }
        
        .bs-icon-md {
        --bs-icon-size: 1.5rem;
        }
        
        .bs-icon-lg {
        --bs-icon-size: 2rem;
        }
        
        .bs-icon-xl {
        --bs-icon-size: 2.5rem;
        }
        
        .bs-icon.bs-icon-primary {
        color: var(--bs-white);
        background: var(--bs-primary);
        }
        
        .bs-icon.bs-icon-primary-light {
        color: var(--bs-primary);
        background: rgba(var(--bs-primary-rgb), .2);
        }
        
        .bs-icon.bs-icon-semi-white {
        color: var(--bs-primary);
        background: rgba(255, 255, 255, .5);
        }
        
        .bs-icon.bs-icon-rounded {
        border-radius: .5rem;
        }
        
        .bs-icon.bs-icon-circle {
        border-radius: 50%;
        }
    </style>
</head>

<body>
    <!-- NavBar -->
    <div class="d-flex justify-content-between align-items-center p-3 px-md-4 mb-5 bg-white border-bottom shadow-sm">
        <h4>Hello <%=username %></h3>
        <ul class="nav nav-pills">
            <li class="nav-item"><a class="nav-link" href="./Home.jsp">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="./ListeDepartement.jsp">Liste Departerments</a></li>
            <li class="nav-item"><a class="nav-link" href="Users">Liste Salle</a></li>
        </ul>
        <a href="Logout">Logout</a>
    </div>

    <!-- Ajouter Departement -->
    <section class="py-5">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-6">
                    <div class="card mb-5 mb-lg-0">
                        <div class="card-body">
                            <% 
                                String id = request.getParameter("id");
                                String utilisateurNom = "";
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjee2", "root", "");
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery("select * from utilisateur where id = "+id);
                                while(rs.next()){
                                    utilisateurNom = rs.getString("username");
                                }
                            %>
                            <h5 class="card-title text-muted text-uppercase text-center mb-4">Supprimer Utilisateur <span class="text-danger"><%=utilisateurNom %></span></h5>
                            <form action="User" method="post">
                                <input type="hidden" name="etat" value="supprimer">
                                <input type="hidden" name="id" value="<%=id %>">
                                
                                <div class="form-group mb-4 d-flex  justify-content-end align-items-center">
                                    <button type="submit" class="btn btn-primary btn-block me-3">Supprimer</button>
                                    <a href="./Home.jsp" class="btn btn-secondary btn-block">Annuler</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>