package murach.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.business.Product;

@WebServlet(urlPatterns = {"", "/index"})
public class ProductServlet extends HttpServlet {
    @Override 
    protected void doGet(HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException{
        List<Product> products = new ArrayList<>();

        products.add(new Product(
            "CD01","86 ( the band) - True Life Songs and Pictures",
            14.95
        ));
        products.add(new Product(
            "CD02","Paddlefoot - The first CD",
            12.95
        ));
        products.add(new Product(
            "CD03","Paddlefoot - The second CD",
            14.95
        ));
        products.add(new Product(
            "CD04","Joe Rut - Genuine Wood Grained Finish",
            14.95
        ));

        request.setAttribute("products", products);

        String url ="/index.jsp";
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
}
