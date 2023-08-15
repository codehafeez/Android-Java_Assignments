<?php

    include_once './DatabaseSearchNewFriend.php';
    $obj_class = new SearchDBclass();
    
    if (isset ($_POST['searchNewFriend'])) {
         echo $obj_class->ShowList_SearchNewFriend();
    }
    
?>