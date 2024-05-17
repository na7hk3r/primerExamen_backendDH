package dao;
import java.util.List;

public interface iOdontologoDAO<T> {
    public T guardar(T t);
    public List<T> listarTodos();

}
