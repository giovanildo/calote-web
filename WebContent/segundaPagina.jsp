<% String msg = "Bem vindo ao meu JSP"; %>
<html>
<head>
<title><% out.println(msg); %></title>
</head>
<body>
Ol� ${param.nome}, <%=msg %>

</body>
</html>