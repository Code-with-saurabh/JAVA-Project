<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans">

    <!-- Centered container for the content -->
    <div class="min-h-screen flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">

        <div class="max-w-md w-full space-y-8 bg-white p-8 rounded-lg shadow-xl">
            
            <h1 class="text-center text-3xl font-extrabold text-blue-600 mb-6">Welcome to Your Profile</h1>
            
            <%
                HttpSession userSession = request.getSession(false);

                if (userSession != null) {
                    String username = (String) userSession.getAttribute("Username");
                    String email = (String) userSession.getAttribute("Email");
                    String phone = (String) userSession.getAttribute("Phone");
                    String firstname = (String) userSession.getAttribute("Firstname");
                    String lastname = (String) userSession.getAttribute("Lastname");

                    if (username != null) {
            %>
            
            <!-- User Details Section -->
            <div class="space-y-4">
                <h2 class="text-2xl font-semibold text-gray-800">Hello, <span class="text-blue-500"><%= firstname + " " + lastname %></span>!</h2>
                <p class="text-lg text-gray-700"><strong>First Name:</strong> <%= firstname %></p>
                <p class="text-lg text-gray-700"><strong>Last Name:</strong> <%= lastname %></p>
                <p class="text-lg text-gray-700"><strong>Email:</strong> <%= email %></p>
                <p class="text-lg text-gray-700"><strong>Phone:</strong> <%= phone %></p>
            </div>

            <!-- Action Buttons -->
            <div class="mt-6 space-y-4">
                <a href="Update.jsp" class="w-full inline-block text-center py-3 px-6 border border-transparent rounded-md shadow-sm text-lg font-medium text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                    Update Details
                </a>

                <!-- Delete Account Form -->
                <form action="DeleteUser" method="post" class="w-full inline-block text-center">
                    <button type="submit" class="w-full py-3 px-6 border border-transparent rounded-md shadow-sm text-lg font-medium text-white bg-red-600 hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-red-500">
                        Delete Account
                    </button>
                </form>

                <!-- Logout Form -->
                <form action="logout.jsp" method="post" class="w-full inline-block text-center">
                    <button type="submit" class="w-full py-3 px-6 border border-transparent rounded-md shadow-sm text-lg font-medium text-white bg-gray-600 hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-500">
                        Logout
                    </button>
                </form>
            </div>

            <%
                    } else {
                        out.println("<p class='text-center text-red-500'>Session Data Not Found.</p>");
                    }
                } else {
                    out.println("<p class='text-center text-red-500'>No active session.</p>");
                }
            %>

        </div>
    </div>
</body>
</html>
