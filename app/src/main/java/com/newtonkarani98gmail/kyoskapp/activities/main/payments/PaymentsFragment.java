package com.newtonkarani98gmail.kyoskapp.activities.main.payments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newtonkarani98gmail.kyoskapp.R;
import com.newtonkarani98gmail.kyoskapp.databinding.PaymentsFragmentBinding;

public class PaymentsFragment extends Fragment {

    private PaymentsViewModel mViewModel;
    private PaymentsFragmentBinding binding;

    public static PaymentsFragment newInstance() {
        return new PaymentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(PaymentsViewModel.class);
        binding = PaymentsFragmentBinding.inflate(inflater);
        View root = binding.getRoot();


        return root;
    }

}