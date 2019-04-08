<?php

include 'DatabaseConfig.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);
 
 $f_name = $_POST['first_name'];
 $l_name = $_POST['last_name'];
 $email = $_POST['email'];
 
 $Sql_Query = "INSERT INTO `insertdata`(`first_name`, `last_name`, `email`) VALUES ('$f_name','$l_name','$email')";
 
 if(mysqli_query($con,$Sql_Query)){
 
 echo 'Data Inserted Successfully';
 
 }
 else{
 
 echo 'Try Again';
 
 }
 mysqli_close($con);
?>