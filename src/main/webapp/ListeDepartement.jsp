<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<% 
	String username = "";
	String user_role = "ROLE_ADMIN";
	if(session.getAttribute("username") != null) {
		username = session.getAttribute("username").toString();
    }else{
		response.sendRedirect("Login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des departements</title>
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

    <!-- Liste des departements -->
    <section class="pricing py-5">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 d-flex justify-content-between align-items-center mb-5">
                    <h2 class="text-center">Liste des departements</h2>
                    <% if (user_role == "ROLE_ADMIN") {%>
                        <a href="./AjouterDep.jsp" class="btn btn-success">Ajouter un departement</a>
                    <% } %>
                </div>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nom</th>
                            <th scope="col">Info</th>
                            <th scope="col">Image</th>
                            <% if (user_role == "ROLE_ADMIN") {%>
                            <th scope="col">Action</th>
                            <% } %>
                        </tr>
                    </thead>
                    <tbody>
                <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjee2", "root", "");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from departement");
                        while (rs.next()) {
                %>
                            <tr>
                                <td><%=rs.getInt("id") %></td>
                                <td><%=rs.getString("nom") %></td>
                                <td><%=rs.getString("info") %></td>
                                <td><img src="<%=rs.getString("image") %>" alt="image" width="100" height="100"></td>
                                <% if (user_role == "ROLE_ADMIN") {%>
                                <td>
                                    <a href="./ModifierDep.jsp?id=<%=rs.getInt("id") %>" class="btn btn-primary">Edit</a>
                                    <a href="./DeleteDep.jsp?id=<%=rs.getInt("id") %>" class="btn btn-danger">Delete</a>
                                </td>
                                <% }%>
                            </tr>
                <%
                        }   
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</body>
</html>