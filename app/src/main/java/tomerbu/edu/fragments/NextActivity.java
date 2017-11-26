package tomerbu.edu.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class NextActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.container,
                        new MovieFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.navigation_webView:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.container,
                                new WebViewFragment()).commit();
                break;
            case R.id.nav_movie:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.container,
                                new MovieFragment()).commit();
                break;
        }
        //return true if you handle the event
        return true;
        //return false if we choose to ignore the event.
    }
}
