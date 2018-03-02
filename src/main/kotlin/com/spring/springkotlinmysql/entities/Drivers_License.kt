package com.spring.springkotlinmysql.entities

import javax.persistence.*

@Entity
@Table
data class License(

        @Id @GeneratedValue
        val id:Long=-1,
        val number:String="",
        @OneToOne(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "user_id")
        val user: User ?= null
){
        override fun toString(): String{
                return "{License: ${this.number}, User: ${user?.firstname} ${user?.lastname}}"
        }
}