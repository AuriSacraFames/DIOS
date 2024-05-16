
package Test;
import ws.WSOperaciones;
import ws.WSOperaciones_Service;

public class TestWS {

   
    public static void main(String[] args) {
        
        //CREAR CLIENTE
        WSOperaciones_Service servicio = new WSOperaciones_Service();
        WSOperaciones cliente = servicio.getWSOperacionesPort();
        
        //UTILIZAR METODOS
        //1.- LOGIN
        if(cliente.login("DIOS", "DIOSDEDIOS224")){
            System.out.println("Acceso Correcto");
        } else {
            System.out.println("Error");
        }
        
        //2.- PAGOS
        if(cliente.procesarPago(5000, 5000) != -1){
            System.out.println("Pago realizado con éxito");
            System.out.println("Cambio: " + cliente.procesarPago(5000, 5000));
        } else {
            System.out.println("Error");
        }
        //System.out.println(cliente.procesarPago(5000, 5000));
        
    }
    
}
