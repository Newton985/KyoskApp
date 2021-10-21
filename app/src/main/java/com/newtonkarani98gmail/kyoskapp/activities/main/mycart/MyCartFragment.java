package com.newtonkarani98gmail.kyoskapp.activities.main.mycart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.newtonkarani98gmail.kyoskapp.databinding.FragmentMyCartBinding;

public class MyCartFragment extends Fragment {

    private MyCartViewModel myCartViewModel;
    private FragmentMyCartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myCartViewModel =
                new ViewModelProvider(this).get(MyCartViewModel.class);

        binding = FragmentMyCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}