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

    //hi
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