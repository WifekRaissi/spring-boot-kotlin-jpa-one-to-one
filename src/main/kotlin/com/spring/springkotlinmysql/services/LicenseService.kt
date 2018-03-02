package com.spring.springkotlinmysql.services

import com.spring.springkotlinmysql.entities.License
import com.spring.springkotlinmysql.entities.User

interface LicenseService{


    fun getLicenses(): String
    fun getLicenseById(id: Long): License?
    fun getLicenseByNumber(number: String): MutableList<License>
    fun addLicense(license: License,user: User): License
    fun deleteLicense(id: Long)
    fun deleteAllLicenses()
    fun updateLicense(id: Long, license: License): License
}