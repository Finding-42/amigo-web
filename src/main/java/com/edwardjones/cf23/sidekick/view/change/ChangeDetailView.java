package com.edwardjones.cf23.sidekick.view.change;

import com.edwardjones.cf23.sidekick.entity.Change;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "changes/:id", layout = MainView.class)
@ViewController("cf23_Change.detail")
@ViewDescriptor("change-detail-view.xml")
@EditedEntityContainer("changeDc")
public class ChangeDetailView extends StandardDetailView<Change> {
}