<?php
$link = $_POST['browse'];


$konek=mysql_connect("localhost","root","");

mysql_select_db("apa");

$quer="SELECT * FROM daf_web WHERE alamat='$link'";
$hasil=mysql_query($quer) or die ("Kesalahan Program :".mysql_error());

if(mysql_num_rows($hasil)==1){
	echo 1;
}
else{
	
	}

?>