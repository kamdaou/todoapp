package td.cadet.todochad.data.remote

// ==========================================================
// TODO 3 — Créer le singleton Retrofit
// ==========================================================
//
// Retrofit a besoin d'être configuré une seule fois avec :
//   - L'URL de base de l'API
//   - Un convertisseur JSON (kotlinx.serialization)
//
// Créez un objet singleton :
//
//   object RetrofitInstance {
//
//       private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
//
//       private val json = Json { ignoreUnknownKeys = true }
//
//       val api: TodoApi by lazy {
//           Retrofit.Builder()
//               .baseUrl(BASE_URL)
//               .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
//               .build()
//               .create(TodoApi::class.java)
//       }
//   }
//
// Points importants :
//   - ignoreUnknownKeys = true : ignore les champs JSON
//     qu'on n'a pas dans notre DTO
//   - by lazy : crée l'instance une seule fois, au premier accès
//   - asConverterFactory : pont entre kotlinx.serialization et Retrofit
//
// Imports nécessaires :
//   - kotlinx.serialization.json.Json
//   - okhttp3.MediaType.Companion.toMediaType
//   - retrofit2.Retrofit
//   - retrofit2.converter.kotlinx.serialization.asConverterFactory
// ==========================================================
