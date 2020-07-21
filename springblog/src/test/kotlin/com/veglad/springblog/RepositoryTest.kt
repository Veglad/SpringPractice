package com.veglad.springblog

import com.veglad.springblog.dao.ArticleRepository
import com.veglad.springblog.dao.UserRepository
import com.veglad.springblog.pojo.DbArticle
import com.veglad.springblog.pojo.DbUser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepositoryTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val articleRepository: ArticleRepository,
        val userRepository: UserRepository
) {

    @Test
    fun `the proper article should be retutned on findByIdOrNull`() {
        val user = DbUser("testAcc", "Mike", "Hoeller")
        val article = DbArticle("Spring Framework 5.0 goes GA", "Dear Spring community ...", "Lorem ipsum", user)
        entityManager.persist(user)
        entityManager.persist(article)
        entityManager.flush()

        val foundArticle = articleRepository.findByIdOrNull(article.id!!)
        assertThat(foundArticle).isEqualTo(article)
    }

    @Test
    fun `findByLogin returns proper user`() {
        val user = DbUser("testAcc", "Mike", "Hoeller")
        entityManager.persist(user)
        entityManager.flush()

        val foundUser = userRepository.findByLogin(user.login)
        assertThat(foundUser).isEqualTo(user)
    }
}
