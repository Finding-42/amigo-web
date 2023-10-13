package com.edwardjones.cf23.sidekick.view.situationalert;

import com.edwardjones.cf23.sidekick.entity.SituationAlert;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "situationAlerts/:id", layout = MainView.class)
@ViewController("cf23_SituationAlert.detail")
@ViewDescriptor("situation-alert-detail-view.xml")
@EditedEntityContainer("situationAlertDc")
public class SituationAlertDetailView extends StandardDetailView<SituationAlert> {
}