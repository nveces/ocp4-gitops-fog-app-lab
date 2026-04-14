

curl -X POST http://localhost:8080/api/operations \
     -H "Content-Type: application/json" \
     -d '{
       "nombre": "Operación de prueba",
       "valor": 100.50
     }'