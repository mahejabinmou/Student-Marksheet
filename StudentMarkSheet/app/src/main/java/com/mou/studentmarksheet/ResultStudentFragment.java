package com.mou.studentmarksheet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mou.studentmarksheet.databinding.FragmentAddStudentBinding;
import com.mou.studentmarksheet.databinding.FragmentResultStudentBinding;


public class ResultStudentFragment extends Fragment {



    private FragmentResultStudentBinding binding;
    public ResultStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentResultStudentBinding.inflate(inflater);
        Bundle bundle = getArguments();
        String name = bundle.getString("sName");
        String roll = bundle.getString("sRoll");
        int bangla = bundle.getInt("sBangla");
        int english = bundle.getInt("sEnglish");
        int math = bundle.getInt("sMath");
        int total = (bangla+english+math);
        float average = total/3;
        binding.ShowStudentName.setText(name);
        binding.ShowStudentRoll.setText(roll);
        binding.ShowBangla.setText(bangla);
        binding.ShowEnglish.setText(english);
        binding.ShowMath.setText(math);
        binding.ShowTotal.setText(total);
        binding.ShowAverage.setText((int) average);

        if(average <=100 && average >= 80)
        {
            binding.ShowGrade.setText("A+");
        }
        else if(average <80 && average >=70)
        {
            binding.ShowGrade.setText("A");
        }

        else if(average <70 && average >=60)
        {
            binding.ShowGrade.setText("B");
        }


        else if(average <60 && average >=50)
        {
            binding.ShowGrade.setText("C");
        }

        else
        {
            binding.ShowGrade.setText("Fail");
        }

        //work on add button
        //after add button, data will be upload in database from here


        return binding.getRoot();
    }
}