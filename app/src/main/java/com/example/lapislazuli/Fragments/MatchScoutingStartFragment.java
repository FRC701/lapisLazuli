package com.example.lapislazuli.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
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
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MatchScoutingStartFragment extends Fragment {

    Button scout;
    MatchSavingClass matchSavingClass;
    TextInputLayout numOnUpperMAuto, numOnMidMAuto, numOnBottomRowMAuto, numOfLinksMAutos,
            numOnUpperMTele, numOnMidMTele, numOnBottomRowMTele, numofLinksMTele;
    RadioButton yesMobility, noMobility, engagedMAuto, dockedMAuto, attempMAuto, notAtempMAuto, groundIntakeMTele, substationIntakeMTele,
            bothIntakeMTele,neitherIntakeMTele, engagedMTele, dockedMTele, attempMTele, notAttepMTele;
    int i = 0;

    FirebaseDatabase rootNode;

    DatabaseReference reference;

    private FragmentMatchScoutingStartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentMatchScoutingStartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        matchSavingClass = new MatchSavingClass();

        //end button
        scout = root.findViewById(R.id.bt_startScout);

        //text input layout
        numOnUpperMAuto = root.findViewById(R.id.til_numOnUpperMAuto);
        numOnMidMAuto = root.findViewById(R.id.til_numOnMidMAuto);
        numOnBottomRowMAuto = root.findViewById(R.id.til_numOnBottomRowMAuto);
        numOfLinksMAutos = root.findViewById(R.id.til_numOfLinksMAutos);
        numOnUpperMTele = root.findViewById(R.id.til_numOnUpperMTele);
        numOnMidMTele = root.findViewById(R.id.til_numOnMidMTele);
        numOnBottomRowMTele = root.findViewById(R.id.til_numOnBottomRowMTele);
        numofLinksMTele = root.findViewById(R.id.til_numofLinksMTele);

        //radio buttons
        yesMobility = root.findViewById(R.id.rb_yesMobility);
        noMobility = root.findViewById(R.id.rb_noMobility);
        engagedMAuto = root.findViewById(R.id.rb_engagedMAuto);
        dockedMAuto = root.findViewById(R.id.rb_dockedMAuto);
        attempMAuto = root.findViewById(R.id.rb_attempMAuto);
        notAtempMAuto = root.findViewById(R.id.rb_notAttempMAuto);
        groundIntakeMTele = root.findViewById(R.id.rb_groundIntakeMTele);
        substationIntakeMTele = root.findViewById(R.id.rb_substationIntakeMTele);
        bothIntakeMTele = root.findViewById(R.id.rb_bothIntakeMTele);
        neitherIntakeMTele = root.findViewById(R.id.rb_neitherIntakeMTele);
        engagedMTele = root.findViewById(R.id.rb_engagedMTele);
        dockedMTele = root.findViewById(R.id.rb_dockedMTele);
        attempMTele = root.findViewById(R.id.bt_attemptMTele);
        notAttepMTele = root.findViewById(R.id.notAttempMTele);

        reference = rootNode.getInstance().getReference().child("match scouting");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    i = (int)snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        scout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_match_scouting);



                String yM = yesMobility.getText().toString();
                String nM = noMobility.getText().toString();
                String eMA = engagedMAuto.getText().toString();
                String dMA = dockedMAuto.getText().toString();
                String aMA = attempMAuto.getText().toString();
                String nAMA = notAtempMAuto.getText().toString();
                String gIMT = groundIntakeMTele.getText().toString();
                String sIMT = substationIntakeMTele.getText().toString();
                String bIMT = bothIntakeMTele.getText().toString();
                String nIMT = neitherIntakeMTele.getText().toString();
                String eMT = engagedMTele.getText().toString();
                String dMT = dockedMTele.getText().toString();
                String aMT = attempMTele.getText().toString();
                String nAMT = notAttepMTele.getText().toString();

            }
        });

        return root;
    }



}
