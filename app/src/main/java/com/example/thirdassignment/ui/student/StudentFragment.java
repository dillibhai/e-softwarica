package com.example.thirdassignment.ui.student;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.thirdassignment.R;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    EditText fullname, age, address;
    RadioGroup gender;
    RadioButton male, female, other;
    Button submit;

    public static List<StudentInfo> details = new ArrayList<>();

    String uname, uage, ugender, uaddress;

    private StudentViewModel studentViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_student, container, false);

        submit = root.findViewById(R.id.btn_save);
        gender = root.findViewById(R.id.gender);
        male = root.findViewById(R.id.radioMale);
        female = root.findViewById(R.id.radioFemale);
        other=root.findViewById(R.id.radioOther);
        fullname = root.findViewById(R.id.fullname);
        age = root.findViewById(R.id.age);
        address = root.findViewById(R.id.address);
        submit.setOnClickListener(this);
        gender.setOnCheckedChangeListener(this);

        studentViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int i) {
                        if (i == R.id.radioMale) {
                            ugender = "Male";
                            Toast.makeText(getContext(), "Male", Toast.LENGTH_SHORT).show();
                        }
                        if (i == R.id.radioFemale) {
                            ugender = "Female";
                            Toast.makeText(getContext(), "Female", Toast.LENGTH_SHORT).show();
                        }if (i == R.id.radioOther) {
                            ugender = "Other";
                            Toast.makeText(getContext(), "Other", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        uage = age.getText().toString();
                        uname = fullname.getText().toString();
                        uaddress = address.getText().toString();
                        if(validate()) {
                            details.add(new StudentInfo(uname, uage, ugender, uaddress));
                            Toast.makeText(getContext(), "Student's Details has been added", Toast.LENGTH_LONG).show();
                            age.setText(null);
                            fullname.setText(null);
                            address.setText(null);
                        }

                    }
                });
            }
        });
        return root;

            }
    private boolean validate() {
        if (TextUtils.isEmpty(uname)) {
            fullname.setError("Enter FullName");
            return false;

        }
        if (TextUtils.isEmpty(uaddress)) {
            address.setError("Enter Address");
            return false;

        }

        if (TextUtils.isEmpty(uage)) {
            age.setError("Enter Age");
            return false;

        }


        if(TextUtils.isEmpty(ugender)) {
            Toast.makeText(getContext(), "Select Gender", Toast.LENGTH_SHORT).show();
            return false;

        }

        return true;


    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}
