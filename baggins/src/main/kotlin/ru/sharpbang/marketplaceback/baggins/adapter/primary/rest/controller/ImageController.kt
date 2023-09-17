package ru.sharpbang.marketplaceback.baggins.adapter.primary.rest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/images")
class ImageController {


    @GetMapping
    fun getImageById(@RequestParam id: Long) {

    }

}