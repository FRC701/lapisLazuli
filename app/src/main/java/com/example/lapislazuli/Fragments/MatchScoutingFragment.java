package com.example.lapislazuli.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lapislazuli.R;
import com.example.lapislazuli.databinding.FragmentMatchScoutingBinding;
import com.example.lapislazuli.databinding.FragmentMatchScoutingStartBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MatchScoutingFragment {

    private FragmentMatchScoutingBinding binding;
    Button scout;
    MatchSavingClass matchSavingClass;
    TextInputLayout numOnUpperMAuto, numOnMidMAuto, numOnBottomRowMAuto, numOfLinksMAutos,
            numOnUpperMTele, numOnMidMTele, numOnBottomRowMTele, numOfLinksMTele;
    RadioButton yesMobility, noMobility, engagedMAuto, dockedMAuto, attempMAuto, notAtempMAuto, groundIntakeMTele, substationIntakeMTele,
            bothIntakeMTele, neitherIntakeMTele, engagedMTele, dockedMTele, attempMTele, notAttepMTele;
    int i = 0;
    FirebaseDatabase rootNode;

    DatabaseReference reference;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentMatchScoutingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        matchSavingClass = new MatchSavingClass();

        //text input layout
        numOnUpperMAuto = root.findViewById(R.id.til_numOnUpperMAuto);
        numOnMidMAuto = root.findViewById(R.id.til_numOnMidMAuto);
        numOnBottomRowMAuto = root.findViewById(R.id.til_numOnBottomRowMAuto);
        numOfLinksMAutos = root.findViewById(R.id.til_numOfLinksMAutos);
        numOnUpperMTele = root.findViewById(R.id.til_numOnUpperMTele);
        numOnMidMTele = root.findViewById(R.id.til_numOnMidMTele);
        numOnBottomRowMTele = root.findViewById(R.id.til_numOnBottomRowMTele);
        numOfLinksMTele = root.findViewById(R.id.til_numofLinksMTele);

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
        attempMTele = root.findViewById(R.id.rb_attempMTele);
        notAttepMTele = root.findViewById(R.id.rb_notAttempMTele);

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

        //end button
        scout = root.findViewById(R.id.bt_startScout);

        scout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_match_scouting);

                //radio buttons
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

                //text input layout
                matchSavingClass.setNumOnUpperMAuto(numOnUpperMAuto.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(matchSavingClass);

                matchSavingClass.setNumOnMidMAuto(numOnMidMAuto.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(matchSavingClass);

                matchSavingClass.setNumOnBottomRowMAuto(numOnBottomRowMAuto.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(matchSavingClass);

                matchSavingClass.setNumOfLinksMAutos(numOfLinksMAutos.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(matchSavingClass);

                matchSavingClass.setNumOnUpperMTele(numOnUpperMTele.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(matchSavingClass);

                matchSavingClass.setNumOnMidMTele(numOnMidMTele.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(matchSavingClass);

                matchSavingClass.setNumOnBottomRowMTele(numOnBottomRowMTele.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(matchSavingClass);

                matchSavingClass.setNumOfLinksMTele(numOfLinksMTele.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(matchSavingClass);

                //radio buttons again
                if(yesMobility.isChecked()){
                    matchSavingClass.setYesMobility(yM);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                } else {
                    matchSavingClass.setNoMobility(nM);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                }

                if(engagedMAuto.isChecked()){
                    matchSavingClass.setEngagedMAuto(eMA);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                } else if (dockedMAuto.isChecked()) {
                    matchSavingClass.setDockedMAuto(dMA);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                } else if (attempMAuto.isChecked()) {
                    matchSavingClass.setAttempMAuto(aMA);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                }else{
                    matchSavingClass.setNotAtempMAuto(nAMA);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                }

                if(groundIntakeMTele.isChecked()){
                    matchSavingClass.setGroundIntakeMTele(gIMT);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                } else if (substationIntakeMTele.isChecked()) {
                    matchSavingClass.setDockedMTele(dMT);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                } else if (bothIntakeMTele.isChecked()) {
                    matchSavingClass.setBothIntakeMTele(bIMT);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                } else {
                    matchSavingClass.setNeitherIntakeMTele(nIMT);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                }

                if(engagedMTele.isChecked()){
                    matchSavingClass.setEngagedMTele(eMT);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                } else if (dockedMTele.isChecked()) {
                    matchSavingClass.setDockedMTele(dMT);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                } else if (attempMTele.isChecked()) {
                    matchSavingClass.setAttempMTele(aMT);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                } else{
                    matchSavingClass.setNotAttepMTele(nAMT);
                    reference.child(String.valueOf(i+1)).setValue(matchSavingClass);
                }

            }
        });

        return root;
    }
}
