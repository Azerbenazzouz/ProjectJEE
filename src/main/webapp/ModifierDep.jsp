<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<%@ page import="entites.Departement"%>
<% 
	String username = "";
	String user_role = "ROLE_ADMIN";
	if(session.getAttribute("username") != null) {
		username = session.getAttribute("username").toString();
    }else{
		response.sendRedirect("Home.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier departement</title>
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
                            <h5 class="card-title text-muted text-uppercase text-center mb-4">Modifier Departement</h5>
                            <%
                                String id = request.getParameter("id");
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjee", "root", "");
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery("select * from departement where id = "+id);
                                Departement dep = new Departement();
                                if(rs.next()){
                                    dep.setId(rs.getInt("id"));
                                    dep.setNom(rs.getString("nom"));
                                    dep.setInfo(rs.getString("info"));
                                    dep.setImage(rs.getString("image"));
                                }
                            %>
                            
                            <form action="ServletAuth" method="post">
                                <input type="hidden" name="id" value="<%=dep.getId()%>">
                                <div class="form-group mb-3">
                                    <input type="text" name="nom" class="form-control" placeholder="Nom du departement" required value="<%=dep.getNom()%>">
                                </div>
                                <div class="form-group mb-3">
                                    <input type="text" name="info" class="form-control" placeholder="Information" required value="<%=dep.getInfo()%>">
                                </div>
                                <div class="form-group mb-3">
                                    <input type="text" name="image" class="form-control" placeholder="Image" required value="<%=dep.getImage()%>">
                                </div>
                                <input type="hidden" name="etat" value="modifier">
                                <button type="submit" class="btn btn-primary btn-block">Modifier</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>