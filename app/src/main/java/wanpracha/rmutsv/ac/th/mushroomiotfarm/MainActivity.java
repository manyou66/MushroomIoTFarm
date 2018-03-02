package wanpracha.rmutsv.ac.th.mushroomiotfarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wanpracha.rmutsv.ac.th.mushroomiotfarm.fragment.AuthenFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Add Fragment to Activity
        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentMainFragment, new AuthenFragment()).commit();

        }//if
    }//Main Method
}//Main Class
