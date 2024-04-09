package com.example.contactsmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.contactsmanagerapp.databinding.ActivityAddNewBinding;
import com.example.contactsmanagerapp.model.Contacts;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewBinding binding;
    private AddNewContactClickHandler handler;
    private Contacts contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        contact = new Contacts();

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_new
        );

        MyViewModel myViewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);

        handler = new AddNewContactClickHandler(
                contact,
                this,
                myViewModel
        );

        binding.setContact(contact);
        binding.setClickHandler(handler);


    }
}