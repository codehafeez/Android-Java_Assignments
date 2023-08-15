<?php
class SearchDBclass
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
        
    function ShowList_SearchNewFriend()
    {
        try
        {
            $res = array();
            $sql = "SELECT firstName, lastName, profileImage FROM userProfile";
            $result=  $this->conn->query($sql) or die("Unable to prepare statement: " . $this->error);
            while($row = mysqli_fetch_array($result))
            { 
                array_push($res,array(
                    "firstName"=>$row['firstName'],
                    "lastName"=>$row['lastName'],
                    "profileImage"=>$row['profileImage']
                ));
            }
            echo json_encode($res);
        } catch (Exception $ex){ echo "Error: " . $ex->getMessage(); }
    }        
}