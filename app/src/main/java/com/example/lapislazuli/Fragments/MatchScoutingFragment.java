package com.example.lapislazuli.Fragments;

import static com.example.lapislazuli.databinding.FragmentMatchScoutingBinding.inflate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lapislazuli.R;
import com.example.lapislazuli.databinding.FragmentMatchScoutingBinding;


public class MatchScoutingFragment extends Fragment {

    private Spinner robotSpinner;
    private FragmentMatchScoutingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstance){

        binding = FragmentMatchScoutingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setUpSpinner();


        Button submit = root.findViewById(R.id.bt_submitMatch);

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_match_scouting);
            }
        });

        return root;
    }

    public void setUpSpinner(){
        View root = binding.getRoot();

        robotSpinner = root.findViewById(R.id.robotSpinner);

        ArrayAdapter<CharSequence> robotAdapter = ArrayAdapter.createFromResource(root.getContext(), R.array.robotNumber, android.R.layout.simple_spinner_item);

        robotAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        robotSpinner.setAdapter(robotAdapter);

        robotSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choice = parent.getItemAtPosition(position).toString();
                Toast.makeText(binding.getRoot().getContext(),choice,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
