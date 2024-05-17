package service;
import dao.iOdontologoDAO;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private iOdontologoDAO<Odontologo> odontologoiOdontologoDAO;
    public OdontologoService(iOdontologoDAO<Odontologo> odontologoiOdontologoDAO {
        this.odontologoiOdontologoDAO;
    }
    public iOdontologoDAO<Odontologo> getOdontologoiOdontologoDAO{
        return odontologoiOdontologoDAO;
    }
    public void setOdontologoiOdontologoDAO(iOdontologoDAO<Odontologo> odontologoiOdontologoDAO){
        this.odontologoiOdontologoDAO = odontologoiOdontologoDAO;
    }

    public Odontologo guardar(Odontologo odontologo){
        return odontologoiOdontologoDAO.guardar(odontologo);
    }
    public List<Odontologo> listarTodos(){
        return odontologoiOdontologoDAO.listarTodos();

    }


}
