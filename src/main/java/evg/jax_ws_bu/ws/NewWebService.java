package evg.jax_ws_bu.ws;


import com.sun.xml.ws.developer.SchemaValidation;
import evg.jax_ws_bu.entity.Models;
import evg.jax_ws_bu.entity.dao.ModelsDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlElement;


@WebService(serviceName = "NewWebService")
@SchemaValidation
public class NewWebService {
    ModelsDAO modelsDao = new ModelsDAO();
   
    @WebMethod(operationName = "getOne")
    public Models getOne(@WebParam(name = "id_rec") Integer id_rec) throws Exception {
        if (!(id_rec instanceof Integer)) {
            throw new Exception("id_rec must be integer");
        }        
        return modelsDao.getById(id_rec);
    }
        
    @WebMethod(operationName = "getOne2")
    public Models getOne2(@WebParam(name = "id_rec") Integer id_rec) throws Exception {
        if (!(id_rec instanceof Integer)) {
            throw new Exception("id_rec must be integer");
        }
        return modelsDao.getById2(id_rec);
    }     
    
    @WebMethod(operationName = "getAll")
    public List<Models> getAll () {
        return modelsDao.getAll();
    }
     
    @WebMethod(operationName = "getAll2")
    public List<Models> getAll2 () {
        return modelsDao.getAll2();
    }
    
    @WebMethod(operationName = "addModel")
    public void addmodel(
        @WebParam(name = "model_name") @XmlElement(name="model_name", required=true, nillable=false) String name,
        @WebParam(name = "manufacturer_id") @XmlElement(name="manufacturer_id", required=true, nillable=false) Integer manufacturerId,
        @WebParam(name = "type_id") @XmlElement(name="type_id", required=true, nillable=false) Integer typeId
    ) throws Exception {
        Models model = new Models(name,manufacturerId,typeId);
        modelsDao.addModel(model);
    }
    
    @WebMethod(operationName = "editModel")
    public void editModel(Models model) {
        modelsDao.editModel(model);
    }
    
    @WebMethod(operationName = "deleteModel")
    public void deleteModel(@WebParam(name = "id_rec") Integer id_rec) throws Exception {
        modelsDao.deleteModel(id_rec);
    }    
}
