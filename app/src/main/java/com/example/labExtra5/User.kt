package com.example.labExtra5

import java.io.Serializable


class User : Serializable {

    var email:String = ""
    var password:String = ""
    var nombre:String = ""
    var tel:String = ""
    var dir:String = ""

    internal constructor(email:String, password:String, nombre:String, tel:String, dir:String){
        this.email = email
        this.password = password
        this.nombre = nombre
        this.tel = tel
        this.dir = dir
    }

}