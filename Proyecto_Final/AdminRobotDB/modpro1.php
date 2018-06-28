<?php
 include('functions.phl');
?>
<html> <head>
<title>Interfaces - Modificaci&oacute;n de Horarios</title>
</head>

<body>
<h1>Modificaci&oacute;n de Horarios</h1>

<?php
 if($_REQUEST['modpro1'])
 {
  $dbh = conectar_dbo();
  $d = "select id from int_usuarios where email='".$_REQUEST['email_u']."'";
  $sth1 = mysql_query($d, $dbh);
  $row=mysql_fetch_array($sth1);


  $myquery = "Update int_usuarios_proceso set hora_fin='".$_REQUEST['hora_f']."', hora_inicio='".$_REQUEST['hora_i']."' where int_usuarios_id ='".$row['id']."' and int_proceso_id ='1'";

  $sth = mysql_query($myquery, $dbh)or die(mysql_error());
  if (mysql_errno($dbh))
    echo mysql_errno($dbh).": ".mysql_error($dbh)."<br>";
  else
    echo "HORARIO ACTUALIZADO";
  closeDB();
 }
 else
  echo "Ejecución No Autorizada !!!";
?>
<p>
<a href="modpro.html">Volver Atras</a><br><br>
<a href="php.html"> Volver al inicio</a>
<hr>
<address></address>
<!-- hhmts start --> <!-- hhmts end -->
</body> </html>
