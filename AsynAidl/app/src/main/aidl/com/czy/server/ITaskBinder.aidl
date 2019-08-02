// ITaskBinder.aidl
package com.czy.server;

// Declare any non-default types here with import statements
import com.czy.server.ITaskCallback;
interface ITaskBinder {
   boolean isTaskRunning();
   void stopRunningTask();
   void registerCallback(ITaskCallback cb);
   void unregisterCallback(ITaskCallback cb);
}