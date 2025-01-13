<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%
    HttpSession userSession1 = request.getSession(false);
    String firstname = null;
    String lastname = null;
    String email = null;
    String phone = null;

    if (userSession1 != null) {
        firstname = (String) userSession1.getAttribute("Firstname");
        lastname = (String) userSession1.getAttribute("Lastname");
        email = (String) userSession1.getAttribute("Email");
        phone = (String) userSession1.getAttribute("Phone");
    } else {
        // Redirect to login or error page
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Information</title>
    <style>
        body {
            font-family: 'Open Sans', Helvetica, Arial, sans-serif;
            background: url(http://farm8.staticflickr.com/7064/6858179818_5d652f531c_h.jpg) no-repeat center center fixed; 
            background-size: cover;
        }

        :root {
            --grey: #2a2a2a;
            --blue: #1fb5bf;
        }

        form {
            width: 40%;
            min-width: 320px;
            max-width: 475px;
            background: rgba(255, 255, 255, 0.9);
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.25);
            padding: 2em;
            border-radius: 8px;
        }

        h1 {
            color: #4d4d4d;
            font-family: 'Open Sans Condensed', sans-serif;
            font-size: 1.5em;
            text-align: center;
            margin-bottom: 1.5em;
        }

        div {
            margin-bottom: 1.5em;
        }

        input[type="text"] {
            display: block;
            width: 100%;
            padding: 0.5em;
            border: 1px solid #eaeaea;
            border-radius: 4px;
            color: #757575;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus {
            outline: none;
            border-color: var(--blue);
        }

        input[type="submit"], .logout-button {
            display: inline-block;
            background: var(--blue);
            border: none;
            padding: 0.5em 2em;
            color: white;
            cursor: pointer;
            border-radius: 4px;
            transition: background 0.3s;
        }

        input[type="submit"]:hover, .logout-button:hover {
            background: #23c5c7;
        }

        @media (max-width: 40em) {
            form {
                width: 95%;
                position: relative;
                margin: 2.5% auto 0 auto;
                left: 0;
                transform: translate(0, 0);
            }
        }
    </style>
</head>
<body>
    <h1>Update User Information</h1>
    <form action="UpdateUser" method="post">
        <div>
            First Name: <input type="text" name="firstname" value="<%= firstname != null ? firstname : "" %>" />
        </div>
        <div>
            Last Name: <input type="text" name="lastname" value="<%= lastname != null ? lastname : "" %>" />
        </div>
        <div>
            Email: <input type="text" name="email" value="<%= email != null ? email : "" %>" />
        </div>
        <div>
            Phone: <input type="text" name="phone" value="<%= phone != null ? phone : "" %>" />
        </div>

        <input type="submit" name="action" value="Submit"/>
    </form>
    
    <form action="logout.jsp" method="post" style="text-align: center; margin-top: 300px;">
        <button type="submit" class="logout-button">Logout</button>
    </form>
</body>
</html>
