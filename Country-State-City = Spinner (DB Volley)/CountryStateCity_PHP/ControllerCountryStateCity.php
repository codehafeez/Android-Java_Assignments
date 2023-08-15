<?php
if($_SERVER['REQUEST_METHOD']=='POST')
{
    include_once 'DatabaseCountryStateCity.php';
    $obj_class = new DBclass();
    
    if (isset ($_POST['load_country'])) {
        echo $obj_class->load_country_data();
    }        
    
    else if (isset ($_POST['country_id'])) {
        echo $obj_class->change_country_spinner($_POST['country_id']);
    }        
    
    else if (isset ($_POST['state_id_country'])) {
        echo $obj_class->change_country_state_spinner($_POST['state_id_country']);
    }        
}
?>
