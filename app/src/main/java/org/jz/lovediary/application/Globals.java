package org.jz.lovediary.application;

import android.content.Context;
import android.os.Handler;

import org.jz.lovediary.factory.ApplicationInitializor;
import org.jz.lovediary.storage.SqlStorage;


/**
 * Created by JZ on 3/6/2016.
 */
public class Globals
{
    public static Context context;
    public static Handler handler;
    public static ApplicationInitializor appInitializor;
    public static SqlStorage sqlStorage;
}
