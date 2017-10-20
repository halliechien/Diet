package com.example.hallie.diet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecordFragment extends Fragment {

    private ImageButton mdisplayArrow;
    private TextView mtotalCalorie,mtotalCarbon,mtotalProtein,mtotalFat,mtotalItem
            ,mfoodCalorie,mfoodCarbon,mfoodProtein,mfoodFat;
    private EditText met_qty;



    public RecordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_record, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        mdisplayArrow=getView().findViewById(R.id.ibtn_displayArrow);
        mtotalCalorie=getView().findViewById(R.id.totalCalorie);
        mtotalCarbon=getView().findViewById(R.id.totalCarbon);
        mtotalProtein=getView().findViewById(R.id.totalProtein);
        mtotalFat=getView().findViewById(R.id.totalFat);
        mtotalItem=getView().findViewById(R.id.totalItem);
        mfoodCalorie=getView().findViewById(R.id.foodCalorie);
        mfoodCarbon=getView().findViewById(R.id.foodCarbon);
        mfoodProtein=getView().findViewById(R.id.foodProtein);
        mfoodFat=getView().findViewById(R.id.foodFat);


    }
}
