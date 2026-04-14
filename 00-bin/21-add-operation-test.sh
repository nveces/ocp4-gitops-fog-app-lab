#!/bin/bash


API_URL=https://fog-route-app-lab.apps.cluster-5h9kv.dynamic.redhatworkshops.io/api/operations

# curl -vk -X POST -H "Content-Type: application/json" \
#      -d '{  "product": "Product A", "amountEur": 100.50,    "userId": "Test01"   }' \
#      ${API_URL}

echo "Load Test: $API_URL"
echo "Press [CTRL+C] to stop."

while true
do
    #
    USER_ID="User_$(shuf -i 1-100 -n 1)"
    AMOUNT=$(echo "scale=2; $RANDOM/100" | bc)
    PRODUCT="Product_$(shuf -e A B C D -n 1)"
    CURRENCY="$(shuf -e EUR USD YEN -n 1)"
    echo "Enviando: $PRODUCT | $AMOUNT EUR | $USER_ID | $CURRENCY"

    # Llamada a la API
    curl  -s -o /dev/null -X POST -H "Content-Type: application/json" \
         -d "{
               \"product\": \"$PRODUCT\",
               \"amountEur\": $AMOUNT,
               \"userId\": \"$USER_ID\",
	           \"currencyId\": \"$CURRENCY\"
             }" \
         "${API_URL}"
    #
    sleep 5
done


exit 0

# EOF
