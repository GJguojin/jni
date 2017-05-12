package org.pngquant;

import org.scijava.nativelib.NativeLoader;

abstract class LiqObject {
    
    private static boolean NATIVE_LIBRARY_LOADED = false;

    static synchronized void loadNativeLibrary() {
      if (!NATIVE_LIBRARY_LOADED) {
        NATIVE_LIBRARY_LOADED = true;
        try {
  			NativeLoader.loadLibrary("imagequant");
  			//System.loadLibrary("imagequant");
  		} catch (Exception e) {
  			System.out.println("loadLibrary error:"+e.getMessage());
  		}
      }
    }
    
    static {
        loadNativeLibrary();
      }

    long handle;

    /**
     * Free memory used by the library. The object must not be used after this call.
     */
    abstract public void close();

    @Override
	protected void finalize() throws Throwable {
        close();
    }
}
