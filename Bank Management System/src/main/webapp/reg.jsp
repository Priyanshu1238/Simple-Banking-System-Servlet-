
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap">
    <title>Bank Management System - Registration</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            background: #042a3f;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            backdrop-filter: blur(5px);
        }

        h2 {
            color: #fff;
            font-size: 2.5rem;
            text-align: center;
            margin-bottom: 20px;
            font-weight: bold;
            text-shadow: 1px 1px 2px #000;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.5);
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
            backdrop-filter: blur(15px);
            border: 1px solid grey;
            text-align: center;
        }

        label {
            text-align: left;
            display: block;
            margin-bottom: 10px;
            letter-spacing: 1px;
            font-weight: normal;
            color: #fff;
            text-shadow: 1px 1px 2px #000;
        }

        input {
            width: 100%;
            padding: 12px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 2px solid grey;
            border-radius: 5px;
            background-color: transparent; 
            color: #fff;
            transition: border-color 0.3s;
        }

        input:focus {
            outline: none;
            border-color: #2196F3;
        }

        input[type="submit"] {
            background-color: #079760;
            font-size: 16px;
            color: #ffffff;
            width: 100%;
            text-transform: uppercase;
            cursor: pointer;
            border: none;
            border-radius: 10px;
            padding: 12px;
            transition: background-color 0.3s, color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #045838;
            color: #fff;
        }

        .home-button a {
            display: inline-block;
            padding: 8px 16px;
            background-color: #fff;
            color: #000;
            text-align: center;
            text-decoration:none;
            font-size: 14px;
            font-weight: bold;
            border-radius: 50px;
            transition: background-color 0.3s, color 0.3s;
        }

        .home-button:hover {
            background-color: #808080;
            color: #fff;
        }
        
       form  a {
            display: inline-block;
            text-decoration: none;
            font-size: 14px;
            color: #fff;
            transition: color 0.3s;
        }

       form a:hover {
            color: #079760;
            text-shadow: 1px 1px 5px #000;
        }
    </style>
</head>
<body>
    <div>
        <h2>Registration Form</h2>

        <form action="NewReg" method="post">
            <label for="eno">Mobile Number:</label>
            <input type="tel" name="acc" id="eno" placeholder="Enter 10-digit mobile number" pattern="\d{10}" maxlength="10" required>

            <label for="ename">Holder Name:</label>
            <input type="text" name="name" id="ename" placeholder="Enter account holder's name" required>

            <label for="esal">Pin Code:</label>
            <input type="number" name="pincode" id="esal" placeholder="Enter unique 4-digit code" min="1000" max="9999" required>

            <label for="balance">Opening Balance:</label>
            <input type="number" name="opblc" id="opblc" placeholder="Default: zero" value="0" min="0" required>

            <input type="submit" value="Register"><br>
          
          	<a href="index.html">Back to home </a>
        </form>
        	  
    </div>
</body>
</html>
