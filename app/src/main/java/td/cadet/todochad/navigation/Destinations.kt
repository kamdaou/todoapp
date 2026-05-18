package td.cadet.todochad.navigation

import kotlinx.serialization.Serializable

// ==========================================================
// TODO 1 — Définir les destinations de navigation
// ==========================================================
//
// Avec Navigation Compose (type-safe), chaque destination est
// un objet ou une data class annotée @Serializable.
//
// Créez les destinations suivantes :
//
//   @Serializable
//   object ListTaches          // écran principal (pas de paramètres)
//
//   @Serializable
//   data class DetailTache(val id: Int)  // écran détail (reçoit l'id)
//
//   @Serializable
//   object AjouterTache        // écran d'ajout
//
//   @Serializable
//   object Parametres          // écran paramètres
//
// Ces classes servent de "routes" type-safe pour la navigation.
// Elles remplacent les anciennes routes basées sur des String.
// ==========================================================
