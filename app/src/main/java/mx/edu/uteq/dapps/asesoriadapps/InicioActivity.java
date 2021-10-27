package mx.edu.uteq.dapps.asesoriadapps;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import mx.edu.uteq.dapps.asesoriadapps.databinding.ActivityInicioBinding;

public class InicioActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityInicioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInicioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_inicio);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_inicio);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    /*
    Agregamos el método que muestra el menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
        Parametro 1
            layout del menu
        Parametro 2
            instancia del menu
         */
        getMenuInflater().inflate(R.menu.pub_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*
    Agregamos el metodo para cachar el click
    de los elementos del menu
     */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //tomamos el id del item seleccionado
        int id = item.getItemId();

        if (id == R.id.action_panel) {
            startActivity(
                    new Intent(
                            InicioActivity.this,
                            MainActivity.class
                    )
            );
        }

        return super.onOptionsItemSelected(item);
    }
}