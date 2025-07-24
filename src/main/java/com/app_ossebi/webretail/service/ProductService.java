package com.app_ossebi.webretail.service;

import com.app_ossebi.webretail.dto.ProductRequest;
import com.app_ossebi.webretail.dto.ProductResponse;
import com.app_ossebi.webretail.model.Product;
import com.app_ossebi.webretail.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;



    /**
     * Creates a new product from the provided {@link ProductRequest} object.
     *
     * <p>This method first creates a new {@link Product} object and then calls
     * {@link #updateProductFromProductRequest(ProductRequest, Product)} to populate
     * the new product with the data from the request. Finally, it persists the new
     * product using the {@link ProductRepository} and returns a {@link ProductResponse}
     * object containing the data of the newly created product.
     *
     * @param productRequest the request object containing the data for the new product
     * @return the response object containing the data of the newly created product
     */

    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = new Product();
       updateProductFromProductRequest(productRequest, product);
       Product savedProduct = productRepository.save(product);
       return mapProductToProductResponse(savedProduct);
    }

    /**
     * Maps a {@link Product} object to a {@link ProductResponse} object.
     *
     * @param savedProduct the product object to be mapped
     * @return the mapped response object
     */
    private ProductResponse mapProductToProductResponse(Product savedProduct) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(savedProduct.getId());
        productResponse.setName(savedProduct.getName());
        productResponse.setDescription(savedProduct.getDescription());
        productResponse.setPrice(savedProduct.getPrice());
        productResponse.setStockQuantity(savedProduct.getStockQuantity());
        productResponse.setCategory(savedProduct.getCategory());
        productResponse.setImageUrl(savedProduct.getImageUrl());
        productResponse.setActive(savedProduct.getActive());
        return productResponse;
    }

    /**
     * Updates the fields of a {@link Product} object from the provided
     * {@link ProductRequest} object.
     *
     * <p>This method takes a {@link ProductRequest} object and uses it to populate
     * the fields of a {@link Product} object. It is used internally by the
     * {@link ProductService} to update the data of a product.
     *
     * @param productRequest the request object containing the data to update the product with
     * @param product the product object to be updated
     */
    private void updateProductFromProductRequest(ProductRequest productRequest, Product product) {
        productRequest.setName(productRequest.getName());
        productRequest.setDescription(productRequest.getDescription());
        productRequest.setPrice(productRequest.getPrice());
        productRequest.setStockQuantity(productRequest.getStockQuantity());
        productRequest.setCategory(productRequest.getCategory());
        productRequest.setImageUrl(productRequest.getImageUrl());
    }
}
