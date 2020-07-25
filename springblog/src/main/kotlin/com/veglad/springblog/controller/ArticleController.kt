package com.veglad.springblog.controller

import com.veglad.springblog.converter.mapToModel
import com.veglad.springblog.dao.ArticleRepository
import com.veglad.springblog.dto.Article
import com.veglad.springblog.errors.ArticleNotFoundError
import com.veglad.springblog.pojo.DbArticle
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/article")
class ArticleController(val repository: ArticleRepository) {
    @GetMapping("/")
    fun findAll(): List<Article> = repository.findAll().map(DbArticle::mapToModel)

    @GetMapping("/{slug}")
    fun findByLogin(@PathVariable slug: String): Article =
            repository.findBySlug(slug)?.mapToModel() ?: throw ArticleNotFoundError()
}
