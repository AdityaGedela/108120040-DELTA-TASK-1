package com.example.finaltask1app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class mainscreen extends AppCompatActivity {
    TextView txtheading,txtqstn;
    CheckBox check1,check2,check3,check4;
    Button btn,btnrfrsh;
    int count=0;
    private static final String TAG = "mainscreen";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen3);
        btnclick();
        //mainscreen.this.finish();
        //System.exit(0);
    }
    public void btnclick(){
        txtheading = findViewById(R.id.textView_heading);
        txtqstn = findViewById(R.id.textView_question);
        check1 = findViewById(R.id.checkBox1);
        check2 = findViewById(R.id.checkBox2);
        check3 = findViewById(R.id.checkBox3);
        check4 = findViewById(R.id.checkBox4);
        btn = findViewById(R.id.button);

        reccursion();
    }

    public void reccursion(){


        String answer;

        answer = questionframing();

        returnarray(answer);

    }

    public String questionframing(){

        int year,month,date,ymax=2999,ymin=1899,mmax=12,mmin=1,dmax,dmin=1;
        year = (int)(Math.random()*(ymax-ymin+1)+ymin);
        month = (int)(Math.random()*(mmax-mmin+1)+mmin);
        if(month==2&&year%4==0)
        {
            dmax = 29;

        }
        else if(month%2==0&&month!=2)
        {
            if(month<8)
            {
                dmax=30;
            }
            else
            {
                dmax=31;
            }
        }
        else if(month==2&&year%4!=0)
        {
            dmax=28;
        }
        else
        {
            if(month<8)
            {
                dmax=31;
            }
            else
            {
                dmax=30;
            }
        }
        date = (int)(Math.random()*(dmax-dmin+1)+dmin);

        txtqstn.setText("Guess the day of the Date "+ date+"-"+month+"-"+year+"");
        String answer;
        answer=answerfinding(date,month,year);

        //Toast.makeText(mainscreen.this,answer,Toast.LENGTH_SHORT).show();


        return answer;




    }
    public String answerfinding(int date,int month,int year){

        if(month==1)
        {
            month=13;
            year--;
        }
        if(month==2)
        {
            month=14;
            year--;
        }
        int q = date;
        int m = month;
        int k = year % 100;
        int j = year / 100;
        String answer;
        int h = q + 13*(m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        h = h % 7;
        switch (h)
        {
            case 0 : answer="Saturday"; break;
            case 1 : answer="Sunday"; break;
            case 2 : answer="Monday"; break;
            case 3 : answer="Tuesday"; break;
            case 4 : answer="Wednessday"; break;
            case 5 : answer="Thursday"; break;
            case 6 : answer="Friday"; break;
            default:answer="false";break;

        }


        return answer;

    }

    public void returnarray(String a) {



        String[] names = getResources().getStringArray(R.array.dow);
        Random rdn = new Random();
        int n1 = rdn.nextInt(names.length - 1);
        int n2 = rdn.nextInt(names.length - 1);
        int n3 = rdn.nextInt(names.length - 1);

        //int n4 = rdn.nextInt(names.length-1);
        String[] checklist = new String[4];

        checklist[0] = names[n1];
        checklist[1] = names[n2];
        checklist[2] = names[n3];
        checklist[3] = a;

        if(names[n1].equals(names[n2])||names[n1].equals(names[n3])||names[n1].equals(a)||names[n2].equals(names[n3])||names[n2].equals(a)||names[n3].equals(a))
        {
            returnarray(a);
        }
        else
        {
            checklistfinal2(checklist,a);

        }
    }

    public void checklistfinal2(String[] finallist,String a){

        int max=3,min=0;
        int f1= (int)(Math.random()*(max-min+1)+min);
        int f2= (int)(Math.random()*(max-min+1)+min);
        int f3= (int)(Math.random()*(max-min+1)+min);
        int f4= (int)(Math.random()*(max-min+1)+min);
        if(f1==f2||f1==f3||f1==f4||f2==f3||f2==f4||f3==f4)
        {
            checklistfinal2(finallist,a);

        }
        else
        {
            check1.setText(finallist[f1]);
            check2.setText(finallist[f2]);
            check3.setText(finallist[f3]);
            check4.setText(finallist[f4]);

            oneoptioncheck();
            ConstraintLayout layoutbckgrnd =  findViewById(R.id.ConstraintLayout);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(check1.isChecked()||check2.isChecked()||check3.isChecked()||check4.isChecked())
                    {
                        if((finallist[f1].equals(a)&&check1.isChecked()==true)||(finallist[f2].equals(a)&&check2.isChecked()==true)||(finallist[f3].equals(a)&&check3.isChecked()==true)||(finallist[f4].equals(a)&&check4.isChecked()==true))
                        {

                            //txtheading.setText("HELLO"+"");

                            check1.setChecked(false);
                            check2.setChecked(false);
                            check3.setChecked(false);
                            check4.setChecked(false);
                            Log.d(TAG, "onClick: HERE");
                            //layoutbckgrnd.setBackgroundResource(R.color.lightpink);
                            count++;
                            //Toast.makeText(mainscreen.this,count+"",Toast.LENGTH_SHORT).show();
                            btnclick();
                        }
                        else
                        {
                          //layoutbckgrnd.setBackgroundColor(Color.RED);
                            //txtheading.setText("INCORRECT"+"");
                            Intent endapp = new Intent(mainscreen.this,wrongoption.class);
                            endapp.putExtra("mycount",count);
                            startActivity(endapp);
                        }
                    }

                    else
                    {
                        Toast.makeText(mainscreen.this,"SELECT ONE OPTION",Toast.LENGTH_SHORT).show();
                    }


                }

            });
        }
    }

    public void oneoptioncheck(){

        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b)
                {
                    check2.setChecked(false);
                    check3.setChecked(false);
                    check4.setChecked(false);
                }

            }
        });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b)
                {
                    check1.setChecked(false);
                    check3.setChecked(false);
                    check4.setChecked(false);
                }

            }
        });
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b)
                {
                    check2.setChecked(false);
                    check1.setChecked(false);
                    check4.setChecked(false);
                }

            }
        });
        check4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b)
                {
                    check2.setChecked(false);
                    check3.setChecked(false);
                    check1.setChecked(false);
                }

            }
        });

    }
}