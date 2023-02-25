package com.example.lapislazuli.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.lapislazuli.R;
import com.example.lapislazuli.databinding.FragmentPitScoutingBinding;


public class PitScouting extends Fragment {

    Button submitPit;

    PitSavingClass PitSavingClass;

    TextInputLayout pitTeamNumber, pitScouterName, pitRobotWeight, pitRobotDimensions, pitRobotSpeed, pitSettingShiftingGearbox, pitDriveTrainType, pitIntakeType, pitLiftingMechanismType, pitRobotProgrammingLanguage, pitAppProgrammingLanguage, pitCubeConeAmount, pitTeleopCycleTime, pitTeleopNodes, pitEndgamePlatformSuccess;

    RadioGroup pitOpenClosedChassis, pitShiftingGearbox, pitHaveAuto, pitAutoPreload, pitTeleopScoringPreference, pitEndgamePlatform;


    RadioButton pitClosedChassis, pitOpenChassis, pitYesShiftingGearbox, pitNoShiftingGearbox, pitYesAuto, pitNoAuto, pitAutoPreloadCone, pitAutoPreloadCube, pitAutoPreloadNo, pitTeleopScoringPreferenceCone, pitTeleopScoringPreferenceCube, pitTeleopScoringPreferenceNoPreference, pitTeleopScoringPreferenceNeither, pitTeleopScoringPreferenceDefense, pitEndGamePlatformYes, pitEndGamePlatformNo;

    CheckBox pitAutoMobility, pitAutoPickUpCone, pitAutoPickUpCube, pitAutoDock;
    int i = 0;

    FirebaseDatabase rootNode;

    DatabaseReference reference;


        private FragmentPitScoutingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPitScoutingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button submitPit = root.findViewById(R.id.bt_submitPit);


