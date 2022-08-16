# meli-test-xments
Prueba técnica mercado libre

### Para ejecutar la prueba
1. se requiere tener MySql
2. ir a la Base de datos 
3. ejecutar los scripts que se encuentran en el archivo de raiz llamado **[query.sql]()**

### El cuerpo de peticiones para [https://meli-test-app.herokuapp.com/mutant](https://meli-test-app.herokuapp.com/mutant) en postman es:
`{
"dna": [
"ATATA","AGTTG","ATAAG","AGTTG","CGCGG"]
}`
### Tener en cuenta que tiene una captura de errores para cuando se intenta ingresar la misca cadena de DNA

### El enlace para traer la estadistica de mutantes en base de datos es [https://meli-test-app.herokuapp.com/stats](https://meli-test-app.herokuapp.com/stats)

#### El proyecto no cuenta son swagger debido a que causa una falla a la hora de desplegar en heroku

#### El proyecto integra sonarCloud como analizador de codigo estatico [https://sonarcloud.io/project/overview?id=gama1236_meli-test-xments](https://sonarcloud.io/project/overview?id=gama1236_meli-test-xments)
