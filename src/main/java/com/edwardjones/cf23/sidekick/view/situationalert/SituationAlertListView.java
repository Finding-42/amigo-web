package com.edwardjones.cf23.sidekick.view.situationalert;

import com.edwardjones.cf23.sidekick.entity.SituationAlert;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "situationAlerts", layout = MainView.class)
@ViewController("cf23_SituationAlert.list")
@ViewDescriptor("situation-alert-list-view.xml")
@LookupComponent("situationAlertsDataGrid")
@DialogMode(width = "64em")
public class SituationAlertListView extends StandardListView<SituationAlert> {
}