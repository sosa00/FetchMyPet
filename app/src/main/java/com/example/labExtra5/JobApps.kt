package com.example.labExtra5

class JobApps private constructor() {

    private var jobApps: ArrayList<JobAppObj> = ArrayList<JobAppObj>()

    init{
        addJobApp(JobAppObj("Joselito perdido","Labrador","Se escapó el 27 de mayo del 2022. Es un labrador de 4 meses y responde al nombre Joselito. Collar rojo."
        ,R.drawable.lostdog))
        addJobApp(JobAppObj("Beethoven perdido","Husky","Visto última vez por el centro de la Guácima el 20 de mayo a las 4pm, tiene placa con nombre Beethoven y número de teléfono."
            ,R.drawable.lostdog2))

    }
    private object HOLDER {
        val INSTANCE = JobApps()
    }

    companion object {
        val instance: JobApps by lazy {
            HOLDER.INSTANCE
        }
    }

    fun addJobApp(jobapp: JobAppObj){
        jobApps?.add(jobapp)

    }

    fun getJobApp(nombre: String): JobAppObj? {
        for (p: JobAppObj in jobApps!!){
            if(p.getTitulo().equals(nombre)){
                return p;
            }
        }
        return null;
    }

    fun getJobApps(): ArrayList<JobAppObj>{
        return this.jobApps!!
    }

//    fun login(user: String?, password: String?): Boolean{
//        for(p: User in usuarios!!){
//            if(p.user.equals(user) && p.password.equals(password)){
//                return true
//            }
//        }
//        return false
//    }
//
//    fun loginP(user: String?, password: String?): User?{
//        for(p: User in usuarios!!){
//            if(p.user.equals(user) && p.password.equals(password)){
//                return p
//            }
//        }
//        return null
//    }

    fun deleteJobApp(position: Int){
        jobApps!!.removeAt(position)
    }

//    fun editPassword(user: String?, password: String){
//        for(p: User in usuarios!!){
//            if(p.user.equals(user)){
//                p.password = password
//            }
//        }
//
//    }

    fun editJobApp(p: JobAppObj, position: Int){
        var aux = jobApps!!.get(position)
        aux.setTitulo(p.getTitulo())
        aux.setDes(p.getDesc())
        aux.setRaza(p.getRaza())

    }
}