        submitPit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_pit_scouting);

                PitSavingClass = new PitSavingClass();


                //text input layout
        Button submitPit = root.findViewById(R.id.bt_submitPit);

        pitTeamNumber = root.findViewById(R.id.til_pitTeamNumber);

        pitScouterName = root.findViewById(R.id.til_pitScouterName);

        pitRobotWeight = root.findViewById(R.id.til_pitRobotWeight);

        pitRobotDimensions = root.findViewById(R.id.til_pitRobotDimensions);

        pitRobotSpeed = root.findViewById(R.id.til_pitRobotSpeed);

        pitSettingShiftingGearbox = root.findViewById(R.id.til_pitSettingShiftingGearbox);

        pitDriveTrainType = root.findViewById(R.id.til_pitDriveTrainType);

        pitIntakeType = root.findViewById(R.id.til_pitIntakeType);

        pitLiftingMechanismType = root.findViewById(R.id.til_pitLiftingMechanismType);

        pitRobotProgrammingLanguage = root.findViewById(R.id.til_pitRobotProgrammingLanguage);

        pitAppProgrammingLanguage = root.findViewById(R.id.til_pitAppProgrammingLanguage);

        pitCubeConeAmount = root.findViewById(R.id.til_pitCubeConeAmount);

        pitTeleopCycleTime = root.findViewById(R.id.til_pitTeleopCycleTime);

        pitTeleopNodes = root.findViewById(R.id.til_pitTeleopNodes);

        pitEndgamePlatformSuccess = root.findViewById(R.id.til_pitEndgamePlatformSuccess);

        //radio groups

        pitOpenClosedChassis = root.findViewById(R.id.rg_pitOpenClosedChassis);

        pitShiftingGearbox = root.findViewById(R.id.rg_pitShiftingGearbox);

        pitHaveAuto = root.findViewById(R.id.rg_pitHaveAuto);

        pitAutoPreload = root.findViewById(R.id.rg_pitAutoPreload);

        pitTeleopScoringPreference = root.findViewById(R.id.rg_pitTeleopScoringPreference);

        pitEndgamePlatform = root.findViewById(R.id.rg_pitEndgamePlatform);






        //radio buttons

        pitClosedChassis = root.findViewById(R.id.rb_pitClosedChassis);

        pitOpenChassis = root.findViewById(R.id.rb_pitOpenChassis);

        pitYesShiftingGearbox = root.findViewById(R.id.rb_pitYesShiftingGearbox);

        pitNoShiftingGearbox = root.findViewById(R.id.rb_pitNoShiftingGearbox);

        pitYesAuto = root.findViewById(R.id.rb_pitYesAuto);

        pitNoAuto = root.findViewById(R.id.rb_pitNoAuto);

        pitAutoPreloadCone = root.findViewById(R.id.rb_pitAutoPreloadCone);

        pitAutoPreloadCube = root.findViewById(R.id.rb_pitAutoPreloadCube);

        pitAutoPreloadNo = root.findViewById(R.id.rb_pitAutoPreloadNo);

        pitTeleopScoringPreferenceCone = root.findViewById(R.id.rb_pitTeleopScoringPreferenceCone);

        pitTeleopScoringPreferenceCube = root.findViewById(R.id.rb_pitTeleopScoringPreferenceCube);

        pitTeleopScoringPreferenceNoPreference = root.findViewById(R.id.rb_pitTeleopScoringPreferenceNoPreference);

        pitTeleopScoringPreferenceNeither = root.findViewById(R.id.rb_pitTeleopScoringPreferenceNeither);

        pitTeleopScoringPreferenceDefense = root.findViewById(R.id.rb_pitTeleopScoringPreferenceDefense);

        pitEndGamePlatformYes = root.findViewById(R.id.rb_pitEndGamePlatformYes);

        pitEndGamePlatformNo = root.findViewById(R.id.rb_pitEndGamePlatformNo);


        //checkboxes
        pitAutoMobility = root.findViewById(R.id.cb_pitAutoMobility);

        pitAutoPickUpCone = root.findViewById(R.id.cb_pitAutoPickUpCone);

        pitAutoPickUpCube = root.findViewById(R.id.cb_pitAutoPickUpCube);

        pitAutoDock = root.findViewById(R.id.cb_pitAutoDock);

        //end button
        submitPit = root.findViewById(R.id.bt_submitPit);


        //checkboxes
        String one = "Auto Mobility";
        String two = "Auto Pick Up Cone";
        String three = "Auto Pick Up Cube";
        String four = "Auto Dock";



                //beginning of database work, scroll down till end

                reference = rootNode.getInstance().getReference().child("pit scouting");

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()) {
                            i = (int) snapshot.getChildrenCount();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                submitPit.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        rootNode = FirebaseDatabase.getInstance();
                        reference = rootNode.getReference("pit scouting");

                        reference.setValue("pit scouting");
                        //radio buttons work

                String closedChassis = pitClosedChassis.getText().toString();
                String openChassis = pitOpenChassis.getText().toString();

                String yShifting = pitYesShiftingGearbox.getText().toString();
                String nShifting = pitNoShiftingGearbox.getText().toString();

                String yAuto = pitYesAuto.getText().toString();
                String nAuto = pitNoAuto.getText().toString();

                String conePreload = pitAutoPreloadCone.getText().toString();
                String cubePreload = pitAutoPreloadCube.getText().toString();
                String noPreload = pitAutoPreloadNo.getText().toString();

                String TconePreference = pitTeleopScoringPreferenceCone.getText().toString();
                String TcubePreference = pitTeleopScoringPreferenceCube.getText().toString();
                String TnoPreference = pitTeleopScoringPreferenceNoPreference.getText().toString();
                String TneitherPreference = pitTeleopScoringPreferenceNeither.getText().toString();
                String TdefensePreference = pitTeleopScoringPreferenceDefense.getText().toString();

                String pitPlatformY = pitEndGamePlatformYes.getText().toString();
                String pitPlatformN = pitEndGamePlatformNo.getText().toString();


                //text input layouts !!
                PitSavingClass.setPitTeamNumber(pitTeamNumber.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitScouterName(pitScouterName.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitRobotWeight(pitRobotWeight.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitRobotDimensions(pitRobotDimensions.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitRobotSpeed(pitRobotSpeed.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitSettingsShiftingGearbox(pitSettingShiftingGearbox.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitDriveTrainType(pitDriveTrainType.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitIntakeType(pitIntakeType.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitLiftingMechanismType(pitLiftingMechanismType.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitRobotProgrammingLanguage(pitRobotProgrammingLanguage.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitAppProgrammingLanguage(pitAppProgrammingLanguage.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitCubeConeAmount(pitCubeConeAmount.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitTeleopCycleTime(pitTeleopCycleTime.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitTeleopNodes(pitTeleopNodes.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);

                PitSavingClass.setPitEndgamePlatformSuccess(pitEndgamePlatformSuccess.getEditText().getText().toString());
                reference.child(String.valueOf(i+1)).setValue(PitSavingClass);



                //radio buttons
                if(pitClosedChassis.isChecked()){
                    PitSavingClass.setPitOpenClosedChassisQues(closedChassis);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else{
                    PitSavingClass.setPitOpenClosedChassisQues(openChassis);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                }


                if(pitYesShiftingGearbox.isChecked()){
                    PitSavingClass.setPitShiftingGearboxQues(yShifting);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else{
                    PitSavingClass.setPitShiftingGearboxQues(nShifting);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                }


                if(pitYesAuto.isChecked()){
                    PitSavingClass.setPitHaveAnAutoQues(yAuto);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else{
                    PitSavingClass.setPitHaveAnAutoQues(nAuto);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                }


                if(pitAutoPreloadCone.isChecked()){
                    PitSavingClass.setPitAutoPreloadQues(conePreload);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else if(pitAutoPreloadCube.isChecked()){
                    PitSavingClass.setPitAutoPreloadQues(cubePreload);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else{
                    PitSavingClass.setPitAutoPreloadQues(noPreload);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                }


                if(pitTeleopScoringPreferenceCone.isChecked()){
                    PitSavingClass.setPitTeleopScoringPreferenceQues(TconePreference);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else if(pitTeleopScoringPreferenceCube.isChecked()){
                    PitSavingClass.setPitTeleopScoringPreferenceQues(TcubePreference);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else if(pitTeleopScoringPreferenceNoPreference.isChecked()){
                    PitSavingClass.setPitTeleopScoringPreferenceQues(TnoPreference);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else if(pitTeleopScoringPreferenceNeither.isChecked()){
                    PitSavingClass.setPitTeleopScoringPreferenceQues(TneitherPreference);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else{
                    PitSavingClass.setPitTeleopScoringPreferenceQues(TdefensePreference);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                }


                if(pitEndGamePlatformYes.isChecked()){
                    PitSavingClass.setPitEndGamePlatformQues(pitPlatformY);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else{
                    PitSavingClass.setPitEndGamePlatformQues(pitPlatformN);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                }



                //checkboxes
                if(pitAutoMobility.isChecked()){
                    PitSavingClass.setPitAutoMobility(one);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else{

                }
                if(pitAutoPickUpCone.isChecked()){
                    PitSavingClass.setPitAutoPickUpCone(two);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else{

                }
                if(pitAutoPickUpCube.isChecked()){
                    PitSavingClass.setPitAutoPickUpCube(three);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else{

                }
                if(pitAutoDock.isChecked()){
                    PitSavingClass.setPitAutoDock(four);
                    reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
                } else{

                }



                    }

                });


                //end of database work
            }
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
