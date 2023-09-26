package com.example.application.views;

import com.example.application.security.SecurityService;
import com.example.application.views.list.ListView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;


public class MainLayout extends AppLayout {

    private final SecurityService service;

    public MainLayout(SecurityService service) {
        this.service = service;
        createHeader();
        createDrawer();
    }

    private void createDrawer() {
        final var listView = new RouterLink("List", ListView.class);
        final var dashboardView = new RouterLink("Dashboard", DashboardView.class);
        listView.setHighlightCondition(HighlightConditions.sameLocation());
        addToDrawer(new VerticalLayout(
                        listView,
                        dashboardView
                )
        );
    }

    private void createHeader() {
        final var logo = new H1("Vaadin CRM");
        logo.addClassNames("text-l", "m-m");

        final var logoutButton = new Button("Log out", e -> service.logout());

        final var header = new HorizontalLayout(new DrawerToggle(), logo, logoutButton);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidthFull();
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }

}
