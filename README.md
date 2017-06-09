To run this application:
1. Setup environment with Grails 3.2.9 and Java 8
2. Create the following Postgres databases:
    * humans
    * dogs
    * g3_base
3. Open grails-app/conf/application.yml and update dbUsername and dbPassword
4. Run the application
5. Check the tables in each database.  You will see that the human, dog, and mammal tables appear in all three databases.
