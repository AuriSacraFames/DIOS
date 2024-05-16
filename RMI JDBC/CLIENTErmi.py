import requests

def realizar_solicitud(url):
    try:
        response = requests.get(url)
        response.raise_for_status()  # Verificar si hubo errores en la respuesta
        return response.json()  # Convertir la respuesta JSON en un diccionario de Python
    except requests.exceptions.RequestException as e:
        print("Error al realizar la solicitud:", e)
        return None

def main():

    url = f"http://192.168.0.50:8080/Calculadora/webresources/operaciones/resta?numeroUno=100&numeroDos=50"
    
    resultado = realizar_solicitud(url)

    if resultado:
        print("El resultado es:", resultado)
    else:
        print("No se pudo obtener el resultado.")

if __name__ == "__main__":
    main()
