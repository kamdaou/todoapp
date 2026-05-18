package td.cadet.todochad.navigation

import kotlinx.serialization.Serializable

@Serializable
object ListTaches

@Serializable
data class DetailTache(val id: Int)

@Serializable
object AjouterTache

@Serializable
object Parametres
