<?php
if(isset($_POST['name1']) && isset( $_POST['email1']) && isset( $_POST['password1']))
{
    $conn = new mysqli("localhost", "root", "swann1", "mydb");
    $sql = "INSERT INTO leadregister(name,email,password) values('" .
    $_POST["name1"] . "','" . $_POST["email1"] . "', '" . $_POST["password1"] . "')";
    $conn->query($sql);
    $conn->close();
}
?>