package com.edwardjones.cf23.sidekick.view.action;

import com.edwardjones.cf23.sidekick.entity.Action;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "actions/:id", layout = MainView.class)
@ViewController("cf23_Action.detail")
@ViewDescriptor("action-detail-view.xml")
@EditedEntityContainer("actionDc")
public class ActionDetailView extends StandardDetailView<Action> {
}