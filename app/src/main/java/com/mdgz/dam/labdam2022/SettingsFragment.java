package com.mdgz.dam.labdam2022;

import android.os.Bundle;

import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.CheckBoxPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SettingsFragment extends PreferenceFragmentCompat {
    ListPreference medio_pago;
    CheckBoxPreference guardar_informacion;
    Preference button_log;

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

        button_log = findPreference("button_log");
        guardar_informacion = findPreference("informacion");
        guardar_informacion.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                button_log.setEnabled((Boolean)newValue);
                if(!(Boolean)newValue){
                    borrarArchivo();
                }
                return true;
            }
        });

        button_log.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                NavHostFragment.findNavController(SettingsFragment.this).navigate(R.id.action_settingsFragment_to_vistaArchivoFragment);
                return true;
            }
        });

    }

    private void borrarArchivo() {
        new File(getContext().getFilesDir(), "RegistroBusquedas.txt").delete();
    }

}