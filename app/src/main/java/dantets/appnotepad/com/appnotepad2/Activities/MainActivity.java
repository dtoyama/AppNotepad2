package dantets.appnotepad.com.appnotepad2.Activities;



import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.view.ActionMode;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import dantets.appnotepad.com.appnotepad2.Fragments.MainFragment;
import dantets.appnotepad.com.appnotepad2.Fragments.PendientesFragment;
import dantets.appnotepad.com.appnotepad2.Fragments.SuperMercadoFragment;
import dantets.appnotepad.com.appnotepad2.Fragments.VacacionesFragment;
import dantets.appnotepad.com.appnotepad2.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        fab = findViewById(R.id.fab);
        navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);

                drawerLayout.closeDrawers();

                switch (item.getItemId()) {
                    case R.id.principal:
                        setFragment(0);
                        break;
                    case R.id.supermercado:
                        setFragment(1);
                        break;
                    case R.id.pendientes:
                        setFragment(2);
                        break;
                    case R.id.vacaciones:
                        setFragment(3);
                        break;

                }
                return false;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open,R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };


        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        setFragment(0);
    }

    public void setFragment(int pos) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (pos) {
            case 0:
                MainFragment fragment = new MainFragment();
                transaction.replace(R.id.fragment, fragment);
                transaction.commit();
                break;
            case 1:
                SuperMercadoFragment fragmentSuperMercado = new SuperMercadoFragment();
                transaction.replace(R.id.fragment, fragmentSuperMercado);
                transaction.commit();
                break;
            case 2:
                PendientesFragment fragmentPendientes = new PendientesFragment();
                transaction.replace(R.id.fragment, fragmentPendientes);
                transaction.commit();
                break;
            case 3:
                VacacionesFragment fragmentVacaciones = new VacacionesFragment();
                transaction.replace(R.id.fragment, fragmentVacaciones);
                transaction.commit();
                break;
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "FAB", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
