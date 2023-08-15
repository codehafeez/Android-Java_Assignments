<?php
session_start();
class LoginDatabase 
{
    public $conn;
    private $servername = "localhost";
    private $username = "root";
    private $password = "";
    private $dbname = "hafeezDB";
    
    function __construct(){
        $this->conn=new mysqli($this->servername,$this->username,$this->password,$this->dbname);
        if($this->conn->connect_error){ die("Connection failed: " . $this->conn->connect_error); }
    }

    function InsertImageBase64_Function($imageBase64) 
    {
        try {
        $sql = "INSERT INTO `imagesBase64`(`image`) VALUES (?)";
        $stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement: " . $link->error);
        mysqli_stmt_bind_param($stmt,"s",$imageBase64);
        mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
        echo 'sussfully save';
        } catch(PDOException $e){ echo "Error: " . $e->getMessage(); }    
    }

    function ShowImageBase64_Function() 
    {
        try 
        {            
            $sql = "SELECT * FROM imagesBase64";
            $result=  $this->conn->query($sql);
            while ($row = mysqli_fetch_array($result)){
            echo $row['image'];
            }            
        } catch(PDOException $e){ echo "Error: " . $e->getMessage(); }    
    }

    
}
