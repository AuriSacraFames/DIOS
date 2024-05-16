from zeep import Client

#CREAR EL CLIENTE
cliente = Client('http://localhost:8080/ServicioWEB_SOAP/WSOperaciones?WSDL')

#LOGIN
if cliente.service.Login("DIOS", "DIOSDEDIOS224"):
    print("Acceso Correcto")
else:
    print("Error")
    
# PAGO
if cliente.service.ProcesarPago(5000,10000)>=0:
    print("Pago Realizado")
else:
    print("Error")