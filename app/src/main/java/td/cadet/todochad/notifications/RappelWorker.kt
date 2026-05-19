package td.cadet.todochad.notifications

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RappelWorker(
    context: Context,
    params: WorkerParameters
) : Worker(context, params) {

    override fun doWork(): Result {
        val titre = inputData.getString("titre") ?: "Rappel"
        val message = inputData.getString("message") ?: "Vous avez une tâche à faire"

        NotificationHelper.showRappelNotification(
            context = applicationContext,
            titre = titre,
            message = message
        )

        return Result.success()
    }
}
