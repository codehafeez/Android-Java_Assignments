<?php

    include_once './DatabaseProfile.php';
    $obj_class = new ProfileDBclass();
    
    if (isset ($_POST['email'])) {
         echo $obj_class->showLoadProfileFields($_POST['email']);
    }
    
    else if (isset ($_POST['currenctUser_email'])&&isset ($_POST['image_upload'])) 
    {
        $email = $_POST['currenctUser_email'];
        $image = $_POST['image_upload'];
        $img_path = "images/".$email.".png";
        if(file_put_contents($img_path, base64_decode($image))) { 
            echo $obj_class->updateProfileImage($email, $img_path);
        }         
    }
    
    else if (isset ($_POST['currenctUser_email'])&&isset ($_POST['currenctUser_firstName'])) {
         echo $obj_class->updateFirstName($_POST['currenctUser_email'], $_POST['currenctUser_firstName']);
    }
    
    else if (isset ($_POST['currenctUser_email'])&&isset ($_POST['currenctUser_lastName'])) {
         echo $obj_class->updateLastName($_POST['currenctUser_email'], $_POST['currenctUser_lastName']);
    }
    
    else if (isset ($_POST['currenctUser_email'])&&isset ($_POST['old_password'])&&isset ($_POST['new_password'])) {
         echo $obj_class->updatePassword($_POST['currenctUser_email'], $_POST['old_password'], $_POST['new_password']);
    }
    
    else if (isset ($_POST['currenctUser_email'])&&isset ($_POST['currenctUser_phoneNumber'])) {
         echo $obj_class->updatePhoneNumber($_POST['currenctUser_email'], $_POST['currenctUser_phoneNumber']);
    }
    
    else if (isset ($_POST['currenctUser_email'])&&isset ($_POST['currenctUser_country'])) {
         echo $obj_class->updateCountry($_POST['currenctUser_email'], $_POST['currenctUser_country']);
    }
    
    else if (isset ($_POST['currenctUser_email'])&&isset ($_POST['currenctUser_city'])) {
         echo $obj_class->updateCity($_POST['currenctUser_email'], $_POST['currenctUser_city']);
    }
    
    else if (isset ($_POST['currenctUser_email'])&&isset ($_POST['currenctUser_state'])) {
         echo $obj_class->updateState($_POST['currenctUser_email'], $_POST['currenctUser_state']);
    }
    
    else if (isset ($_POST['currenctUser_email'])&&isset ($_POST['currenctUser_aboutMe'])) {
         echo $obj_class->updateAboutMe($_POST['currenctUser_email'], $_POST['currenctUser_aboutMe']);
    }
    
    else if (isset ($_POST['currenctUser_email'])&&isset ($_POST['currenctUser_dateOfBirth'])) {
         echo $obj_class->updateDateOfBirth($_POST['currenctUser_email'], $_POST['currenctUser_dateOfBirth']);
    }
?>