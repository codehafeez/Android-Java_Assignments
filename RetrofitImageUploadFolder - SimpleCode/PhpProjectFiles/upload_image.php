<?php

    $target_dir = "uploads/";
    $target_file_name = $target_dir.basename($_FILES["file"]["name"]);
    $response = array();
    
    if (isset($_FILES['file'])){
        if(move_uploaded_file($_FILES["file"]["tmp_name"], $target_file_name)) {
            $success = TRUE;
            $message = "Sussfully Uploaded";
        }
        else {
            $success = FALSE;
            $message = "Error!, While Uploading";
        }
    }
    else {
        $success = FALSE;
        $message = "Error!, Required Field Missing";
    }
    
    $response["success"] = $success;
    $response["message"] = $message;
    echo json_encode($response);
?>