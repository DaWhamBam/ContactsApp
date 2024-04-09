package com.example.contactsmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.contactsmanagerapp.model.Contacts;
import com.example.contactsmanagerapp.model.Repository;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private LiveData<List<Contacts>> allContacts;

    private Repository myRepository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        allContacts = myRepository.getAllContacts();
        return allContacts;
    }

    public void addNewContacts(Contacts contact) {
        myRepository.addContacts(contact);
    }

    public void deleteContact(Contacts contact) {
        myRepository.deleteContacts(contact);
    }
}
