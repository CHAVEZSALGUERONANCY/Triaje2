package com.example.triaje.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/example/triaje/api/RetrofitClient;", "", "()V", "BASE_URL", "", "instance", "Lcom/example/triaje/api/ApiService;", "getInstance", "()Lcom/example/triaje/api/ApiService;", "instance$delegate", "Lkotlin/Lazy;", "token", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "updateToken", "", "newToken", "app_debug"})
public final class RetrofitClient {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BASE_URL = "http://192.168.1.104:4000/";
    @org.jetbrains.annotations.Nullable
    private static java.lang.String token;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy instance$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.triaje.api.RetrofitClient INSTANCE = null;
    
    private RetrofitClient() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.triaje.api.ApiService getInstance() {
        return null;
    }
    
    public final void updateToken(@org.jetbrains.annotations.NotNull
    java.lang.String newToken) {
    }
}