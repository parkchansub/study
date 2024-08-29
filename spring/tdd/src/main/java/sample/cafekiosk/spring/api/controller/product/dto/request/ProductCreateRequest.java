package sample.cafekiosk.spring.api.controller.product.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

@Getter
@NoArgsConstructor
public class ProductCreateRequest {


    private ProductType type;
    private ProductSellingStatus sellingStatus;
    private String name;
    private int price;
}
