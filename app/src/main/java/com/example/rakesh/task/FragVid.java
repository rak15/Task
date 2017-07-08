package com.example.rakesh.task;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragVid extends Fragment {
   // public static final String ARG_PAGE="arg_page";
    public FragVid() {
        // Required empty public constructor
    }
  /*  public static FragVid newInstance(int pageNo){
        FragVid fragVid =new FragVid();
        Bundle arguments=new Bundle();
        arguments.putInt(ARG_PAGE,pageNo);
        fragVid.setArguments(arguments);
        return fragVid;
    }
    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView=(RecyclerView)inflater.inflate(R.layout.fragment_frag_vid, container, false); //adding layout with RecyclerView in this fragment
        String[] videoNames=new String[Video.videos.length];
        for (int i=0;i<videoNames.length;i++)
            videoNames[i]=Video.videos[i].getName();
        String[] videoDesc=new String[Video.videos.length];
        for (int i=0;i<videoDesc.length;i++)
            videoDesc[i]=Video.videos[i].getDescription();
        int[] videoImages=new int[Video.videos.length];
        for (int i=0;i<videoNames.length;i++)
            videoImages[i]=Video.videos[i].getImageId();
        VidRecycleAdapter adapter=new VidRecycleAdapter(videoNames,videoDesc,videoImages);  //passing array to adapter
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return recyclerView;
    }

}
