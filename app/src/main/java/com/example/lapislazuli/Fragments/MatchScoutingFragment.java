package com.example.lapislazuli.Fragments;

import static com.example.lapislazuli.databinding.FragmentMatchScoutingBinding.inflate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lapislazuli.R;
import com.example.lapislazuli.databinding.FragmentMatchScoutingBinding;

public class MatchScoutingFragment extends Fragment {

    private FragmentMatchScoutingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstance){

        binding = FragmentMatchScoutingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Button submit = root.findViewById(R.id.bt_submitMatch);

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_match_scouting_start);
            }
        });

        return root;
    }


}
