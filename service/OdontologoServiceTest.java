package service;
import com.sun.source.tree.AssertTree;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OdontologoServiceTest {
    OdontologoService odontologoService=new OdontologoService();

    @Test
    public void registarOdontologos(){
        Odontologo odontologo1=new Odontologo(1234,"Rene","Valenzuela");
        Odontologo odontologo2=new Odontologo(5678,"Mathias","Curbelo");

        // Guardar
        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);

        // Verificar existencia
        Assertions.assertNotNull(odontologoService.listarTodos(odontologo1.getNumeroMatricula());
        Assertions.assertNotNull(odontologoService.listarTodos(odontologo2.getNumeroMatricula());
    }

    @Test
    public void listarTodosLosOdontologos(){

        System.out.println("El tamaño del listado es : " + odontologoService.listarTodos());

        Assertions.assertEquals(3, odontologoService.listarTodos().size());
    }


}