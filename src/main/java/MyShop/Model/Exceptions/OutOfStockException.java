package MyShop.Model.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutOfStockException extends Exception {

    private int stock;

    public int getStock() {
        return stock;
    }
}
