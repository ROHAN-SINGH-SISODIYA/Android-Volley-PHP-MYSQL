<?php

$con=mysqli_connect('localhost','root','','volley');


$sql="SELECT `name`, `email`, `mobile` FROM `showdata` WHERE 1";
$result=mysqli_query($con,$sql);

if (mysqli_num_rows($result)>0) 
{
	$row=mysqli_fetch_assoc($result);
    
    $row['name'];

	echo json_encode(array("name"=>$row["name"],"email"=>$row["email"],"mobile"=>$row["mobile"]));
}

?>