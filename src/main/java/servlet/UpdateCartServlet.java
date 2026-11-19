package murach.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import murach.business.Cart;

@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {

    @Override 
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String productId = request.getParameter("productId");
        int quantity = Integer.parseInt(
            request.getParameter("quantity")
    );

    HttpSession session = request.getSession();
    Cart cart = (Cart) session.getAttribute("cart");

    if(cart != null){
        cart.updateItem(productId, quantity);
    }
    response.sendRedirect(request.getContextPath()+"/cart");
    }
}