/*
  This file is part of Subsonic.
	Subsonic is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	Subsonic is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
	GNU General Public License for more details.
	You should have received a copy of the GNU General Public License
	along with Subsonic. If not, see <http://www.gnu.org/licenses/>.
	Copyright 2014 (C) Scott Jackson
*/

package github.daneren2005.dsub.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import github.daneren2005.dsub.service.DownloadFile;
import github.daneren2005.dsub.view.SongView;
import github.daneren2005.dsub.view.UpdateView;

public class DownloadFileAdapter extends SectionAdapter<DownloadFile> {
	public static int VIEW_TYPE_DOWNLOAD_FILE = 1;

	public DownloadFileAdapter(Context context, List<DownloadFile> entries, OnItemClickedListener onItemClickedListener) {
		super(context, entries);
		this.onItemClickedListener = onItemClickedListener;
	}

	@Override
	public UpdateView.UpdateViewHolder onCreateSectionViewHolder(ViewGroup parent, int viewType) {
		return new UpdateView.UpdateViewHolder(new SongView(context));
	}

	@Override
	public void onBindViewHolder(UpdateView.UpdateViewHolder holder, DownloadFile item, int viewType) {
		SongView songView = (SongView) holder.getUpdateView();
		songView.setObject(item.getSong(), false);
		songView.setDownloadFile(item);
	}

	@Override
	public int getItemViewType(DownloadFile item) {
		return VIEW_TYPE_DOWNLOAD_FILE;
	}
}
