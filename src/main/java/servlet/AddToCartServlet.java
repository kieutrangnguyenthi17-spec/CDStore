package murach.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import murach.business.Cart;
import murach.business.Product;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    @Override 
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String productId=request.getParameter("productId");
        Product product=findProduct(productId);
        if(product==null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        HttpSession session=request.getSession();
        Cart cart=(Cart) session.getAttribute("cart");
        if(cart==null){
            cart=new Cart();
        }
        cart.addItem(product);
        session.setAttribute("cart", cart);
        response.sendRedirect(request.getContextPath()+"/cart");
    }
    private Product findProduct(String productId){
        List<Product> products=new ArrayList<>();
        products.add(new Product("CD01","86 (the band) - True Life Songs and Pictures", 14.95));
        products.add(new Product("CD02","Paddlefoot - The first CD", 12.95));
        products.add(new Product("CD03","Paddlefoot - The second CD", 14.95));
        products.add(new Product("CD04","Joe Rut - Genuine Wood Grained Finish", 14.95));

        for(Product product:products){
            if(product.getId().equals(productId)){
                return product;
            }
        }
        return null;
    }
}
