package com.phuoc.loginwithmvvmdatabindinglivedata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.phuoc.loginwithmvvmdatabindinglivedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLoginViewModel(loginViewModel);
        binding.setLifecycleOwner(this);

        loginViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user.getEmail().length() > 0 && user.getPassword().length() > 0)
                    Toast.makeText(getApplicationContext(), "email : " + user.getEmail() + " password " + user.getPassword(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}