package com.veglad.springblog.dao

import com.veglad.springblog.pojo.DbUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<DbUser, Long> {
    fun findByLogin(login: String): DbUser?
}
