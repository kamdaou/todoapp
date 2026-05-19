package td.cadet.todochad.notifications

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

// ==========================================================
// TODO 2 — Créer le Worker pour les rappels
// ==========================================================
//
// WorkManager exécute des tâches en arrière-plan, même si
// l'application est fermée. Parfait pour les rappels !
//
// Créez la classe suivante :
//
//   class RappelWorker(
//       context: Context,
//       params: WorkerParameters
//   ) : Worker(context, params) {
//
//       override fun doWork(): Result {
//           val titre = inputData.getString("titre") ?: "Rappel"
//           val message = inputData.getString("message") ?: "Vous avez une tâche à faire"
//
//           NotificationHelper.showRappelNotification(
//               context = applicationContext,
//               titre = titre,
//               message = message
//           )
//
//           return Result.success()
//       }
//   }
//
// Points importants :
//   - inputData contient les données passées lors de la planification
//   - doWork() tourne sur un thread en arrière-plan (pas le thread UI)
//   - Result.success() indique que le travail est terminé
//
// Imports nécessaires :
//   - androidx.work.Worker
//   - androidx.work.WorkerParameters
// ==========================================================
