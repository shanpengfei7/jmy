package com.jmy.domain;

import java.util.ArrayList;
import java.util.List;

import com.jmy.entity.Actionclass;

public class ActionClassDoMain extends Actionclass {

	private List<ActionDoMain> actions = new ArrayList<ActionDoMain>();

	public List<ActionDoMain> getActions() {
		return actions;
	}

	public void setActions(List<ActionDoMain> actions) {
		this.actions = actions;
	}
	
}
