package service;

import dao.impl.OdontologoDaoH2;
import model.Odontologo;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {
    OdontologoService odontologoService=new OdontologoService(new OdontologoDAOH2());

    @Test
    public void registarOdontologos(){
    Odontologo odontologo1=new Odontologo(1234,"Rene","Valenzuela");
    Odontologo odontologo2=new Odontologo(5678,"Mathias","Curbelo");

    // verificar existencia
    Assert.assertNotNull(odontologoService.guardar(odontologo1));
    Assert.assertNotNull(odontologoService.guardar(odontologo2));
    }

    @Test
    public void listarTodosLosOdontologos(){

        System.out.println("el tamaño del listado es : "+odontologoService.listarTodos().size());

        Assert.assertEquals(3, odontologoService.listarTodos().size());
    }


}