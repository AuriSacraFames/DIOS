import socket

def main():
    host = '192.168.128.181'  # Ingresa la IP del servidor
    port = 9999

    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect((host, port))

    while True:
        message = input("Mensaje a enviar al servidor: ")
        client_socket.send(message.encode('utf-8'))

        response = client_socket.recv(1024)
        print(f"Respuesta del servidor: {response.decode('utf-8')}")

    client_socket.close()

if __name__ == "__main__":
    main()