package com.edwardjones.cf23.sidekick.view.portfolio;

import com.edwardjones.cf23.sidekick.entity.Portfolio;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "portfolios", layout = MainView.class)
@ViewController("cf23_Portfolio.list")
@ViewDescriptor("portfolio-list-view.xml")
@LookupComponent("portfoliosDataGrid")
@DialogMode(width = "64em")
public class PortfolioListView extends StandardListView<Portfolio> {
}