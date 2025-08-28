<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Survey Submitted</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/main.css">
</head>
<body>
  <h1>Survey Submitted</h1>
  <p>Thanks for joining, <b>${fullName}</b>!</p>
  <p>Your info:</p>
  <ul>  
    <li>Email: <%= request.getAttribute("email") %></li>
    <li>Date Of Birth: <%= request.getAttribute("dob") %></li>
    <li>Heard from: <%= request.getAttribute("hear") %></li>
    <li>Contact by: <%= request.getAttribute("contact") %></li>
    <li>Receive announcements: <%= request.getAttribute("agree") %></li>
  </ul>
  <a href="<%=request.getContextPath()%>/index.html">← Back</a>
</body>
</html>
