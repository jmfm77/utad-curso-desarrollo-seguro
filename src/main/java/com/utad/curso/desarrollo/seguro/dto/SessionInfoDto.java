package com.utad.curso.desarrollo.seguro.dto;

import java.util.List;

public class SessionInfoDto {

    private boolean authenticated;

    private String username;

    private List<String> roles;

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(
            boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(
            String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(
            List<String> roles) {
        this.roles = roles;
    }

}
