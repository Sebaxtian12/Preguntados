package co.edu.unab.parra.cristian.reprofunab.Adapters;

import android.content.Context;
import android.util.AttributeSet;

import androidx.preference.Preference;

import com.mikepenz.aboutlibraries.LibsBuilder;

import co.edu.unab.parra.cristian.reprofunab.R;

public class Opensource extends Preference {

    public Opensource(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onClick() {
        super.onClick();
        openLicenses();
    }

    private void openLicenses() {
        LibsBuilder builder = new LibsBuilder().withFields(R.string.class.getFields());
        builder.setActivityTitle(getContext().getString(R.string.licenses));
        builder.setAboutShowIcon(false);
        builder.setAboutShowVersionName(false);
        builder.setAboutShowVersionCode(false);
        builder.start(getContext());
    }
}