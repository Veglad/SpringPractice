package com.veglad.springblog

import com.veglad.springblog.dao.UserRepository
import com.veglad.springblog.pojo.DbUser
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@WebMvcTest()
class UserControllerTest (@Autowired val mockMvc: MockMvc) {

    @MockBean
    private lateinit var userRepository: UserRepository

    @Test
    fun `list users`() {
        val user1 = DbUser("springjuergen", "Juergen", "Hoeller")
        val user2 = DbUser("smaldini", "Stéphane", "Maldini")
        every { userRepository.findAll() } returns listOf(user1, user2)

        mockMvc.perform(get("api/v1/user").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("\$.[0].login").value(user1.login))
                .andExpect(jsonPath("\$.[1].login").value(user2.login))
    }
}
