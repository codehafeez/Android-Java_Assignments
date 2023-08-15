<?php
class DBclass
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
            die("Connection failed: ".$this->conn->connect_error);    
        }
    }
    
    function signUp($firstName, $lastName, $email, $gender, $password)
    {
        try
        {
            $res = array();
            $sql = "SELECT * FROM userProfile WHERE email='$email'";
            $result=  $this->conn->query($sql) or die("Unable to prepare statement: ".$this->error);
            if($row = mysqli_fetch_array($result)){ array_push($res, array("lastName"=>"emailExist")); }
            else 
            {                 
                $sql = "INSERT INTO userProfile(firstName, lastName, email, gender, password) VALUES (?,?,?,?,?)";
                $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement: ".$this->error);
                mysqli_stmt_bind_param($stmt,"sssss",$firstName,$lastName,$email,$gender,$password);
                mysqli_stmt_execute($stmt)or die("Unable to execute query: ".$stmt->error);   
                array_push($res, array("lastName"=>"yesDone"));
            }
            echo json_encode($res);
        } catch (Exception $ex){ echo "Error: ".$ex->getMessage(); }
    }
               
}