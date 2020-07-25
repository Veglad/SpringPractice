package com.veglad.springblog.converter

import com.veglad.springblog.dto.Article
import com.veglad.springblog.dto.User
import com.veglad.springblog.pojo.DbArticle
import com.veglad.springblog.pojo.DbUser
import com.veglad.springblog.utils.format

fun DbUser.mapToModel() = User(
        login = login,
        firstname = firstname,
        lastame = lastame,
        description = description ?: ""
)

fun DbArticle.mapToModel() = Article(
        slug = slug,
        title = title,
        headline = headline,
        content = content,
        author = author.mapToModel(),
        addedAt = addedAt.format()
)
