package com.pratham.skills.ui.registration.registrationForms;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pratham.skills.R;
import com.pratham.skills.interfaces.FragmentOnclickListener;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddressDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

@EFragment(R.layout.fragment_address_details)
public class AddressDetailsFragment extends Fragment {
    private FragmentOnclickListener fragmentOnclickListener;

    public AddressDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentOnclickListener = (FragmentOnclickListener) context;
    }

    // TODO: Rename and change types and number of parameters
    public static AddressDetailsFragment_ newInstance() {
        AddressDetailsFragment_ fragment = new AddressDetailsFragment_();
        return fragment;
    }

    @Click(R.id.next)
    public void onNextClick() {
       // fragmentOnclickListener.ShowFragment();
    }
    @Click(R.id.previous)
    public void onPreviousClick() {
         fragmentOnclickListener.ShowFragment(NameDetailsFragment_.newInstance());
    }
    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_address_details, container, false);
    }*/
}
