<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Auth Login</title>
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
	<section class="py-5">
        <div class="container py-5">
            <div class="row mb-4 mb-lg-5">
                <div class="col-md-8 col-xl-6 text-center mx-auto">
                    <p class="fw-bold text-success mb-2">Se connecter</p>
                    <h2 class="fw-bold">Content de te revoir</h2>
                </div>
            </div>
            <div class="row d-flex justify-content-center">
                <div class="col-md-6 col-xl-4">
                    <div class="card">
                        <div class="card-body text-center d-flex flex-column align-items-center">
                            <div class="bs-icon-xl bs-icon-circle bs-icon-primary shadow bs-icon my-4"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-person">
                                    <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664z"></path>
                                </svg></div>
                            <form method="post" data-bs-theme="light" action="./Login">
                                <div class="mb-3"><input class="form-control" type="text" name="username" placeholder="username" autofocus=""></div>
                                <div class="mb-3"><input class="form-control" type="password" name="password" placeholder="Mot de passe"></div>
                                <div class="mb-3"><button class="btn btn-success shadow d-block w-100" type="submit">Se connecter</button></div>
                            </form>
                            <p class="text-muted">Forgot your password ?&nbsp;<a href="#">S'inscrire</a></p>
                            <div><button class="btn btn-danger" type="button"><i class="fab fa-google"></i>&nbsp;Connectez-vous avec Google&nbsp;</button></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../../assets/js/bs-init.js"></script>
</body>
</html>