package com.pratham.skills.utils;

import android.text.TextUtils;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;

public class Validations {

    /*@BindingAdapter("checkNotEmpty")
    public static void passwordValidator(EditText editText, String password) {
        // ignore infinite loops
        int minimumLength = 5;
        if (TextUtils.isEmpty(password)) {
            editText.setError(null);
            return;
        }
        if (editText.getText().toString().length() < minimumLength) {
            editText.setError("Password must be minimum " + minimumLength + " length");
        } else editText.setError(null);
    }*/

    public static boolean checkIsEmpty(String str){
        if(str==null||str.isEmpty()){
            return true;
        }
        return false;
    }
}
