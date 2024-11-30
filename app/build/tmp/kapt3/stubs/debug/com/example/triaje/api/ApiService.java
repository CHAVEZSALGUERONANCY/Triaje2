package com.example.triaje.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0003H\'J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\'J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\'J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u0019H\'\u00a8\u0006\u001c"}, d2 = {"Lcom/example/triaje/api/ApiService;", "", "crearPaciente", "Lretrofit2/Call;", "Lcom/example/triaje/api/PacienteResponse;", "paciente", "Lcom/example/triaje/api/Paciente;", "createAccount", "Lcom/example/triaje/api/CreateAccountResponse;", "request", "Lcom/example/triaje/api/CreateAccountRequest;", "createHospital", "Lcom/example/triaje/api/HospitalResponse;", "hospitalRequest", "Lcom/example/triaje/api/Hospital;", "getHospitales", "", "Lcom/example/triaje/api/Hospitales;", "login", "Lcom/example/triaje/api/LoginResponse;", "loginRequest", "Lcom/example/triaje/api/LoginRequest;", "obtenerPerfil", "Lcom/example/triaje/api/PerfilResponse;", "token", "", "validarHospital", "nombreHospital", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "/api/usuarios/usuario")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.example.triaje.api.CreateAccountResponse> createAccount(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.triaje.api.CreateAccountRequest request);
    
    @retrofit2.http.POST(value = "/api/auth/login")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.example.triaje.api.LoginResponse> login(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.triaje.api.LoginRequest loginRequest);
    
    @retrofit2.http.GET(value = "/api/usuarios/perfil")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.example.triaje.api.PerfilResponse> obtenerPerfil(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token);
    
    @retrofit2.http.POST(value = "/api/crearpaciente")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.example.triaje.api.PacienteResponse> crearPaciente(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.triaje.api.Paciente paciente);
    
    @retrofit2.http.GET(value = "api/hospital/nombre_hospital")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<java.util.List<com.example.triaje.api.Hospitales>> getHospitales();
    
    @retrofit2.http.POST(value = "/api/hospital")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.example.triaje.api.HospitalResponse> createHospital(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.triaje.api.Hospital hospitalRequest);
    
    @retrofit2.http.GET(value = "/api/hospital/validar/{nombre_hospital}")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.example.triaje.api.Hospital> validarHospital(@retrofit2.http.Path(value = "nombre_hospital")
    @org.jetbrains.annotations.NotNull
    java.lang.String nombreHospital);
}