<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<% 
	String username = "";
	String user_role = "";
	if(session.getAttribute("username") != null) {
		username = session.getAttribute("username").toString();
    }else{
		response.sendRedirect("Login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
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
    <div class="d-flex justify-content-between align-items-center p-3 px-md-4 mb-5 bg-white border-bottom shadow-sm">
        <h4>Hello <%=username %></h3>
        <ul class="nav nav-pills">
            <li class="nav-item"><a class="nav-link" href="./Home.jsp">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="./ListeDepartement.jsp">Liste Departerments</a></li>
            <li class="nav-item"><a class="nav-link" href="Users">Liste Salle</a></li>
        </ul>
        <a href="Logout">Logout</a>
    </div>
</body>
</html>