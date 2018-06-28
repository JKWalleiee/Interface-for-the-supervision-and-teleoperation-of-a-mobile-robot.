<?php
 include('functions.phl');
?>
<html> <head>
<title>Interfaces - Modificacio&oacute;n de Usuarios</title>
</head>

<body>
<h1>Inserci&oacute;n de Datos</h1>

<?php
 if($_REQUEST['modusu1'])
 {
  $dbh = conectar_dbo();
   $myquery = "Update int_usuarios set clave='".$_REQUEST['contraseña']."', nombres='".$_REQUEST['nombre']."', apellidos='".$_REQUEST['Apellido']."' where email='".$_REQUEST['descripcion']."'";

  $sth = mysql_query($myquery, $dbh);
  if (mysql_errno($dbh))
    echo mysql_errno($dbh).": ".mysql_error($dbh)."<br>";
  else
    echo "USUARIO MODIFICADO";
  closeDB();
 }
 else
  echo "Ejecución No Autorizada !!!";
?>
<p>
<a href="modosu.html">Volver Atras</a><br><br>
<a href="php.html"> Volver al inicio</a>
<hr>
<address></address>
<!-- hhmts start --> <!-- hhmts end -->
</body> </html>
