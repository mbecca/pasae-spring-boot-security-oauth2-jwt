!["workflow"](workflow.jpg)

# PASAE Spring Boot Security OAuth2 JWT 

Verificamos que no podemos acceder a la URL:

curl localhost:8080/

Nos va a dar un error similar a : {"error":"unauthorized","error_description":"Full authentication is required to access this resource"}

Para obtener un access_token a través del Authorization Server:

curl clientId:clientSecret@localhost:8080/oauth/token -d grant_type=password -d username=mbecca -d password=password

Hay que resguardar el valor del access_token recibido: 

Ahora con el token si podemos acceder a la URL inicial:

curl -H "Authorization: Bearer <access_token_value>" localhost:8080/




Por ejemplo para generar keystore.jks

keytool -genkey -alias mytestkey -keyalg RSA -keystore keystore.jks -storepass mystorepass -dname "CN=WebServerPASAE,OU=Unit,O=Organization,L=City,S=State,C=AR"


