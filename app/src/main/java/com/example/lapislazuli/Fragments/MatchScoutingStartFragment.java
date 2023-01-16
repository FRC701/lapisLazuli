package com.example.lapislazuli.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lapislazuli.MainActivity;
import com.example.lapislazuli.R;

import com.example.lapislazuli.databinding.MatchScoutingStartBinding;
public class MatchScoutingStartFragment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public Button button;

    private MatchScoutingStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_match_scouting_start);

        Spinner roboNum = findViewById(R.id.robot_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.robotNumber, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roboNum.setAdapter(adapter);
        roboNum.setOnItemSelectedListener(this);

        button = (Button) findViewById(R.id.bt_startScout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchScoutingStartFragment.this, MatchScoutingFragment.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
