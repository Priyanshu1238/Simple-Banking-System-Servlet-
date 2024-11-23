<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap">
    <title>Bank Management System - Current Balance</title>
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
            flex-direction: column; /* Added this line */
        }

        h2 {
            color: #fff;
            font-size: 2.5rem;
            text-align: center;
            margin-bottom: 20px;
            font-weight: bold;
        }

        .balance-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.5);
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
            backdrop-filter: blur(15px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            text-align: center;
        }

        .links {
            margin-top: 20px;
            text-align: center;
        }

        a {
            display: inline-block;
            text-decoration: none;
            font-size: 14px;
            color: #fff;
            transition: color 0.3s;
            margin: 0 10px;
        }

        a:hover {
            color: #64B5F6;
            text-shadow: 1px 1px 5px #000;
        }
    </style>
</head>
<body>

    <% 
        Long balance = (Long)request.getAttribute("myname"); 
        
    %>
    
    <div class="balance-container">
        <h2>Your Current Balance is <%= balance %></h2>
        <div class="links">
            <a href="mainoption.jsp">Back to Options</a> |
            <a href="logout">Logout</a>
        </div>
    </div>

</body>
</html>