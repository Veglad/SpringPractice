package com.veglad.springblog.dto

data class Article(
        var slug: String,
        var title: String,
        var headline: String,
        var content: String,
        val author: User,
        var addedAt: String
)
