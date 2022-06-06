class Login  {
    private String user;
    private String password;
    private String nombre;
    private String rol;
    public Login(){
        this.user = "";
        this.password = "";


    }
    public Login(String user, String password){
        this.user = user;
        this.password = password;

    }
    public Login(String user, String password, String nombre, String rol) {
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.rol = rol;

    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}

