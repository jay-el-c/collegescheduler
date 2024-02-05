package com.example.collegescheduler;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.newClassButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.menuFragmentToNewClassFragment);
            }
        });

        view.findViewById(R.id.newAssignmentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.menuFragmentToNewAssignmentFragment);
            }
        });

        view.findViewById(R.id.assignmentsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.menuFragmentToAssignmentsFragment);
            }
        });

        view.findViewById(R.id.examsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.menuFragmentToExamsFragment);
            }
        });

        view.findViewById(R.id.newExamButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.newExamFragment);
            }
        });

        view.findViewById(R.id.toDosButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.toDosFragment);
            }
        });

    }
}