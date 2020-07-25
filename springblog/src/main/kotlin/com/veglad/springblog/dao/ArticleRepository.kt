package com.veglad.springblog.dao

import com.veglad.springblog.pojo.DbArticle
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : CrudRepository<DbArticle, Long> {
    fun findBySlug(slug: String): DbArticle?

    fun findAllByOrderByAddedAtDesc(): Iterable<DbArticle>
}
