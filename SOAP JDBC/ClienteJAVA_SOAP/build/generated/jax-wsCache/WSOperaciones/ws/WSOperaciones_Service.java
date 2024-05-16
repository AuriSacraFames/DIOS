
package ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSOperaciones", targetNamespace = "http://ws/", wsdlLocation = "http://localhost:8080/ServicioWEB_SOAP/WSOperaciones?WSDL")
public class WSOperaciones_Service
    extends Service
{

    private final static URL WSOPERACIONES_WSDL_LOCATION;
    private final static WebServiceException WSOPERACIONES_EXCEPTION;
    private final static QName WSOPERACIONES_QNAME = new QName("http://ws/", "WSOperaciones");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ServicioWEB_SOAP/WSOperaciones?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSOPERACIONES_WSDL_LOCATION = url;
        WSOPERACIONES_EXCEPTION = e;
    }

    public WSOperaciones_Service() {
        super(__getWsdlLocation(), WSOPERACIONES_QNAME);
    }

    public WSOperaciones_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSOPERACIONES_QNAME, features);
    }

    public WSOperaciones_Service(URL wsdlLocation) {
        super(wsdlLocation, WSOPERACIONES_QNAME);
    }

    public WSOperaciones_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSOPERACIONES_QNAME, features);
    }

    public WSOperaciones_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSOperaciones_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSOperaciones
     */
    @WebEndpoint(name = "WSOperacionesPort")
    public WSOperaciones getWSOperacionesPort() {
        return super.getPort(new QName("http://ws/", "WSOperacionesPort"), WSOperaciones.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSOperaciones
     */
    @WebEndpoint(name = "WSOperacionesPort")
    public WSOperaciones getWSOperacionesPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws/", "WSOperacionesPort"), WSOperaciones.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSOPERACIONES_EXCEPTION!= null) {
            throw WSOPERACIONES_EXCEPTION;
        }
        return WSOPERACIONES_WSDL_LOCATION;
    }

}
