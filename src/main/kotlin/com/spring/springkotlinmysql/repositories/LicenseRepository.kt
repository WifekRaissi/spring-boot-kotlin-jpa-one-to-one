package com.spring.springkotlinmysql.repositories

import com.spring.springkotlinmysql.entities.License
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface LicenseRepository: CrudRepository<License, Long> {
    fun findByNumber(number:String): MutableList<License>
}
