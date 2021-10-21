package com.newtonkarani98gmail.kyoskapp.activities.main.mycart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.newtonkarani98gmail.kyoskapp.databinding.FragmentMyCartBinding;
import com.newtonkarani98gmail.kyoskapp.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {

    private MyCartViewModel myCartViewModel;
    private FragmentMyCartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myCartViewModel =
                new ViewModelProvider(this).get(MyCartViewModel.class);

        binding = FragmentMyCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.cartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        myCartViewModel.getCartItemsMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> itemList) {
                CartAdapter cartAdapter = new CartAdapter(itemList);
                binding.cartRecyclerView.setAdapter(cartAdapter);

                for (int i = 0 ; i<itemList.size(); i++ ){
                    cartAdapter.notifyDataSetChanged();
                }
            }
        });


        myCartViewModel.getCartItems();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}