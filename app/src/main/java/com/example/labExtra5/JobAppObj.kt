package com.example.labExtra5

import java.io.Serializable


class JobAppObj : Serializable {

    var titulo_: String = ""
    var raza_: String = ""
    var descripcion_: String = ""
    var foto: Int = 0

    internal constructor(titulo: String, raza: String, descripcion: String, foto: Int) {
        this.titulo_ = titulo
        this.raza_ = raza
        this.descripcion_ = descripcion
        this.foto = foto


    }

    internal constructor() {
        this.titulo_ = ""
        this.raza_ = ""
        this.descripcion_ = ""


    }


    fun getTitulo(): String {
        return titulo_
    }

    fun setTitulo(name : String) {
        titulo_ = name
    }
    fun getRaza(): String{
        return raza_
    }

    fun setRaza(raza : String) {
        raza_ = raza
    }

    fun getDesc():String{
        return descripcion_
    }

    fun setDes(des : String) {
        descripcion_ = des
    }



}