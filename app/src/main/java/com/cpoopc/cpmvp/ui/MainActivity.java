package com.cpoopc.cpmvp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.cpoopc.cpmvp.R;
import com.cpoopc.cpmvp.mvp.BaseMVPAdapter;
import com.cpoopc.cpmvp.model.ItemBean;
import com.cpoopc.cpmvp.ui.widget.MvpTextItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView listView = (ListView) findViewById(R.id.listView);
        BaseMVPAdapter<ItemBean, MvpTextItem<ItemBean>> baseMVPAdapter = new BaseMVPAdapter<ItemBean, MvpTextItem<ItemBean>>(new MvpTextItem.MvpTextItemPresenter2()) {
            @Override
            protected MvpTextItem<ItemBean> createView() {
                MvpTextItem<ItemBean> mvpTextItem = new MvpTextItem<>(mContext);
                mvpTextItem.setPresenter(getPresenter());
                return mvpTextItem;
            }
        };
        List<ItemBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new ItemBean("哈哈" + i));
        }
        baseMVPAdapter.setItems(list);
        listView.setAdapter(baseMVPAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
