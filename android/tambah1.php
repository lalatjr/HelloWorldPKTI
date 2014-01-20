<?php
$un=$_POST['username'];
$pw=$_POST['password'];
$rpw=$_POST['repassword'];
$nl=$_POST['nama'];
$jk=$_POST['jekel'];
$al=$_POST['alamat'];
$nt=$_POST['nomor_tlp'];
$nh=$_POST['nomor_hp'];

$conn = mysql_connect("localhost","root","");
mysql_select_db("apa");

$query="INSERT INTO user (username,password,repassword,nama_lengkap,jekel,alamat,nomor_tlp,nomor_hp) VALUES ('$un','$pw','$rpw','$nl','$jk','$al','$nt','$nh')";

$result=mysql_query($query);

if($result)
{ echo "1";
}
else if($un==""||$pw==""||$rpw==""||$nl==""||$jk==""||$al==""||$nt==""||$nh==""){
echo "3";
}
else{
echo "2";
}
?>