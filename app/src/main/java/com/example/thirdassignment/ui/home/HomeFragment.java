package com.example.thirdassignment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thirdassignment.R;
import com.example.thirdassignment.ui.student.StudentFragment;

public class HomeFragment extends Fragment {

    RecyclerView studentsview;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        studentsview = root.findViewById(R.id.recycle);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {


                StudentAdapter adapter = new StudentAdapter(StudentFragment.details);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                studentsview.setLayoutManager(layoutManager);
                studentsview.setAdapter(adapter);
            }
        });
        return root;
    }
}