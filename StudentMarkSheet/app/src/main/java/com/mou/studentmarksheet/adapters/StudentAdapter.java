package com.mou.studentmarksheet.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mou.studentmarksheet.R;
import com.mou.studentmarksheet.models.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentAdapter() {

    }
    DatabaseReference reference;
    private void readData(List<Student> studentList) {

        reference = FirebaseDatabase.getInstance().getReference("Students");
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row,parent,false);
        return new StudentViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
//        holder.nameTV.setText(studentList.get(position).getName());
//        holder.rollTV.setText(studentList.get(position).getRoll());
//        holder.gradeTV.setText(studentList.get(position).getGrade());
//        readData(studentList);
        if (studentList.size()>0){
            holder.nameTV.setText(studentList.get(position).getName());
            holder.rollTV.setText(studentList.get(position).getRoll());
            holder.gradeTV.setText(studentList.get(position).getGrade());
            readData(studentList);
        }

        else{
            Log.d("tag","No data found");
        }


    }

    @Override
    public int getItemCount() {
        return studentList.size();

    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV,rollTV,gradeTV;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.rowStudentName);
            rollTV = itemView.findViewById(R.id.rowStudentRoll);
            gradeTV = itemView.findViewById(R.id.rowStudentGrade);

        }
    }
}
