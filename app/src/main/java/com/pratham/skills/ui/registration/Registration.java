package com.pratham.skills.ui.registration;

import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.pratham.skills.R;
import com.pratham.skills.interfaces.FragmentOnclickListener;
import com.pratham.skills.ui.registration.registrationForms.NameDetailsFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.WindowFeature;

@Fullscreen
@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_registration)
public class Registration extends AppCompatActivity implements FragmentOnclickListener {

    @AfterViews
    public void init() {
        ShowFragment(NameDetailsFragment_.newInstance());
    }

    @Override
    public void ShowFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
        transaction.add(R.id.registration, fragment);
        transaction.addToBackStack(transaction.getClass().getName());
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

