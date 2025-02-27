package com.example.collegehelper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TimetableFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        List<TimetableImage> images = new ArrayList<>();
        images.add(new TimetableImage(R.drawable.tb1));
        images.add(new TimetableImage(R.drawable.tb2));
        images.add(new TimetableImage(R.drawable.tb3));
        images.add(new TimetableImage(R.drawable.tb4));
        images.add(new TimetableImage(R.drawable.tb5));
        images.add(new TimetableImage(R.drawable.tb6));

        // ✅ Fix: Pass `getContext()` to the adapter
        TimetableAdapter adapter = new TimetableAdapter(getContext(), images);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
