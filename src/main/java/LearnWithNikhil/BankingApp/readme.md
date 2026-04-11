{
"firstName":"nikhil",
"lastName" :"pal",
"email": "nik@gmail.com",
"phone": "5194988971",
"address" :"220 sunny meadow crt",
"externalId": "nik"
}

# MAPPER PURPOSE [ WORKS BOTH DIRECTION  ]

1. ENTITY TO DTO [OUTGOING ]
This is commonly used when returning data from a database to a client, 
allowing for filtering sensitive fields (e.g., hiding password fields)
2. DTO TO ENTITY [INCOMING ]
The mapper takes data from a DTO (e.g., from a JSON request body) and updates a new or existing Entity. 
This is used for creating or updating records in the database



# THE SOLE PURPOSE OF UTILITY CLASS 
Its primary purpose is to promote code reusability, maintainability, 
and organization by preventing the duplication of generic logic across different parts of the application

# IDEMPOTENCY 
ensures that an operation produces the same result and no unintended side effects, no matter how many times it is executed.



# 1 iteration = just watch videos 
# 2 iteration = start coding 



https://github.com/BankStack09 