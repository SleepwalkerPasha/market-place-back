package ru.sharpbang.marketplaceback.restservice.adapter.primary.rest.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.sharpbang.marketplaceback.restservice.adapter.secondary.rest.client.RestServiceClient

@RestController
@RequestMapping("/catalog")
class CatalogController(
    private val restServiceClient: RestServiceClient
) {
    @GetMapping("/product/{productId}")
    fun getProductInfo(@PathVariable productId: Long) =
        ResponseEntity.ok(restServiceClient.createResponseToGetProductData(productId))

}