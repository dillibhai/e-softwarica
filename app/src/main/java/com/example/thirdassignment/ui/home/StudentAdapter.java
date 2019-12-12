package com.example.thirdassignment.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thirdassignment.R;
import com.example.thirdassignment.ui.student.StudentInfo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyHolder> {
    List<StudentInfo>student;

    public StudentAdapter(List<StudentInfo> student) {
        this.student = student;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_data,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        final StudentInfo studentInfo = student.get(position);
        holder.name.setText(studentInfo.getName());
        holder.gender.setText(studentInfo.getGender());
        holder.age.setText(studentInfo.getAge());
        holder.address.setText(studentInfo.getAddress());
        String m = studentInfo.getGender();

        if(m == "Male"){
            holder.image.setImageResource(R.drawable.male);
        }
        if(m=="Female") {
            holder.image.setImageResource(R.drawable.female);
        }
         if(m=="Other") {
            holder.image.setImageResource(R.drawable.other);
        }
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student.remove(studentInfo);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView name,age,gender,address;
        ImageView image;
        Button delete;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.textView2);
            age = itemView.findViewById(R.id.textView3);
            gender = itemView.findViewById(R.id.textView4);
            image = itemView.findViewById(R.id.imageView2);
            delete = itemView.findViewById(R.id.delete);
            address = itemView.findViewById(R.id.address);


        }
    }
}
