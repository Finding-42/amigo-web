package com.edwardjones.cf23.sidekick.view.user;

import com.edwardjones.cf23.sidekick.entity.User;
import com.edwardjones.cf23.sidekick.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "users", layout = MainView.class)
@ViewController("cf23_User.list")
@ViewDescriptor("user-list-view.xml")
@LookupComponent("usersDataGrid")
@DialogMode(width = "64em")
public class UserListView extends StandardListView<User> {
}