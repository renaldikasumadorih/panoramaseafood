<?php
	include_once('../connection.php');
	
	$id =$_POST['id'];
	$nama=$_POST['nama'];
	$tlp=$_POST['tlp'];
	$alamat=$_POST['alamat'];
	$food=$_POST['food'];
	$waktu=$_POST['waktu'];
	$status=$_POST['status'];
	
	$getdata = mysqli_query($koneksi, "SELECT * FROM pesan WHERE nama = '$nama'");	
	$rows = mysqli_num_rows($getdata);

	$response = array();
	
	if($rows > 0){
		$query = "UPDATE pesan SET tlp='$tlp', alamat='$alamat', food='$food', waktu='$waktu', status='$status' WHERE nama='$nama'";
		$exequery = mysqli_query($koneksi, $query);
	
			if($exequery){
				$response['code'] = 1;
				$response['message'] = "Success ! Data berhasil di perbaharui";
			}
			else{
				$response['code'] = 0;
				$response['message'] = "Failed ! Data gagal di perbaharui";
			}
	}
	else{
		$response['code'] = 0;
				$response['message'] = "Failed ! Data not found";
	}
	echo json_encode($response);
?>