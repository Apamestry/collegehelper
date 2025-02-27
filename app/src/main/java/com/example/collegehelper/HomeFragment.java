package com.example.collegehelper;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private NoticeAdapter adapter;
    private List<NoticeModel> noticeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        noticeList = new ArrayList<>();
        adapter = new NoticeAdapter(noticeList, getContext());

        recyclerView.setAdapter(adapter);

        // Fetch notices from the website
        new FetchNoticesTask().execute("https://xavierscollegegoa.ac.in/");

        return view;
    }

    // Async Task to fetch data from the website
    private class FetchNoticesTask extends AsyncTask<String, Void, List<NoticeModel>> {

        @Override
        protected List<NoticeModel> doInBackground(String... urls) {
            List<NoticeModel> fetchedNotices = new ArrayList<>();
            try {
                Document doc = Jsoup.connect(urls[0]).get();

                // Find the section where notices are listed
                Element noticeContainer = doc.select("div.entry-content").first();

                if (noticeContainer != null) {
                    Elements noticeElements = noticeContainer.select("a"); // Selecting <a> for both text and link

                    for (Element element : noticeElements) {
                        String title = element.text();  // Extract notice title
                        String link = element.absUrl("href"); // Extract absolute URL

                        // Ensure it's a valid notice (not empty or duplicate)
                        if (!title.isEmpty() && !link.isEmpty()) {
                            fetchedNotices.add(new NoticeModel(title, link));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return fetchedNotices;
        }



        @Override
        protected void onPostExecute(List<NoticeModel> result) {
            if (result.isEmpty()) {
                Toast.makeText(getContext(), "Failed to load notices!", Toast.LENGTH_SHORT).show();
            } else {
                noticeList.clear();
                noticeList.addAll(result);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
