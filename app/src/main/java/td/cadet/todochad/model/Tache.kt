package td.cadet.todochad.model

data class Tache(
    val id: Int,
    val titre: String,
    val description: String = "",
    val terminee: Boolean = false
)
