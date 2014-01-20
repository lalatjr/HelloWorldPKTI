<?php
$id = $_POST['aid'];
$nama = $_POST['anama'];
$jk = $_POST['ajk'];
$pass = $_POST['apass'];


$konek=mysql_connect("localhost","root","");

mysql_select_db("loginapa");

$tambah="INSERT INTO user (id,user,password,jenis_kelamin) VALUES ('".$id."','".$nama."','".$pass."','".$jk."')";

$tam_quer = mysql_query($tambah);
if($tam_quer){
echo "Data telah disimpan";
}
else
echo "Gagal untuk menambahkan";
?>