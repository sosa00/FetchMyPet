package com.example.labExtra5

import com.example.labExtra5.ui.Login


class Usuarios private constructor() {

    private var usuarios: ArrayList<User> = ArrayList<User>()

    init{
        addUser(User("admin", "admin","admin", "8888","admin"))
        addUser(User("nattiortega12@gmail.com", "123","Natasha Ortega", "83109325","Heredia"))
        addUser(User("britanyrojas98@gmail.com", "123","Britany Rojas", "88888888","Alajuela"))
        addUser(User("joseandrexzk@gmail.com", "123","Jose Monge", "88888888","San Jose"))
        addUser(User("danielsosa1400@gmail.com", "123","Daniel Sosa", "88888888","Puntarenas"))
        addUser(User("miguelr128@gmail.com", "123","Miguel Rodriguez", "88888888","Casa de Miguel"))
    }

    private object HOLDER {
        val INSTANCE = Usuarios()
    }

    companion object {
        val instance: Usuarios by lazy {
            HOLDER.INSTANCE
        }
    }

    fun addUser(user: User){
        usuarios?.add(user)

    }

    fun getUser(nombre: String): User? {
        for (p: User in usuarios!!){
            if(p.nombre.equals(nombre)){
                return p;
            }
        }
        return null;
    }

    fun getUsuarios(): ArrayList<User>{
        return this.usuarios!!
    }

    fun login(email: String?, password: String?): Boolean{
        for(p: User in usuarios!!){
            if(p.email.equals(email) && p.password.equals(password)){
                return true
            }
        }
        return false
    }

    fun loginP(email: String?, password: String?): User?{
        for(p: User in usuarios!!){
            if(p.email.equals(email) && p.password.equals(password)){
                return p
            }
        }
        return null
    }

    fun deletePerson(position: Int){
        usuarios!!.removeAt(position)
    }

    fun editPassword(user: String?, password: String){
        for(p: User in usuarios!!){
            if(p.email.equals(user)){
                p.password = password
            }
        }

    }


    fun editUser(p: User, position: Int){
        var aux = usuarios!!.get(position)
        aux.password = p.password
        aux.nombre = p.nombre
        aux.email = p.email
        aux.dir = p.dir
        aux.tel = p.tel
    }

    fun editPersonByName(p: User, nom : String){
        for(pList: User in usuarios!!) {
            if(pList.nombre.equals(nom)) {
                var aux = pList
                aux.password = p.password
                aux.nombre = p.nombre
                aux.email = p.email
                aux.dir = p.dir
                aux.tel = p.tel
            }
        }
    }
}