package com.example.sample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.List;


public class sliderFragment extends Fragment {

    reviewAdapt adaptOverView;
    RecyclerView recyclerOverView;
    SlidingUpPanelLayout slidingUpPanelLayout;
    TextView mMapCover;


    public sliderFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findview(view);
    }

    private void findview(View view) {
        recyclerOverView = view.findViewById(R.id.slider_recycle);
        mMapCover = view.findViewById(R.id.maps);
        slidingUpPanelLayout = view.findViewById(R.id.slider_drawer);
        populateList();
        list();
    }

    private void list() {
        slidingUpPanelLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                mMapCover.setAlpha(1-slideOffset);
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState,
                                            SlidingUpPanelLayout.PanelState newState) {

            }
        });
    }

    private void populateList() {

        List<reviewModel> reviewModelList = new ArrayList<>();

        for (int i = 1; i < 20; i++) {
            int imges = R.drawable.ic_userlogin;
            String names = " Name is " + i;
            String dates = " Dates is " + i;
            String detail = " details about is " + i;

            reviewModel models = new reviewModel(names, dates, detail, 4, imges);

            reviewModelList.add(models);
        }

        setupRecycle(reviewModelList);
    }

    private void setupRecycle(List<reviewModel> reviewModelList) {

        adaptOverView = new reviewAdapt(getContext(), reviewModelList, 5);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        layout.setSmoothScrollbarEnabled(true);
        recyclerOverView.setLayoutManager(layout);
        recyclerOverView.setHasFixedSize(true);
        recyclerOverView.setAdapter(adaptOverView);

    }
}