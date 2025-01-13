<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error - Login Failure</title>
    <!-- Tailwind CSS CDN link -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 font-sans text-gray-900">

    <!-- Main container: centered error message -->
    <div class="min-h-screen flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
        <div class="max-w-md w-full space-y-8">
            <div>
                <h2 class="text-center text-4xl font-extrabold text-red-600">
                    Something went wrong
                </h2>
                <p class="mt-2 text-center text-lg text-gray-600">
                    <strong>Error:</strong> 
                    <% 
                        String message = request.getParameter("message");
                        if (message != null) {
                            out.print(message);
                        } else {
                            out.print("An unexpected error occurred.");
                        }
                    %>
                </p>
            </div>
            
            <!-- Button container -->
            <div class="flex justify-center mt-6">
                <a href="/MyProject" class="w-full inline-flex justify-center py-3 px-6 border border-transparent rounded-md shadow-sm text-lg font-medium text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 transition duration-150 ease-in-out">
                    Go Back to Login
                </a>
            </div>
            
            <!-- Optional footer for support or contact -->
            <div class="mt-8 text-center text-sm text-gray-500">
                <p>If you continue to experience issues, please contact support.</p>
            </div>
        </div>
    </div>
</body>
</html>
