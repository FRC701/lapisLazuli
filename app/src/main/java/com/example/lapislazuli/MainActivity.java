package com.example.lapislazuli;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lapislazuli.Fragments.PitSavingClass;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lapislazuli.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    com.example.lapislazuli.Fragments.PitSavingClass PitSavingClass;

    Button submitPit;

    TextInputLayout pitTeamNumber, pitScouterName, pitRobotWeight, pitRobotDimensions, pitRobotSpeed, pitSettingShiftingGearbox, pitDriveTrainType, pitIntakeType, pitLiftingMechanismType, pitRobotProgrammingLanguage, pitAppProgrammingLanguage, pitCubeConeAmount, pitTeleopCycleTime, pitTeleopNodes, pitEndgamePlatformSuccess;

    RadioGroup pitOpenClosedChassis, pitShiftingGearbox, pitHaveAuto, pitAutoPreload, pitTeleopScoringPreference, pitEndgamePlatform;

    RadioButton pitClosedChassis, pitOpenChassis, pitYesShiftingGearbox, pitNoShiftingGearbox, pitYesAuto, pitNoAuto, pitAutoPreloadCone, pitAutoPreloadCube, pitAutoPreloadNo, pitTeleopScoringPreferenceCone, pitTeleopScoringPreferenceCube, pitTeleopScoringPreferenceNoPreference, pitTeleopScoringPreferenceNeither, pitTeleopScoringPreferenceDefense, pitEndGamePlatformYes, pitEndGamePlatformNo;

    CheckBox pitAutoMobility, pitAutoPickUpCone, pitAutoPickUpCube, pitAutoDock;
    int i = 0;

    FirebaseDatabase rootNode;

    DatabaseReference reference;


    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pit_scouting);

        PitSavingClass = new PitSavingClass();


        //text input layout
        Button submit = findViewById(R.id.bt_submitPit);

        pitTeamNumber = findViewById(R.id.til_pitTeamNumber);

        /*pitScouterName = findViewById(R.id.til_pitScouterName);

        pitRobotWeight = findViewById(R.id.til_pitRobotWeight);

        pitRobotDimensions = findViewById(R.id.til_pitRobotDimensions);

        pitRobotSpeed = findViewById(R.id.til_pitRobotSpeed);

        pitSettingShiftingGearbox = findViewById(R.id.til_pitSettingShiftingGearbox);

        pitDriveTrainType = findViewById(R.id.til_pitDriveTrainType);

        pitIntakeType = findViewById(R.id.til_pitIntakeType);

        pitLiftingMechanismType = findViewById(R.id.til_pitLiftingMechanismType);

        pitRobotProgrammingLanguage = findViewById(R.id.til_pitRobotProgrammingLanguage);

        pitAppProgrammingLanguage = findViewById(R.id.til_pitAppProgrammingLanguage);

        pitCubeConeAmount = findViewById(R.id.til_pitCubeConeAmount);

        pitTeleopCycleTime = findViewById(R.id.til_pitTeleopCycleTime);

        pitTeleopNodes = findViewById(R.id.til_pitTeleopNodes);

        pitEndgamePlatformSuccess = findViewById(R.id.til_pitEndgamePlatformSuccess);

        //radio groups

        /*pitOpenClosedChassis = findViewById(R.id.rg_pitOpenClosedChassis);

        pitShiftingGearbox = findViewById(R.id.rg_pitShiftingGearbox);

        pitHaveAuto = findViewById(R.id.rg_pitHaveAuto);

        pitAutoPreload = findViewById(R.id.rg_pitAutoPreload);

        pitTeleopScoringPreference = findViewById(R.id.rg_pitTeleopScoringPreference);

        pitEndgamePlatform = findViewById(R.id.rg_pitEndgamePlatform);






        //radio buttons

        pitClosedChassis = findViewById(R.id.rb_pitClosedChassis);

        pitOpenChassis = findViewById(R.id.rb_pitOpenChassis);

        pitYesShiftingGearbox = findViewById(R.id.rb_pitYesShiftingGearbox);

        pitNoShiftingGearbox = findViewById(R.id.rb_pitNoShiftingGearbox);

        pitYesAuto = findViewById(R.id.rb_pitYesAuto);

        pitNoAuto = findViewById(R.id.rb_pitNoAuto);

        pitAutoPreloadCone = findViewById(R.id.rb_pitAutoPreloadCone);

        pitAutoPreloadCube = findViewById(R.id.rb_pitAutoPreloadCube);

        pitAutoPreloadNo = findViewById(R.id.rb_pitAutoPreloadNo);

        pitTeleopScoringPreferenceCone = findViewById(R.id.rb_pitTeleopScoringPreferenceCone);

        pitTeleopScoringPreferenceCube = findViewById(R.id.rb_pitTeleopScoringPreferenceCube);

        pitTeleopScoringPreferenceNoPreference = findViewById(R.id.rb_pitTeleopScoringPreferenceNoPreference);

        pitTeleopScoringPreferenceNeither = findViewById(R.id.rb_pitTeleopScoringPreferenceNeither);

        pitTeleopScoringPreferenceDefense = findViewById(R.id.rb_pitTeleopScoringPreferenceDefense);

        pitEndGamePlatformYes = findViewById(R.id.rb_pitEndGamePlatformYes);

        pitEndGamePlatformNo = findViewById(R.id.rb_pitEndGamePlatformNo);


        //checkboxes
        pitAutoMobility = findViewById(R.id.cb_pitAutoMobility);

        pitAutoPickUpCone = findViewById(R.id.cb_pitAutoPickUpCone);

        pitAutoPickUpCube = findViewById(R.id.cb_pitAutoPickUpCube);

        pitAutoDock = findViewById(R.id.cb_pitAutoDock);

        //end button
        submitPit = findViewById(R.id.bt_submitPit);


        //checkboxes
        String one = "Auto Mobility";
        String two = "Auto Pick Up Cone";
        String three = "Auto Pick Up Cube";
        String four = "Auto Dock";

         */

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

                //radio buttons work

                /*String closedChassis = pitClosedChassis.getText().toString();
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

                 */

            }

        });


       //end of database work


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_match_scouting_start, R.id.nav_pit_scouting)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

//end of testing code

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}