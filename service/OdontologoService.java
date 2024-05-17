package service;
import dao.iDAO;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private iDAO<Odontologo> odontologoiDAO;

    public iDAO<Odontologo> getOdontologoiDAO() {
        return odontologoiDAO;
    }

    public void setOdontologoiDAO(iDAO<Odontologo> odontologoiDAO) {
        this.odontologoiDAO = odontologoiDAO;
    }

    public Odontologo guardar(Odontologo odontologo){
        return odontologoiDAO.guardar(odontologo);
    }
    public List<Odontologo> listarTodos(){
        return odontologoiDAO.listarTodos();

    }


}
