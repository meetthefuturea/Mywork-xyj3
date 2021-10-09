package com.example.mywork_xyj;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment weixinfragment = new weixin();
    private Fragment tongxunlufragment = new tongxunlu();
    private Fragment faxianfragment = new faxian();
    private Fragment wofragment = new wo();
    private  FragmentManager fragmentManager;
    private LinearLayout linearLayout_weixin,linearLayout_tongxunlu,linearLayout_faxian,linearLayout_wo;
    private ImageButton weixin_button,tongxunlu_button,faxian_button,wo_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        linearLayout_weixin=findViewById(R.id.weixin);
        linearLayout_tongxunlu=findViewById(R.id.tongxunlu);
        linearLayout_faxian=findViewById(R.id.faxian);
        linearLayout_wo=findViewById(R.id.wo);

        weixin_button = findViewById(R.id.weixin1);
        tongxunlu_button = findViewById(R.id.tongxunlu1);
        faxian_button = findViewById(R.id.faxian1);
        wo_button = findViewById(R.id.wo1);

        linearLayout_weixin.setOnClickListener(this);
        linearLayout_tongxunlu.setOnClickListener(this);
        linearLayout_faxian.setOnClickListener(this);
        linearLayout_wo.setOnClickListener(this);
        init_Fragment();
    }

    private void init_Fragment() {
        fragmentManager =getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.Frame_container,weixinfragment);
        fragmentTransaction.add(R.id.Frame_container,tongxunlufragment);
        fragmentTransaction.add(R.id.Frame_container,faxianfragment);
        fragmentTransaction.add(R.id.Frame_container,wofragment);
        fragmentTransaction.commit();
        showFragment(0);
        weixin_button.setImageResource(R.drawable.weixin);
    }
    private void hide_Fragment(FragmentTransaction fragmentTransaction)
    {
        fragmentTransaction.hide(weixinfragment);
        fragmentTransaction.hide(tongxunlufragment);
        fragmentTransaction.hide(faxianfragment);
        fragmentTransaction.hide(wofragment);
    }

    public void onClick(View view) {
        resetButton();

        switch (view.getId()) {
            case R.id.weixin:
                showFragment(0);
                weixin_button.setImageResource(R.drawable.weixin);
                break;
            case R.id.tongxunlu:
                showFragment(1);
                tongxunlu_button.setImageResource(R.drawable.tongxunlu);
                break;
            case R.id.faxian:
                showFragment(2);
                faxian_button.setImageResource(R.drawable.faxian);
                break;
            case R.id.wo:

                showFragment(3);
                wo_button.setImageResource(R.drawable.wo);
                break;
            default:
                break;
        }
    }
        private void showFragment(int i)
        {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hide_Fragment(fragmentTransaction);
        switch (i)
        {
            case 0:
                fragmentTransaction.show(weixinfragment);
                break;
            case 1:
                fragmentTransaction.show(tongxunlufragment);
                break;
            case 2:
                fragmentTransaction.show(faxianfragment);
                break;
            case 3:
                fragmentTransaction.show(wofragment);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }
        private void resetButton()
    {
        weixin_button.setImageResource(R.drawable.weixin);
        tongxunlu_button.setImageResource(R.drawable.tongxunlu);
        faxian_button.setImageResource(R.drawable.faxian);
        wo_button.setImageResource(R.drawable.wo);
    }
}