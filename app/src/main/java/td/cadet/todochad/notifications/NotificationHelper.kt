package td.cadet.todochad.notifications

import android.content.Context

// ==========================================================
// TODO 1 — Créer le helper de notifications
// ==========================================================
//
// Android 8+ (API 26) exige un canal de notification.
// Ce helper centralise la création du canal et l'envoi de notifs.
//
// Créez l'objet suivant :
//
//   object NotificationHelper {
//
//       const val CHANNEL_ID = "todochad_rappels"
//       private const val CHANNEL_NAME = "Rappels de tâches"
//
//       fun createNotificationChannel(context: Context) {
//           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//               val channel = NotificationChannel(
//                   CHANNEL_ID,
//                   CHANNEL_NAME,
//                   NotificationManager.IMPORTANCE_HIGH
//               ).apply {
//                   description = "Notifications de rappel pour les tâches TodoChad"
//               }
//               val manager = context.getSystemService(NotificationManager::class.java)
//               manager.createNotificationChannel(channel)
//           }
//       }
//
//       fun showRappelNotification(context: Context, titre: String, message: String) {
//           val notification = NotificationCompat.Builder(context, CHANNEL_ID)
//               .setSmallIcon(android.R.drawable.ic_dialog_info)
//               .setContentTitle(titre)
//               .setContentText(message)
//               .setPriority(NotificationCompat.PRIORITY_HIGH)
//               .setAutoCancel(true)
//               .build()
//
//           val manager = NotificationManagerCompat.from(context)
//           if (ActivityCompat.checkSelfPermission(context,
//               Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
//               manager.notify(titre.hashCode(), notification)
//           }
//       }
//   }
//
// Imports nécessaires :
//   - android.app.NotificationChannel
//   - android.app.NotificationManager
//   - android.os.Build
//   - android.Manifest
//   - android.content.pm.PackageManager
//   - androidx.core.app.ActivityCompat
//   - androidx.core.app.NotificationCompat
//   - androidx.core.app.NotificationManagerCompat
// ==========================================================
