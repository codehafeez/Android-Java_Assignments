package com.example.abdulhafeez.apphome;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

//==============================================================================================
//==============================================================================================
//==============================================================================================
    Menu mOptionsMenu;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mOptionsMenu = menu;
        getMenuInflater().inflate(R.menu.menu_home, menu);
        menu.getItem(0).setVisible(true);
        menu.getItem(1).setVisible(true);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settingMenu_id) { Toast.makeText(getApplicationContext(), "Setting Working", Toast.LENGTH_LONG).show(); }
        return super.onOptionsItemSelected(item);
    }
//==============================================================================================
//==============================================================================================
//==============================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpaper);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(MyFragment.newInstance("name_tab1"), "Home");
        adapter.addFragment(MyFragment.newInstance("name_tab2"), "Groups");
        adapter.addFragment(MyFragment.newInstance("name_tab3"), "Followers");
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.group);
        tabLayout.getTabAt(2).setIcon(R.drawable.follower);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                switch (tab.getPosition())
                {
                    case 0: tab.setIcon(R.drawable.home_selected);
                        mOptionsMenu.getItem(0).setVisible(false);
                        mOptionsMenu.getItem(1).setVisible(false);
                        String o1 = mOptionsMenu.getItem(0).toString();
                        String o2 = mOptionsMenu.getItem(1).toString();
                        String o3 = mOptionsMenu.getItem(2).toString();
                        Toast.makeText(getApplicationContext(), "Size: "+mOptionsMenu.size()+"\nItem1: "+o1+" \nItem2: "+o2+" \nItem3: "+o3, Toast.LENGTH_LONG).show();

                        tabLayout.getTabAt(1).setIcon(R.drawable.group);
                        tabLayout.getTabAt(2).setIcon(R.drawable.follower);
                        break;
                    case 1: tab.setIcon(R.drawable.group_selected);
                        mOptionsMenu.getItem(0).setVisible(true);
                        mOptionsMenu.getItem(1).setVisible(true);
                        tabLayout.getTabAt(0).setIcon(R.drawable.home);
                        tabLayout.getTabAt(2).setIcon(R.drawable.follower);
                        break;
                    case 2: tab.setIcon(R.drawable.follower_selected);
                        tabLayout.getTabAt(0).setIcon(R.drawable.home);
                        tabLayout.getTabAt(1).setIcon(R.drawable.group);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    class ViewPageAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPageAdapter(FragmentManager manager) { super(manager); }

        @Override
        public Fragment getItem(int position) { return mFragmentList.get(position); }
        @Override
        public int getCount() { return mFragmentList.size(); }
        @Override
        public CharSequence getPageTitle(int position){ return mFragmentTitleList.get(position); }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
    }

    public static class MyFragment extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
            View view = null;
            if(getArguments().getString("msg").equals("name_tab1")){ view = inflater.inflate(R.layout.fragment_home, container, false); }
            else if(getArguments().getString("msg").equals("name_tab2")){ view = inflater.inflate(R.layout.fragment_group, container, false); }
            else if(getArguments().getString("msg").equals("name_tab3")){ view = inflater.inflate(R.layout.fragment_follower, container, false); }
            return view;
        }

        public static MyFragment newInstance(String text){
            MyFragment f = new MyFragment();
            Bundle b = new Bundle();
            b.putString("msg", text);
            f.setArguments(b);
            return f;
        }
    }




    public void funShow(View view){
        TextView tv = (TextView) findViewById(R.id.helloWorld_id);
        tv.setText("Hafeez - Button Working");
    }
}
