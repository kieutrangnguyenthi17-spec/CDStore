package murach.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        for (LineItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }

        items.add(new LineItem(product, 1));
    }
    public void updateItem(String productId, int quantity){
        for (LineItem item : items){
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

    public void removeItem(String productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId().equals(productId)) {
                items.remove(i);
                return;
            }
        }
    }
    
    public List<LineItem> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;

        for (LineItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }

        return total;
    }
}