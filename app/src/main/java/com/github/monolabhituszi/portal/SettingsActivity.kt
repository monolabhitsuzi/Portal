package com.github.monolabhituszi.portal

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.github.monolabhituszi.portal.databinding.ActivitySettingsBinding
import com.github.monolabhituszi.portal.ui.Theme

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings_container, SettingsFragment())
            .commit()
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        private lateinit var parentContext: Context
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)

            findPreference<ListPreference>("theme")?.setOnPreferenceChangeListener { _, newValue ->
                Theme.applyTheme(parentContext, newValue.toString())
                return@setOnPreferenceChangeListener true
            }
        }

        override fun onAttach(context: Context) {
            parentContext = context
            super.onAttach(context)
        }
    }
}
