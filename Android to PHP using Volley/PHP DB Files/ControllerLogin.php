<?php
if($_SERVER['REQUEST_METHOD']=='POST')
{

    include_once './DatabaseFunction.php';
    $obj_class = new DBclass();
    
    $username = $_POST['userId'];
    $password = $_POST['password'];

    if (isset ($_POST['userId'])&&isset ($_POST['password'])) {
        echo $obj_class->login($_POST['userId'], $_POST['password']);
    }
    
}
?>

