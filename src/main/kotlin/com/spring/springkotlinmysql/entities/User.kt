package com.spring.springkotlinmysql.entities

import javax.persistence.*

@Entity
@Table
data class User(
    @Id @GeneratedValue
    val id:Long=-1,
    val firstname: String="",
    val lastname:String="",
    @OneToOne(mappedBy = "user")
    val license: License? = null

    ){
    override fun toString(): String{
        return "{user: ${this.firstname} ${this.lastname}, License: ${license?.number}}";
    }
}