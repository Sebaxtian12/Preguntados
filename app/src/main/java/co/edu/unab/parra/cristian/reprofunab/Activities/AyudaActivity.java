package co.edu.unab.parra.cristian.reprofunab.Activities;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.andrognito.flashbar.Flashbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import co.edu.unab.parra.cristian.reprofunab.Adapters.AyudaAdapter;
import co.edu.unab.parra.cristian.reprofunab.Model.AyudaModel;
import co.edu.unab.parra.cristian.reprofunab.R;

import static com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_PUSH_DURATION;
import static com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_RELEASE_DURATION;
import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class AyudaActivity extends AppCompatActivity {
    private Flashbar flashbar = null;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        //FlashBar Implementation
        FloatingActionButton show = findViewById(R.id.show);
        show.setOnClickListener(v -> {
            if (flashbar == null) {
                flashbar = positiveNegativeAction();
            }
            flashbar.show();
        });


        // Set a Toolbar to replace the ActionBar.
        Toolbar appbar = findViewById(R.id.toolbar);
        setSupportActionBar(appbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_flecha);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.ayuda_e_inquietudes));


        expandableListView = findViewById(R.id.expandableListView);
        expandableListDetail = AyudaModel.getData();
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter = new AyudaAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            Toast.makeText(
                    getApplicationContext(),
                    expandableListTitle.get(groupPosition)
                            + " -> "
                            + Objects.requireNonNull(expandableListDetail.get(
                            expandableListTitle.get(groupPosition))).get(
                            childPosition), Toast.LENGTH_SHORT
            ).show();
            return false;
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this,NavigationDrawerActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    private Flashbar positiveNegativeAction() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.BOTTOM)
                .title("Estimado usuario")
                .message(
                        "¿No fue lo suficientemente claro esta sección, tiene alguna sugerencia? No dude en escribirnos pulsando en el botón (SÍ) de este mensaje")
                .backgroundColorRes(R.color.colorPrimaryDark)
                .positiveActionText("Sí")
                .negativeActionText("No, gracias")
                .positiveActionTapListener(bar -> {
                    showFeedbackDialog(AyudaActivity.this);
                    bar.dismiss();
                })
                .negativeActionTapListener(Flashbar::dismiss)
                .positiveActionTextColorRes(R.color.colorPrimary)
                .negativeActionTextColorRes(R.color.colorPrimary)
                .build();
    }


    public static void showFeedbackDialog(Activity activity) {
        final androidx.appcompat.app.AlertDialog alertDialog;
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(activity);
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_feedback, null);
        builder.setView(view);
        final EditText edt_feedback = view.findViewById(R.id.edt_feedback);
        TextView btn_submit = view.findViewById(R.id.btn_submit);
        TextView btn_cancel = view.findViewById(R.id.btn_cancel);
        alertDialog = builder.create();
        Objects.requireNonNull(alertDialog.getWindow()).getAttributes().windowAnimations = R.style.DialogAnimationTheme;
        PushDownAnim.setPushDownAnimTo(btn_submit).setScale(MODE_SCALE, 0.89f).setDurationPush(DEFAULT_PUSH_DURATION).setDurationRelease(DEFAULT_RELEASE_DURATION);
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        alertDialog.show();
        btn_cancel.setOnClickListener(v -> alertDialog.dismiss());
        btn_submit.setOnClickListener(v -> {

            if (!TextUtils.isEmpty(edt_feedback.getText().toString())) {
                alertDialog.dismiss();
                sendFeedback(activity, edt_feedback.getText().toString());
            } else {
                Toast.makeText(activity, "" + activity.getString(R.string.empty_feedback), Toast.LENGTH_SHORT).show();
            }

        });

    }
    public static void sendFeedback(Activity activity, String s) {

        String mailto = "mailto:" + activity.getString(R.string.feedback_mail) +
                "?cc=" + "" +
                "&subject=" + Uri.encode(activity.getString(R.string.app_name)) +
                "&body=" + Uri.encode(s);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));

        try {
            activity.startActivity(emailIntent);
        } catch (ActivityNotFoundException ignored) {
        }


    }
}
