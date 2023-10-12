package ru.sharpbang.marketplaceback.restservice.adapter.secondary.rest.client

import org.apache.hc.client5.http.classic.HttpClient
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.sharpbang.marketplaceback.restservice.model.response.ProductResponse

@Service
class RestServiceClient {
    @Value("\${bagiins.url}")
    private val serverUrl: String? = null
    private val rest: RestTemplate? = null

    init {
        val rest = RestTemplate()
        val httpClient: HttpClient = HttpClientBuilder.create().build()
        val requestFactory = HttpComponentsClientHttpRequestFactory(httpClient)
        rest.requestFactory = requestFactory
    }

    fun createResponseToGetProductData(productId: Long) =
        rest?.getForObject(String.format("%s//products/%d", serverUrl, productId), ProductResponse::class.java)!!

}