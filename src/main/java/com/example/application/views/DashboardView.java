package com.example.application.views;

import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@Route(value = "dashboard", layout = MainLayout.class)
@PageTitle("Dashboard | Vaadin CRM")
@PermitAll
public class DashboardView extends VerticalLayout {

    private final CrmService crmService;

    public DashboardView(CrmService crmService) {
        this.crmService = crmService;
        addClassName("dashboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(getContactStats(), getCompaniesChart());
    }

    private Component getCompaniesChart() {
        final var stats = new Span(crmService.countContacts() + " contacts");
        stats.addClassNames("text-xl", "mt-m");
        return stats;
    }

    private Component getContactStats() {
        final var chart = new Chart(ChartType.PIE);

        final var dataSeries = new DataSeries();
        crmService.findAllCompanies().forEach(company -> {
            dataSeries.add(new DataSeriesItem(company.getName(), company.getEmployeeCount()));
        });
        chart.getConfiguration().setSeries(dataSeries);
        return chart;
    }

}
