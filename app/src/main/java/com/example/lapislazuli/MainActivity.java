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

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.lapislazuli.R;
import com.example.lapislazuli.databinding.FragmentPitScoutingBinding;

public class MainActivity extends AppCompatActivity {

    Button submitPit;

    com.example.lapislazuli.Fragments.PitSavingClass PitSavingClass;

    TextInputLayout teamNumberPitScouting, pitScouterName, pitRobotWeight, pitRobotDimensions, pitRobotSpeed, pitSettingShiftingGearbox, pitDriveTrainType, pitIntakeType, pitLiftingMechanismType, pitRobotProgrammingLanguage, pitAppProgrammingLanguage, pitCubeConeAmount, pitTeleopCycleTime, pitTeleopNodes, pitEndgamePlatformSuccess;

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
        TextInputLayout findViewById;

        teamNumberPitScouting = findViewById(R.id.til_teamNumberPitScouting);

        pitScouterName = findViewById(R.id.til_pitScouterName);

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

        pitOpenClosedChassis = findViewById(R.id.rg_pitOpenClosedChassis);

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

//code for testing



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
       public void onClick(View v) {

           //checkboxes
           if(pitAutoMobility.isChecked()){
               PitSavingClass.setpitAutoMobility(one);
               reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
           } else{

           }
           if(pitAutoPickUpCone.isChecked()){
               PitSavingClass.setpitAutoPickUpCone(two);
               reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
           } else{

           }
           if(pitAutoPickUpCube.isChecked()){
               PitSavingClass.setpitAutoPickUpCube(three);
               reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
           } else{

           }
           if(pitAutoDock.isChecked()){
               PitSavingClass.setpitAutoDock(four);
               reference.child(String.valueOf(i+1)).setValue(PitSavingClass);
           } else{

           }

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