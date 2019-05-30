<?php
	include_once('../connection.php');
	
	$id =$_POST['id'];
	$nama=$_POST['nama'];
	$stok=$_POST['stok'];
	$harga=$_POST['harga'];
	$deskripsi=$_POST['deskripsi'];
	$gambar=$_POST['gambar'];
	
	$path = "gambar/$gambar.jpg";
	$url = "http://192.168.43.4/PanoramaSeafood/fo/$path";
	
	$getdata = mysqli_query($koneksi, "SELECT * FROM food WHERE id = '$id'");	
	$rows = mysqli_num_rows($getdata);

	$response = array();
	
	if($rows > 0){
		$query = "UPDATE food SET nama='$nama', stok='$stok', harga='$harga', deskripsi='$deskripsi', gambar='$url' WHERE id='$id'";
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