package info.androidhive.floatinglabels;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private EditText firstName, lastName, email, dateOfBirth, password, conformPasword;
    private TextInputLayout firstNameMsg, lastNameMsg, emailMsg, passwordMsg, conformPaswordMsg;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.firstNameTxt);
        firstNameMsg = (TextInputLayout) findViewById(R.id.firstName_msg);
        lastName = (EditText) findViewById(R.id.lastNameTxt);
        lastNameMsg = (TextInputLayout) findViewById(R.id.lastName_msg);
        email = (EditText) findViewById(R.id.emailTxt);
        emailMsg = (TextInputLayout) findViewById(R.id.email_msg);
        password = (EditText) findViewById(R.id.passwordTxt);
        passwordMsg = (TextInputLayout) findViewById(R.id.password_msg);
        conformPasword = (EditText) findViewById(R.id.conformPasswordTxt);
        conformPaswordMsg = (TextInputLayout) findViewById(R.id.conformPassword_msg);

        btnSignUp = (Button) findViewById(R.id.signUpBtn);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { submitForm(); }
        });
    }

    public void dateOfBirth_function(){
        firstName.setText("Date of Birth working");
    }

    private void clearMsg()
    {
        firstNameMsg.setErrorEnabled(false);
        lastNameMsg.setErrorEnabled(false);
        emailMsg.setErrorEnabled(false);
        passwordMsg.setErrorEnabled(false);
        conformPaswordMsg.setErrorEnabled(false);
    }

    private void submitForm()
    {
        clearMsg();
        if (firstName.getText().toString().isEmpty()) {
            firstNameMsg.setError("Please enter first name");
            firstName.requestFocus();
        }
        else if (lastName.getText().toString().isEmpty()) {
            lastNameMsg.setError("Please enter last name");
            lastNameMsg.requestFocus();
        }
        else if (email.getText().toString().isEmpty() || !email.getText().toString().matches(emailPattern) ){
            emailMsg.setError("Please enter valid email address");
            emailMsg.requestFocus();
        }
        else if (password.getText().toString().isEmpty()) {
            passwordMsg.setError("Please enter password");
            passwordMsg.requestFocus();
        }
        else if (!conformPasword.getText().toString().equals(password.getText().toString())) {
            conformPaswordMsg.setError("Password not match");
            conformPaswordMsg.requestFocus();
        }

        else { Toast.makeText(getApplicationContext(), "Sussfully Done", Toast.LENGTH_LONG).show(); }
    }
}
