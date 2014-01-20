<?php
	$link = mysql_connect('localhost', 'root', '') or die('Cannot connect to the DB');
	mysql_select_db('apa', $link) or die('Cannot select the DB');
	 
	/* grab the posts from the db */
	$query = "SELECT id, alamat, ip FROM daf_web";
	$result = mysql_query($query, $link) or die('Errorquery:  '.$query);
	 
	$rows = array();
	while ($r = mysql_fetch_assoc($result)) {
	    $rows[] = $r;
	}
	$data = "{situs:".json_encode($rows)."}";
	echo $data;
	?>