<?php

    include_once './DatabaseLogin.php';
    $obj_class = new LoginDBclass();
    
    if (isset ($_POST['email'])&&isset ($_POST['password'])) {
         echo $obj_class->login($_POST['email'], $_POST['password']);
    }
?>