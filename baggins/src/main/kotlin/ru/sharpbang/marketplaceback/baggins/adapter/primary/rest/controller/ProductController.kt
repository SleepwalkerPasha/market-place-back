package ru.sharpbang.marketplaceback.baggins.adapter.primary.rest.controller

import mu.KotlinLogging
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.sharpbang.marketplaceback.baggins.model.request.NewProductRequest
import ru.sharpbang.marketplaceback.baggins.model.request.UpdateProductRequest
import ru.sharpbang.marketplaceback.baggins.port.ImagePort
import ru.sharpbang.marketplaceback.baggins.port.ProductInfoPort
import ru.sharpbang.marketplaceback.baggins.port.ProductPort
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.DELETE_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.GET_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.POST_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.RestContstants.PUT_METHOD
import ru.sharpbang.marketplaceback.baggins.support.utils.executeWithLogging

@RestController
@RequestMapping("/products")
class ProductController(
    private val productPort: ProductPort,
    private val imagePort: ImagePort,
    private val productInfoPort: ProductInfoPort
) {

    @GetMapping("/{productId}")
    fun getProductById(@PathVariable productId: Long) = executeWithLogging(
        logger = logger,
        logPoint = SERVICE_LOG_POINT,
        requestBody = productId,
        httpMethod = GET_METHOD
    ) { productPort.getProductById(productId) }

    @PostMapping
    fun addNewProduct(@RequestBody newProductRequest: NewProductRequest) = executeWithLogging(
        logger = logger,
        logPoint = SERVICE_LOG_POINT,
        requestBody = newProductRequest,
        httpMethod = POST_METHOD
    ) {
        productPort.addNewProduct(newProductRequest)
    }

    @PutMapping("/update")
    fun updateProductInfo(@RequestBody updateProductRequest: UpdateProductRequest) = executeWithLogging(
        logger = logger,
        logPoint = SERVICE_LOG_POINT,
        requestBody = updateProductRequest,
        httpMethod = PUT_METHOD
    ) {
        productPort.updateProductInfo(updateProductRequest)
    }

    @DeleteMapping("/{productId}/delete")
    fun deleteProduct(@PathVariable productId: Long) = executeWithLogging(
        logger = logger,
        logPoint = SERVICE_LOG_POINT,
        requestBody = productId,
        httpMethod = DELETE_METHOD
    ) {
        productPort.deleteProduct(productId)
    }

    @GetMapping("/{productId}/images")
    fun getImagesOfProduct(@PathVariable productId: Long) = executeWithLogging(
        logger = logger,
        logPoint = SERVICE_LOG_POINT,
        requestBody = productId,
        httpMethod = GET_METHOD
    ) {
        imagePort.getImagesByProductId(productId)
    }

    @GetMapping("/{productId}/info")
    fun getProductInfo(@PathVariable productId: Long) = executeWithLogging(
        logger = logger,
        logPoint = SERVICE_INFO_LOG_POINT,
        requestBody = productId,
        httpMethod = GET_METHOD
    ) {
        productInfoPort.getProductCharacteristics(productId)
    }

    companion object {
        private const val SERVICE_LOG_POINT = "PRODUCT"
        private const val SERVICE_INFO_LOG_POINT = "PRODUCT.INFO"


        private val logger = KotlinLogging.logger { }
    }
}
