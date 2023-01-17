package com.example.lapislazuli.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lapislazuli.MainActivity;
import com.example.lapislazuli.R;
import com.example.lapislazuli.databinding.FragmentMatchScoutingStartBinding;


public class MatchScoutingStartFragment extends Fragment {

    private Spinner robotSpinner;

    private FragmentMatchScoutingStartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        binding = FragmentMatchScoutingStartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setUpSpinner();

        Button scout = root.findViewById(R.id.bt_startScout);

        scout.setOnClickListener(new View.OnClickListener(){

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

        robotSpinner = root.findViewById(R.id.robot_spinner);

        ArrayAdapter<CharSequence> robotAdapter = ArrayAdapter.createFromResource(root.getContext(),R.array.robotNumber,android.R.layout.simple_spinner_item);
        robotAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        robotSpinner.setAdapter(robotAdapter);

        robotSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choice = parent.getItemAtPosition(position).toString();
                Toast.makeText(binding.getRoot().getContext(), choice,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
