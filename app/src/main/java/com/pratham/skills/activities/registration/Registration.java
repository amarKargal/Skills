package com.pratham.skills.activities.registration;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.pratham.skills.R;
import com.pratham.skills.databinding.ActivityRegistrationBinding;
import com.pratham.skills.modal.User;
import com.pratham.skills.utils.Validations;

public class Registration extends AppCompatActivity {
    private RegistrationViewModel registrationViewModel;
    ActivityRegistrationBinding activityRegistrationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegistrationBinding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        registrationViewModel = ViewModelProviders.of(this).get(RegistrationViewModel.class);
        User user = registrationViewModel.getUser();
        activityRegistrationBinding.setUser(user);


        activityRegistrationBinding.submit.setOnClickListener(v -> {
            boolean flag = true;
            if (Validations.checkIsEmpty(user.getFirstName())) {
                flag = false;
                activityRegistrationBinding.etFirstName.setError(getString(R.string.error_msg));
            } else {
                activityRegistrationBinding.etFirstName.setError(null);
            }
            if (Validations.checkIsEmpty(user.getLastName())) {
                flag = false;
                activityRegistrationBinding.etLastName.setError(getString(R.string.error_msg));
            } else {
                activityRegistrationBinding.etLastName.setError(null);
            }
            if (Validations.checkIsEmpty(user.getAddress())) {
                flag = false;
                activityRegistrationBinding.etAddress.setError(getString(R.string.error_msg));
            } else {
                activityRegistrationBinding.etAddress.setError(null);
            }
            if (Validations.checkIsEmpty(user.getState())) {
                flag = false;
                activityRegistrationBinding.etState.setError(getString(R.string.error_msg));
            } else {
                activityRegistrationBinding.etState.setError(null);
            }
            if (Validations.checkIsEmpty(user.getPin_code())) {
                flag = false;
                activityRegistrationBinding.etPinCode.setError(getString(R.string.error_msg));
            } else {
                activityRegistrationBinding.etPinCode.setError(null);
            }
            if (flag) {
                registrationViewModel.onRegistered();
            }
        });


    }

}
