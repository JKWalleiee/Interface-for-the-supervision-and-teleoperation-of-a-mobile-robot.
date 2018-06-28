<?php
 include('functions.phl');
?>
<html> <head>
<title>Interfaces - Inserci&oacute;n de Usuarios</title>
</head>

<body>
<h1>Inserción de Datos</h1>

<?php
 if($_REQUEST['insert'])
 {
  $dbh = conectar_dbo();
  $myquery = "insert into int_usuarios set nombres='".$_REQUEST['nombre']."', email='".$_REQUEST['descripcion']."', apellidos='".$_REQUEST['Apellido']."',clave='".$_REQUEST['contraseña']."', int_usuarios_tipo_id ='2'";

  $sth = mysql_query($myquery, $dbh);
  if (mysql_errno($dbh))
    echo mysql_errno($dbh).": ".mysql_error($dbh)."<br>";
  else
    echo "USUARIO AGREGADO";
  closeDB();
 }
 else
  echo "Ejecución No Autorizada !!!";
?>
<p>
<a href="forma.html">Volver Atras</a><br><br>
<a href="php.html"> Volver al inicio</a>
<hr>
<address></address>
<!-- hhmts start --> <!-- hhmts end -->
</body> </html>
