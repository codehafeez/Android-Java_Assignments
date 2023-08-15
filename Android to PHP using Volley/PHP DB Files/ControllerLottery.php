<?php
if($_SERVER['REQUEST_METHOD']=='POST')
{
    include_once './DatabaseFunction.php';
    $obj_class = new DBclass();
    
    echo $obj_class->LotteryList();
}
?>