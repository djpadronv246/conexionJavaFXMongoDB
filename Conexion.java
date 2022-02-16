
package conexionjavamongodsm502;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dulce Padron
 */
public class Conexion {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document= new BasicDBObject();
    
    public Conexion() {
        try {
            Mongo mongo = new Mongo ("localhost",27017);
            BaseDatos= mongo.getDB("Actividad502");
            coleccion=BaseDatos.getCollection("Actividad502");
            System.out.println("conexion exitosa");
            
        } catch(UnknownHostException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    // C-CREATE R-READ U-UPDATE D-DELETE
    
    public boolean insertar(String accion){
    document.put("accion",accion);
    coleccion.insert(document);
    return true;
    }
    
    public void Mostrar(){
    DBCursor cursor = coleccion.find();
        while (cursor.hasNext()) {            
            System.out.println(cursor.next());
        }
    }
    
    public boolean Actualizar(String accionVieja, String accionNueva){
        document.put("accion", accionVieja);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("accion", accionNueva);
        coleccion.findAndModify(document, documentoNuevo);
        return true;
    }
    
    public boolean Eliminar(String accion){
    document.put("accion", accion);
    coleccion.remove(document);
    return true;
    }

}
