package com.adapter;

import com.krishna.PilotPen;

public class School {
	public static void main(String[] args) {
		// PilotPen pp= new PilotPen();\
		Pen p = new PenAdapter();
		AssignmentWork aw = new AssignmentWork();
		aw.setP(p);
		aw.writAssignment("I am bit tired to write an Assignment");

	}
}
