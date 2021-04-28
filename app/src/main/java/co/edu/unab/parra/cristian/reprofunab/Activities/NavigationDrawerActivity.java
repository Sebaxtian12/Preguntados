package co.edu.unab.parra.cristian.reprofunab.Activities;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import com.google.android.material.navigation.NavigationView;
import com.thekhaeng.pushdownanim.PushDownAnim;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import co.edu.unab.parra.cristian.reprofunab.R;

import static com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_PUSH_DURATION;
import static com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_RELEASE_DURATION;
import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;


public class NavigationDrawerActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        //get boolean of dark mode switch preference
        // Set a Toolbar to replace the ActionBar.
        Toolbar appbar = findViewById(R.id.toolbar);
        setSupportActionBar(appbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.inicio, R.id.categoria, R.id.examen, R.id.ayuda, R.id.configuracion, R.id.acerca)
                .setOpenableLayout(drawerLayout) //Has change because .setDrawerLayout is deprecated
                .build();
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        final NavController navCo = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navCo, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navView, navCo);

        //Assign the navigation menu options

        //Import the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ///Drawerarrow animation
        ActionBarDrawerToggle myToogle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(myToogle);
        myToogle.syncState();


        //Adding navigation item selected listener for add activities elements and alert dialog
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NotNull MenuItem item) {
                boolean handled = NavigationUI.onNavDestinationSelected(item, navCo);


                if (!handled) {
                    switch (item.getItemId()) {
                        case R.id.ayuda:
                            Log.i("NavigationView", "Pulsada opción 1");
                            Intent intent = new Intent(NavigationDrawerActivity.this, AyudaActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.calificanos:
                            final AlertDialog alert_dialog;
                            AlertDialog.Builder builder = new AlertDialog.Builder(NavigationDrawerActivity.this);
                            View view = LayoutInflater.from(NavigationDrawerActivity.this).inflate(R.layout.dialog_rating, null);
                            builder.setView(view);
                            final RatingBar rating_bar = view.findViewById(R.id.rating_bar);
                            TextView btn_submit = view.findViewById(R.id.btn_submit);
                            TextView tv_no = view.findViewById(R.id.tv_no);
                            PushDownAnim.setPushDownAnimTo(btn_submit).setScale(MODE_SCALE, 0.89f).setDurationPush(DEFAULT_PUSH_DURATION).setDurationRelease(DEFAULT_RELEASE_DURATION);
                            PushDownAnim.setPushDownAnimTo(tv_no).setScale(MODE_SCALE, 0.89f).setDurationPush(DEFAULT_PUSH_DURATION).setDurationRelease(DEFAULT_RELEASE_DURATION);
                            alert_dialog = builder.create();
                            alert_dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                            alert_dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationTheme;
                            alert_dialog.show();

                            btn_submit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (rating_bar.getRating() >= 3) {
                                        try {
                                            NavigationDrawerActivity.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + NavigationDrawerActivity.this.getPackageName())));

                                        } catch (ActivityNotFoundException anfe) {
                                            NavigationDrawerActivity.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + NavigationDrawerActivity.this.getPackageName())));
                                        }
                                        alert_dialog.dismiss();
                                    } else if (rating_bar.getRating() <= 0) {
                                        Toast.makeText(NavigationDrawerActivity.this, "" + NavigationDrawerActivity.this.getString(R.string.rating_error), Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            tv_no.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    alert_dialog.dismiss();
                                }
                            });
                            break;
                        default:
                            throw new IllegalArgumentException("menu option not implemented!!");
                    }
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return handled;
            }
        });

        /*
        //Eventos del Drawer Layout
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }
            @Override
            public void onDrawerOpened(View drawerView) {
            }
            @Override
            public void onDrawerClosed(View drawerView) {
            }
            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
        */
/**
        /// Save the default values in shared preferences
        PreferenceManager.setDefaultValues(this, R.xml.configuraciones, false);

        // Pickup Shared preferences
        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        Boolean switchPref = sharedPref.getBoolean
                (ConfiguracionActivity.KEY_PREF_THEME_SWITCH, false);
        Toast.makeText(this, switchPref.toString(),
                Toast.LENGTH_SHORT).show();
*/
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
/**
//Add menu option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }
**/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}



