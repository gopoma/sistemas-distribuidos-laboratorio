1. Iniciar el contenedor, desde la ruta raiz del proyecto  
`docker compose up`
2. Verificar la ip del contenedor  
`docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' <nombre_del_contenedor_o_ID>`  
3. Copiar la ip y cambiarla en el archivo server > main > resources > application.properties si fuera diferente
4. Iniciar la aplicacion en server > main > java > ServerApplication
