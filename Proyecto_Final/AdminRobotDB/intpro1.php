<?php
 include('functions.phl');
?>
<html> <head>
<title>Interfaces - Inserci&oacute;n de Horarios</title>
</head>

<body>
<h1>Inserci&oacute;n de Horarios</h1>

<?php
 if($_REQUEST['intpro1'])
 {
  $dbh = conectar_dbo();
  $d = "select id from int_usuarios where email='".$_REQUEST['usuario']."'";
  $sth1 = mysql_query($d, $dbh);
  $row=mysql_fetch_array($sth1);

  $myquery = "insert into int_usuarios_proceso set int_proceso_id='1', int_usuarios_id='".$row['id']."', fecha='".$_REQUEST['fecha']."',hora_inicio='".$_REQUEST['horai']."',hora_fin='".$_REQUEST['horaf']."'";
  $sth = mysql_query($myquery, $dbh);
  if (mysql_errno($dbh))
    echo mysql_errno($dbh).": ".mysql_error($dbh)."<br>";
  else
    echo "HORARIO AGREGADO";
  closeDB();
 }
 else
  echo "Ejecución No Autorizada !!!";
?>
<p>
<a href="intpro.html">Volver Atras</a><br><br>
<a href="php.html"> Volver al inicio</a>
<hr>
<address></address>
<!-- hhmts start --> <!-- hhmts end -->
</body> </html>
