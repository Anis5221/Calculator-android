package com.example.classassets.ui.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.classassets.Database;
import com.example.classassets.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub,
            buttonMul, buttonDivision, buttonEqual, buttonDel, buttonDot, Remainder;
    TextView edt1, edt2;
    boolean Addition, Subtract, Multiplication, Division, mRemainder, decimal;
    double input1 = 0, input2 = 0;
    String str = "";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        Database db = new Database(getActivity());
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        button0 = root.findViewById(R.id.button0);
        button1 =  root.findViewById(R.id.button1);
        button2 =  root.findViewById(R.id.button2);
        button3 =  root.findViewById(R.id.button3);
        button4 =  root.findViewById(R.id.button4);
        button5 =  root.findViewById(R.id.button5);
        button6 =  root.findViewById(R.id.button6);
        button7 =  root.findViewById(R.id.button7);
        button8 =  root.findViewById(R.id.button8);
        button9 = root.findViewById(R.id.button9);
        buttonDot =  root.findViewById(R.id.buttonDot);
        buttonAdd =  root.findViewById(R.id.buttonadd);
        buttonSub =  root.findViewById(R.id.buttonsub);
        buttonMul =  root.findViewById(R.id.buttonmul);
        buttonDivision =  root.findViewById(R.id.buttondiv);
        Remainder =  root.findViewById(R.id.Remainder);
        buttonDel =  root.findViewById(R.id.buttonDel);
        buttonEqual = root.findViewById(R.id.buttoneql);


        edt1 =  root.findViewById(R.id.display);
        edt2 = root.findViewById(R.id.display2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Addition = true;
                    decimal = false;
                    str = edt1.getText()+"+";
                    edt2.setText(str);

                    edt1.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Subtract = true;
                    decimal = false;
                    str = edt1.getText() + "-";
                    edt2.setText(str);
                    edt1.setText(null);
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Multiplication = true;
                    decimal = false;
                    str = edt1.getText()+"*";
                    edt2.setText(str);
                    edt1.setText(null);
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    Division = true;
                    decimal = false;
                    str = edt1.getText()+"/";
                    edt2.setText(str);
                    edt1.setText(null);
                }
            }
        });

        Remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    mRemainder = true;
                    decimal = false;
                    str = edt1.getText()+"%";
                    edt2.setText(str);
                    edt1.setText(null);
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Addition || Subtract || Multiplication || Division || mRemainder) {
                    edt2.setText(null);
                    edt2.setText(str+edt1.getText());
                    input2 = Float.parseFloat(edt1.getText() + "");
                }

                if (Addition) {
                    double add = input1 + input2;
                    edt1.setText( add+ "");
                    String s1 = Double.toString(input1);
                    String s2 = Double.toString(input2);
                    String s3 = Double.toString(add);
                    Date today = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
                    String dateToStr = format.format(today);
                    insertHistory("Addition", s1,s2,s3,dateToStr);
                    Addition = false;
                }

                if (Subtract) {
                    double sub = input1 - input2;
                    edt1.setText( sub+ "");
                    String s1 = Double.toString(input1);
                    String s2 = Double.toString(input2);
                    String s3 = Double.toString(sub);
                    Date today = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
                    String dateToStr = format.format(today);
                    insertHistory("Subtraction", s1,s2,s3,dateToStr);
                    Subtract = false;
                }

                if (Multiplication) {
                    double mul = input1 * input2;
                    edt1.setText(mul + "");
                    String s1 = Double.toString(input1);
                    String s2 = Double.toString(input2);
                    String s3 = Double.toString(mul);
                    Date today = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
                    String dateToStr = format.format(today);
                    insertHistory("Multiplication", s1,s2,s3,dateToStr);
                    Multiplication = false;
                }

                if (Division) {
                    double div = input1 / input2;
                    edt1.setText(div + "");
                    String s1 = Double.toString(input1);
                    String s2 = Double.toString(input2);
                    String s3 = Double.toString(div);
                    Date today = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
                    String dateToStr = format.format(today);
                    insertHistory("Division", s1,s2,s3,dateToStr);
                    Division = false;
                }
                if (mRemainder) {
                    double rem = input1 % input2;
                    edt1.setText( rem+ "");
                    String s1 = Double.toString(input1);
                    String s2 = Double.toString(input2);
                    String s3 = Double.toString(rem);
                    Date today = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
                    String dateToStr = format.format(today);
                    insertHistory("Remainder", s1,s2,s3,dateToStr);
                    mRemainder = false;
                }
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                edt2.setText("");
                input1 = 0.0;
                input2 = 0.0;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edt1.setText(edt1.getText() + ".");
                decimal = true;


            }
        });



        return root;
    }

    private void insertHistory(String name, String input1, String input2, String result, String date){
        Database db = new Database(getActivity());
        db.insertContact(name, input1, input2, result, date);

//        Activity a = getActivity().getApplicationContext();
        Log.i("Test toast", "inside insert");
        Toast.makeText(getActivity().getApplicationContext(),"Saved!",Toast.LENGTH_LONG).show();
    }
}