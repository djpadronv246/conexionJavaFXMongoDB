
package utl.conexionjavafxmongo.core;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
/**
 *
 * @author Dulce Padron
 */
public class Conexion {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document= new BasicDBObject();
    
    public  Conexion() {
        try {
            Mongo mongo = new Mongo ("localhost",27017);
            BaseDatos= mongo.getDB("abarrotes");
            coleccion=BaseDatos.getCollection("productos");
            System.out.println("Conexion Exitosa");
        } catch(UnknownHostException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    // C-CREATE R-READ U-UPDATE D-DELETE
    
    public boolean insertar(String nombre){
    document.put("nombre",nombre);
    coleccion.insert(document);
    return true;
    }
    
    String resultado="";
    
    public String Mostrar(){
        resultado="";
    DBCursor cursor = coleccion.find();
        while (cursor.hasNext()) {            
             resultado = resultado + "\n" + cursor.next();
        }
        return resultado;
    }
    
    
    public boolean Actualizar(String nombreViejo, String nombreNuevo){
        document.put("nombre", nombreViejo);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("nombre", nombreNuevo);
        coleccion.findAndModify(document, documentoNuevo);
        return true;
    }
    
    public boolean Eliminar(String nombre){
    document.put("nombre", nombre);
    coleccion.remove(document);
    return true;
    }

}
