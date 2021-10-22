package com.newtonkarani98gmail.kyoskapp.activities.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.newtonkarani98gmail.kyoskapp.R;
import com.newtonkarani98gmail.kyoskapp.databinding.FragmentHomeBinding;
import com.newtonkarani98gmail.kyoskapp.models.CategoriesResponse;
import com.newtonkarani98gmail.kyoskapp.models.Category;
import com.newtonkarani98gmail.kyoskapp.models.Item;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    List<Category> categories = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


       //Features Images
       binding.featuresRecyclerView.setItemAnimator(new DefaultItemAnimator());
       binding.featuresRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

       FeaturesAdapter featuresAdapter = new FeaturesAdapter(homeViewModel.getFeatureImages());
       binding.featuresRecyclerView.setAdapter(featuresAdapter);

       for (int i = 0; i< homeViewModel.getFeatureImages().size(); i++){ featuresAdapter.notifyDataSetChanged(); }

        homeViewModel.getActiveCategory().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

                for (int i = 0; i < categories.size(); i++){
                    View view= binding.horizontalLinear.getChildAt(i);
                    TextView textView = view.findViewById(R.id.categoryText);
                    textView.setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, null));
                    textView.setBackgroundResource(R.drawable.round_inactive);
                }


                View view= binding.horizontalLinear.getChildAt(integer);
                TextView textView = view.findViewById(R.id.categoryText);
                textView.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white, null));
                textView.setBackgroundResource(R.drawable.round_active);

            }
        });


       homeViewModel.getCategoriesResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<CategoriesResponse>() {
           @Override
           public void onChanged(CategoriesResponse categoriesResponse) {
               //Now get Items
               Category c = new Category();
               c.setDescription("All");
               c.setCode("ALL");

               categories.add(c);

               categories.addAll(categoriesResponse.getCategories());
               homeViewModel.getItems();

               for (int i = 0 ; i< categories.size(); i++){
                   View view= LayoutInflater.from(getContext()).inflate(R.layout.category_item, null);
                   TextView textView = view.findViewById(R.id.categoryText);
                   textView.setText(categories.get(i).getDescription());

                   if (i == 0 ){
                       textView.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white, null));
                       textView.setBackgroundResource(R.drawable.round_active);
                   }

                   int finalI = i;
                   textView.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           homeViewModel.getActiveCategory().setValue(finalI);
                       }
                   });

                   binding.horizontalLinear.addView(view);
               }



           }
       });

       homeViewModel.getItemsMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
           @Override
           public void onChanged(List<Item> itemList) {

               binding.categoriesOverViewRecyclerView.setItemAnimator(new DefaultItemAnimator());
               binding.categoriesOverViewRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

               CategoriesOverviewAdapter categoriesOverviewAdapter = new CategoriesOverviewAdapter(homeViewModel.getCategoriesResponseMutableLiveData().getValue().getCategories(), homeViewModel);
               binding.categoriesOverViewRecyclerView.setAdapter(categoriesOverviewAdapter);

               for (int i =0; i< homeViewModel.getCategoriesResponseMutableLiveData().getValue().getCategories().size() ; i++){ categoriesOverviewAdapter.notifyDataSetChanged(); }


           }
       });




       //get Categories
        homeViewModel.getCategories();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}