/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author natan
 */
public class usuario {
    public static int cod_us;
    public static String nome;
    public static String email;
    public static String  pass;

    public static int getCod_us() {
        return cod_us;
    }

    public static void setCod_us(int cod_us) {
        usuario.cod_us = cod_us;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        usuario.nome = nome;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        usuario.email = email;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        usuario.pass = pass;
    }
    
    
}
