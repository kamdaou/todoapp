package td.cadet.todochad.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface TodoApi {

    @GET("todos")
    suspend fun getTodos(): List<TodoDto>

    @GET("todos/{id}")
    suspend fun getTodoById(@Path("id") id: Int): TodoDto
}
