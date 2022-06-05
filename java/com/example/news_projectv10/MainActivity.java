package com.example.news_projectv10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    /**
     * name of data to send in intent
     */
    public static final String dataname = "usedUrl";

    /**
     * app buttons
     */

    Button theNewYorkTimesBtn,
            cityambtn,
            guardianbtn,
            telegraphbtn,
            latimesbtn,
            smhbtn,
            unitedNationsbtn,
            bbcbtn,
            esbtn,
            sunbtn,
            dmbtn,
            nypbtn;


    /**
     * on create method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * database connect part
         */

        ////////projectDatabase dp = new projectDatabase(this);

        /**
         * first site
         * new yourk times
         */
        theNewYorkTimesBtn = findViewById(R.id.The_New_York_Times_btn);
        theNewYorkTimesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://www.nytimes.com/international");
                startActivity(intent);

                /**
                 * just for test
                 */


            }
        });

        /**
         * second site
         * cityam
         */
        cityambtn = findViewById(R.id.cityam_btn);
        cityambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://www.cityam.com/news");
                startActivity(intent);
            }
        });

        /**
         * 3 -
         * guardian
         */
        guardianbtn = findViewById(R.id.guardian_btn);
        guardianbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://www.theguardian.com/international");
                startActivity(intent);
            }
        });

        /**
         * 4-
         * telegraph
         */
        telegraphbtn = findViewById(R.id.telegraph_btn);
        telegraphbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://www.telegraph.co.uk");
                startActivity(intent);
            }
        });

        /**
         * 5-
         * latimes
         */
        latimesbtn = findViewById(R.id.latimes_btn);
        latimesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://www.latimes.com");
                startActivity(intent);
            }
        });

        /**
         * 6-
         * smh
         */
        smhbtn = findViewById(R.id.smh_btn);
        smhbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://www.smh.com.au");
                startActivity(intent);
            }
        });

        /**
         * 7-
         * United Nations
         */
        unitedNationsbtn = findViewById(R.id.United_Nations_btn);
        unitedNationsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://news.un.org/en");
                startActivity(intent);
            }
        });

        /**
         * 8-
         * bbc
         */
        bbcbtn = findViewById(R.id.bbc_btn);
        bbcbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://www.bbc.com/news");
                startActivity(intent);
            }
        });

        /**
         * 9-
         * es
         */
        esbtn = findViewById(R.id.es_btn);
        esbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://esnewsreporting.com");
                startActivity(intent);
            }
        });

        /**
         * 10-
         * sun
         */
        sunbtn = findViewById(R.id.sun_btn);
        sunbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://www.thesun.co.uk");
                startActivity(intent);
            }
        });


        /**
         * 11-
         * dm
         */
        dmbtn = findViewById(R.id.dm_btn);
        dmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://www.dmnews.com");
                startActivity(intent);
            }
        });

        /**
         * 12-
         * nyp
         */
        nypbtn = findViewById(R.id.nyp_btn);
        nypbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webViewPage.class);
                intent.putExtra(dataname,"https://nypost.com");
                startActivity(intent);
            }
        });

    }
}