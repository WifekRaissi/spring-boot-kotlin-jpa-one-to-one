package com.spring.springkotlinmysql.services

import com.spring.springkotlinmysql.entities.License
import com.spring.springkotlinmysql.entities.User
import com.spring.springkotlinmysql.repositories.LicenseRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LicenseServiceImpl:LicenseService {

    private val log = KotlinLogging.logger {}
    @Autowired
    lateinit var repository: LicenseRepository

    override fun getLicenses(): String {
        val licenses = repository.findAll()
        var info: String = ""

        licenses.forEach {
            info += it.toString()
        }
        return info
    }
    override fun getLicenseById(id: Long) =
            repository.findOne(id)


    override fun getLicenseByNumber(number: String) =
            repository.findByNumber(number)



    override fun addLicense(license: License, user: User): License {
        repository.save(License(license.id,license.number,user))
        log.info("${license.number},added!!!")
        return license


    }

    override fun deleteLicense(id: Long) {
        repository.delete(id)
        log.info("license deleted!!")
    }

    override fun deleteAllLicenses() {
        repository.deleteAll()
        log.info("All licenses deleted!!")
    }



    override fun updateLicense(id: Long, license: License):License {
        val currentLicense = repository.findOne(id)
        if (currentLicense != null) repository.save(currentLicense.copy(id,license.number))
        log.info("${license.number},updated!!!")
        return currentLicense

    }



}
