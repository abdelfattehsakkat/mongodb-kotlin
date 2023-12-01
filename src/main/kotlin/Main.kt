
import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.Projections
import com.mongodb.kotlin.client.coroutine.MongoClient
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

// data class Movie(val title: String, val runtime: Int, val imdb: IMDB) {
data class Movie(val title: String, val year: Int, val cast: List<String>) {
}

data class Results(val title: String, val year: Int)

fun main() = runBlocking {
    // Replace the uri string with your MongoDB deployment's connection string
    val uri = "mongodb://localhost:27017/"
    val mongoClient = MongoClient.create(uri)
    val database = mongoClient.getDatabase("mydb")
    val collection = database.getCollection<Movie>("movies")

    val projectionFields= Projections.fields(
        Projections.include(Movie::title.name, Movie::year.name),
        Projections.excludeId()
    )
    val resultsFlow = collection.withDocumentClass<Results>()
        .find(eq(Movie::title.name, "Avatar"))
        .projection(projectionFields)
        .firstOrNull()

    if (resultsFlow == null) {
        println("No results found.");
    } else {
        println(resultsFlow)
    }

    mongoClient.close()
}
