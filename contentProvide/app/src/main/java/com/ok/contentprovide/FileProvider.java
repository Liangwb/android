package com.ok.contentprovide;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

import java.io.File;
import java.io.FileNotFoundException;

public class FileProvider extends ContentProvider {
    private static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int SUCCESS = 1;
    static{
        matcher.addURI("com.ok.contentprovide", "private.txt", SUCCESS);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return 0;
    }

    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode)
            throws FileNotFoundException {
        if(matcher.match(uri) == SUCCESS){
            File file = new File(getContext().getFilesDir(), uri.getPath());
            return ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
        }else{
            return super.openFile(uri, mode);
        }
    }

}