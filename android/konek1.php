<?php
$db_host ="localhost";
$db_name = "loginapa";
$db_user = "root";
$db_password = "";

extract($_REQUEST, EXTR_OVERWRITE);

mysql_connect($db_host,$db_user,$db_password) or die ("gagal koneksi");
mysql_select_db($db_name);

if($ct== "INS"){
	$sql = "INSERT INTO USER (id,user,password,jenis_kelamin) VALUES ()"
}
?>