package wanpracha.rmutsv.ac.th.mushroomiotfarm.fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import wanpracha.rmutsv.ac.th.mushroomiotfarm.MainActivity;
import wanpracha.rmutsv.ac.th.mushroomiotfarm.R;

/**
 * Created by bow on 2/3/2561.
 */

public class ManualFragment extends Fragment {

    private String urlField1 = "https://thingspeak.com/channels/437885/charts/1?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15";
    private String urlField2 = "https://thingspeak.com/channels/437885/charts/2?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15";


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setHasOptionsMenu(true);

//        Create Toolbar
        createToolbar();

//        Create WebView
        createWebView();

    }//Main Method

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.manu_manual, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Light
        if (item.getItemId() == R.id.itemLight) {
//            Do it
            return true;
        }

//        Fan
        if (item.getItemId() == R.id.itemFan) {
//            Do it
            return true;
        }
//        Cloud
        if (item.getItemId() == R.id.itemCloud) {
//            Do it
            return true;
        }
//        CCTV
        if (item.getItemId() == R.id.itemVideo) {
//            Do it
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void createWebView() {
        WebView webView = getView().findViewById(R.id.webViewTemp);
        WebView webView1 = getView().findViewById(R.id.webViewHumidity);

        WebViewClient field1WebViewClient = new WebViewClient();
        webView.setWebViewClient(field1WebViewClient);
        webView.loadUrl(urlField1);
        webView.getSettings().setJavaScriptEnabled(true);

        WebViewClient field2WebViewClient = new WebViewClient();
        webView1.setWebViewClient(field2WebViewClient);
        webView1.loadUrl(urlField2);
        webView1.getSettings().setJavaScriptEnabled(true);

    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarManual);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Manual");
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manual, container, false);
        return view;
    }

}
