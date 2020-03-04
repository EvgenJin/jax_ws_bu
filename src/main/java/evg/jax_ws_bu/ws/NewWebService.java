package evg.jax_ws_bu.ws;

import evg.jax_ws_bu.entity.Models;
import evg.jax_ws_bu.entity.dao.ModelsDAO;
import java.io.IOException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "NewWebService")
public class NewWebService {
    ModelsDAO modelsDao = new ModelsDAO();

    @WebMethod(operationName = "getOne")
    public Models getOne(@WebParam(name = "id_rec") Integer id_rec) throws Exception {
        return modelsDao.getById(id_rec);
    }
    
    @WebMethod(operationName = "getOne2")
    public Object getOne2(@WebParam(name = "id_rec") Integer id_rec) throws Exception {
        return modelsDao.getById2(id_rec);
    }    
    
    @WebMethod(operationName = "getAll")
    public List<Models> getAll () {
        return modelsDao.getAll();
    }
     
    @WebMethod(operationName = "getAll2")
    public List<Object[]> getAll2 () throws IOException {
        return modelsDao.getAll2();
    }      
}
