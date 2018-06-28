<html> <head>
<title>Login</title>

<script language="JavaScript">
function checkForma(Objeto)
{
 if (Objeto.nombre.value=='')
 {
  alert('Escriba una Solicitud Válida !!!');
  Objeto.nombre.focus();
  return false;
 }
 return true;
}
</script>
</head>

<body>
<h1>Login Administrador</h1>

<form action="" method=post onSubmit="return checkForma(this);">

Email: <input type=text name=nombre size=30>
<P>
Contrase&ntilde;a: <input type=text name=clave size=30>
<P>
<P>

<input type=submit name=Tablas value="Entrar"><br><br>
</form>

<hr>
</body> </html>

<?php
include('functions.phl');
	if($_REQUEST['Tablas']=='Entrar'){
		$dbh = conectar_dbo();
			$myquery = "Select id from int_usuarios where email='".$_REQUEST['nombre']."' and int_usuarios_tipo_id=1 and clave='".$_REQUEST['clave']."'";
			$sth1 = mysql_query($myquery, $dbh);
			$row=mysql_fetch_array($sth1);

			if($row[0] != "")
			{
				header('Location: php.html');
			}
			else
			{
			echo "ACCESO DENEGADO";
			}


		closeDB();
	}
?>
