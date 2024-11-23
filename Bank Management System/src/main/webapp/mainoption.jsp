<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap">
    <title>Bank Management System - Options</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            background: #042a3f;
            color: #fff;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            backdrop-filter: blur(5px);
        }

        .welcome-message {
            color: #fff;
            font-size: 3rem;
            font-weight: bold;
            text-align: center;
            margin-bottom: 30px;
            text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.5);
        }

        h2 {
            color: #fff;
            font-size: 2rem;
            text-align: center;
            margin: 10px 0; 
            font-weight: bold;
        }

        .options-container {
            width: 500px;
            padding: 20px 30px 30px 30px;
            background-color: rgba(0, 0, 0, 0.5);
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
            backdrop-filter: blur(15px);
            border: 1px solid grey;
            text-align: center;
        }

        .link {
            display: flex;
            flex-direction: column;
            gap: 15px;
            margin-top: 10px;
        }

        a {
            background-color: #079760;
            color: #ffffff;
            padding: 12px;
            border: none;
            border-radius: 10px;
            font-size: 16px;
            text-transform: uppercase;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s, color 0.3s;
        }

        a:hover {
            background-color: #045838;
            color: #fff;
        }
    </style>
</head>
<body>

    <% String name = (String) session.getAttribute("key"); %>
    <div class="welcome-message">
        Welcome, <%= name %>
    </div>

    <div class="options-container">
        <h2>Options</h2>
        <br>
        <div class="link">
            <a href="withdraw.jsp">Withdraw</a>
            <a href="deposit.jsp">Deposit</a>
            <a href="enquiry">Enquiry</a>
            <a href="logout">Logout</a>
        </div>
    </div>

</body>
</html>