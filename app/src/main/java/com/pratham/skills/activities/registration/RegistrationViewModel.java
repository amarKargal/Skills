package com.pratham.skills.activities.registration;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.pratham.skills.database.AppDatabase;
import com.pratham.skills.database.BackupDatabase;
import com.pratham.skills.modal.User;

public class RegistrationViewModel extends AndroidViewModel {
    User user = new User();



    public RegistrationViewModel(@NonNull Application application) {
        super(application);
    }

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void onRegistered() {
        AppDatabase.getDatabaseInstance(getApplication()).getUserDoa().insert(user);
        BackupDatabase.backup(getApplication());
    }

        /*   public MutableLiveData<String> firstName = new MutableLiveData<>();
    public MutableLiveData<String> lastName = new MutableLiveData<>();
    public MutableLiveData<String> address = new MutableLiveData<>();
    public MutableLiveData<String> state = new MutableLiveData<>();
    public MutableLiveData<String> pin_code = new MutableLiveData<>();

    private MutableLiveData<User> userMutableLiveData;

    public MutableLiveData<User> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onClick(View view) {
        User loginUser = new User(firstName.getValue(),lastName.getValue(),address.getValue(),state.getValue(),pin_code.getValue());
        userMutableLiveData.setValue(loginUser);
    }*/
}
