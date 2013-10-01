package com.paraschool.editor.modules.relier.client;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Widget;
import com.paraschool.editor.api.client.EditModuleContext;
import com.paraschool.editor.api.client.ModuleWidget;
import com.paraschool.editor.api.client.ViewModuleContext;
import com.paraschool.editor.modules.commons.client.EventBus;
import com.paraschool.editor.modules.relier.client.i18n.RelierModuleMessages;
import com.paraschool.editor.modules.relier.client.ui.EditWidget;
import com.paraschool.editor.modules.relier.client.ui.ViewWidget;

/*
 * Created at 5 sept. 2010
 * By bathily
 */
public class RelierModuleWidget implements ModuleWidget {

	private EditWidget editWidget;
	private ViewWidget viewWidget;
	
	private RelierModuleMessages messages;
	
	public RelierModuleWidget(RelierModuleMessages messages) {
		super();
		this.messages = messages;
	}

	@Override
	public Widget editWidget(EditModuleContext context) {
		if(editWidget == null){
			editWidget = new EditWidget(new EventBus(), context, messages);
		}
		return editWidget;
	}

	@Override
	public Widget viewWidget(ViewModuleContext context) {
		viewWidget = new ViewWidget(new EventBus(), context, messages);
		return viewWidget;
	}

	@Override
	public String getEditData() {
		return new JSONObject(editWidget.getData()).toString();
	}

	@Override
	public String getResultData() {
		return new JSONObject(viewWidget.getData()).toString();
	}

	@Override
	public Widget optionsWidget(EditModuleContext context) {
		return editWidget.getOptionsWidget();
	}
}
