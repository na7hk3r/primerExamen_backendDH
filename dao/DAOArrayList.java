package dao;

import model.Odontologo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DAOArrayList implements iDAO<Odontologo>{
    private List<Odontologo> odontologos;

    public DAOArrayList () {
        this.odontologos = new ArrayList<>();
        Odontologo odontologo1= new Odontologo(1234, "Jorge", "Pereyra");
        Odontologo odontologo2= new Odontologo(3333, "Julian", "Master");
        this.odontologos.add(odontologo1);
        this.odontologos.add(odontologo2);
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        this.odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        return odontologos;
    }
}
