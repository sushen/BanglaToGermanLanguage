package blog.video.biswas.banglatogermanlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    public static final int RC_SIGN_IN = 1;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();

        startActivityForResult(
                // Get an instance of AuthUI based on the default app
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.EmailBuilder().build(),
                                new AuthUI.IdpConfig.PhoneBuilder().build(),
                                new AuthUI.IdpConfig.GoogleBuilder().build()
                        ))
                        .setIsSmartLockEnabled(!BuildConfig.DEBUG /* credentials */, true /* hints */)
                        .build(),
                RC_SIGN_IN);

        button = findViewById(R.id.goToYoutube);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Youtube.class);
                startActivity(intent);
            }
        });
    }

}