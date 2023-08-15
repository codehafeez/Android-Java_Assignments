<?php
class DBclass
{
    public $conn;
    private $servername = "localhost";
    private $username = "root";
    private $password = "";
    private $dbname = "michawla";

    function __construct()
    {
        $this->conn=new mysqli($this->servername,$this->username,$this->password,$this->dbname);
        if($this->conn->connect_error){
            die("Connection failed: " . $this->conn->connect_error);    
        }
    }
    
    
    
    

function login($userId, $password)
{
$sql = "SELECT * FROM employee WHERE id = '$userId' AND password = '$password'";
$result=  $this->conn->query($sql);
$response = array();
if($row = mysqli_fetch_array($result)) { 
$response = $row; 
}    
else { echo "loginError"; }
echo json_encode($response);
}
    
    
function LotteryList()
{        
$sql = "SELECT id, loteryName FROM lottery";
$result=  $this->conn->query($sql);
$res = array(); 
while($row = mysqli_fetch_array($result)){
array_push($res, array("id"=>$row['id'],"loteryName"=>$row['loteryName']));
}
echo json_encode($res);
}
    
    
function GetCustomerByLotteryAndroid($lotteryID)
{
$sql="SELECT lotterymember.memberid,lotterymember.type,lotterymember.lotteryid ,clients.id,clients.name,clients.fathername,clients.contactnumber FROM `lotterymember` INNER JOIN clients ON clients.id=lotterymember.memberid WHERE lotterymember.lotteryid=?";   
$stmt = mysqli_prepare($this->conn, $sql) or die("Unable to prepare statement: " . $link->error);
mysqli_stmt_bind_param($stmt,"i",$lotteryID);
mysqli_stmt_execute($stmt)or die("Unable to execute query: " . $stmt->error);
$rslt = mysqli_stmt_get_result($stmt);
$res = array(); 
while($row = mysqli_fetch_array($rslt))
{
array_push($res, array(
"id"=>$row['id'],
"name"=>$row['name'],
"fathername"=>$row['fathername'],
"contactnumber"=>$row['contactnumber']
));
}
echo json_encode($res);
}



}