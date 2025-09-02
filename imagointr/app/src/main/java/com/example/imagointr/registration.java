package com.example.imagointr;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class registration extends AppCompatActivity {

    private EditText editTextRegisterName,editTextRegisterEmail,editTextRegisterMobile,editTextRegisterDOB,editTextRegisterPwd,editTextRegisterConfirmPwd;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;
    private ImageButton calendarBtn;
    private ProgressBar progressBar;
    public DatePicker set_Date;
    private static final String TAG = "registration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        //getSupportActionBar().setTitle("Register");
        Toast.makeText(registration.this,"You can register now",Toast.LENGTH_LONG).show();
        editTextRegisterName = findViewById(R.id.editText_FullName);
        editTextRegisterEmail = findViewById(R.id.editText_Email);
        editTextRegisterMobile = findViewById(R.id.editText_MobileNumber);
        editTextRegisterDOB = findViewById(R.id.editText_DOB);
        editTextRegisterPwd = findViewById(R.id.editText_Password);
        editTextRegisterConfirmPwd = findViewById(R.id.editText_ConfirmPassword);
        progressBar = findViewById(R.id.progressBar);

        //RadioButton for Gender
        radioGroupRegisterGender = findViewById(R.id.register_GenderRadioGroup);
        radioGroupRegisterGender.clearCheck();

        Button registerBtn = findViewById(R.id.register_SubmitBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
                radioButtonRegisterGenderSelected = findViewById(selectedGenderId);
                String full_Name, email, mobile_Number, dob, password, confirm_Password, gender;
                full_Name = String.valueOf(editTextRegisterName.getText());
                email = String.valueOf(editTextRegisterEmail.getText());
                mobile_Number = String.valueOf(editTextRegisterMobile.getText());
                dob = String.valueOf(editTextRegisterDOB.getText());
                password = String.valueOf(editTextRegisterPwd.getText());
                confirm_Password = String.valueOf(editTextRegisterConfirmPwd.getText());

                if (TextUtils.isEmpty(full_Name)){
                    Toast.makeText(registration.this,"Please enter your name",Toast.LENGTH_LONG).show();;
                    editTextRegisterName.setError("full name is required");
                    editTextRegisterName.requestFocus();
                } else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(registration.this,"Please enter your email",Toast.LENGTH_LONG).show();;
                    editTextRegisterEmail.setError("email is required");
                    editTextRegisterEmail.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(registration.this,"Please re-enter your email",Toast.LENGTH_LONG).show();;
                    editTextRegisterEmail.setError("valid email is required");
                    editTextRegisterEmail.requestFocus();
                } else if (TextUtils.isEmpty(mobile_Number)) {
                    Toast.makeText(registration.this,"Please enter your mobile number",Toast.LENGTH_LONG).show();;
                    editTextRegisterMobile.setError("mobile number is required");
                    editTextRegisterMobile.requestFocus();
                } else if (TextUtils.isEmpty(dob)) {
                    Toast.makeText(registration.this,"Please enter your date of birth",Toast.LENGTH_LONG).show();
                    editTextRegisterDOB.setError("date of birth is required");
                    editTextRegisterDOB.requestFocus();
                } else if (radioGroupRegisterGender.getCheckedRadioButtonId()==-1) {
                    Toast.makeText(registration.this,"Please select your gender",Toast.LENGTH_LONG).show();
                    radioButtonRegisterGenderSelected.setError("Gender is required");
                    radioButtonRegisterGenderSelected.requestFocus();
                } else if (TextUtils.isEmpty(mobile_Number)) {
                    Toast.makeText(registration.this,"Please enter your mobile number",Toast.LENGTH_LONG).show();;
                    editTextRegisterMobile.setError("Mobile is required");
                    editTextRegisterMobile.requestFocus();
                } else if (mobile_Number.length() != 10) {
                    Toast.makeText(registration.this,"Please re-enter mobile number",Toast.LENGTH_LONG).show();;
                    editTextRegisterMobile.setError("Valid mobile number is required");
                    editTextRegisterMobile.requestFocus();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(registration.this,"Please enter your password",Toast.LENGTH_LONG).show();;
                    editTextRegisterPwd.setError("Password is required");
                    editTextRegisterPwd.requestFocus();
                } else if (password.length() < 6) {
                    Toast.makeText(registration.this,"Password should be at least 6 character long",Toast.LENGTH_LONG).show();;
                    editTextRegisterPwd.setError("Password too weak");
                    editTextRegisterPwd.requestFocus();
                } else if (TextUtils.isEmpty(confirm_Password)) {
                    Toast.makeText(registration.this,"Please confirm your password",Toast.LENGTH_LONG).show();;
                    editTextRegisterConfirmPwd.setError("Password confirmation is required");
                    editTextRegisterConfirmPwd.requestFocus();
                } else if (!password.equals(confirm_Password)) {
                    Toast.makeText(registration.this,"please enter samer password",Toast.LENGTH_LONG).show();;
                    editTextRegisterConfirmPwd.setError("Password doesn't match");
                    editTextRegisterConfirmPwd.requestFocus();
                    editTextRegisterPwd.clearComposingText();
                    editTextRegisterConfirmPwd.clearComposingText();
                }
                else {
                    gender = radioButtonRegisterGenderSelected.getText().toString();
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}