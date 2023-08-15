<?php
if($_SERVER['REQUEST_METHOD']=='POST')
{
    include_once './DatabaseFunction.php';
    $obj_class = new DBclass();
    
    $username = $_POST['userId'];
    if (isset ($_POST['userId'])) {
        echo $obj_class->GetCustomerByLotteryAndroid($_POST['userId']);
    }
}
?>