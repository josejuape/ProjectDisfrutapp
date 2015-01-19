/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disfruta.bean.admin;

/**
 *
 * @author Juape
 */
public class UsuarioDesktop {
    protected int idUser;
    protected String nombres;
    protected String apellidos;
    protected String dni;
    protected String fechNacimiento;
    protected String sexo;
    protected String foto;
    protected String email;
    protected String direccion;
    protected String celular;
    protected String usuario;
    protected String password;
    protected String estado;
    protected String fechaRegistro;
    protected int pedidosAtendidos;
    protected TipoUserDesktop tipoUser;
    protected String tipoOperacion;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechNacimiento() {
        return fechNacimiento;
    }

    public void setFechNacimiento(String fechNacimiento) {
        this.fechNacimiento = fechNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getPedidosAtendidos() {
        return pedidosAtendidos;
    }

    public void setPedidosAtendidos(int pedidosAtendidos) {
        this.pedidosAtendidos = pedidosAtendidos;
    }

    public TipoUserDesktop getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(TipoUserDesktop tipoUser) {
        this.tipoUser = tipoUser;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    
    
}
