package co.edu.unab.parra.cristian.reprofunab.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;


import co.edu.unab.parra.cristian.reprofunab.Fragments.ConfigFragment;
import co.edu.unab.parra.cristian.reprofunab.Fragments.PreExamenFragment;
import co.edu.unab.parra.cristian.reprofunab.R;


public class ConfiguracionActivity extends AppCompatActivity implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //display settings fragment as main content of activity
        //supportFragmentManager - class extends AppCompatActivity
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new ConfigFragment())
                .commit();
    }


    /**
     * Determines if the device has an extra-large screen. For example, 10"
     * tablets are extra-large.
     */

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    protected boolean isValidFragment(String fragmentName) {
        return PreferenceFragment.class.getName().equals(fragmentName)
                || ConfigFragment
                .class.getName().equals(fragmentName)
                || PreExamenFragment
                .class.getName().equals(fragmentName);
    }

    @Override
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat caller, Preference pref) {
        // Instantiate the new Fragment
        final Bundle args = pref.getExtras();
        final Fragment fragment = getSupportFragmentManager().getFragmentFactory().instantiate(
                getClassLoader(),
                pref.getFragment());
        fragment.setArguments(args);
        fragment.setTargetFragment(caller, 0);
        // Replace the existing Fragment with the new Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .addToBackStack(null)
                .commit();
        return true;
    }
}

/**
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("lbopensource")) {
            new MaterialAlertDialogBuilder(this)
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
        }
        if (key.equals("shareapp")){
            Intent sharingIntent1 = new Intent(Intent.ACTION_SEND);
            sharingIntent1.setType("text/plain");
            sharingIntent1.putExtra(Intent.EXTRA_SUBJECT, this.getString(R.string.app_name));
            sharingIntent1.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + this.getPackageName() + System.getProperty("line.separator"));
            this.startActivity(Intent.createChooser(sharingIntent1, "Compartir via"));
        }
    }
    */
