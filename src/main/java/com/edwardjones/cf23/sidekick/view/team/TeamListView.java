package com.edwardjones.cf23.sidekick.view.team;

import com.edwardjones.cf23.sidekick.entity.Team;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "teams", layout = MainView.class)
@ViewController("cf23_Team.list")
@ViewDescriptor("team-list-view.xml")
@LookupComponent("teamsDataGrid")
@DialogMode(width = "64em")
public class TeamListView extends StandardListView<Team> {
}