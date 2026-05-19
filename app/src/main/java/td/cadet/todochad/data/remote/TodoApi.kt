package td.cadet.todochad.data.remote

// ==========================================================
// TODO 1 — Définir l'interface Retrofit pour l'API
// ==========================================================
//
// Retrofit transforme une interface Kotlin en client HTTP.
// Chaque méthode correspond à un appel réseau.
//
// L'API utilisée : https://jsonplaceholder.typicode.com/todos
// Elle retourne une liste de tâches au format JSON :
//   { "userId": 1, "id": 1, "title": "...", "completed": false }
//
// Créez l'interface suivante :
//
//   interface TodoApi {
//
//       @GET("todos")
//       suspend fun getTodos(): List<TodoDto>
//
//       @GET("todos/{id}")
//       suspend fun getTodoById(@Path("id") id: Int): TodoDto
//   }
//
// Annotations :
//   - @GET("todos") : requête GET sur /todos
//   - @Path("id") : remplace {id} dans l'URL
//   - suspend : appel asynchrone via coroutines
//
// Imports nécessaires :
//   - retrofit2.http.GET
//   - retrofit2.http.Path
// ==========================================================
