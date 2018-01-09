package nirun.krirk.ac.th.niruncalculate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import nirun.krirk.ac.th.niruncalculate.MainActivity;
import nirun.krirk.ac.th.niruncalculate.R;

/**
 * Created by nirun on 9/1/2561.
 */

public class MainFagement extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // create Toolbar
        createToolbar();

      //ShowName Controler
        showNameControler();
        //Calculate Controller
        calculateController();



    } // Main Method

    private void calculateController() {
        Button button = getView().findViewById(R.id.btnCalculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, new CalculateFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });
    }

    private void showNameControler() {
        Button button = getView().findViewById(R.id.btnShowName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = getView().findViewById(R.id.textShowName);
                textView.setText("Nirun");


            }
        });
    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarMain);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }
}
