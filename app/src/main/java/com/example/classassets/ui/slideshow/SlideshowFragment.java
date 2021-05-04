package com.example.classassets.ui.slideshow;

import android.os.Bundle;
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
import android.database.Cursor;
import com.example.classassets.Database;
import com.example.classassets.MainActivity;
import com.example.classassets.R;
import com.example.classassets.ui.home.HomeFragment;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    TextView name ;
    TextView input1;
    TextView input2;
    TextView resultView;
    TextView date;
    int Value = -1;
    int id_To_Update = 0;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
//        final TextView textView = root.findViewById(R.id.text_slideshow);
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        name = (TextView) root.findViewById(R.id.editTextName);
        input1 = (TextView) root.findViewById(R.id.editTextPhone);
        input2 = (TextView) root.findViewById(R.id.editTextEmail);
        resultView = (TextView) root.findViewById(R.id.editTextResult);
        date = (TextView) root.findViewById(R.id.editTextDate);
        Bundle extras = this.getArguments();


        Database mydb = new Database(getActivity());

        if(extras != null){
            int Value = extras.getInt("id");
            if(Value >0){
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();
                String nam = rs.getString(rs.getColumnIndex(Database.CONTACTS_COLUMN_NAME));
                String phon = rs.getString(rs.getColumnIndex(Database.CONTACTS_COLUMN_INPUT1));
                String emai = rs.getString(rs.getColumnIndex(Database.CONTACTS_COLUMN_INPUT2));
                String result = rs.getString(rs.getColumnIndex(Database.CONTACTS_COLUMN_RESULT));
                String dbDate = rs.getString(rs.getColumnIndex(Database.CONTACTS_COLUMN_DATE));


                if (!rs.isClosed())  {
                    rs.close();
                }
                name.setText((CharSequence)nam);
                input1.setText((CharSequence)emai);
                input2.setText((CharSequence)phon);
                resultView.setText((CharSequence)result);
                date.setText((CharSequence)dbDate);
            }
        }

        Button saveButton = (Button) root.findViewById(R.id.dataSave);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(extras != null) {

                     Value = extras.getInt("id");
                }
                if(Value>0){
                    if(mydb.updateContact(id_To_Update,name.getText().toString(),
                            input1.getText().toString(), input2.getText().toString(), resultView.getText().toString(),date.getText().toString())){
                        Toast.makeText(getActivity().getApplicationContext(),"Updated!",Toast.LENGTH_SHORT).show();
                        HomeFragment h = new HomeFragment();
                        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, h).commit();

                    } else{
                        Toast.makeText(getActivity(), "not Updated", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    if(mydb.insertContact(name.getText().toString(), input1.getText().toString(), input2.getText().toString(), resultView.getText().toString(),date.getText().toString())){
                        Toast.makeText(getActivity(),"Data Saved",Toast.LENGTH_SHORT).show();
                        HomeFragment h = new HomeFragment();
                        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, h).commit();
                    } else{
                        Toast.makeText(getActivity(), "not done",
                                Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

        Button deleteRecord = (Button) root.findViewById(R.id.dataDelete);
        deleteRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(extras != null){
                    int id = extras.getInt("id");
                    mydb.deleteContact(id);
                    HomeFragment h = new HomeFragment();
                    getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, h).commit();
                }

            }
        });

        return root;
    }


}