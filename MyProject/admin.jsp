<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page session="true" %> <!-- No need to manually declare session -->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Manage Users</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100 font-sans text-gray-900">

    <% 
        // No need to declare session manually, it's already available as implicit object.
        String adminUser = (String) session.getAttribute("Username");
        if (adminUser == null || !adminUser.equals("admin")) {
            response.sendRedirect("/MyProject");
            return; // Redirect to login if not an admin
        }
    %>

    <!-- Admin Page Content -->
    <div class="min-h-screen flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
        <div class="max-w-7xl w-full space-y-8 bg-white p-10 rounded-lg shadow-xl">
            <h2 class="text-center text-3xl font-extrabold text-blue-600">Admin Panel</h2>

            <h3 class="mt-6 text-center text-xl font-medium text-gray-700">
                Manage Users
            </h3>

            <!-- Display All Users -->
            <div class="overflow-x-auto mt-6">
                <table class="min-w-full table-auto">
                    <thead class="bg-gray-200">
                        <tr>
                            <th class="px-6 py-3 text-left text-sm font-semibold text-gray-600">ID</th>
                            <th class="px-6 py-3 text-left text-sm font-semibold text-gray-600">Username</th>
                            <th class="px-6 py-3 text-left text-sm font-semibold text-gray-600">Email</th>
                            <th class="px-6 py-3 text-left text-sm font-semibold text-gray-600">Phone</th>
                            <th class="px-6 py-3 text-left text-sm font-semibold text-gray-600">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            // Connect to the database and fetch all users
                            Connection con = null;
                            Statement stmt = null;
                            ResultSet rs = null;
                            try {
                                // Load the MySQL driver
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/smaple", "qwertyui", "qwertyui");
                                
                                stmt = con.createStatement();
                                String query = "SELECT * FROM users"; // Query to fetch all users
                                rs = stmt.executeQuery(query);
                                
                                // Loop through and display users
                                while (rs.next()) {
                                    String userId = rs.getString("id");
                                    String username = rs.getString("username");
                                    String email = rs.getString("email");
                                    String phone = rs.getString("phone");
                        %>
                                    <tr>
                                        <td class="px-6 py-3 text-sm text-gray-700"><%= userId %></td>
                                        <td class="px-6 py-3 text-sm text-gray-700"><%= username %></td>
                                        <td class="px-6 py-3 text-sm text-gray-700"><%= email %></td>
                                        <td class="px-6 py-3 text-sm text-gray-700"><%= phone %></td>
                                        <td class="px-6 py-3 text-sm text-gray-700">
                                            <form action="deleteUser.jsp" method="post" class="inline-block">
                                                <input type="hidden" name="userId" value="<%= userId %>">
                                                <button type="submit" class="bg-red-600 text-white px-4 py-2 rounded-md hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-red-500">
                                                    Delete
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                        <%      } 
                            } catch (Exception e) {
                                out.println("<p class='text-center text-red-500'>Error fetching users: " + e.getMessage() + "</p>");
                            } finally {
                                if (rs != null) try { rs.close(); } catch (SQLException e) {}
                                if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
                                if (con != null) try { con.close(); } catch (SQLException e) {}
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <!-- Logout Button -->
            <div class="mt-6 text-center">
                <a href="logout.jsp" class="bg-gray-600 text-white px-6 py-3 rounded-lg hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-gray-500 focus:ring-offset-2">
                    Logout
                </a>
            </div>
        </div>
    </div>

</body>

</html>
