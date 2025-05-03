package com.smurzik.onboarding.presentation

import android.content.Context

class SharedPrefHelper(context: Context) {

    private val prefs = context.getSharedPreferences("onboarding_prefs", Context.MODE_PRIVATE)

    var isOnboardingShown: Boolean
        get() = prefs.getBoolean("onboarding_shown", false)
        set(value) = prefs.edit().putBoolean("onboarding_shown", value).apply()
}