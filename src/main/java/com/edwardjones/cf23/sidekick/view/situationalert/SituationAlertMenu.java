package com.edwardjones.cf23.sidekick.view.situationalert;

import com.edwardjones.cf23.sidekick.entity.SituationAlert;
import com.edwardjones.cf23.sidekick.view.main.MainView;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "situationAlertsMenu", layout = MainView.class)
@ViewController("cf23_SituationAlertMenu.list")
@ViewDescriptor("situation-alert-menu.xml")
@LookupComponent("situationAlertsDataGrid")
@DialogMode(width = "64em")
public class SituationAlertMenu extends StandardListView<SituationAlert>
{
    @Autowired
    private ViewNavigators viewNavigators;
    
    private void navigateToEditEntity(SituationAlert entity)
    {
        viewNavigators.detailView(SituationAlert.class)
                      .editEntity(entity)
                      .withViewClass(SituationAlertMenuDetailView.class)
                      .navigate();
    }
    
    @Subscribe("situationAlertsDataGrid")
    public void onSituationAlertsDataGridItemDoubleClick(final ItemDoubleClickEvent<SituationAlert> event)
    {
        navigateToEditEntity(event.getItem());
    }
}