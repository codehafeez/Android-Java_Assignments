<?php
    
    if (isset ($_POST['image'])&&isset ($_POST['name'])) {
        $image = $_POST['image'];
        $name = $_POST['name'];
        $img_path = "images/.$name.jpg";

        if(file_put_contents($img_path, base64_decode($image))){ echo "Image Uploaded Sussfully"; } 
        else { echo "Error to Upload Image"; }
    }
    

?>

