<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1" />
	<title>Ingreso - SolutionTotal</title>
	
	<!-- Stylesheets -->
        <link rel="stylesheet" type="text/css" href="/SolutionTotal/faces/resources/css/styleLogin.css" />
	<!-- Optimize for mobile devices -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>  
</head>
<body>

	<!-- TOP BAR -->
	<div id="top-bar">
		
		<div class="page-full-width">

		</div> <!-- end full-width -->	
	
	</div> <!-- end top-bar -->
	
	
	
	<!-- HEADER -->
	<div id="header">
		
		<div class="page-full-width cf">
	
			<div id="login-intro" class="fl">
			
				<h1>Ingreso al Sistema</h1>
				<h5>Escriba sus credenciales</h5>
			
			</div> <!-- login-intro -->
			
			<!-- Change this image to your own company's logo -->
			<!-- The logo will automatically be resized to 39px height. -->
			<a href="#" id="company-branding" class="fr"><img src="/SolutionTotal/faces/resources/images/company-logo.png" alt="Blue Hosting" /></a>
			
		</div> <!-- end full-width -->	

	</div> <!-- end header -->
	
	
	
	<!-- MAIN CONTENT -->
	<div id="content">
	
		<form action="j_security_check" method="POST" id="login-form" >
		
			<fieldset>

				<p>
					<label for="login-username">Usuario</label>
					<input type="text" name="j_username" id="login-username" class="round full-width-input" autofocus />
				</p>

				<p>
					<label for="login-password">Contrase&ntilde;a</label>
					<input type="password" name="j_password"  class="round full-width-input" />
				</p>
                                
				<input type="submit" class="button round blue image-right ic-right-arrow" value="Entrar" /> 

			</fieldset>
		</form>
		
	</div> <!-- end content -->
	
	
	
	<!-- FOOTER -->
	<div id="footer">

		<p>&copy; Copyright 2012 <a href="#">Antonio Salinas - Luis Muga</a>. Todos los derechos reservados.</p>
	
	</div> <!-- end footer -->

</body>
</html>