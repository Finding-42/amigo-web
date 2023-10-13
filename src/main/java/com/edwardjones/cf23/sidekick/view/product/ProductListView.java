package com.edwardjones.cf23.sidekick.view.product;

import com.edwardjones.cf23.sidekick.entity.Product;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "products", layout = MainView.class)
@ViewController("cf23_Product.list")
@ViewDescriptor("product-list-view.xml")
@LookupComponent("productsDataGrid")
@DialogMode(width = "64em")
public class ProductListView extends StandardListView<Product> {
}