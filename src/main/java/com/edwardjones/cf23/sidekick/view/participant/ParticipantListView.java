package com.edwardjones.cf23.sidekick.view.participant;

import com.edwardjones.cf23.sidekick.entity.Participant;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "participants", layout = MainView.class)
@ViewController("cf23_Participant.list")
@ViewDescriptor("participant-list-view.xml")
@LookupComponent("participantsDataGrid")
@DialogMode(width = "64em")
public class ParticipantListView extends StandardListView<Participant> {
}