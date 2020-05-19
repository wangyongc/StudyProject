package com.example.studyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.studyproject.Serialize.SerializeDemo;
import com.example.studyproject.component.ComponentActivity;
import com.example.studyproject.design.DesignPatternActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 组件化
     * */
    public void onClickComponent(View view) {
        ComponentActivity.start(this);
    }

    /**
     * 设计模式
     * */
    public void onClickDesign(View view) {
        DesignPatternActivity.start(this);
    }

    /**
     * 算法
     * */
    public void onClickArithmetic(View view) {
        //ArithmeticDemo
    }

    /**
     * 序列化
     * */
    public void onClickSerialize(View view) {
        SerializeDemo.start(this);
    }
}
