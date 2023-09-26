package com.example.application.views.list;

import com.example.application.data.entity.Contact;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.ListDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ListViewTest {

    @Autowired
    private ListView listView;

//    @Test
//    public void formShownWhenContactSelected() {
//        final var grid = listView.grid;
//        final var firstContact = getFirstItem(grid);
//
//        final var form = listView.form;
//        assertFalse(form.isVisible());
//        grid.asSingleSelect().setValue(firstContact);
//        assertTrue(form.isVisible());
//        assertEquals(firstContact.getFirstName(), form.firstName.getValue());
//
//    }
//
//    public Contact getFirstItem(Grid<Contact> grid) {
//        return ((ListDataProvider<Contact>)grid.getDataProvider()).getItems().iterator().next();
//    }

}
