package com.pratham.skills.modal;

import android.text.TextUtils;
import android.widget.EditText;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User extends BaseObservable {
   @PrimaryKey(autoGenerate = true)
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String pin_code;

    public User() {
    }

    public User(String firstName, String lastName, String address, String state, String pin_code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.pin_code = pin_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        //notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Bindable
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Bindable
    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", pin_code='" + pin_code + '\'' +
                '}';
    }

}
