# Introduction 
Utilize Azure Communications Service to send SMS messages

# Getting Started
1.	Create an Azure Communications Service resource, and obtain connection information
2.	Acquire a sending number from the new resource
3.	If running with gradle, rename the gradle files appropriately and remove/rename pom.
4. Choose connectivity to the resource (key vs connection string) and:
    a. Populate the environment variables as noted in the application.yml
    b. In SmsClientConfig choose the appropriate method and comment appropriately
    c. DefaultCredentialBuilder works only if you maintain Env variables for CLIENT_ID, TENANT_ID and SECRET

# Build and Test
Utilize an http tester (Postman/Curl) to consume the endpoints
