<?php
$user = $_POST['auser'];
$pass = $_POST['apass'];

$konek=mysql_connect("localhost","root","");

mysql_select_db("apa");

$quer="SELECT * FROM user WHERE username='$user' AND password='$pass'";
$hasil=mysql_query($quer) or die ("Kesalahan Program :".mysql_error());

if(mysql_num_rows($hasil)==1){
	echo 1;
}
else{
	
	}

?>