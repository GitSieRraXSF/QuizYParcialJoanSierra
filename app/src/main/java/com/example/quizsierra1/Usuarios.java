package com.example.quizsierra1;

public class Usuarios {
    String User;
    String Pass;
    Usuarios Siguiente;
    public Usuarios(String User, String Pass){
        this.User = User;
        this.Pass = Pass;
        this.Siguiente = null;
    }
}