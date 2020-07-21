package com.veglad.springblog.pojo

import com.veglad.springblog.utils.toSlug
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class DbArticle(
        var title: String,
        var headline: String,
        var content: String,
        @ManyToOne val author: DbUser,
        var slug: String = title.toSlug(),
        var addedAt: LocalDateTime = LocalDateTime.now(),
        @Id @GeneratedValue var id: Long? = null
)
