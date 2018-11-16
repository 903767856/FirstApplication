package com.example.a90376.firstapplication;

//import android.app.ActionBar;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.Toolbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Fruit[] fruits={new Fruit("简介",R.drawable.qicai),new Fruit("加入我们",R.drawable.paobuji),
            new Fruit("健身课程",R.drawable.xunlian), new Fruit("俱乐部比赛",R.drawable.pingpang),
            new Fruit("寻找教练",R.drawable.jiaolian), new Fruit("形体训练班",R.drawable.xunlianban)};
    private List<Fruit> fruitList=new ArrayList<>();
    private FruitAdapter adapter;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Toast.makeText(this, "You clicked Settingd",Toast.LENGTH_SHORT).
                        show();
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);//显示滑动菜单
                break;
            default:
        }
        return true;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);//得到实例
        final NavigationView navView=(NavigationView)findViewById(R.id.nav_view);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null) {//显示导航按钮
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_caidan);
        }
        navView.setCheckedItem(R.id.castom);//设置默认选中
        //设置事件监听
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
          @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {//响应点击函数
              if(menuItem.getItemId()==R.id.castom)
              {
                  android.content.Intent i=new android.content.Intent(MainActivity.this,LoginActivity.class);
                  startActivity(i);
              }
               mDrawerLayout.closeDrawers();
                return true;
            }
       });

        initFruits();
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits()
    {
        fruitList.clear();
        for (int i=0;i<6;i++)
        {
            fruitList.add(fruits[i]);
        }
    }
}

