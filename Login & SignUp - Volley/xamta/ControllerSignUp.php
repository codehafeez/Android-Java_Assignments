<?php
if($_SERVER['REQUEST_METHOD']=='POST')
{
    include_once './DatabaseSignUp.php';
    $obj_class = new DBclass();
    
    if (isset ($_POST['firstName'])&&isset ($_POST['lastName'])&&isset ($_POST['email'])&&isset ($_POST['gender'])&&isset ($_POST['dob'])&&isset ($_POST['password'])) {
        echo $obj_class->signUp($_POST['firstName'], $_POST['lastName'], $_POST['email'], $_POST['gender'], $_POST['dob'], $_POST['password']);
    }    
}
?>
