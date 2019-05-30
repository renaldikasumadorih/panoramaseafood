<?php
$user_name = "root";
$user_pass = "";
$host_name = "localhost";
$db_name = "food_ordering";

$con = mysqli_connect($host_name,$user_name,$user_pass,$db_name);

if($con){
	$image = $_POST["image"];
	$name = $_POST["name"];
	$sql = "insert into image (name) values('$name')";
	$upload_path = "gambar/$name.jpg";

	if(mysqli_query($con,$sql)){
		file_put_contents($upload_path,base64_decode($image));
		echo json_encode(array('response'=>'Image Upload Succesfully'));
	}
	else{
		echo json_encode(array('response'=>'Image upload failed'));
	}
}
mysqli_close($con);

?>