package by.hometrainng.yourbeer.manager

import android.content.Context

import by.hometrainng.yourbeer.delegate.PrefsDelegate


class SharedPrefsManager(context: Context) {

    private val sharedPrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    var nightMode: by.hometrainng.yourbeer.model.NightMode by enumPref(KEY_MODE, by.hometrainng.yourbeer.model.NightMode.LIGHT)

    private inline fun <reified E : Enum<E>> enumPref(key: String, defaultValue: E) =
        PrefsDelegate(
            sharedPrefs,
            getValue = { getString(key, null)?.let(::enumValueOf) ?: defaultValue },
            setValue = { putString(key, it.name) }
        )

    companion object {
        private const val PREFS_NAME = "prefs"
        private const val KEY_MODE = "mode"
    }
}
