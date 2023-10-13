package com.edwardjones.cf23.sidekick.view.page;

import com.edwardjones.cf23.sidekick.entity.Page;
import com.edwardjones.cf23.sidekick.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.datetimepicker.TypedDateTimePicker;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewComponent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import java.time.Duration;
import java.time.LocalDateTime;

@Route(value = "pages/:id", layout = MainView.class)
@ViewController("cf23_Page.detail")
@ViewDescriptor("page-detail-view.xml")
@EditedEntityContainer("pageDc")
public class PageDetailView extends StandardDetailView<Page>
{
    @ViewComponent
    private TypedDateTimePicker<LocalDateTime> firstPagedOnField;
    @ViewComponent
    private TypedDateTimePicker<LocalDateTime> lastPagedOnField;
    @ViewComponent
    private TypedDateTimePicker<LocalDateTime> respondedOnField;
    
    @Subscribe
    public void onInit(InitEvent event)
    {
        firstPagedOnField.setStep(Duration.ofMinutes(15));
        lastPagedOnField.setStep(Duration.ofMinutes(15));
        respondedOnField.setStep(Duration.ofMinutes(15));
    }
}