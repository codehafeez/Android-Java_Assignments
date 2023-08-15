<?php
class ProfileDBclass
{
    public $conn;
    private $servername = "localhost";
    private $username = "root";
    private $password = "";
    private $dbname = "xamta";

    function __construct() {
        $this->conn=new mysqli($this->servername,$this->username,$this->password,$this->dbname);
        if($this->conn->connect_error){
            die("Connection failed: " . $this->conn->connect_error);    
        }
    }
        
    function showLoadProfileFields($email)
    {
        try {
            $res = array();
            $sql = "SELECT * FROM userProfile WHERE email='$email'";
            $result=  $this->conn->query($sql) or die("Unable to prepare statement: " . $this->error);
            if($row = mysqli_fetch_array($result))
            { 
                array_push($res,array(
                    "profileImage"=>$row['profileImage'],
                    "firstName"=>$row['firstName'],
                    "lastName"=>$row['lastName'],
                    "gender"=>$row['gender'],
                    "dateOfBirth"=>$row['dob'],
                    "phoneNumber"=>$row['phoneNumber'],
                    "country"=>$row['country'],
                    "city"=>$row['city'],
                    "state"=>$row['state'],
                    "aboutMe"=>$row['aboutMe']
                ));
            }
            echo json_encode($res);
        } catch (Exception $ex){ echo "Error: " . $ex->getMessage(); }
    }        
    
    function updateProfileImage($email, $img_path)
    {
        try
        {
            $sql = "UPDATE userProfile SET profileImage=? WHERE email='".$email."'" ;
            $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement");
            mysqli_stmt_bind_param($stmt,"s",$img_path);
            mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
            echo 'sussfully_update';
        } catch (Exception $ex){ echo "Error: ".$ex->getMessage(); }
    }
    
    function updateFirstName($email, $firstName)
    {
        try {
            $sql = "UPDATE userProfile SET firstName=? WHERE email='".$email."'" ;
            $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement");
            mysqli_stmt_bind_param($stmt,"s",$firstName);
            mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
            echo 'sussfully_update';
        }
        catch (Exception $e) { echo "Error: " . $e->getMessage(); }       
    }
    
    function updateLastName($email, $lastName)
    {
        try {
            $sql = "UPDATE userProfile SET lastName=? WHERE email='".$email."'" ;
            $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement");
            mysqli_stmt_bind_param($stmt,"s",$lastName);
            mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
            echo 'sussfully_update';
        }
        catch (Exception $e) { echo "Error: " . $e->getMessage(); }       
    }

    function updatePassword($email, $old_password, $new_password)
    {
        try {
            $sql = "SELECT * FROM userProfile WHERE email='$email' AND password='$old_password'";
            $result=  $this->conn->query($sql) or die("Unable to prepare statement: " . $this->error);
            if(mysqli_fetch_array($result)){ 
                $sql = "UPDATE userProfile SET password=? WHERE email='".$email."'" ;
                $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement");
                mysqli_stmt_bind_param($stmt,"s",$new_password);
                mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
                echo 'Sussfully Change Password';
            }
            else { echo 'Sorry!, Incorrect Old Password'; }
        }
        catch (Exception $e) { echo "Error: " . $e->getMessage(); }       
    }
    
    function updatePhoneNumber($email, $phoneNumber)
    {
        try {
            $sql = "UPDATE userProfile SET phoneNumber=? WHERE email='".$email."'" ;
            $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement");
            mysqli_stmt_bind_param($stmt,"s",$phoneNumber);
            mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
            echo 'sussfully_update';
        }
        catch (Exception $e) { echo "Error: " . $e->getMessage(); }       
    }
    
    function updateCountry($email, $country)
    {
        try {
            $sql = "UPDATE userProfile SET country=? WHERE email='".$email."'" ;
            $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement");
            mysqli_stmt_bind_param($stmt,"s",$country);
            mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
            echo 'sussfully_update';
        }
        catch (Exception $e) { echo "Error: " . $e->getMessage(); }       
    }
    
    function updateCity($email, $city)
    {
        try {
            $sql = "UPDATE userProfile SET city=? WHERE email='".$email."'" ;
            $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement");
            mysqli_stmt_bind_param($stmt,"s",$city);
            mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
            echo 'sussfully_update';
        }
        catch (Exception $e) { echo "Error: " . $e->getMessage(); }       
    }
    
    function updateState($email, $state)
    {
        try {
            $sql = "UPDATE userProfile SET state=? WHERE email='".$email."'" ;
            $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement");
            mysqli_stmt_bind_param($stmt,"s",$state);
            mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
            echo 'sussfully_update';
        }
        catch (Exception $e) { echo "Error: " . $e->getMessage(); }       
    }
    
    function updateAboutMe($email, $aboutMe)
    {
        try {
            $sql = "UPDATE userProfile SET aboutMe=? WHERE email='".$email."'" ;
            $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement");
            mysqli_stmt_bind_param($stmt,"s",$aboutMe);
            mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
            echo 'sussfully_update';
        }
        catch (Exception $e) { echo "Error: " . $e->getMessage(); }       
    }    
    
    function updateDateOfBirth($email, $dateOfBirth)
    {
        try {
            $sql = "UPDATE userProfile SET dob=? WHERE email='".$email."'" ;
            $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement");
            mysqli_stmt_bind_param($stmt,"s",$dateOfBirth);
            mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
            echo 'sussfully_update';
        }
        catch (Exception $e) { echo "Error: " . $e->getMessage(); }       
    }    
    
}