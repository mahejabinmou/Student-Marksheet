package com.mou.studentmarksheet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mou.studentmarksheet.databinding.FragmentAddStudentBinding;
import com.mou.studentmarksheet.databinding.FragmentHomeBinding;

import java.util.HashMap;


public class AddStudentFragment extends Fragment {

       FirebaseDatabase db=FirebaseDatabase.getInstance();
       DatabaseReference reference= db.getReference().child("Students");

    private FragmentAddStudentBinding binding;
    public AddStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddStudentBinding.inflate(inflater);
        binding.buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = binding.studentName.getText().toString();
                final String roll = binding.studentRoll.getText().toString();
                final int bangla = Integer.parseInt(binding.bangla.getText().toString());
                final int english = Integer.parseInt(binding.english.getText().toString());
                final int math = Integer.parseInt(binding.math.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putString("sName",name);
                bundle.putString("sRoll",roll);
                bundle.putInt("sBangla",bangla);
                bundle.putInt("sEnglish",english);
                bundle.putInt("sMath",math);
                reference.push().setValue(bundle);
//                HashMap<String,String> studentMap=new HashMap<>();
//                HashMap<String,Integer> studentMapScore=new HashMap<>();

//                studentMap.put("sName",name);
//                studentMap.put("sRoll",roll);
//                studentMapScore.put("sBangla",bangla);
//                studentMapScore.put("sEnglish",english);
//                studentMapScore.put("sMath",math);
//                reference.push().setValue(studentMap);
//                reference.push().setValue(studentMapScore);


                Navigation.findNavController(view).navigate(R.id.resultStudentFragment,bundle);
            }
        });
        return binding.getRoot();
    }
}