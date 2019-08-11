package com.example.alexandr.reg.shop;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.math.BigDecimal;

import butterknife.BindView;
import com.example.alexandr.reg.R;

public class ProductFragment extends BaseFragment implements ProductRecyclerAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public int getViewId() {
        return R.layout.fragment_product;
    }

    @Override
    public void onViewCreated(View view) {
        ProductRecyclerAdapter productRecyclerAdapter = new ProductRecyclerAdapter(context, ProductsHelper.getProductsList());
        productRecyclerAdapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(productRecyclerAdapter);
    }

    @Override
    public void onItemClick(ProductModel productModel) {
        ProductEntityModel product = new ProductEntityModel();
        product.setId(productModel.getId());
        product.setName(productModel.getTitle());
        product.setDescription(productModel.getDescription());
        product.setPrice(BigDecimal.valueOf(productModel.getPrice()));
        product.setImage(productModel.getImage());

        CartEntity cart = CartHelper.getCart();
        cart.add(product, 1);

        Intent intent = new Intent(context, CartActivity.class);
        startActivity(intent);

        getActivity().invalidateOptionsMenu();
    }
}
