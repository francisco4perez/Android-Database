package cl.onecrowd.alfredo.aqualert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cl.onecrowd.alfredo.aqualert.resource.dbFlow.MobUser;

public class MainActivity extends AppCompatActivity {

    EditText name_txt, age_txt;
    Button save_btn, view_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_txt = (EditText) findViewById(R.id.name_editText);
        age_txt = (EditText) findViewById(R.id.age_editText);
        save_btn = (Button) findViewById(R.id.save_button);
        view_btn = (Button) findViewById(R.id.view_button);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameTxtContent = name_txt.getText().toString();
                String ageTxtContent = age_txt.getText().toString();

                if(nameTxtContent.trim().isEmpty() || ageTxtContent.trim().isEmpty()){

                    if(nameTxtContent.trim().isEmpty()){
                        name_txt.setError("Required!");
                    }
                    if(ageTxtContent.trim().isEmpty()){
                        age_txt.setError("Required!");
                    }
                }
                else {
                    MobUser user = new MobUser();
                    user.insertData(nameTxtContent,Integer.parseInt(ageTxtContent));

                    Boolean chksave = user.save();

                    Toast.makeText(MainActivity.this, "Save Checking:\n"+chksave,Toast.LENGTH_SHORT).show();
                }


            }
        });

        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_users = new Intent(getApplicationContext(), DatabaseView_activity.class);
                startActivity(view_users);
            }
        });


    }
}
