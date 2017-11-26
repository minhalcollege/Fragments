package tomerbu.edu.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnMovie, btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //No more casting with findViewByID!:-)
        btnMovie = findViewById(R.id.btnMovie);
        btnTime = findViewById(R.id.btnTime);

        //Android studio 3: Lambdas!
        btnMovie.setOnClickListener(v -> {
            //1) get a reference to the Fragment Manager:
            //Job: add remove replace find fragments.
            FragmentManager fm = getSupportFragmentManager();
            //Supports fragments on older devices...
            //1.5)  init the Movie Fragment:
            MovieFragment movieFragment = new MovieFragment();
            //2) replace the container with MovieFragment
            //2.5) The Fragment Manager performs transactions...
            //3) don't forget to commit...
            fm.beginTransaction().
                    replace(R.id.container, movieFragment).
                    commit();
        });
        btnTime.setOnClickListener(v -> {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.container, new WebViewFragment()).
                    commit();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
