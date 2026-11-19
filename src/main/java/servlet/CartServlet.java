package murach.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import murach.business.Cart;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{
    @Override 
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session= request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            session.setAttribute("cart", cart);
        }
        request.setAttribute("cart", cart);
        String url = "/cart.jsp";

        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
}