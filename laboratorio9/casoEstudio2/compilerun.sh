#!/bin/bash

# Verificar si se proporcionó el nombre del archivo de la clase principal como argumento
if [ -z "$1" ]; then
  echo "Uso: $0 <nombre_archivo_clase"
  exit 1
fi

# Asignar el argumento proporcionado a una variable y quitar el sufijo .java si está presente
MAIN_CLASS="${1%.java}"

# Compilar los archivos Java
javac -cp lib/mysql-connector-j-8.4.0.jar -d bin/ *.java
# Verificar si la compilación fue exitosa
if [ $? -ne 0 ]; then
  echo "La compilación falló."
  exit 1
fi

# Ejecutar la aplicación Java
java -cp bin:lib/mysql-connector-j-8.4.0.jar casoEstudio2."$MAIN_CLASS"
# Verificar si la ejecución fue exitosa
if [ $? -ne 0 ]; then
  echo "La ejecución falló."
  exit 1
fi
