package com.example.models;

import com.example.novice.R;

public class NavigationDrawerItem {

	private String Title;
	private String Caption;
	private int Icon;

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}

	public String getCaption() {
		return Caption;
	}
	public void setCaption(String caption) {
		Caption = caption;
	}

	public int getIcon() {
		return Icon;
	}
	public void setIcon(int icon) {
		Icon = icon;
	}

	public NavigationDrawerItem(String Title) {
		this.Title = Title;
		switch (Title) {
			case "Email" :
				this.Icon = R.drawable.ic_action_email;
				this.Caption = "Read emails on the go on your smartphone";
				break;
			case "Attachment" :
				this.Icon = R.drawable.ic_action_attachment;
				this.Caption = "Emails can have attachments as well";
				break;
			case "Picture" :
				this.Icon = R.drawable.ic_action_picture;
				this.Caption = "Pictures are a commonplace on smartphones";
				break;
			case "Read" :
				this.Caption = "Reading at your fingertips, literally";
				this.Icon = R.drawable.ic_action_read;
				break;
		}
	}
}
