package nirun.krirk.ac.th.niruncalculate.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
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

public class CalculateFragment extends Fragment implements View.OnClickListener {


//    Explicit

    private TextView textView;
    private Button buttonC, button1, button2, button3,
            button0, button4, button5, button6, button7,
            button8, button9,
            buttonx, buttonadd, buttonplus, buttonminus, buttondiv;



    private String displayString ="";
    private double num1ADouuble, displayADouuble;
    private String tag = "23Janv1";
    private boolean addABoolean = false;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Create Toolbar
        createToolbar();

        // IntialView
        intialView();


        //  One controller
        oneController();
        //  Tow controller
        towController();

        //  three controller
        threeController();

//        four Controller
        fourController();

//        Number controller

        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonadd.setOnClickListener(this);
        buttonminus.setOnClickListener(this);
        buttonplus.setOnClickListener(this);
        buttondiv.setOnClickListener(this);
        buttonx.setOnClickListener(this);
        buttonC.setOnClickListener(this);



    }// Main Method

    private void fourController() {
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDisplay("4");
            }
        });
    }

    private void threeController() {
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDisplay("3");
            }
        });
    }

    private void towController() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDisplay("2");

            }
        });
    }

    private void oneController() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Show Display
                showDisplay("1");
            }
        });
    }

    private void showDisplay(String strDisplay) {
        StringBuilder stringBuilder = new StringBuilder();
        displayString = displayString + stringBuilder.append(strDisplay).toString();
        textView.setText(displayString);
    }

    private void intialView() {
        textView = getView().findViewById(R.id.txtdisplay);
        buttonC = getView().findViewById(R.id.btnc);
        button1 = getView().findViewById(R.id.btn1);
        button2 = getView().findViewById(R.id.btn2);
        button3 = getView().findViewById(R.id.btn3);
        button4 = getView().findViewById(R.id.btn4);
        button5 = getView().findViewById(R.id.btn5);
        button6 = getView().findViewById(R.id.btn6);
        button7 = getView().findViewById(R.id.btn7);
        button8 = getView().findViewById(R.id.btn8);
        button9 = getView().findViewById(R.id.btn9);
        button0 = getView().findViewById(R.id.btn0);
        buttonadd = getView().findViewById(R.id.btnadd);
        buttonminus = getView().findViewById(R.id.btnminus);
        buttonx = getView().findViewById(R.id.btnx);
        buttondiv = getView().findViewById(R.id.btndiv);
        buttonplus = getView().findViewById(R.id.btnplus);
    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarCalculate);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar()
                .setTitle("Calculate");
        ((MainActivity) getActivity()).getSupportActionBar()
                .setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);
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
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn5:
                showDisplay("5");
                break;

            case R.id.btn6:
                showDisplay("6");
                break;

                case R.id.btn7:
                showDisplay("7");
                break;

            case R.id.btn8:
                showDisplay("8");
                break;

                case R.id.btn9:
                showDisplay("9");
                break;

                case R.id.btn0:
                showDisplay("0");
                break;

                case R.id.btnc:
                    //   Clear Display
                    clearDisplay();
                break;

            case R.id.btnadd:

                addABoolean = true;

                     displayADouuble = Double.parseDouble(displayString);
                     if (num1ADouuble == 0){
                         num1ADouuble = displayADouuble;
                     }else {
                         num1ADouuble = num1ADouuble + displayADouuble;
                     }

                Log.d(tag, "num1 ==>" + num1ADouuble);

//                     showDisplay(Double.toString(num1ADouuble));


                     clearDisplay();
                     break;

            case  R.id.btnplus:
                displayADouuble = Double.parseDouble(displayString);

                Log.d(tag, "num1Adouble ==>" + num1ADouuble);
                Log.d(tag, "displayAdouble ==>" + displayADouuble);
                Log.d(tag, "addABoolean ==>" + addABoolean);

                if (num1ADouuble == 0) {
                    num1ADouuble = num1ADouuble + displayADouuble;
                    addABoolean = false;

                }
                textView.setText(Double.toString(num1ADouuble));
                break;

            case  R.id.btnminus:

                if (num1ADouuble == 0){
                    num1ADouuble = Double.parseDouble(displayString);
                } else {
                    num1ADouuble = num1ADouuble - Double.parseDouble(displayString);
                }

                Log.d(tag, "num1 atbtnminus ==>" + num1ADouuble);
                clearDisplay();

                break;

        }        //switch



    }

    private void clearDisplay() {
        textView.setText("");
        displayString = "";
    }
}       // Maim Class
