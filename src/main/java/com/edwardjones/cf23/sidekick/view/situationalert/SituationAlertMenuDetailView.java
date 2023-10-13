package com.edwardjones.cf23.sidekick.view.situationalert;

import com.edwardjones.cf23.sidekick.entity.Participant;
import com.edwardjones.cf23.sidekick.entity.SituationAlert;
import com.edwardjones.cf23.sidekick.summary.BedrockModel;
import com.edwardjones.cf23.sidekick.summary.BedrockSummaryService;
import com.edwardjones.cf23.sidekick.view.main.MainView;
import com.edwardjones.cf23.sidekick.view.participant.ParticipantDetailView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@Route(value = "situationAlertsMenuDetail/:id", layout = MainView.class)
@ViewController("cf23_SituationAlertMenu.detail")
@ViewDescriptor("situation-alert-menu-detail-view.xml")
@EditedEntityContainer("situationAlertDc")
public class SituationAlertMenuDetailView extends StandardDetailView<SituationAlert>
{
    @Autowired
    private BedrockSummaryService bedrockSummaryService;
    @Autowired
    private DialogWindows dialogWindows;
    
    @Subscribe("participantsDataGrid")
    public void onParticipantsDataGridItemDoubleClick(final ItemDoubleClickEvent<Participant> event)
    {
        dialogWindows.detail(this, Participant.class)
                     .withViewClass(ParticipantDetailView.class)
                     .editEntity(event.getItem())
                     .open();
    }
    
    @Subscribe("transcribeButton")
    public void onTranscribeButtonClick(final ClickEvent<JmixButton> event)
    {
        Mono<String> stringMono = bedrockSummaryService.summarizeText(getEditedEntity().getTranscript().getText(),
                                                                      BedrockModel.COHERE_COMMAND);
        stringMono.subscribe(s -> getEditedEntity().getTranscript().setSummary(s));
    }
}