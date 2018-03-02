package com.spring.springkotlinmysql.controllers

import com.spring.springkotlinmysql.entities.License
import com.spring.springkotlinmysql.entities.User
import com.spring.springkotlinmysql.services.LicenseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/license")
class LicenseController{

@Autowired
    lateinit var licenseService: LicenseService

    @GetMapping("/licenses")
    fun getAllLicenses() =
            licenseService.getLicenses()

    @GetMapping(value = "/licenses/{id}")
    fun getLicenserById(@PathVariable("id") id: Long) = licenseService.getLicenseById(id)

    @GetMapping(value = "/licenses/{number}")
    fun getLicenseByNumber(@PathVariable("number") number: String) =
            licenseService.getLicenseByNumber(number)

    @PostMapping("/licenses")
    fun createLicense(@Valid @RequestBody license: License) {
        val user= User(3,"wifek")
        licenseService.addLicense(license,user)


    }
    @DeleteMapping("/licenses/{id}")
    fun deleteLicenseById(@PathVariable id: Long) =
            licenseService.deleteLicense(id)

    @DeleteMapping("/licenses")
    fun deleteLicenses() =
            licenseService.deleteAllLicenses()

    @PutMapping("/licenses/{id}")
    fun updateLicense(@PathVariable("id")id:Long, @RequestBody user: License)=
            licenseService.updateLicense(id,user)




}



