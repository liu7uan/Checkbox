package com.aq.nlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox eatBox;
    private CheckBox sleepBox;
    private CheckBox dotaBox;
    private CheckBox actlBox;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

//        OnCheckedChangeListener方法是用
        eatBox=(CheckBox)findViewById(R.id.eat);
        sleepBox=(CheckBox)findViewById(R.id.sleep);
        dotaBox=(CheckBox)findViewById(R.id.dota);
        actlBox=(CheckBox)findViewById(R.id.actl);
        Cbltr cbltr=new Cbltr();
        actlBox.setOnCheckedChangeListener(cbltr);

        CheckBoxlistener cbl=new CheckBoxlistener();
        eatBox.setOnCheckedChangeListener(cbl);
        sleepBox.setOnCheckedChangeListener(cbl);
        dotaBox.setOnCheckedChangeListener(cbl);

        onBoxClickListener onbl=new onBoxClickListener();
            eatBox.setOnClickListener(onbl);
            sleepBox.setOnClickListener(onbl);
            dotaBox.setOnClickListener(onbl);
    }

    class Cbltr implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.getId()==R.id.actl) {
                check(isChecked);
            }

        }
    }
    //公用方法
    public void check(boolean isChecked){
        if (!isChecked) {
            eatBox.setChecked(false);
            sleepBox.setChecked(false);
            dotaBox.setChecked(false);
            actlBox.setText("全选");
            System.out.println("eatBox,sleepBox,dotaBox no checked");
        } else if (isChecked) {
            eatBox.setChecked(true);
            sleepBox.setChecked(true);
            dotaBox.setChecked(true);
            actlBox.setText("取消");
            System.out.println("eatBox,sleepBox,dotaBox is checked");
        }
    }
    class CheckBoxlistener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView.getId()==R.id.eat){
                System.out.println("eat");
            }else if(buttonView.getId()==R.id.sleep){
                System.out.println("sleep");
            }else if(buttonView.getId()==R.id.dota){
                System.out.println("dota");
            }
            if (isChecked){
                System.out.println("checked");
            }else{
                System.out.println("no checked");
            }
        }
    }
//        OnClickListener 使用方法
    class onBoxClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
        System.out.println("Checkbox is click"+v.getId());
            CheckBox box=(CheckBox)v;
            if(((CheckBox) v).isChecked()){
                System.out.println("Checked");
            }else{
                System.out.println("NO Checked");
            }
        }
    }
}
