package jvm;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import javax.crypto.spec.GCMParameterSpec;

public class JVMTest {
	public static void main(String[] args) throws InterruptedException {
		String obj = new String("aaa");
		//WeakReference<Object> wf = new WeakReference<Object>(obj);
		obj = null;
		System.gc();
		System.out.println(obj);
//		System.out.println(wf.get());
	}
}
