// IPersonService.aidl
package com.czy.server;

// Declare any non-default types here with import statements
import com.czy.server.Person;
interface IPersonService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
          void save(in Person person);
}
