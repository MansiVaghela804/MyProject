package com.example.admin.myproject.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.admin.myproject.R;

public class FragmentActivity extends AppCompatActivity {
    FirstFragment firstFragment;
    BlankFragment blankFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        fragmentManager = getSupportFragmentManager();
    }

    public void addA(View view) {
        firstFragment = new FirstFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame, firstFragment, "A");
        fragmentTransaction.addToBackStack("addA");
        fragmentTransaction.commit();
    }

    public void addB(View view) {
        blankFragment = new BlankFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame, blankFragment, "B");
        fragmentTransaction.addToBackStack("addB");
        fragmentTransaction.commit();

    }

    public void Raplace(View view) {
        blankFragment = new BlankFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame, blankFragment, "B");
        fragmentTransaction.addToBackStack("addB");
        fragmentTransaction.commit();
    }
}
