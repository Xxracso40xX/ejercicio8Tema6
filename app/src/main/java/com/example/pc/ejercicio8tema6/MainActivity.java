package com.example.pc.ejercicio8tema6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static final int FLIP_VERTICAL = 1;
    static final int FLIP_HORIZONTAL = 2;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = findViewById(R.id.imageView);
        registerForContextMenu(imagen);
    }
    private Bitmap flipImage(Bitmap src, int type) {
        Matrix matrix = new Matrix();
        if (type == FLIP_VERTICAL) {
            // y = y * -1
            matrix.preScale(1.0f, -1.0f);
        } else if (type == FLIP_HORIZONTAL) {
            // x = x * -1
            matrix.preScale(-1.0f, 1.0f);
        }
        return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.CtxOpc1:
                imagen.setImageBitmap(flipImage(BitmapFactory.decodeResource(getResources(), R.drawable.imagen),FLIP_VERTICAL));
                break;
            case R.id.CtxOpc2:
                imagen.setImageBitmap(flipImage(BitmapFactory.decodeResource(getResources(), R.drawable.imagen),FLIP_HORIZONTAL));
                break;
        }
        return true;
    }
}
