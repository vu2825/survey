package com.example.email;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EmailListServlet", urlPatterns = {"/surveyServlet"})
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        // Lấy tham số từ form
        String first   = req.getParameter("firstName");
        String last    = req.getParameter("lastName");
        String email   = req.getParameter("email");
        String dob     = req.getParameter("dob");          // KHỚP name="dob" ở HTML
        String hear    = req.getParameter("hear");
        String contact = req.getParameter("contact");

        // Gộp fullName
        String fullName = (first != null ? first : "") + " " + (last != null ? last : "");
        req.setAttribute("fullName", fullName.trim());

        // Checkbox: có thể chọn 0/1/2 ô -> nếu có ít nhất 1 ô -> Yes
        String[] agrees = req.getParameterValues("agree"); // name="agree"
        String agree = (agrees != null && agrees.length > 0) ? "Yes" : "No";

        // Gửi sang JSP
        req.setAttribute("email", email);
        req.setAttribute("dob", dob);
        req.setAttribute("hear", hear);
        req.setAttribute("contact", contact);
        req.setAttribute("agree", agree);

        req.getRequestDispatcher("/WEB-INF/views/thanks.jsp").forward(req, resp);
    }

    // Mở trực tiếp servlet -> quay về trang form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}
