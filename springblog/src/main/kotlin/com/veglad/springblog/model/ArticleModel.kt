package com.veglad.springblog.model

data class ArticleModel(
        var slug: String,
        var title: String,
        var headline: String,
        var content: String,
        val author: UserModel,
        var addedAt: String
)
