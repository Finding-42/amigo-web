package com.edwardjones.cf23.sidekick.view.product;

import com.edwardjones.cf23.sidekick.entity.Product;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "products/:id", layout = MainView.class)
@ViewController("cf23_Product.detail")
@ViewDescriptor("product-detail-view.xml")
@EditedEntityContainer("productDc")
public class ProductDetailView extends StandardDetailView<Product> {
}