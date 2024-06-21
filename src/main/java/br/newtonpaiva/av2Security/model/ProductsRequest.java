package br.newtonpaiva.av2Security.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
public class ProductsRequest {
    @Id
    private String id;
    private String productName;
    private String categoria;

    public ProductsRequest() {
    }

    public ProductsRequest(String id, String product, String categoria) {
        this.id = id;
        this.productName = product;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return productName;
    }

    public void setProduct(String product) {
        this.productName = product;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
