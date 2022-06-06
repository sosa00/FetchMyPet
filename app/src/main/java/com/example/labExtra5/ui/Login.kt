package com.example.labExtra5.ui
import java.io.Serializable
class Login : Serializable  {
    private var user: String
    private var password: String
    private lateinit var nombre: String
    private var rol: String

    internal constructor() {
        user = ""
        password = ""
        nombre = ""
        rol = ""
    }

    internal constructor(user: String, password: String, nombre: String, rol: String) {
        this.user = user
        this.password = password
        this.nombre = nombre
        this.rol = rol
    }

    fun getUser(): String? {
        return user
    }

    fun setUser(user: String?) {
        this.user = user!!
    }
    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String?) {
        this.password = password!!
    }

    fun getNombre(): String?{
        return this.nombre
    }

    fun setNombre(nombre: String?){
        this.nombre = nombre!!
    }

    fun getRol(): String?{
        return this.rol
    }


}