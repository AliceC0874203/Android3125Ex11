package com.example.android_3125_ex11;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.android_3125_ex11.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<ImageObj> selectedImages = new ArrayList<>();
    ArrayList<ImageObj> validImageList = new ArrayList<>();
    ArrayList<ImageObj> images = new ArrayList<>();
    GridViewCustomAdapter gridViewCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        images.add(new ImageObj(R.drawable.img1, true));
        images.add(new ImageObj(R.drawable.img2, true));
        images.add(new ImageObj(R.drawable.img3, true));
        images.add(new ImageObj(R.drawable.img4, true));
        images.add(new ImageObj(R.drawable.img5, false));
        images.add(new ImageObj(R.drawable.img6, false));
        images.add(new ImageObj(R.drawable.img7, false));
        images.add(new ImageObj(R.drawable.img8, false));
        images.add(new ImageObj(R.drawable.img9, false));

        for (ImageObj image : images) {
            if (image.isTrafficLight() == true) {
                validImageList.add(image);
            }
        }

        gridViewCustomAdapter = new GridViewCustomAdapter(getApplicationContext(), images);
        binding.gridLayout.setAdapter(gridViewCustomAdapter);
        gridViewCustomAdapter.notifyDataSetChanged();

        binding.gridLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageObj selectedItem = (ImageObj) parent.getItemAtPosition(position);
                selectedImages.add(selectedItem);
            }
        });

        binding.btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(images);
                gridViewCustomAdapter.notifyDataSetChanged();
                binding.checkbox.setChecked(false);
                binding.btnVerify.setVisibility(View.INVISIBLE);
                selectedImages.removeAll(selectedImages);
            }
        });

        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = checkValidation();
                if (valid) {
                    Toast.makeText(getApplicationContext(), "Verified", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Not Verified", Toast.LENGTH_SHORT).show();
                }
                selectedImages.removeAll(selectedImages);
            }
        });

        binding.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                if (checked) {
                    binding.btnVerify.setVisibility(View.VISIBLE);
                } else {
                    binding.btnVerify.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private boolean checkValidation() {
        if (selectedImages.size() != validImageList.size()) {
            return false;
        } else {

            for (ImageObj image : selectedImages) {
                if (image.isTrafficLight() == false) {
                    return false;
                }
            }
            for (int i = 0; i < selectedImages.size(); i++) {
                if (!validImageList.contains(selectedImages.get(i))) {
                    return false;
                } else {
                    continue;
                }
            }
            return true;
        }
    }
}