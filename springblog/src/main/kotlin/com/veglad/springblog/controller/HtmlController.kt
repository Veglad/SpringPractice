package com.veglad.springblog.controller

import com.veglad.springblog.BlogProperties
import com.veglad.springblog.converter.mapToModel
import com.veglad.springblog.dao.ArticleRepository
import com.veglad.springblog.errors.ArticleNotFoundError
import com.veglad.springblog.pojo.DbArticle
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class HtmlController(private val repository: ArticleRepository, private val properties: BlogProperties) {
    @GetMapping("/")
    fun blog(model: Model): String {
        val articles = repository.findAllByOrderByAddedAtDesc().map(DbArticle::mapToModel)
        model["title"] = properties.title
        model["banner"] = properties.banner
        model["articles"] = articles
        return "blog"
    }

    @GetMapping("/article/{slug}")
    fun article(@PathVariable slug: String, model: Model): String {
        val article = repository.findBySlug(slug)?.mapToModel() ?: throw ArticleNotFoundError()
        model["title"] = "Blog"
        model["article"] = article
        return "article"
    }
}
