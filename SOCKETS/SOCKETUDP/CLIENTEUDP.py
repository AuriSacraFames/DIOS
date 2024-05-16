import socket

# Configurar el socket UDP
client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server_address = ('192.168.128.181', 12345)

# Solicitar al usuario que ingrese un número
number = input("Ingrese un número: ")

# Enviar el número al servidor
client_socket.sendto(number.encode(), server_address)

# Recibir la respuesta del servidor
data, _ = client_socket.recvfrom(1024)
print("El cuadrado del número es:", data.decode())

# Cerrar el socket del cliente
client_socket.close()