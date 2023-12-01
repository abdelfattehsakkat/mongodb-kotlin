## Movie Database Query

- This Kotlin code is a simple example of querying a MongoDB database using the official MongoDB Kotlin driver. It connects to a MongoDB server, retrieves information about a movie from a collection, and prints the results.
- Source: https://www.mongodb.com/docs/drivers/kotlin/coroutine/current/usage-examples/findOne/

**Prerequisites**

- Ensure that you have the MongoDB server running locally on the default port (27017). Update the uri variable with your MongoDB deployment's connection string if necessary.

**Dependencies**

- Make sure to include the MongoDB Kotlin driver in your project dependencies. You can typically add it to your build.gradle or build.gradle.kts file:

```java

implementation("org.mongodb:mongodb-driver-sync:4.2.3")
implementation("org.mongodb:mongodb-driver-reactivestreams:4.2.3")
implementation("org.mongodb:mongodb-driver-kotlin:1.9.0")
``` 
**Code Explanation**

**1. Data Classes:**
- `Movie`: Represents a movie with properties such as title, year, and cast.
- `Results`: Represents the result of the query with title and year.

**2. MongoDB Connection:**
Connects to a MongoDB server using the MongoDB Kotlin driver.
**3. Query:**

 - Defines a query to find a movie with the title "Avatar" in the "movies" collection.
 - Specifies projection fields to include only the title and year while excluding the document's ID.

**4. Execution:**
 - Runs the query using find and projection.
 - Prints the results if a movie with the title "Avatar" is found; otherwise, it prints a message indicating no results.
**5. Closing Connection:**
 - Closes the MongoDB client connection after the query is executed.

**Running the Code**

1. Update the uri variable with your MongoDB deployment's connection string.
2. Ensure that the MongoDB server is running locally.
3. Execute the code.

Note: Make sure to handle exceptions and error cases appropriately in a production environment.

Feel free to adapt this code to fit your specific use case or extend it for more complex queries.
