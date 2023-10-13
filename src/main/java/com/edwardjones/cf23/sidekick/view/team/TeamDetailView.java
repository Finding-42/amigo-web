package com.edwardjones.cf23.sidekick.view.team;

import com.edwardjones.cf23.sidekick.entity.Team;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "teams/:id", layout = MainView.class)
@ViewController("cf23_Team.detail")
@ViewDescriptor("team-detail-view.xml")
@EditedEntityContainer("teamDc")
public class TeamDetailView extends StandardDetailView<Team> {
}