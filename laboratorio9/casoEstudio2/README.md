1. Iniciar el contenedor, desde la ruta raiz del proyecto  
`docker compose up`
2. Verificar la ip del contenedor  
`docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' <nombre_del_contenedor_o_ID>`  
3. Ejecuta la aplicacion

linux:
`./compilerun.sh EjemploTransaccion.java` 

windows:
`.\compilerun.bat .\EjemploTransaccion.java`
