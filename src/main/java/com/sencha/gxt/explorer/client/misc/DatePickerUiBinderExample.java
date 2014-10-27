/**
 * Sencha GXT 3.1.0 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.sencha.gxt.explorer.client.misc;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.explorer.client.model.Example.Detail;
import com.sencha.gxt.widget.core.client.info.Info;


@Detail(name = "DatePicker (UiBinder)", icon = "datepicker", category = "Misc", files = "DatePickerUiBinderExample.ui.xml")
public class DatePickerUiBinderExample implements IsWidget, EntryPoint {

  interface MyUiBinder extends UiBinder<Widget, DatePickerUiBinderExample> {
  }

  private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
  
  private Widget widget;

  @UiField(provided = true)
  Date minDate = new DateWrapper().addDays(-5).asDate();

  @Override
  public Widget asWidget() {
    if (widget == null) {
      widget = uiBinder.createAndBindUi(this);
    }
    
    return widget; 
  }

  @Override
  public void onModuleLoad() {
    RootPanel.get().add(asWidget());
  }
  
  @UiHandler("picker")
  public void onValueChange(ValueChangeEvent<Date> event) {
    Date d = event.getValue();
    DateTimeFormat f = DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT);
    Info.display("Value Changed", "You selected " + f.format(d)); 
  }

}
