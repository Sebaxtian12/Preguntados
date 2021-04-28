package co.edu.unab.parra.cristian.reprofunab.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import org.jetbrains.annotations.NotNull;

import co.edu.unab.parra.cristian.reprofunab.Activities.ConfiguracionActivity;
import co.edu.unab.parra.cristian.reprofunab.BuildConfig;
import co.edu.unab.parra.cristian.reprofunab.R;

public class ConfigFragment extends PreferenceFragmentCompat {
    private static final String KEY_APP_VERSION = "pref_app_version";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.configuraciones, rootKey);
        findPreference(KEY_APP_VERSION).setSummary(BuildConfig.VERSION_NAME);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = super.onCreateView(inflater, container, savedInstanceState);
        //read settings value from shared preferences
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(requireContext().getApplicationContext());
        //get boolean of dark mode switch preference
        return view;
    }
}

/**
        boolean switchPref = sharedPreferences
                .getBoolean(ConfiguracionActivity.KEY_PREF_THEME_SWITCH, false);
        if(switchPref){
            //dark mode enabled
            Log.d("DARK MODE SETTING:", "DARK MODE ENABLED");
            //enable dark mode method, pass decorView of activity
            assert view != null;
            enableDarkMode(view);

        }
        return view;
**/


/**
    private void enableDarkMode(View decorView) {
        //set background color
        decorView.setBackgroundColor(requireContext().getApplicationContext()
        .getColor(R.color.darkModeBackground));
        }

        }


                        new MaterialAlertDialogBuilder(getActivity())
                                .setTitle("Title")
                                .setMessage("Your message goes here. Keep it short but clear.")
                                .setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                })
                                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                })
                                .show();
                         */
