package com.pratham.skills.ui.registration.registrationForms;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pratham.skills.R;
import com.pratham.skills.interfaces.FragmentOnclickListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_name_details)
public class NameDetailsFragment extends Fragment {
    private FragmentOnclickListener fragmentOnclickListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentOnclickListener = (FragmentOnclickListener) context;
    }

    public NameDetailsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static NameDetailsFragment_ newInstance() {
        NameDetailsFragment_ fragment = new NameDetailsFragment_();
        //  Bundle args = new Bundle();
        //  fragment.setArguments(args);
        return fragment;
    }

    @AfterViews
    public void init() {

    }

    @Click(R.id.next)
    public void onNextClick() {
        fragmentOnclickListener.ShowFragment(AddressDetailsFragment.newInstance());
    }


}
