<?php
if(isset ($_POST['open_username']) && isset ($_POST['open_password']) ){

    echo 'Name : '.$_POST['open_username'].' --- Password : '.$_POST['open_password'];
    // echo $loginObj->Memberlogic($_POST['open_username'],$_POST['open_password']);
}
else if(isset ($_POST['fname']) && isset ($_POST['lname']) && isset ($_POST['gender']) && isset ($_POST['dof']) && isset ($_POST['email']) && isset ($_POST['password'])){

    //echo $_POST['fname'],$_POST['lname'],$_POST['email'],$_POST['password'],$_POST['gender'],$_POST['dof'];

    // echo $loginObj->Reg_member($_POST['fname'],$_POST['lname'],$_POST['email'],$_POST['password'],$_POST['gender'],$_POST['dof']);
}

    