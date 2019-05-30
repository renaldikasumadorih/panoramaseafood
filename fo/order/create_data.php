<?php
	include_once('../connection.php');
	
	$id =$_POST['id'];
	$nama=$_POST['nama'];
	$tlp=$_POST['tlp'];
	$alamat=$_POST['alamat'];
	$food=$_POST['food'];
	$waktu=$_POST['waktu'];
	$status=$_POST['status'];
	
	
	$insert = "INSERT INTO pesan(id, nama, tlp, alamat, food) VALUES 
	('$id', '$nama', '$tlp', '$alamat', '$food')";
	
	$exeinsert = mysqli_query($koneksi, $insert);
	$response = array();
	
	if($exeinsert){
		$response['code'] = 1;
		$response['message'] = "Success ! Data berhasil di tambahkan";
	}
	else{
		$response['code'] = 0;
		$response['message'] = "Failed ! Data gagal di tambahkan";
	}
		echo json_encode($response);
?>