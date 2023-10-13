package com.edwardjones.cf23.sidekick.view.participant;

import com.edwardjones.cf23.sidekick.entity.Participant;

import com.edwardjones.cf23.sidekick.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "participants/:id", layout = MainView.class)
@ViewController("cf23_Participant.detail")
@ViewDescriptor("participant-detail-view.xml")
@EditedEntityContainer("participantDc")
public class ParticipantDetailView extends StandardDetailView<Participant> {
}