package com.example.user.musicplayerlib;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.support.v4.media.session.MediaButtonReceiver;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.RemoteViews;

public class MusicWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds){
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.music_widget);

        PendingIntent playAction
                = MediaButtonReceiver.buildMediaButtonPendingIntent(context, PlaybackStateCompat.ACTION_PLAY_PAUSE);
        PendingIntent nextAction
                = MediaButtonReceiver.buildMediaButtonPendingIntent(context, PlaybackStateCompat.ACTION_SKIP_TO_NEXT);
        PendingIntent previousAction
                = MediaButtonReceiver.buildMediaButtonPendingIntent(context, PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS);

        views.setOnClickPendingIntent(R.id.play,playAction);
        views.setOnClickPendingIntent(R.id.next,nextAction);
        views.setOnClickPendingIntent(R.id.next,previousAction);
        appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
