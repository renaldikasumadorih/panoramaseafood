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
	
	$insert = "INSERT INTO food(id, nama, stok, harga, deskripsi, gambar) VALUES ('$id', '$nama', '$stok', '$harga', '$deskripsi', '$url')";
	
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