package com.veglad.springblog

import com.veglad.springblog.dao.ArticleRepository
import com.veglad.springblog.dao.UserRepository
import com.veglad.springblog.pojo.DbArticle
import com.veglad.springblog.pojo.DbUser
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogInitConfiguration {

    @Bean
    fun databaseInititalizer(userRepository: UserRepository, articleRepository: ArticleRepository) = ApplicationRunner {
        val smaldini = userRepository.save(DbUser("smaldini", "Stéphane", "Maldini"))
        articleRepository.save(DbArticle(
                title = "Reactor Bismuth is out",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
        ))
        articleRepository.save(DbArticle(
                title = "Reactor Aluminium has landed",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
        ))
    }
}
