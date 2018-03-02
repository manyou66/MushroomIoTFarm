package wanpracha.rmutsv.ac.th.mushroomiotfarm.fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import wanpracha.rmutsv.ac.th.mushroomiotfarm.R;

/**
 * Created by bow on 2/3/2561.
 */

public class LightFragment extends Fragment {
    private FirebaseDatabase firebaseDatabase;
    private String LightString;
    private DatabaseReference databaseReference;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

//      Get Value From Firebase
        getValueFromFirebase();

//        On Controller
        onController();

//        Off Controler
        offController();

    }//Main Method

    private void offController() {
        Button button = getView().findViewById(R.id.btnOff);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateLight("0");

            }
        });
    }

    private void updateLight(String lightString) {
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("light", lightString);
        databaseReference.updateChildren(stringObjectMap);
    }

    private void onController() {
        Button button = getView().findViewById(R.id.btnOn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateLight("1");

            }
        });
    }

    private void getValueFromFirebase() {
        final TextView textView = getView().findViewById(R.id.txtLight);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                LightString = String.valueOf(map.get("light"));
                textView.setText(LightString);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_light, container, false);
        return view;
    }
}
