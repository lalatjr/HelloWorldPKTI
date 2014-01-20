<?php
$host="localhost";
$username="root";
$password="";
$database="loginapa";
$con=mysql_connect($host,$username,$password);
$pilihdatabase=mysql_select_db($database,$con);
	if($pilihdatabase) echo "Berhasil";
	else echo "Gagal Koneksi";
// Check connection
?>



