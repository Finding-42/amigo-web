package com.edwardjones.cf23.sidekick.view.transcript;

import com.edwardjones.cf23.sidekick.entity.Transcript;
import com.edwardjones.cf23.sidekick.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.textarea.JmixTextArea;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewComponent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "transcripts/:id", layout = MainView.class)
@ViewController("cf23_Transcript.detail")
@ViewDescriptor("transcript-detail-view.xml")
@EditedEntityContainer("transcriptDc")
public class TranscriptDetailView extends StandardDetailView<Transcript>
{
    @ViewComponent
    private JmixTextArea summaryField;
    @ViewComponent
    private JmixTextArea textField;
    
    @Subscribe
    public void init(InitEvent event)
    {
        summaryField.getStyle().set("font-weight", "bold");
        summaryField.getStyle().set("overflow", "auto");
        summaryField.getStyle().set("resize", "both");
        
        textField.getStyle().set("font-weight", "bold");
        textField.getStyle().set("overflow", "auto");
        textField.getStyle().set("resize", "both");
    }
}