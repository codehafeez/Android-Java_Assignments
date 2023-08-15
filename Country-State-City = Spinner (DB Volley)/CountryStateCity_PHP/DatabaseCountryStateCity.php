<?php
class DBclass
{
    public $conn;
    private $servername = "localhost";
    private $username = "root";
    private $password = "";
    private $dbname = "MyWorld_MySQL";

    function __construct() {
        $this->conn=new mysqli($this->servername,$this->username,$this->password,$this->dbname);
        if($this->conn->connect_error){ die("Connection failed: ".$this->conn->connect_error); }
    }
    
    function load_country_data()
    {
        try
        {
            $response = array();
            $sql = "SELECT id, name FROM countries";
            $result = $this->conn->query($sql);
            while($row = mysqli_fetch_array($result)) {
                array_push($response, array('country_id'=>$row["id"],'country_name'=>$row["name"]));
            }
            echo json_encode($response);
        } catch (Exception $ex){ echo "Error: ".$ex->getMessage(); }
    }    
    
    function change_country_spinner($country_id)
    {
        try
        {
            $response = array();
            $sql = "SELECT * FROM states WHERE country_id='$country_id'";
            $result = $this->conn->query($sql);
            while($row = mysqli_fetch_array($result)) {
                array_push($response, array('country_state_id'=>$row["id"],'country_state_name'=>$row["name"]));
            }
            echo json_encode($response);
        } catch (Exception $ex){ echo "Error: ".$ex->getMessage(); }
    }
    
    function change_country_state_spinner($country_id)
    {
        try
        {
            $response = array();
            $sql = "SELECT * FROM cities WHERE state_id='$country_id'";
            $result = $this->conn->query($sql);
            while($row = mysqli_fetch_array($result)) {
                array_push($response, array('country_state_city_id'=>$row["id"],'country_state_city_name'=>$row["name"]));
            }
            echo json_encode($response);
        } catch (Exception $ex){ echo "Error: ".$ex->getMessage(); }
    }
}
