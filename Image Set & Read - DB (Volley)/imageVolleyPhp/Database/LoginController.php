<?php

    include_once './LoginDatabase.php';
    $obj_class = new LoginDatabase();
    
    if (isset($_POST['imageCode'])){
        echo $obj_class->InsertImageBase64_Function($_POST['imageCode']);
    }

    if (isset($_POST['showImageCode'])){
        echo $obj_class->ShowImageBase64_Function();
    }
?>