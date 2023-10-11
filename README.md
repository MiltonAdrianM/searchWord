# searchWord

Para realizar la prueba se puede seguir el siguiente ejemplo:

curl --location 'localhost:8080/search-horandvert/' \
--header 'Content-Type: application/json' \
--data '{
"searchword": "abcdefghijklmnopqrstuvwxyzabcdef",
"rows": 4,
"word": "tuv"
}'