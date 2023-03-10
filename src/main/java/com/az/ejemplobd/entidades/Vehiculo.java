package com.az.ejemplobd.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalField;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    static DateTimeFormatter dtf =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public Vehiculo() {
    }

    public Vehiculo(String placas, String color, String marca, String modelo, Double kilometraje, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        this.placas = placas;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    @Id
    private String placas;
    @Basic
    private String color;
    @Basic
    private String marca;
    @Basic
    private String modelo;
    @Basic
    private Double kilometraje;
    @Basic
    @Column(name = "fecha_entrada")
    private LocalDateTime fechaIngreso;
    @Basic
    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    @JsonIgnore
    public String getFechaIngresoTexto() {
        if (this.fechaIngreso != null)
            return dtf.format(this.fechaIngreso);
        else
            return "";
    }

    public void setFechaIngresoTexto(String f) {
        try {
            this.fechaIngreso = LocalDateTime.parse(f, dtf);
        }
        catch(DateTimeParseException dtpe) {
        }
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @JsonIgnore
    public String getFechaSalidaTexto() {
        if (this.fechaSalida != null)
            return dtf.format(fechaSalida);
        else
            return "";
    }

    public void setFechaSalidaTexto(String f) {
        try {
            this.fechaSalida = LocalDateTime.parse(f, dtf);
        }
        catch (DateTimeParseException dtpe) {}
    }
}
