package com.mdgz.dam.labdam2022;

import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {
    ListPreference medio_pago;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
        medio_pago = findPreference("medios_pago");
        medio_pago.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                medio_pago.setSummary(newValue.toString());
                findPreference("moneda").setEnabled(newValue.toString().equals("Efectivo"));
                return true;
            }
        });
    }
}