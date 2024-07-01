package com.almi.reto_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.almi.reto_android.R;
import com.almi.reto_android.data.Courses;

import java.util.ArrayList;

public class CoursesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Courses> coursesArrayList = new ArrayList<>();

    public CoursesAdapter(Context context, ArrayList<Courses> coursesArrayList) {
        this.context = context;
        this.coursesArrayList = coursesArrayList;
    }

    @Override
    public int getCount() {
        return coursesArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return coursesArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return CustomView(position, convertView, parent);
    }

    private View CustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View line = inflater.inflate(R.layout.item_courses_adapter, null);

        TextView modality=line.findViewById(R.id.lvCourseModality);
        modality.setText(coursesArrayList.get(position).getModality());

        TextView courseName=line.findViewById(R.id.lvCourseName);
        courseName.setText(coursesArrayList.get(position).getCourseName());

        TextView hours=line.findViewById(R.id.lvCourseHours);
        hours.setText(String.valueOf(coursesArrayList.get(position).getHours()));

        return line;
    }
}
