/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Swift
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String action = request.getParameter("action");

        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        if (username != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
        }

        if (action.equals("register")) {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
        }

        if (action.equals("add")) {
            if (request.getParameter("item") != null) {
                String item = request.getParameter("item");
                list.add(item);
                session.setAttribute("list", list);
            }
        }

        if (action.equals("delete")) {
            for (int i = 0; i < list.size(); i++) {
                String element = list.get(i);
                String checked = request.getParameter("item");
                if (checked.equals(element)) {
                    list.remove(i);
                }
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}
