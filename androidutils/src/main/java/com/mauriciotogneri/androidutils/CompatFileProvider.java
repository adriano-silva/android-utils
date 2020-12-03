package com.mauriciotogneri.androidutils;

import android.database.Cursor;
import android.net.Uri;

import com.mauriciotogneri.androidutils.fileprovider.LegacyCompatCursorWrapper;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

public class CompatFileProvider extends FileProvider
{
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        return (new LegacyCompatCursorWrapper(super.query(uri, projection, selection, selectionArgs, sortOrder)));
    }
}