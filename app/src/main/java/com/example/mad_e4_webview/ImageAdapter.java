/**
 * This class contains methods for custom image adapter to handle images in welcome screen
 * MAD-A1
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */

package com.example.mad_e4_webview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public Integer[] images = {R.drawable.monke1, R.drawable.monke2, R.drawable.monke3, R.drawable.monke4, R.drawable.monke5, R.drawable.monke6};

    public ImageAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;

        if (view == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(240, 240)); // Adjust the size as needed
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(8, 8, 8, 8); // Add padding between images
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(images[i]);
        return imageView;
    }
}
