<%
    String phone = request.getParameter("phone");
    String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Application</title>
    </head>
    <body>
        <p>Name: <%= request.getParameter("name") %></p>
        <%
            if (phone != ""){ out.println("<p>Phone: " + phone + "</p>"); }
            if (email != ""){ out.println("<p>Email: " + email + "</p>"); }
        %>
    </body>
</html>