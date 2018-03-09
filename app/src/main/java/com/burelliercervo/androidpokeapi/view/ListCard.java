package com.burelliercervo.androidpokeapi.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.burelliercervo.androidpokeapi.adapter.MyListAdapter;
import com.burelliercervo.androidpokeapi.service.ListPokemonsTask;
import com.burelliercervo.androidpokeapi.model.Pokemon;
import com.burelliercervo.androidpokeapi.R;

import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class ListCard extends AppCompatActivity {

    MyListAdapter myListAdapter;
    private ListView mListView;
    private List<Pokemon> pokemons = new ArrayList<>();
    private int offset = 0;
    private ListPokemonsTask listPokemonsTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_card);
        initComponent();

        this.listPokemonsTask.execute("1");

        Button btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }

    public void initComponent(){
        this.listPokemonsTask = new ListPokemonsTask();
    }

    public void afficherPokemons(List<Pokemon> PokemonsList) {

        myListAdapter = new MyListAdapter(PokemonsList, this);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(myListAdapter);
        myListAdapter.notifyDataSetChanged();
        Toast.makeText(this,"nombre de Pokemon : "+PokemonsList.size(),Toast.LENGTH_SHORT).show();

        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = mListView.getItemAtPosition(position);
                Log.d("TAG", "onItemClick: " + o);
                Intent myIntent = new Intent(ListCard.this, DetailCard.class);
                ListCard.this.startActivity(myIntent);
                myIntent.putExtra(EXTRA_MESSAGE, o.toString());
                startActivityForResult(myIntent, 0);
            }
        });
    }
}




