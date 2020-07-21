package com.veglad.springblog.pojo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class DbUser(
        var login: String,
        var firstname: String,
        var lastame: String,
        var description: String? = null,
        @Id @GeneratedValue var id: Long? = null
)
