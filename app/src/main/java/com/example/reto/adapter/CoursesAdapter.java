package com.example.reto.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.reto.R;
import com.example.reto.data.Courses;
import java.util.ArrayList;

public class CoursesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Courses> coursesList;

    public CoursesAdapter(Context context, ArrayList<Courses> coursesList) {
        this.context = context;
        this.coursesList = coursesList;
    }

    @Override
    public int getCount() {
        return coursesList.size();
    }

    @Override
    public Object getItem(int position) {
        return coursesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_courses_adapter, null);


        TextView modality = view.findViewById(R.id.lvCourseModality);
        TextView courseName = view.findViewById(R.id.lvCourseName);
        TextView hours = view.findViewById(R.id.lvCourseHours);

        Courses currentCourse = (Courses) getItem(position);

        modality.setText(currentCourse.getModality());
        courseName.setText(currentCourse.getCourse());
        hours.setText(String.valueOf(currentCourse.getHours()));

        return view;
    }


    public ArrayList<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(ArrayList<Courses> coursesList) {
        this.coursesList = coursesList;
    }
}
