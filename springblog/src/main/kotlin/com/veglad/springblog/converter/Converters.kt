package com.veglad.springblog.converter

import com.veglad.springblog.model.ArticleModel
import com.veglad.springblog.model.UserModel
import com.veglad.springblog.pojo.DbArticle
import com.veglad.springblog.pojo.DbUser
import com.veglad.springblog.utils.format

fun DbUser.mapToModel() = UserModel(
        login = login,
        firstname = firstname,
        lastame = lastame,
        description = description ?: ""
)

fun DbArticle.mapToModel() = ArticleModel(
        slug = slug,
        title = title,
        headline = headline,
        content = content,
        author = author.mapToModel(),
        addedAt = addedAt.format()
)
