<?php
	include_once('../connection.php');
	
	$nama = $_POST['nama'];
	$getdata = mysqli_query($koneksi, "SELECT * FROM food WHERE nama = '$nama'");
	$rows = mysqli_num_rows($getdata);
	
	$delete = "DELETE FROM food WHERE nama = '$nama'";
	$exedelete = mysqli_query($koneksi, $delete);
	
	$respose = array();
	
	if($rows > 0){
		if($exedelete)
		{
			$respose['code']=1;
			$respose['message'] = "Delete Success";
		}
		else
		{
			$respose['code'] = 0;
			$respose['message'] = "Failed Delete";
		}
	}
	else
	{
		$respose['code'] = 0;
		$respose['message'] = "Failed Delete, data not found";
	}
	echo json_encode($respose);

	?>