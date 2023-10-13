package com.edwardjones.cf23.sidekick.view.portfolio;

import com.edwardjones.cf23.sidekick.entity.Portfolio;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "portfolios/:id", layout = MainView.class)
@ViewController("cf23_Portfolio.detail")
@ViewDescriptor("portfolio-detail-view.xml")
@EditedEntityContainer("portfolioDc")
public class PortfolioDetailView extends StandardDetailView<Portfolio> {
}