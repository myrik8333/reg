package com.example.alexandr.reg.shop;

import com.example.alexandr.reg.R;

public class CartActivity extends BaseActivity {

    @Override
    public int getViewId() {
        return R.layout.activity_cart;
    }

    @Override
    public void onCreateView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
}
