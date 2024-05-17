package model;

public class Odontologo {
    private double idOdontologo;
    private int numeroMatricula;
    private String nombre;
    private String apellido;

    public Odontologo(double idOdontologo, int numeroMatricula, String nombre, String apellido) {
        this.idOdontologo = idOdontologo;
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(int numeroMatricula, String nombre, String apellido) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public double getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(double idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Odontologo con: " +
                "id=" + idOdontologo +
                ", nroMatricula=" + numeroMatricula +
                ", nombre='" + nombre + apellido;
    }
}
