package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.facebookParsing.Comment;
import com.example.facebookParsing.Feeds;
import com.example.facebookParsing.SingleFeed;
import com.example.novice.R;

public class FacebookFeedExpandableListAdapter
		extends
			BaseExpandableListAdapter {

	private Feeds facebookFeeds;
	private Context context;

	public FacebookFeedExpandableListAdapter(Context context,
			Feeds facebookFeeds) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.facebookFeeds = facebookFeeds;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return facebookFeeds.getFeeds().size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return ((SingleFeed) facebookFeeds.getFeeds().get(groupPosition))
				.getComments().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return (SingleFeed) facebookFeeds.getFeeds().get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return (Comment) ((SingleFeed) facebookFeeds.getFeeds().get(
				groupPosition)).getComments().get(childPosition);
	}
	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		SingleFeed singleFeed = (SingleFeed) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.feed_item, null);
		}

		((TextView) convertView.findViewById(R.id.fb_message))
				.setText(singleFeed.getMessage());
		((TextView) convertView.findViewById(R.id.fb_description))
				.setText(singleFeed.getDescription());
		((TextView) convertView.findViewById(R.id.fb_creator))
				.setText(singleFeed.getCreator().getName());

		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Comment singleComment = (Comment) getChild(groupPosition,
				childPosition);

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.comment_item, null);
		}

		TextView txtCommentName = (TextView) convertView
				.findViewById(R.id.fb_comment_name);
		TextView txtCommentDescription = (TextView) convertView
				.findViewById(R.id.fb_comment_message);

		txtCommentName.setText(singleComment.getName());
		txtCommentDescription.setText(singleComment.getMessage());
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
