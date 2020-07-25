package com.veglad.springblog.controller

import com.veglad.springblog.converter.mapToModel
import com.veglad.springblog.dao.UserRepository
import com.veglad.springblog.errors.UserNotFound
import com.veglad.springblog.dto.User
import com.veglad.springblog.pojo.DbUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/user")
class UserController(val repository: UserRepository) {
    @GetMapping("/")
    fun findAll(): List<User> = repository.findAll().map(DbUser::mapToModel)

    @GetMapping("/{login}")
    fun findByLogin(@PathVariable login: String): User =
            repository.findByLogin(login)?.mapToModel() ?: throw UserNotFound()
}
