<?php
class LoginDBclass
{
    public $conn;
    private $servername = "localhost";
    private $username = "root";
    private $password = "";
    private $dbname = "xamta";

    function __construct()
    {
        $this->conn=new mysqli($this->servername,$this->username,$this->password,$this->dbname);
        if($this->conn->connect_error){
            die("Connection failed: " . $this->conn->connect_error);    
        }
    }
    
    
    function login($email, $password)
    {
        try
        {
            $res = array();
            $sql = "SELECT * FROM signUp WHERE email='$email' AND password='$password'";
            $result=  $this->conn->query($sql) or die("Unable to prepare statement: " . $link->error);
            if($row = mysqli_fetch_array($result)){ array_push($res, array("lastName"=>$row['lastName'])); }
            else { array_push($res, array("lastName"=>$row="LoginError")); }
            echo json_encode($res);
        } catch (Exception $ex){ echo "Error: " . $ex->getMessage(); }
    }
        
}